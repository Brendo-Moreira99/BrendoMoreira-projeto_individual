package Crud;

import java.util.Date;
import java.util.Scanner;

import ClassesDAO.ClienteDAO;
import modelo.Cliente;

public class ClienteCrud {
	public static void main(String args[]) {

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();

		Scanner entrada = new Scanner(System.in);

		int opcao = 0;
		int opcao2 = 0;

		String nome = "";
		String cpf = "";
		String cep = "";
		String estado = "";
		int numero = 0;
		String bairro = "";
		String telefone = "";
		String municipio = "";
		
		String rua = "";

		int id = 0;

		do {

			System.out.println("===== Agenda de clientes =====");
			System.out.println("1 - Cadastro de cliente");
			System.out.println("2 - Excluir cliente");
			System.out.println("3 - Atualizar dados");
			System.out.println("4 - Mostrar lista de clientes");
			System.out.println("5 - Buscar clientes por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcao) {
			case 1: {
				
			
				
				System.out.println("Digite o novo nome para o cliente: ");
				nome = entrada.nextLine();
				
				cliente.setNome(nome);
			
				System.out.println("Digite o novo cpf do cliente: ");
				cpf = entrada.next();
				cliente.setCPF(cpf);
				
				entrada.nextLine();
				
				System.out.println("Digite o novo Estado do cliente: ");
				estado = entrada.nextLine();
			
				cliente.setEstado(estado);
			
				System.out.println("Digite o novo Municipio do cliente : ");
				municipio = entrada.nextLine();
				
				cliente.setMunicipio(municipio);
				
				
				System.out.println("Digite o novo Bairro do cliente: ");
				bairro = entrada.nextLine();
				
				cliente.setBairro(bairro);
			
				System.out.println("Digite a rua da nova residêcia do cliente: ");
				rua = entrada.nextLine();
				
				cliente.setRua(rua);
			
				System.out.println("Digite o novo cep da residêcia do cliente: ");
				cep = entrada.next();
				cliente.setCep(cep);

				System.out.println("Digite o numero da nova residência do cliente: ");
				numero = entrada.nextInt();
				cliente.setNumero(numero);

			
				System.out.println("Digite o novo telefone do cliente: ");
				telefone = entrada.next();
				cliente.setTelefone(telefone);

				
				cliente.setData_cli(new Date());

				clienteDAO.save(cliente);
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do contato para exclusao: ");
				try {
					id= entrada.nextInt();

					clienteDAO.removeById(id);

				} catch (Exception e) {
					

					System.out.println(" Nenhum contato para excluir ");
				}

				break;
			}
			case 3: {

				do {
					System.out.println("Digite o codigo do cliente para atualizar seus dados: ");
					id = entrada.nextInt();
					entrada.nextLine();
					
						System.out.println("Digite o novo nome para o cliente: ");
						nome = entrada.nextLine();
						
						cliente.setNome(nome);
					
						System.out.println("Digite o novo cpf do cliente: ");
						cpf = entrada.next();
						cliente.setCPF(cpf);
						
						entrada.nextLine();
						
						System.out.println("Digite o novo Estado do cliente: ");
						estado = entrada.nextLine();
					
						cliente.setEstado(estado);
					
						System.out.println("Digite o novo Municipio do cliente : ");
						municipio = entrada.nextLine();
						
						cliente.setMunicipio(municipio);
						
						
						System.out.println("Digite o novo Bairro do cliente: ");
						bairro = entrada.nextLine();
						
						cliente.setBairro(bairro);
					
						System.out.println("Digite a rua da nova residêcia do cliente: ");
						rua = entrada.nextLine();
						
						cliente.setRua(rua);
					
						System.out.println("Digite o novo cep da residêcia do cliente: ");
						cep = entrada.next();
						cliente.setCep(cep);

						System.out.println("Digite o numero da nova residência do cliente: ");
						numero = entrada.nextInt();
						cliente.setNumero(numero);

					
						System.out.println("Digite o novo telefone do cliente: ");
						telefone = entrada.next();
						cliente.setTelefone(telefone);

					
					
					cliente.setData_cli(new Date());

					cliente.setId_Cliente(id);

					clienteDAO.update(cliente);

					System.out.println("Aperte 0 para sair ou qualquer outra tecla se quiser continuar: ");
					opcao2 = entrada.nextInt();
				} while (opcao2 != 0);

				break;
			}
			case 4: {
				for (Cliente c : clienteDAO.getClientes()) {

					System.out.println("ID: " + c.getId_Cliente());
					System.out.println("NOME: " + c.getNome());
					System.out.println("CPF: " + c.getCPF());
					System.out.println("ESTADO: " + c.getEstado());
					System.out.println("MUNICIPIO: " + c.getMunicipio());
					System.out.println("BAIRRO: " + c.getBairro());
					System.out.println("RUA: " + c.getRua());
					System.out.println("NUMERO: " + c.getNumero());
					System.out.println("CEP: " + c.getCep());
					System.out.println("TELEFONE: " + c.getTelefone());
					System.out.println("DATA CADASTRO: " + c.getData_cli());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				id = entrada.nextInt();

				Cliente c = new Cliente();

				c = clienteDAO.getClienteById(id);

				System.out.println("NOME: " + c.getNome());
				System.out.println("CPF: " + c.getCPF());
				System.out.println("ESTADO: " + c.getEstado());
				System.out.println("MUNICIPIO: " + c.getMunicipio());
				System.out.println("BAIRRO: " + c.getBairro());
				System.out.println("RUA: " + c.getRua());
				System.out.println("NUMERO: " + c.getNumero());
				System.out.println("CEP: " + c.getCep());
				System.out.println("TELEFONE: " + c.getTelefone());
				System.out.println("DATA CADASTRO: " + c.getData_cli());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Obrigado por utlizar nossos serviços === ");
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
