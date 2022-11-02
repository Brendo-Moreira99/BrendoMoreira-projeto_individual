package Crud;


import java.util.Scanner;

import ClassesDAO.PermissaoDAO;
import modelo.Permissao;



public class PermissaoCrud {

		
		public static void main(String args[]) {

			PermissaoDAO permissaoDAO = new PermissaoDAO();
			Permissao permissao = new Permissao();

			Scanner entrada = new Scanner(System.in);

			int opcao = 0;
			int opcao2 = 0;

			String tipo = "";
		

			int id = 0;

			do {

				System.out.println("===== Agenda de Permissões =====");
				System.out.println("1 - Cadastro de permissão");
				System.out.println("2 - Excluir permissao");
				System.out.println("3 - Atualizar permissões");
				System.out.println("4 - Mostrar lista de permissões");
				System.out.println("5 - Buscar permissões por ID");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				case 1: {
					System.out.println("Digite o tipo de permissão : ");
					tipo = entrada.next();
					permissao.setTipo(tipo);

					

					permissaoDAO.save(permissao);
					break;
				}
				case 2: {
					System.out.println("Digite o codigo da permissão: ");
					try {
						id= entrada.nextInt();

						permissaoDAO.removeById(id);

					} catch (Exception e) {
						

						System.out.println(" Nenhum contato para excluir ");
					}

					break;
				}
				case 3: {

					do {
						System.out.println("Digite o codigo da permissão: ");
						id = entrada.nextInt();

				
							System.out.println("Digite a nova permissão: ");
							tipo = entrada.next();
							permissao.setTipo(tipo);
						
						
						
					

						permissao.setId_Permissao(id);

						permissaoDAO.update(permissao);

						System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
						opcao2 = entrada.nextInt();
					} while (opcao2 != 0);

					break;
				}
				case 4: {
					for (Permissao pe : permissaoDAO.getPermissao()) {
						
						System.out.println("----------------------------------- ");
						
						System.out.println("ID: " + pe.getId_Permissao());
						System.out.println("NOME: " + pe.getTipo());
						
						

						System.out.println("----------------------------------- ");
					}
					break;
				}
				case 5: {

					System.out.print("Digite o ID para buscar: ");
					id = entrada.nextInt();

					Permissao pe = new Permissao();

					pe= permissaoDAO.getPermissaoById(id);

					System.out.println("NOME: " + pe.getTipo());
				
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

