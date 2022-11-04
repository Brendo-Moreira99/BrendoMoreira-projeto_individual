<<<<<<< HEAD
package Crud;

import java.util.Scanner;

import ClassesDAO.Itens_CompraDAO;
import ClassesDAO.PacoteDAO;
import ClassesDAO.ReservaDAO;
import ClassesDAO.VooDAO;
import modelo.Itens_Compra;
import modelo.Pacote;
import modelo.Reserva;
import modelo.Voo;


public class Itens_compraCrud {
	public static void main(String[] args) {

		
		
		Itens_Compra itens = new Itens_Compra();
		Itens_CompraDAO itensDAO = new Itens_CompraDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		VooDAO vooDAO = new VooDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;
		double valor = 0;
		int quantidade = 0;
		int id_reserva = 0;
		int id_voo = 0;
		int id_pacote = 0;
		int id_itens = 0;

		do {

			System.out.println("===== Listagem de Compras =====");
			System.out.println("1 - Cadastro de compras");
			System.out.println("2 - Excluir compras");
			System.out.println("3 - Atualizar compras");
			System.out.println("4 - Mostrar compras");
			System.out.println("5 - Buscar compras por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				try {
					System.out.println("Digite o id do voo: ");
					id_voo = entrada.nextInt();
					Voo voo = vooDAO.getVooById(id_voo);
					entrada.nextLine();
					
					
					System.out.println("Digite o id da reserva: ");
					id_reserva = entrada.nextInt();
					Reserva reserva = reservaDAO.getReservaById(id_reserva);
					

					System.out.println("Digite o id do pacote:  ");
					id_pacote = entrada.nextInt();
					Pacote pacote = pacoteDAO.getPacoteById(id_pacote);
					
					System.out.println("Digite o valor dos itens :  ");
					valor = entrada.nextDouble();
					itens.setValor_itens(valor);
					
					System.out.println("Quantidade dos itens:  ");
					quantidade = entrada.nextInt();
					itens.setQuantidade(quantidade);

					
					itens.setPack(pacote);
					itens.setReserva(reserva);
					itens.setVoo(voo);
					
					itens.Calcular_Itens();
					
					itensDAO.save(itens);

				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Não foi possivel salvar a compra");
					System.out.println("----------------------------------");

					e.printStackTrace();
				} 

				break;
			}
			case 2: {
				System.out.println("Digite o Id da compra: ");
				try {
					id_itens = entrada.nextInt();

					itensDAO.removeById(id_itens);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {

					
					System.out.println("Digite o codigo da Compra que será atalizada: ");
					id_itens = entrada.nextInt();
					itens.setId_itensCompra(id_itens);
					
					System.out.println("Digite o novo id do voo: ");
					id_voo = entrada.nextInt();
					Voo voo = vooDAO.getVooById(id_voo);

					System.out.println("Digite o novo id da reserva: ");
					id_reserva = entrada.nextInt();
					Reserva reserva = reservaDAO.getReservaById(id_reserva);
					

					System.out.println("Digite o novo id do pacote:  ");
					id_pacote = entrada.nextInt();
					Pacote pacote = pacoteDAO.getPacoteById(id_pacote);
					
					System.out.println("Digite o novo valor dos itens :  ");
					valor = entrada.nextDouble();
					itens.setValor_itens(valor);
					
					System.out.println("A nova quantidade de itens:  ");
					quantidade = entrada.nextInt();
					itens.setQuantidade(quantidade);

					
					itens.setPack(pacote);
					itens.setReserva(reserva);
					itens.setVoo(voo);
					
					itens.Calcular_Itens();
				
					itensDAO.update(itens);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {//

				for (Itens_Compra r : itensDAO.getItensCompra()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID ITENS COMPRA: " + r.getId_itensCompra());
					System.out.println("ID DO PACOTE: " + r.getPack().getId_itens_Pacote());
					System.out.println("ID DA RESERVA: " + r.getReserva().getId_Reserva());
					System.out.println("ID DO VOO: " + r.getVoo().getId_Voo());
					System.out.println("VALOR DOS ITENS: R$" +r.getValor_itens());
					System.out.println("QUANTIDADE: " + r.getQuantidade());
					System.out.println("ID DO HOTEL: " + r.getPack().getHotelaria().getId_Hotel());
					System.out.println("VALOR DO PACOTE: " + r.getPack().getValor_Pacote());
					System.out.println("QUANTIDADE DE PESSOAS NO PACOTE: " + r.getPack().getQuantidade_Pessoas());
					System.out.println("TIPO DE PACOTE: " + r.getPack().getTipo());
					System.out.println("DATA DE IDA DO PACOTE: " + r.getPack().getPacote_ida());
					System.out.println("DATA DE VOLTA DO PACOTE: " + r.getPack().getPacote_volta());
					System.out.println("DESTINO DO PACOTE: " + r.getPack().getDestino());
					System.out.println("TRANSFER DO PACOTE: " + r.getPack().getTransfer_pacote());
					System.out.println("ID DO USUARIO: " + r.getReserva().getId_Reserva());
					System.out.println("VALOR TOTAL: R$" + r.getReserva().getValor_total());
					System.out.println("TIPO DE PAGAMENTO DO USUARIO: " + r.getReserva().getPagamento());
					System.out.println("QUANTIDADE DE PESSOAS PARA O VOO: " + r.getVoo().getQuantidade_Pessoas());
					System.out.println("DESTINO DO VOO: " + r.getVoo().getDestino());
					System.out.println("DATA DE IDA DO VOO: " + r.getVoo().getData_ida());
					System.out.println("DATA DE VOLTA DO VOO: " + r.getVoo().getData_volta());
					System.out.println("TRANSFER DO VOO: " + r.getVoo().getTransfer());
					
					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID da reserva para buscar: ");
				id_itens = entrada.nextInt();

				Itens_Compra r = new Itens_Compra();

				r = itensDAO.getItens_CompraById(id_itens);

				System.out.println("ID ITENS COMPRA: " + r.getId_itensCompra());
				System.out.println("ID DO PACOTE: " + r.getPack().getId_itens_Pacote());
				System.out.println("ID DA RESERVA: " + r.getReserva().getId_Reserva());
				System.out.println("ID DO VOO: " + r.getVoo().getId_Voo());
				System.out.println("VALOR DOS ITENS: R$" +r.getValor_itens());
				System.out.println("QUANTIDADE: " + r.getQuantidade());
				System.out.println("ID DO HOTEL: " + r.getPack().getHotelaria().getId_Hotel());
				System.out.println("VALOR DO PACOTE: " + r.getPack().getValor_Pacote());
				System.out.println("QUANTIDADE DE PESSOAS NO PACOTE: " + r.getPack().getQuantidade_Pessoas());
				System.out.println("TIPO DE PACOTE: " + r.getPack().getTipo());
				System.out.println("DATA DE IDA DO PACOTE: " + r.getPack().getPacote_ida());
				System.out.println("DATA DE VOLTA DO PACOTE: " + r.getPack().getPacote_volta());
				System.out.println("DESTINO DO PACOTE: " + r.getPack().getDestino());
				System.out.println("TRANSFER DO PACOTE: " + r.getPack().getTransfer_pacote());
				System.out.println("ID DO USUARIO: " + r.getReserva().getId_Reserva());
				System.out.println("VALOR TOTAL: R$" + r.getReserva().getValor_total());
				System.out.println("TIPO DE PAGAMENTO DO USUARIO: " + r.getReserva().getPagamento());
				System.out.println("QUANTIDADE DE PESSOAS PARA O VOO: " + r.getVoo().getQuantidade_Pessoas());
				System.out.println("DESTINO DO VOO: " + r.getVoo().getDestino());
				System.out.println("DATA DE IDA DO VOO: " + r.getVoo().getData_ida());
				System.out.println("DATA DE VOLTA DO VOO: " + r.getVoo().getData_volta());
				System.out.println("TRANSFER DO VOO: " + r.getVoo().getTransfer());
				
				
				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Obrigado por utilizar nossos serviços === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			}
			;

		} while (opcao != 6);

		entrada.close();
	}

}
=======
package Crud;

import java.util.Scanner;

import ClassesDAO.Itens_CompraDAO;
import ClassesDAO.PacoteDAO;
import ClassesDAO.ReservaDAO;
import ClassesDAO.VooDAO;
import modelo.Itens_Compra;
import modelo.Pacote;
import modelo.Reserva;
import modelo.Voo;


public class Itens_compraCrud {
	public static void main(String[] args) {

		
		
		Itens_Compra itens = new Itens_Compra();
		Itens_CompraDAO itensDAO = new Itens_CompraDAO();
		PacoteDAO pacoteDAO = new PacoteDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		VooDAO vooDAO = new VooDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;
		double valor = 0;
		int quantidade = 0;
		int id_reserva = 0;
		int id_voo = 0;
		int id_pacote = 0;
		int id_itens = 0;

		do {

			System.out.println("===== Listagem de Compras =====");
			System.out.println("1 - Cadastro de compras");
			System.out.println("2 - Excluir compras");
			System.out.println("3 - Atualizar compras");
			System.out.println("4 - Mostrar compras");
			System.out.println("5 - Buscar compras por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				try {
					System.out.println("Digite o id do voo: ");
					id_voo = entrada.nextInt();
					Voo voo = vooDAO.getVooById(id_voo);
					entrada.nextLine();
					
					
					System.out.println("Digite o id da reserva: ");
					id_reserva = entrada.nextInt();
					Reserva reserva = reservaDAO.getReservaById(id_reserva);
					

					System.out.println("Digite o id do pacote:  ");
					id_pacote = entrada.nextInt();
					Pacote pacote = pacoteDAO.getPacoteById(id_pacote);
					
					System.out.println("Digite o valor dos itens :  ");
					valor = entrada.nextDouble();
					itens.setValor_itens(valor);
					
					System.out.println("Quantidade dos itens:  ");
					quantidade = entrada.nextInt();
					itens.setQuantidade(quantidade);

					
					itens.setPack(pacote);
					itens.setReserva(reserva);
					itens.setVoo(voo);
					
					itens.Calcular_Itens();
					
					itensDAO.save(itens);

				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Não foi possivel salvar a compra");
					System.out.println("----------------------------------");

					e.printStackTrace();
				} 

				break;
			}
			case 2: {
				System.out.println("Digite o Id da compra: ");
				try {
					id_itens = entrada.nextInt();

					itensDAO.removeById(id_itens);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {

					
					System.out.println("Digite o codigo da Compra que será atalizada: ");
					id_itens = entrada.nextInt();
					itens.setId_itensCompra(id_itens);
					
					System.out.println("Digite o novo id do voo: ");
					id_voo = entrada.nextInt();
					Voo voo = vooDAO.getVooById(id_voo);

					System.out.println("Digite o novo id da reserva: ");
					id_reserva = entrada.nextInt();
					Reserva reserva = reservaDAO.getReservaById(id_reserva);
					

					System.out.println("Digite o novo id do pacote:  ");
					id_pacote = entrada.nextInt();
					Pacote pacote = pacoteDAO.getPacoteById(id_pacote);
					
					System.out.println("Digite o novo valor dos itens :  ");
					valor = entrada.nextDouble();
					itens.setValor_itens(valor);
					
					System.out.println("A nova quantidade de itens:  ");
					quantidade = entrada.nextInt();
					itens.setQuantidade(quantidade);

					
					itens.setPack(pacote);
					itens.setReserva(reserva);
					itens.setVoo(voo);
					
					itens.Calcular_Itens();
				
					itensDAO.update(itens);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {//

				for (Itens_Compra r : itensDAO.getItensCompra()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID ITENS COMPRA: " + r.getId_itensCompra());
					System.out.println("ID DO PACOTE: " + r.getPack().getId_itens_Pacote());
					System.out.println("ID DA RESERVA: " + r.getReserva().getId_Reserva());
					System.out.println("ID DO VOO: " + r.getVoo().getId_Voo());
					System.out.println("VALOR DOS ITENS: R$" +r.getValor_itens());
					System.out.println("QUANTIDADE: " + r.getQuantidade());
					System.out.println("ID DO HOTEL: " + r.getPack().getHotelaria().getId_Hotel());
					System.out.println("VALOR DO PACOTE: " + r.getPack().getValor_Pacote());
					System.out.println("QUANTIDADE DE PESSOAS NO PACOTE: " + r.getPack().getQuantidade_Pessoas());
					System.out.println("TIPO DE PACOTE: " + r.getPack().getTipo());
					System.out.println("DATA DE IDA DO PACOTE: " + r.getPack().getPacote_ida());
					System.out.println("DATA DE VOLTA DO PACOTE: " + r.getPack().getPacote_volta());
					System.out.println("DESTINO DO PACOTE: " + r.getPack().getDestino());
					System.out.println("TRANSFER DO PACOTE: " + r.getPack().getTransfer_pacote());
					System.out.println("ID DO USUARIO: " + r.getReserva().getId_Reserva());
					System.out.println("VALOR TOTAL: R$" + r.getReserva().getValor_total());
					System.out.println("TIPO DE PAGAMENTO DO USUARIO: " + r.getReserva().getPagamento());
					System.out.println("QUANTIDADE DE PESSOAS PARA O VOO: " + r.getVoo().getQuantidade_Pessoas());
					System.out.println("DESTINO DO VOO: " + r.getVoo().getDestino());
					System.out.println("DATA DE IDA DO VOO: " + r.getVoo().getData_ida());
					System.out.println("DATA DE VOLTA DO VOO: " + r.getVoo().getData_volta());
					System.out.println("TRANSFER DO VOO: " + r.getVoo().getTransfer());
					
					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID da reserva para buscar: ");
				id_itens = entrada.nextInt();

				Itens_Compra r = new Itens_Compra();

				r = itensDAO.getItens_CompraById(id_itens);

				System.out.println("ID ITENS COMPRA: " + r.getId_itensCompra());
				System.out.println("ID DO PACOTE: " + r.getPack().getId_itens_Pacote());
				System.out.println("ID DA RESERVA: " + r.getReserva().getId_Reserva());
				System.out.println("ID DO VOO: " + r.getVoo().getId_Voo());
				System.out.println("VALOR DOS ITENS: R$" +r.getValor_itens());
				System.out.println("QUANTIDADE: " + r.getQuantidade());
				System.out.println("ID DO HOTEL: " + r.getPack().getHotelaria().getId_Hotel());
				System.out.println("VALOR DO PACOTE: " + r.getPack().getValor_Pacote());
				System.out.println("QUANTIDADE DE PESSOAS NO PACOTE: " + r.getPack().getQuantidade_Pessoas());
				System.out.println("TIPO DE PACOTE: " + r.getPack().getTipo());
				System.out.println("DATA DE IDA DO PACOTE: " + r.getPack().getPacote_ida());
				System.out.println("DATA DE VOLTA DO PACOTE: " + r.getPack().getPacote_volta());
				System.out.println("DESTINO DO PACOTE: " + r.getPack().getDestino());
				System.out.println("TRANSFER DO PACOTE: " + r.getPack().getTransfer_pacote());
				System.out.println("ID DO USUARIO: " + r.getReserva().getId_Reserva());
				System.out.println("VALOR TOTAL: R$" + r.getReserva().getValor_total());
				System.out.println("TIPO DE PAGAMENTO DO USUARIO: " + r.getReserva().getPagamento());
				System.out.println("QUANTIDADE DE PESSOAS PARA O VOO: " + r.getVoo().getQuantidade_Pessoas());
				System.out.println("DESTINO DO VOO: " + r.getVoo().getDestino());
				System.out.println("DATA DE IDA DO VOO: " + r.getVoo().getData_ida());
				System.out.println("DATA DE VOLTA DO VOO: " + r.getVoo().getData_volta());
				System.out.println("TRANSFER DO VOO: " + r.getVoo().getTransfer());
				
				
				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Obrigado por utilizar nossos serviços === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			}
			;

		} while (opcao != 6);

		entrada.close();
	}

}
>>>>>>> 0f8b9f6a000d2ff7c19dcd3b1c91c4acee1454da
