<<<<<<< HEAD
package Crud;

import java.util.Scanner;

import ClassesDAO.DiariasHotelariaDAO;
import ClassesDAO.PacoteDAO;
import modelo.DiariasHotelaria;
import modelo.Pacote;

public class PacoteCrud {

	public static void main(String[] args) {
		

		Pacote pacote = new Pacote();
		PacoteDAO pacoteDAO = new PacoteDAO();
		DiariasHotelariaDAO diariasDAO = new DiariasHotelariaDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		double valor = 0;
		String ida = "";
		String volta = "";
		int transfer = 0;
		String destino = "";
		int quantidade = 0;
		int id_pacote = 0;
		int id_hotelaria = 0;

		do {

			System.out.println("===== Lista de Pacotes =====");
			System.out.println("1 - Cadastro de Pacotes promocionais");
			System.out.println("2 - Excluir Pacotes promocionais");
			System.out.println("3 - Atualizar Pacotes promocionais");
			System.out.println("4 - Mostrar lista de Pacotes promocionais");
			System.out.println("5 - Buscar Pacotes promocionais por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				try {
					System.out.println("Digite o id do Hotel/Resort: ");
					id_hotelaria = entrada.nextInt();
					DiariasHotelaria diarias = diariasDAO.getDiariasHotelariaById(id_hotelaria);
					entrada.nextLine();
				

					System.out.println("Digite a data de ida do pacote: ");
					ida = entrada.nextLine();
					pacote.setPacote_ida(ida);
					
					System.out.println("Digite a data de volta do pacote: ");
					volta = entrada.nextLine();
					pacote.setPacote_volta(volta);
			
					
					System.out.println("Digite o destino do pacote: ");
					destino= entrada.nextLine();
					pacote.setDestino(destino);
					
					System.out.println("Digite a quantidade de pessoas incluidas no pacote: ");
					quantidade= entrada.nextInt();
					pacote.setQuantidade_Pessoas(quantidade);
					
					System.out.println("Digite o valor do pacote: ");
					valor = entrada.nextDouble();
					pacote.setValor_Pacote(valor);
					
					System.out.println("1 - Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
					System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
					System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
					System.out.println("4 - sem transfer");
					transfer = entrada.nextInt();
					
					pacote.Transferpacote_saber(transfer);
					
					pacote.Tipo_saber(quantidade);

					pacote.setHotelaria(diarias);
					
					pacoteDAO.save(pacote);

				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Não foi possivel salvar o pacote");
					System.out.println("----------------------------------");

					e.printStackTrace();
				} 

				break;
			}
			case 2: {
				System.out.println("Digite o Id do pacote: ");
				try {
					id_pacote= entrada.nextInt();

					pacoteDAO.removeById(id_pacote);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {
					
					System.out.println("Digite o id do Pacote a ser atualizado: ");
					id_pacote = entrada.nextInt();
					pacote.setId_itens_Pacote(id_pacote);
					
					
					System.out.println("Digite o novo id do Hotel/Resort: ");
					id_hotelaria = entrada.nextInt();
					DiariasHotelaria diarias = diariasDAO.getDiariasHotelariaById(id_hotelaria);
					entrada.nextLine();
					
					System.out.println("Digite a nova data de ida do pacote: ");
					ida = entrada.nextLine();
					pacote.setPacote_ida(ida);
					
					System.out.println("Digite a nova data de volta do pacote: ");
					volta = entrada.nextLine();
					pacote.setPacote_volta(volta);
			
					
					System.out.println("Digite o novo destino do pacote: ");
					destino= entrada.nextLine();
					pacote.setDestino(destino);
					
					System.out.println("Digite a nova quantidade de pessoas incluidas no pacote: ");
					quantidade = entrada.nextInt();
					pacote.setQuantidade_Pessoas(quantidade);
					
					System.out.println("Digite o novo valor do pacote: ");
					valor = entrada.nextDouble();
					pacote.setValor_Pacote(valor);
		
					

					System.out.println("1 - Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
					System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
					System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
					System.out.println("4 - sem transfer");
					transfer = entrada.nextInt();
					
					pacote.Transferpacote_saber(transfer);
					
					
					pacote.Tipo_saber(quantidade);

					pacote.setHotelaria(diarias);
				
					
					pacoteDAO.update(pacote);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {

				for (Pacote p : pacoteDAO.getPacote()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID DO PACOTE: " + p.getId_itens_Pacote());

					System.out.println("QUANTIDADE DE PESSOAS DO PACOTE: " + p.getQuantidade_Pessoas());
					System.out.println("TIPO DE PROMOÇÃO DO PACOTE: " + p.getTipo());
					System.out.println("VALOR: R$" + p.getValor_Pacote());
					System.out.println("DATA DE IDA: " + p.getPacote_ida());
					System.out.println("DATA DE VOLTA: " + p.getPacote_volta());
					System.out.println("DESTINO: " + p.getDestino());
					System.out.println("TRANSFER PACOTE: " + p.getTransfer_pacote());
					System.out.println("ID DO HOTEL: " + p.getHotelaria().getId_Hotel());
					System.out.println("NOME DO HOTEL: " + p.getHotelaria().getNome_Hotel());
					System.out.println("DIARIAS: " + p.getHotelaria().getQtd_dias());
					System.out.println("QUANTIDADE DE QUARTOS: " + p.getHotelaria().getQtd_Quartos());
					System.out.println("ESTADO: " + p.getHotelaria().getEstado());
					System.out.println("MUNICIPIO: " + p.getHotelaria().getMunicipio());
					System.out.println("RUA: " + p.getHotelaria().getRua());
					System.out.println("NUMERO: " + p.getHotelaria().getNumero());
					

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID do paacote para buscar: ");
				id_pacote = entrada.nextInt();

				Pacote p = new Pacote();

				p = pacoteDAO.getPacoteById(id_pacote);

				System.out.println("ID DO PACOTE: " + p.getId_itens_Pacote());

				System.out.println("QUANTIDADE DE PESSOAS DO PACOTE: " + p.getQuantidade_Pessoas());
				System.out.println("TIPO DE PROMOÇÃO DO PACOTE: " + p.getTipo());
				System.out.println("VALOR: R$" + p.getValor_Pacote());
				System.out.println("DATA DE IDA: " + p.getPacote_ida());
				System.out.println("DATA DE VOLTA: " + p.getPacote_volta());
				System.out.println("DESTINO: " + p.getDestino());
				System.out.println("TRANSFER PACOTE: " + p.getTransfer_pacote());
				System.out.println("ID DO HOTEL: " + p.getHotelaria().getId_Hotel());
				System.out.println("NOME DO HOTEL: " + p.getHotelaria().getNome_Hotel());
				System.out.println("DIARIAS: " + p.getHotelaria().getQtd_dias());
				System.out.println("QUANTIDADE DE QUARTOS: " + p.getHotelaria().getQtd_Quartos());
				System.out.println("ESTADO: " + p.getHotelaria().getEstado());
				System.out.println("MUNICIPIO: " + p.getHotelaria().getMunicipio());
				System.out.println("RUA: " + p.getHotelaria().getRua());
				System.out.println("NUMERO: " + p.getHotelaria().getNumero());
				
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

import ClassesDAO.DiariasHotelariaDAO;
import ClassesDAO.PacoteDAO;
import modelo.DiariasHotelaria;
import modelo.Pacote;

public class PacoteCrud {

	public static void main(String[] args) {
		

		Pacote pacote = new Pacote();
		PacoteDAO pacoteDAO = new PacoteDAO();
		DiariasHotelariaDAO diariasDAO = new DiariasHotelariaDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		double valor = 0;
		String ida = "";
		String volta = "";
		int transfer = 0;
		String destino = "";
		int quantidade = 0;
		int id_pacote = 0;
		int id_hotelaria = 0;

		do {

			System.out.println("===== Lista de Pacotes =====");
			System.out.println("1 - Cadastro de Pacotes promocionais");
			System.out.println("2 - Excluir Pacotes promocionais");
			System.out.println("3 - Atualizar Pacotes promocionais");
			System.out.println("4 - Mostrar lista de Pacotes promocionais");
			System.out.println("5 - Buscar Pacotes promocionais por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				try {
					System.out.println("Digite o id do Hotel/Resort: ");
					id_hotelaria = entrada.nextInt();
					DiariasHotelaria diarias = diariasDAO.getDiariasHotelariaById(id_hotelaria);
					entrada.nextLine();
				

					System.out.println("Digite a data de ida do pacote: ");
					ida = entrada.nextLine();
					pacote.setPacote_ida(ida);
					
					System.out.println("Digite a data de volta do pacote: ");
					volta = entrada.nextLine();
					pacote.setPacote_volta(volta);
			
					
					System.out.println("Digite o destino do pacote: ");
					destino= entrada.nextLine();
					pacote.setDestino(destino);
					
					System.out.println("Digite a quantidade de pessoas incluidas no pacote: ");
					quantidade= entrada.nextInt();
					pacote.setQuantidade_Pessoas(quantidade);
					
					System.out.println("Digite o valor do pacote: ");
					valor = entrada.nextDouble();
					pacote.setValor_Pacote(valor);
					
					System.out.println("1 - Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
					System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
					System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
					System.out.println("4 - sem transfer");
					transfer = entrada.nextInt();
					
					pacote.Transferpacote_saber(transfer);
					
					pacote.Tipo_saber(quantidade);

					pacote.setHotelaria(diarias);
					
					pacoteDAO.save(pacote);

				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Não foi possivel salvar o pacote");
					System.out.println("----------------------------------");

					e.printStackTrace();
				} 

				break;
			}
			case 2: {
				System.out.println("Digite o Id do pacote: ");
				try {
					id_pacote= entrada.nextInt();

					pacoteDAO.removeById(id_pacote);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {
					
					System.out.println("Digite o id do Pacote a ser atualizado: ");
					id_pacote = entrada.nextInt();
					pacote.setId_itens_Pacote(id_pacote);
					
					
					System.out.println("Digite o novo id do Hotel/Resort: ");
					id_hotelaria = entrada.nextInt();
					DiariasHotelaria diarias = diariasDAO.getDiariasHotelariaById(id_hotelaria);
					entrada.nextLine();
					
					System.out.println("Digite a nova data de ida do pacote: ");
					ida = entrada.nextLine();
					pacote.setPacote_ida(ida);
					
					System.out.println("Digite a nova data de volta do pacote: ");
					volta = entrada.nextLine();
					pacote.setPacote_volta(volta);
			
					
					System.out.println("Digite o novo destino do pacote: ");
					destino= entrada.nextLine();
					pacote.setDestino(destino);
					
					System.out.println("Digite a nova quantidade de pessoas incluidas no pacote: ");
					quantidade = entrada.nextInt();
					pacote.setQuantidade_Pessoas(quantidade);
					
					System.out.println("Digite o novo valor do pacote: ");
					valor = entrada.nextDouble();
					pacote.setValor_Pacote(valor);
		
					

					System.out.println("1 - Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
					System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
					System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
					System.out.println("4 - sem transfer");
					transfer = entrada.nextInt();
					
					pacote.Transferpacote_saber(transfer);
					
					
					pacote.Tipo_saber(quantidade);

					pacote.setHotelaria(diarias);
				
					
					pacoteDAO.update(pacote);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {

				for (Pacote p : pacoteDAO.getPacote()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID DO PACOTE: " + p.getId_itens_Pacote());

					System.out.println("QUANTIDADE DE PESSOAS DO PACOTE: " + p.getQuantidade_Pessoas());
					System.out.println("TIPO DE PROMOÇÃO DO PACOTE: " + p.getTipo());
					System.out.println("VALOR: R$" + p.getValor_Pacote());
					System.out.println("DATA DE IDA: " + p.getPacote_ida());
					System.out.println("DATA DE VOLTA: " + p.getPacote_volta());
					System.out.println("DESTINO: " + p.getDestino());
					System.out.println("TRANSFER PACOTE: " + p.getTransfer_pacote());
					System.out.println("ID DO HOTEL: " + p.getHotelaria().getId_Hotel());
					System.out.println("NOME DO HOTEL: " + p.getHotelaria().getNome_Hotel());
					System.out.println("DIARIAS: " + p.getHotelaria().getQtd_dias());
					System.out.println("QUANTIDADE DE QUARTOS: " + p.getHotelaria().getQtd_Quartos());
					System.out.println("ESTADO: " + p.getHotelaria().getEstado());
					System.out.println("MUNICIPIO: " + p.getHotelaria().getMunicipio());
					System.out.println("RUA: " + p.getHotelaria().getRua());
					System.out.println("NUMERO: " + p.getHotelaria().getNumero());
					

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID do paacote para buscar: ");
				id_pacote = entrada.nextInt();

				Pacote p = new Pacote();

				p = pacoteDAO.getPacoteById(id_pacote);

				System.out.println("ID DO PACOTE: " + p.getId_itens_Pacote());

				System.out.println("QUANTIDADE DE PESSOAS DO PACOTE: " + p.getQuantidade_Pessoas());
				System.out.println("TIPO DE PROMOÇÃO DO PACOTE: " + p.getTipo());
				System.out.println("VALOR: R$" + p.getValor_Pacote());
				System.out.println("DATA DE IDA: " + p.getPacote_ida());
				System.out.println("DATA DE VOLTA: " + p.getPacote_volta());
				System.out.println("DESTINO: " + p.getDestino());
				System.out.println("TRANSFER PACOTE: " + p.getTransfer_pacote());
				System.out.println("ID DO HOTEL: " + p.getHotelaria().getId_Hotel());
				System.out.println("NOME DO HOTEL: " + p.getHotelaria().getNome_Hotel());
				System.out.println("DIARIAS: " + p.getHotelaria().getQtd_dias());
				System.out.println("QUANTIDADE DE QUARTOS: " + p.getHotelaria().getQtd_Quartos());
				System.out.println("ESTADO: " + p.getHotelaria().getEstado());
				System.out.println("MUNICIPIO: " + p.getHotelaria().getMunicipio());
				System.out.println("RUA: " + p.getHotelaria().getRua());
				System.out.println("NUMERO: " + p.getHotelaria().getNumero());
				
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
