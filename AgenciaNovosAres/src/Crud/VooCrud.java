<<<<<<< HEAD
package Crud;

import java.util.Scanner;

import ClassesDAO.VooDAO;
import modelo.Voo;

public class VooCrud {

	public static void main(String[] args) {
	
		VooDAO vooDAO = new VooDAO();
		Voo voo = new Voo();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		String partida = "";
		int pessoas = 0;
		String destino = "";
		String volta = "" ;
		double valor = 0;
		String ida = "" ;
		int transfer = 0;
		
	

		int id = 0;

		do {

			System.out.println("===== Agenda de Voos =====");
			System.out.println("1 - Cadastro de Voo");
			System.out.println("2 - Excluir Voo");
			System.out.println("3 - Atualizar Voo");
			System.out.println("4 - Mostrar lista de Voos");
			System.out.println("5 - Buscar Voo por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o Local de Partida do voo: ");
				entrada.nextLine();
				partida = entrada.nextLine();
				voo.setLocal_Partida(partida);
				
				
				System.out.println("Quantidade de pessoas na viagem: ");
				pessoas = entrada.nextInt();
				entrada.nextLine();
				
				voo.setQuantidade_Pessoas(pessoas);
				
				System.out.println("Escreva o destino da viagem: ");
				destino = entrada.nextLine();
				
				voo.setDestino(destino);
				
				
				System.out.println("Digite a data de ida: ");
				ida = entrada.nextLine();
				voo.setData_ida(ida);
				
				System.out.println("Digite a data de volta: ");
				volta = entrada.nextLine();
				
				voo.setData_volta(volta);
				
				System.out.println("digite o valor da viagem: ");
				valor = entrada.nextInt();
				voo.setValor_viagem(valor);
				
				System.out.println("1 -  Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
				System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
				System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
				transfer = entrada.nextInt();
				
				
				voo.Transfer_saber(transfer);

				vooDAO.save(voo);
				
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do voo: ");
				try {
					id= entrada.nextInt();

					vooDAO.removeById(id);
					{
						
						
					}
				} catch (Exception e) {
					
					System.out.println("================================");
					System.out.println(" Nenhum contato para excluir ");
					System.out.println("================================");

				
				}

				break;
			}
			case 3: {

				do {
					System.out.println("Digite o codigo do voo que vai ser atualizado: ");
					id = entrada.nextInt();
					voo.setId_Voo(id);

					System.out.println("Digite o Local de Partida do voo: ");
					entrada.nextLine();
					partida = entrada.nextLine();
					voo.setLocal_Partida(partida);
					
					System.out.println("Quantidade de pessoas na nova viagem: ");
					pessoas = entrada.nextInt();
					voo.setQuantidade_Pessoas(pessoas);
					entrada.nextLine();
					
					System.out.println("Escreva o destino da nova viagem: ");
					destino = entrada.nextLine();
					voo.setDestino(destino);
					
					
					System.out.println("Digite a nova data de ida: ");
					ida = entrada.nextLine();
					voo.setData_ida(ida);
					
					System.out.println("Digite a nova data de volta: ");
					volta = entrada.nextLine();
					voo.setData_volta(volta);
					
					System.out.println("digite o novo valor da viagem: ");
					valor = entrada.nextInt();
					voo.setValor_viagem(valor);
					entrada.nextLine();
					
					System.out.println("O novo Trasfer será in/out, somente in ou somente out? ");
					
					System.out.println("1 -  Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
					System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
					System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
					transfer = entrada.nextInt();
			
					voo.Transfer_saber(transfer);
					

					

					vooDAO.update(voo);
					

					System.out.println("Aperte 0 para sair ou qualquer outro número se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {
				for (Voo vo : vooDAO.getVoo()) {
					
					System.out.println("----------------------------------- ");
					
					System.out.println("ID DO VOO: " + vo.getId_Voo());
					System.out.println("LOCAL DE PARTIDA DA VIAGEM: " + vo.getLocal_Partida());
					System.out.println("QUANTIDADE DE PESSOAS: " + vo.getQuantidade_Pessoas());
					System.out.println("DATA DE IDA: " + vo.getData_ida());
					System.out.println("DATA DE VOLTA: " + vo.getData_volta());
					System.out.println("VALOR DO VOO: R$" + vo.getValor_viagem());
					System.out.println("TRANSFER DE VIAGEM: " + vo.getTransfer());
				
					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				try {
				System.out.print("Digite o ID para buscar: ");
				id = entrada.nextInt();

				Voo vo = new Voo();

				vo= vooDAO.getVooById(id);

				System.out.println("ID DO VOO: " + vo.getId_Voo());
				System.out.println("LOCAL DE PARTIDA DA VIAGEM: " + vo.getLocal_Partida());
				System.out.println("QUANTIDADE DE PESSOAS: " + vo.getQuantidade_Pessoas());
				System.out.println("DATA DE IDA: " + vo.getData_ida());
				System.out.println("DATA DE VOLTA: " + vo.getData_volta());
				System.out.println("VALOR DO VOO: R$" + vo.getValor_viagem());
				System.out.println("TRANSFER DE VIAGEM: " + vo.getTransfer());
			
				System.out.println("----------------------------------- ");
			} catch (Exception e) {
				
				System.out.println("================================");
				System.out.println(" Nenhum contato para buscar ");
				System.out.println("================================");
			}break;}

				

			case 6: {
				System.out.println(" === Obrigado por utlizar nossos serviços === ");
				break;
			}
			default:
				System.out.println("Opcao invalida. ");

			}
			;

		} while (opcao != 6);

		entrada.close();

	}

}
=======
package Crud;

import java.util.Scanner;

import ClassesDAO.VooDAO;
import modelo.Voo;

public class VooCrud {

	public static void main(String[] args) {
	
		VooDAO vooDAO = new VooDAO();
		Voo voo = new Voo();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		String partida = "";
		int pessoas = 0;
		String destino = "";
		String volta = "" ;
		double valor = 0;
		String ida = "" ;
		int transfer = 0;
		
	

		int id = 0;

		do {

			System.out.println("===== Agenda de Voos =====");
			System.out.println("1 - Cadastro de Voo");
			System.out.println("2 - Excluir Voo");
			System.out.println("3 - Atualizar Voo");
			System.out.println("4 - Mostrar lista de Voos");
			System.out.println("5 - Buscar Voo por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o Local de Partida do voo: ");
				entrada.nextLine();
				partida = entrada.nextLine();
				voo.setLocal_Partida(partida);
				
				
				System.out.println("Quantidade de pessoas na viagem: ");
				pessoas = entrada.nextInt();
				entrada.nextLine();
				
				voo.setQuantidade_Pessoas(pessoas);
				
				System.out.println("Escreva o destino da viagem: ");
				destino = entrada.nextLine();
				
				voo.setDestino(destino);
				
				
				System.out.println("Digite a data de ida: ");
				ida = entrada.nextLine();
				voo.setData_ida(ida);
				
				System.out.println("Digite a data de volta: ");
				volta = entrada.nextLine();
				
				voo.setData_volta(volta);
				
				System.out.println("digite o valor da viagem: ");
				valor = entrada.nextInt();
				voo.setValor_viagem(valor);
				
				System.out.println("1 -  Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
				System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
				System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
				transfer = entrada.nextInt();
				
				
				voo.Transfer_saber(transfer);

				vooDAO.save(voo);
				
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do voo: ");
				try {
					id= entrada.nextInt();

					vooDAO.removeById(id);
					{
						
						
					}
				} catch (Exception e) {
					
					System.out.println("================================");
					System.out.println(" Nenhum contato para excluir ");
					System.out.println("================================");

				
				}

				break;
			}
			case 3: {

				do {
					System.out.println("Digite o codigo do voo que vai ser atualizado: ");
					id = entrada.nextInt();
					voo.setId_Voo(id);

					System.out.println("Digite o Local de Partida do voo: ");
					entrada.nextLine();
					partida = entrada.nextLine();
					voo.setLocal_Partida(partida);
					
					System.out.println("Quantidade de pessoas na nova viagem: ");
					pessoas = entrada.nextInt();
					voo.setQuantidade_Pessoas(pessoas);
					entrada.nextLine();
					
					System.out.println("Escreva o destino da nova viagem: ");
					destino = entrada.nextLine();
					voo.setDestino(destino);
					
					
					System.out.println("Digite a nova data de ida: ");
					ida = entrada.nextLine();
					voo.setData_ida(ida);
					
					System.out.println("Digite a nova data de volta: ");
					volta = entrada.nextLine();
					voo.setData_volta(volta);
					
					System.out.println("digite o novo valor da viagem: ");
					valor = entrada.nextInt();
					voo.setValor_viagem(valor);
					entrada.nextLine();
					
					System.out.println("O novo Trasfer será in/out, somente in ou somente out? ");
					
					System.out.println("1 -  Trasfer será in/out (trajeto do aeroporto até o resort e do resort até o aeroporto) ");
					System.out.println("2 - somente in (trajeto do aeroporto até o resort) ");
					System.out.println("3 - somente out(trajeto do resort até o aeroporto) ");
					transfer = entrada.nextInt();
			
					voo.Transfer_saber(transfer);
					

					

					vooDAO.update(voo);
					

					System.out.println("Aperte 0 para sair ou qualquer outro número se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {
				for (Voo vo : vooDAO.getVoo()) {
					
					System.out.println("----------------------------------- ");
					
					System.out.println("ID DO VOO: " + vo.getId_Voo());
					System.out.println("LOCAL DE PARTIDA DA VIAGEM: " + vo.getLocal_Partida());
					System.out.println("QUANTIDADE DE PESSOAS: " + vo.getQuantidade_Pessoas());
					System.out.println("DATA DE IDA: " + vo.getData_ida());
					System.out.println("DATA DE VOLTA: " + vo.getData_volta());
					System.out.println("VALOR DO VOO: R$" + vo.getValor_viagem());
					System.out.println("TRANSFER DE VIAGEM: " + vo.getTransfer());
				
					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				try {
				System.out.print("Digite o ID para buscar: ");
				id = entrada.nextInt();

				Voo vo = new Voo();

				vo= vooDAO.getVooById(id);

				System.out.println("ID DO VOO: " + vo.getId_Voo());
				System.out.println("LOCAL DE PARTIDA DA VIAGEM: " + vo.getLocal_Partida());
				System.out.println("QUANTIDADE DE PESSOAS: " + vo.getQuantidade_Pessoas());
				System.out.println("DATA DE IDA: " + vo.getData_ida());
				System.out.println("DATA DE VOLTA: " + vo.getData_volta());
				System.out.println("VALOR DO VOO: R$" + vo.getValor_viagem());
				System.out.println("TRANSFER DE VIAGEM: " + vo.getTransfer());
			
				System.out.println("----------------------------------- ");
			} catch (Exception e) {
				
				System.out.println("================================");
				System.out.println(" Nenhum contato para buscar ");
				System.out.println("================================");
			}break;}

				

			case 6: {
				System.out.println(" === Obrigado por utlizar nossos serviços === ");
				break;
			}
			default:
				System.out.println("Opcao invalida. ");

			}
			;

		} while (opcao != 6);

		entrada.close();

	}

}
>>>>>>> 0f8b9f6a000d2ff7c19dcd3b1c91c4acee1454da
