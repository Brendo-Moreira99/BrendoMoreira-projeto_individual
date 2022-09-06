package Crud;

import java.util.Scanner;

import ClassesDAO.ClienteDAO;
import ClassesDAO.PermissaoDAO;
import ClassesDAO.UsuarioDAO;
import modelo.Cliente;
import modelo.Permissao;
import modelo.Usuario;

public class UsuarioCrud {

	public static void main(String args[]) {

		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PermissaoDAO permissaoDAO = new PermissaoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		String email = "";
		String senha = "";

		int id_usuario = 0;
		int id_permissao = 0;
		int id_cliente = 0;

		do {

			System.out.println("===== Lista de usuarios =====");
			System.out.println("1 - Cadastro de usuario");
			System.out.println("2 - Excluir usuario");
			System.out.println("3 - Atualizar usuario");
			System.out.println("4 - Mostrar lista de usuarios");
			System.out.println("5 - Buscar usuarios por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o email do usuario : ");
				email = entrada.next();
				usuario.setEmail(email);

				System.out.println("Digite a senha do usuario : ");
				senha = entrada.next();
				usuario.setSenha(senha);

				System.out.println("Digite o Id do cliente : ");
				id_cliente = entrada.nextInt();
				entrada.nextLine();
				Cliente cliente2 = clienteDAO.getClienteById(id_cliente);
				
				
			

				System.out.println("Digite o id que identifica a permissao do cliente : ");
				id_permissao = entrada.nextInt();
				entrada.nextLine();
				Permissao permissao2 = permissaoDAO.getPermissaoById(id_permissao);
				
				
				
				
				usuario.setCliente(cliente2);
		
				usuario.setPermissao(permissao2);
				

				
				usuarioDAO.save(usuario);

				break;
			}
			case 2: {
				System.out.println("Digite o Id do usuario: ");
				try {
					id_usuario = entrada.nextInt();

					usuarioDAO.removeById(id_usuario);

				} catch (Exception e) {

					System.out.println(" Nenhum usuario para excluir ");
				}

				break;
			}
			case 3: {

				do {

					System.out.println("Digite o codigo do usuario: ");
					id_usuario = entrada.nextInt();
					entrada.nextLine();
					

					System.out.println("Digite o novo email: ");
					email = entrada.next();

					System.out.println("Digite a nova senha: ");
					senha = entrada.next();

					System.out.println("Digite o novo Id do cliente: ");
					id_cliente = entrada.nextInt();
					entrada.nextLine();

					System.out.println("Digite o novo Id da permissão: ");
					id_permissao = entrada.nextInt();
				

					Cliente cliente1 = clienteDAO.getClienteById(id_cliente);
					Permissao permissao1 = permissaoDAO.getPermissaoById(id_permissao);

					Usuario us = new Usuario(id_usuario, senha, email,permissao1,cliente1);



					usuarioDAO.update(us);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {

				for (Usuario u : usuarioDAO.getUsuario()) {

					System.out.println("----------------------------------- ");

					System.out.println("ID DO USUARIO: " + u.getId());

					System.out.println("EMAIL: " + u.getEmail());
					System.out.println("SENHA: " + u.getSenha());
					System.out.println("ID DO CLIENTE: " + u.getCliente().getId_Cliente());
					System.out.println("NOME: " + u.getCliente().getNome());
					System.out.println("CPF: " + u.getCliente().getCPF());
					System.out.println("ESTADO: " + u.getCliente().getEstado());
					System.out.println("MUNICIPIO: " + u.getCliente().getMunicipio());
					System.out.println("TELEFONE: " + u.getCliente().getTelefone());
					System.out.println("ID PERMISSAO: " + u.getPermissao().getId_Permissao());
					System.out.println("TIPO DA PERMISSAO: " + u.getPermissao().getTipo());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID do usuario para buscar: ");
				id_usuario = entrada.nextInt();

				Usuario u = new Usuario();

				u = usuarioDAO.getUsuarioById(id_usuario);

				System.out.println("ID DO USUARIO: " + u.getId());

				System.out.println("EMAIL: " + u.getEmail());
				System.out.println("SENHA: " + u.getSenha());
				System.out.println("ID DO CLIENTE: " + u.getCliente().getId_Cliente());
				System.out.println("NOME: " + u.getCliente().getNome());
				System.out.println("CPF: " + u.getCliente().getCPF());
				System.out.println("ESTADO: " + u.getCliente().getEstado());
				System.out.println("MUNICIPIO: " + u.getCliente().getMunicipio());
				System.out.println("TELEFONE: " + u.getCliente().getTelefone());
				System.out.println("ID PERMISSAO: " + u.getPermissao().getId_Permissao());
				System.out.println("TIPO DA PERMISSAO: " + u.getPermissao().getTipo());

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
