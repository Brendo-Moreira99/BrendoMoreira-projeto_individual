package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	

	public void save(Cliente cliente) {

		 // Os ? são os parâmetros que nós vamos adicionar na base de dados 		 

		String sql = "INSERT INTO cliente(Rua,Bairro,Data_cli,Municipio,Numero,Estado,Telefone,Cep,Cpf,Nome)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();


			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cliente.getRua());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, cliente.getBairro());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(cliente.getData_cli().getTime()));
			// Adiciona o valor do quarto parâmetro da sql
			pstm.setString(4,cliente.getMunicipio());
			// Adiciona o valor do quinto parâmetro da sql
			pstm.setInt(5,cliente.getNumero());
			// Adiciona o valor do sexto parâmetro da sql
			pstm.setString(6,cliente.getEstado());
			// Adiciona o valor do sétimo parâmetro da sql
			pstm.setString(7,cliente.getTelefone());
			// Adiciona o valor do oitavo parâmetro da sql
			pstm.setString(8,cliente.getCep());
			// Adiciona o valor do nono parâmetro da sql
			pstm.setString(9,cliente.getCPF());
			// Adiciona o valor do décimo parâmetro da sql
			pstm.setString(10,cliente.getNome());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM cliente WHERE Id_Cliente = ?";

		try {
			conn = Conexao.createConnectionToMySQL(); // cria a conexao

			pstm = conn.prepareStatement(sql); // passa comando sql para o objeto pstm

			pstm.setInt(1, id); // seta o id no comando sql

			pstm.execute(); // executa o comando sql que está no objeto pstm

		} catch (Exception e) {			
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET Rua = ?,  Bairro = ?, Data_cli= ?, Municipio = ?, Numero=?, Estado=?,Telefone=?,Cep=?,Cpf=?,Nome=?  " + " WHERE Id_Cliente = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cliente.getRua());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, cliente.getBairro());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setDate(3, new Date(cliente.getData_cli().getTime()));
			// Adiciona o valor do quarto parâmetro da sql
			pstm.setString(4,cliente.getMunicipio());
			// Adiciona o valor do quinto parâmetro da sql
			pstm.setInt(5,cliente.getNumero());
			// Adiciona o valor do sexto parâmetro da sql
			pstm.setString(6,cliente.getEstado());
			// Adiciona o valor do sétimo parâmetro da sql
			pstm.setString(7,cliente.getTelefone());
			// Adiciona o valor do oitavo parâmetro da sql
			pstm.setString(8,cliente.getCep());
			// Adiciona o valor do nono parâmetro da sql
			pstm.setString(9,cliente.getCPF());
			// Adiciona o valor do décimo parâmetro da sql
			pstm.setString(10,cliente.getNome());

			pstm.setInt(11, cliente.getId_Cliente());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Cliente cliente = new Cliente();

				// Recupera o id do banco e atribui ele ao objeto
				cliente.setId_Cliente(rset.getInt("Id_Cliente"));

				// Recupera o Nome do banco e atribui ele ao objeto
				cliente.setNome(rset.getString("Nome"));

				// Recupera a rua do banco e atribui ele ao objeto
				cliente.setRua(rset.getString("Rua")); 

				// Recupera o Bairro do banco e atribui ele ao objeto
				cliente.setBairro(rset.getString("Bairro"));
				

				// Recupera a data do banco e atribui ela ao objeto
				cliente.setData_cli(rset.getDate("Data_cli"));
				

				// Recupera o Municipio do banco e atribui ele ao objeto
				cliente.setMunicipio(rset.getString("Municipio"));
				
				// Recupera o numero do banco e atribui ele ao objeto
				cliente.setNumero(rset.getInt("Numero"));

				// Recupera o Estdo do banco e atribui ele ao objeto
				cliente.setEstado(rset.getString("Estado"));
				
				// Recupera o Bairro do banco e atribui ele ao objeto
				cliente.setTelefone(rset.getString("Telefone"));
				
				// Recupera o Cep do banco e atribui ele ao objeto
				cliente.setCep(rset.getString("Cep"));
				
				// Recupera o Cpf do banco e atribui ele ao objeto
				cliente.setCPF(rset.getString("Cpf"));
				

				
				// Adiciono o cliente recuperado, a lista de clientes
				clientes.add(cliente);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return clientes;
	}
	
	public Cliente getClienteById(int id) {

		String sql = "SELECT * FROM cliente where Id_Cliente = ?";
		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			// Recupera o id do banco e atribui ele ao objeto
			cliente.setId_Cliente(rset.getInt("Id_Cliente"));

			// Recupera a rua do banco e atribui ele ao objeto
			cliente.setRua(rset.getString("Rua")); 

			// Recupera o Bairro do banco e atribui ele ao objeto
			cliente.setBairro(rset.getString("Bairro"));
			

			// Recupera a cidade do banco e atribui ela ao objeto
			cliente.setData_cli(rset.getDate("Data_cli"));
			

			// Recupera o Municipio do banco e atribui ele ao objeto
			cliente.setMunicipio(rset.getString("Municipio"));
			
			// Recupera o numero do banco e atribui ele ao objeto
			cliente.setNumero(rset.getInt("Numero"));

			// Recupera o Estdo do banco e atribui ele ao objeto
			cliente.setEstado(rset.getString("Estado"));
			
			// Recupera o Telefone do banco e atribui ele ao objeto
			cliente.setTelefone(rset.getString("Telefone"));
			
			// Recupera o Cep do banco e atribui ele ao objeto
			cliente.setCep(rset.getString("Cep"));
			
			// Recupera o Cpf do banco e atribui ele ao objeto
			cliente.setCPF(rset.getString("Cpf"));
			
			// Recupera o Telefone do banco e atribui ele ao objeto
			cliente.setNome(rset.getString("Nome"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}
}

