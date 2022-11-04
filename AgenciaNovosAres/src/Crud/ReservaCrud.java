<<<<<<< HEAD
package Crud;

import java.util.Scanner;

import ClassesDAO.ReservaDAO;
import ClassesDAO.UsuarioDAO;
import modelo.Reserva;
import modelo.Usuario;

public class ReservaCrud {

	public static void main(String[] args) {

		Reserva reserva = new Reserva();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ReservaDAO reservaDAO = new ReservaDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		double valor = 0;
		int pagamento = 0;

		int id_reserva = 0;
		int id_usuario = 0;

		do {

			System.out.println("===== Lista de Reserva =====");
			System.out.println("1 - Cadastro de reserva");
			System.out.println("2 - Excluir reserva");
			System.out.println("3 - Atualizar reserva");
			System.out.println("4 - Mostrar lista de reservas");
			System.out.println("5 - Buscar reservas por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				try {
					System.out.println("Digite o id do usuario : ");
					id_usuario = entrada.nextInt();
					Usuario usuario = usuarioDAO.getUsuarioById(id_usuario);

					System.out.println("Digite o valor total da compra: ");
					valor = entrada.nextDouble();
					reserva.setValor_total(valor);

					System.out.println("Escolha o tipo de pagamento do usuario: ");

					System.out.println("1 - Cartão de Crédito ");
					System.out.println("2 - Bolheto Bancário");
					System.out.println("3 - Cartão de Débito");
					System.out.println("4 - PIX");
					pagamento = entrada.nextInt();
					reserva.Pagamento_saber(pagamento);

					reserva.setUsuario(usuario);



					reservaDAO.save(reserva);

				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Não foi possivel salvar a reserva");
					System.out.println("----------------------------------");

					e.printStackTrace();
				} 

				break;
			}
			case 2: {
				System.out.println("Digite o Id da reserva: ");
				try {
					id_reserva = entrada.nextInt();

					usuarioDAO.removeById(id_usuario);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {

					System.out.println("Digite o codigo da Reserva: ");
					id_reserva = entrada.nextInt();
					reserva.setId_Reserva(id_reserva);

					System.out.println("Digite o id do usuario : ");
					id_usuario = entrada.nextInt();

					System.out.println("Digite o valor total da compra: ");
					valor = entrada.nextDouble();
					reserva.setValor_total(valor);

					System.out.println("1 - Cartão de Crédito ");
					System.out.println("2 - Bolheto Bancário");
					System.out.println("3 - Cartão de Débito");
					System.out.println("4 - PIX");
					
					pagamento = entrada.nextInt();
					reserva.Pagamento_saber(pagamento);

					Usuario usuario = usuarioDAO.getUsuarioById(id_usuario);

					reserva.setUsuario(usuario);

//					usuario.setId(id_usuario);

					reservaDAO.update(reserva);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {

				for (Reserva r : reservaDAO.getReserva()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID DA RESERVA: " + r.getId_Reserva());

					System.out.println("ID DO USUARIO: " + r.getUsuario().getId());
					System.out.println("VALOR TOTAL: R$" + r.getValor_total());
					System.out.println("TIPO DE PAGAMENTO: " + r.getPagamento());
					System.out.println("NOME: " + r.getUsuario().getCliente().getNome());
					System.out.println("CPF: " + r.getUsuario().getCliente().getCPF());
					System.out.println("ESTADO: " + r.getUsuario().getCliente().getEstado());
					System.out.println("DATA DA RESERVA: " + r.getUsuario().getCliente().getData_cli());
					System.out.println("TELEFONE: " + r.getUsuario().getCliente().getTelefone());
					System.out.println("EMAIL: " + r.getUsuario().getEmail());
					System.out.println("SENHA: " + r.getUsuario().getSenha());
					

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID da reserva para buscar: ");
				id_reserva = entrada.nextInt();

				Reserva r = new Reserva();

				r = reservaDAO.getReservaById(id_reserva);

				System.out.println("ID DA RESERVA: " + r.getId_Reserva());

				System.out.println("ID DO USUARIO: " + r.getUsuario().getId());
				System.out.println("VALOR TOTAL: R$" + r.getValor_total());
				System.out.println("TIPO DE PAGAMENTO: " + r.getPagamento());
				System.out.println("NOME: " + r.getUsuario().getCliente().getNome());
				System.out.println("CPF: " + r.getUsuario().getCliente().getCPF());
				System.out.println("ESTADO: " + r.getUsuario().getCliente().getEstado());
				System.out.println("DATA DA RESERVA: " + r.getUsuario().getCliente().getData_cli());
				System.out.println("TELEFONE: " + r.getUsuario().getCliente().getTelefone());
				
				System.out.println("EMAIL: " + r.getUsuario().getEmail());
				System.out.println("SENHA: " + r.getUsuario().getSenha());
				
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

import ClassesDAO.ReservaDAO;
import ClassesDAO.UsuarioDAO;
import modelo.Reserva;
import modelo.Usuario;

public class ReservaCrud {

	public static void main(String[] args) {

		Reserva reserva = new Reserva();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ReservaDAO reservaDAO = new ReservaDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		double valor = 0;
		int pagamento = 0;

		int id_reserva = 0;
		int id_usuario = 0;

		do {

			System.out.println("===== Lista de Reserva =====");
			System.out.println("1 - Cadastro de reserva");
			System.out.println("2 - Excluir reserva");
			System.out.println("3 - Atualizar reserva");
			System.out.println("4 - Mostrar lista de reservas");
			System.out.println("5 - Buscar reservas por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {

				try {
					System.out.println("Digite o id do usuario : ");
					id_usuario = entrada.nextInt();
					Usuario usuario = usuarioDAO.getUsuarioById(id_usuario);

					System.out.println("Digite o valor total da compra: ");
					valor = entrada.nextDouble();
					reserva.setValor_total(valor);

					System.out.println("Escolha o tipo de pagamento do usuario: ");

					System.out.println("1 - Cartão de Crédito ");
					System.out.println("2 - Bolheto Bancário");
					System.out.println("3 - Cartão de Débito");
					System.out.println("4 - PIX");
					pagamento = entrada.nextInt();
					reserva.Pagamento_saber(pagamento);

					reserva.setUsuario(usuario);



					reservaDAO.save(reserva);

				} catch (Exception e) {
					System.out.println("----------------------------------");
					System.out.println("Não foi possivel salvar a reserva");
					System.out.println("----------------------------------");

					e.printStackTrace();
				} 

				break;
			}
			case 2: {
				System.out.println("Digite o Id da reserva: ");
				try {
					id_reserva = entrada.nextInt();

					usuarioDAO.removeById(id_usuario);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {

					System.out.println("Digite o codigo da Reserva: ");
					id_reserva = entrada.nextInt();
					reserva.setId_Reserva(id_reserva);

					System.out.println("Digite o id do usuario : ");
					id_usuario = entrada.nextInt();

					System.out.println("Digite o valor total da compra: ");
					valor = entrada.nextDouble();
					reserva.setValor_total(valor);

					System.out.println("1 - Cartão de Crédito ");
					System.out.println("2 - Bolheto Bancário");
					System.out.println("3 - Cartão de Débito");
					System.out.println("4 - PIX");
					
					pagamento = entrada.nextInt();
					reserva.Pagamento_saber(pagamento);

					Usuario usuario = usuarioDAO.getUsuarioById(id_usuario);

					reserva.setUsuario(usuario);

//					usuario.setId(id_usuario);

					reservaDAO.update(reserva);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {

				for (Reserva r : reservaDAO.getReserva()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID DA RESERVA: " + r.getId_Reserva());

					System.out.println("ID DO USUARIO: " + r.getUsuario().getId());
					System.out.println("VALOR TOTAL: R$" + r.getValor_total());
					System.out.println("TIPO DE PAGAMENTO: " + r.getPagamento());
					System.out.println("NOME: " + r.getUsuario().getCliente().getNome());
					System.out.println("CPF: " + r.getUsuario().getCliente().getCPF());
					System.out.println("ESTADO: " + r.getUsuario().getCliente().getEstado());
					System.out.println("DATA DA RESERVA: " + r.getUsuario().getCliente().getData_cli());
					System.out.println("TELEFONE: " + r.getUsuario().getCliente().getTelefone());
					System.out.println("EMAIL: " + r.getUsuario().getEmail());
					System.out.println("SENHA: " + r.getUsuario().getSenha());
					

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID da reserva para buscar: ");
				id_reserva = entrada.nextInt();

				Reserva r = new Reserva();

				r = reservaDAO.getReservaById(id_reserva);

				System.out.println("ID DA RESERVA: " + r.getId_Reserva());

				System.out.println("ID DO USUARIO: " + r.getUsuario().getId());
				System.out.println("VALOR TOTAL: R$" + r.getValor_total());
				System.out.println("TIPO DE PAGAMENTO: " + r.getPagamento());
				System.out.println("NOME: " + r.getUsuario().getCliente().getNome());
				System.out.println("CPF: " + r.getUsuario().getCliente().getCPF());
				System.out.println("ESTADO: " + r.getUsuario().getCliente().getEstado());
				System.out.println("DATA DA RESERVA: " + r.getUsuario().getCliente().getData_cli());
				System.out.println("TELEFONE: " + r.getUsuario().getCliente().getTelefone());
				
				System.out.println("EMAIL: " + r.getUsuario().getEmail());
				System.out.println("SENHA: " + r.getUsuario().getSenha());
				
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
