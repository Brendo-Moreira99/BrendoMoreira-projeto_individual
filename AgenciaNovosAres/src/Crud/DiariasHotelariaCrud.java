package Crud;

import java.util.Scanner;

import ClassesDAO.DiariasHotelariaDAO;
import modelo.DiariasHotelaria;

public class DiariasHotelariaCrud {

	public static void main(String[] args) {
		
		DiariasHotelariaDAO diariasDAO = new DiariasHotelariaDAO();
		DiariasHotelaria diarias = new DiariasHotelaria();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		String rua = "";
		int dias = 0;
		String estado = "";
		String municipio = "" ;
		int numero = 0;
		String hotel = "" ;
		int quartos = 0;
		String cep = "";
		int id = 0;

		do {

			System.out.println("===== Agenda de Hoteis =====");
			System.out.println("1 - Cadastro de Hotel ou Resort ");
			System.out.println("2 - Excluir Hotel ou Resort");
			System.out.println("3 - Atualizar Hotel ou Resort");
			System.out.println("4 - Mostrar lista de Hoteis e Resorts");
			System.out.println("5 - Buscar Hoteis e Resorts ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("---- Comece digitando o endereço do Hotel/Resort --- ");
				System.out.println("Digite a rua do Hotel/Resort : ");
				entrada.nextLine();
				rua = entrada.nextLine();
				diarias.setRua(rua);
				
				
				System.out.println("Digite o numero do Hotel/Resort :");
				numero = entrada.nextInt();
				entrada.nextLine();
				
				diarias.setNumero(numero);
				
				System.out.println("Digite o cep do Hotel/Resort: ");
				cep = entrada.next();
				
				diarias.setCep(cep);
				entrada.nextLine();
				
				System.out.println("Digite o Estado do Hotel/Resort: ");
				estado = entrada.nextLine();
				diarias.setEstado(estado);
				
				System.out.println("Digite o Municipio do Hotel/Resort: ");
				municipio = entrada.nextLine();
				diarias.setMunicipio(municipio);
				
				System.out.println("Digite o nome do Hotel/Resort:");
				hotel = entrada.nextLine();
				diarias.setNome_Hotel(hotel);
				

				System.out.println("Digite a quantidade de quartos:");
				quartos = entrada.nextInt();
				diarias.setQtd_Quartos(quartos);
				
				System.out.println("Digite a quantidade de dias da diaria do Hotel/Resort:");
				dias = entrada.nextInt();
				diarias.setQtd_dias(dias);
				
				
				diariasDAO.save(diarias);
				
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do Hotel/Resort: ");
				try {
					id= entrada.nextInt();

					diariasDAO.removeById(id);
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
					System.out.println("Digite o codigo do Hotel/Resort que vai ser atualizado: ");
					id = entrada.nextInt();
					
				
					System.out.println("Digite a nova rua do Hotel/Resort : ");
					entrada.nextLine();
					rua = entrada.nextLine();
					diarias.setRua(rua);
					
					
					System.out.println("Digite o novo numero do Hotel/Resort :");
					numero = entrada.nextInt();
					entrada.nextLine();
					
					diarias.setNumero(numero);
					
					System.out.println("Digite o novo cep do Hotel/Resort: ");
					cep = entrada.next();
					
					diarias.setCep(cep);
					entrada.nextLine();
					
					System.out.println("Digite o novo Estado do Hotel/Resort: ");
					estado = entrada.nextLine();
					diarias.setEstado(estado);
					
					System.out.println("Digite o novo  Municipio do Hotel/Resort: ");
					municipio = entrada.nextLine();
					diarias.setMunicipio(municipio);
					
					System.out.println("Digite o novo nome do Hotel/Resort:");
					hotel = entrada.nextLine();
					diarias.setNome_Hotel(hotel);
					

					System.out.println("Digite a nova quantidade de quartos:");
					quartos = entrada.nextInt();
					diarias.setQtd_Quartos(quartos);
					
					System.out.println("Digite a nova quantidade de dias da diaria do Hotel/Resort:");
					dias = entrada.nextInt();
					diarias.setQtd_dias(dias);
					
					

					diarias.setId_Hotel(id);

					diariasDAO.update(diarias);
					

					System.out.println("Aperte 0 para sair ou qualquer outro número se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {
				for (DiariasHotelaria di : diariasDAO.getDiariasHotelaria()) {
					
					System.out.println("----------------------------------- ");
					
					System.out.println("ID DO HOTEL: " + di.getId_Hotel());
					System.out.println("NOME DO HOTEL/RESORT: " + di.getNome_Hotel());
					System.out.println("RUA DO HOTEL/RESORT: " + di.getRua());
					System.out.println("NUMERO DO HOTEL: " + di.getNumero());
					System.out.println("CEP: " + di.getCep());
					System.out.println("ESTADO: " + di.getEstado());
					System.out.println("MUNICIPIO: " + di.getMunicipio());
					System.out.println("DIARIAS: " + di.getQtd_dias());
					System.out.println("QUARTOS: " + di.getQtd_Quartos());
					
				
					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				try {
				System.out.print("Digite o ID para buscar: ");
				id = entrada.nextInt();

				DiariasHotelaria di = new DiariasHotelaria();

				di= diariasDAO.getDiariasHotelariaById(id);

				System.out.println("ID DO HOTEL: " + di.getId_Hotel());
				System.out.println("NOME DO HOTEL/RESORT: " + di.getNome_Hotel());
				System.out.println("RUA DO HOTEL/RESORT: " + di.getRua());
				System.out.println("NUMERO DO HOTEL: " + di.getNumero());
				System.out.println("CEP: " + di.getCep());
				System.out.println("ESTADO: " + di.getEstado());
				System.out.println("MUNICIPIO: " + di.getMunicipio());
				System.out.println("DIARIAS: " + di.getQtd_dias());
				System.out.println("QUARTOS: " + di.getQtd_Quartos());
			
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
