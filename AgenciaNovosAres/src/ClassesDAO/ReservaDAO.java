package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Usuario;

public class ReservaDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void save(Reserva reserva) {
		
	
	// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO reserva  (Id_Usuario,Valor_total,Pagamento) VALUES(?,?,?)";

		try
		{
			
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			
			pstm.setInt(1, reserva.getUsuario().getId());
		
			// Adiciona o valor do primeiro parâmetro da sql
			
			pstm.setDouble(2, reserva.getValor_total());
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(3, reserva.getPagamento());
			
		

			// Executa a sql para inserção dos dados
			pstm.execute();

		}catch(
		Exception e)
		{

			e.printStackTrace();
		}finally
		{

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

			String sql = "DELETE FROM reserva WHERE Id_Reserva = ?";

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

		public void update(Reserva reserva) {

			String sql = "UPDATE reserva SET Id_Usuario = ?, Valor_total = ? ,Pagamento = ?" + " WHERE id_Reserva = ?";
			
			
			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionToMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);


				// Adiciona o valor do primeiro parâmetro da sql
				
				pstm.setInt(1, reserva.getUsuario().getId());
			
				// Adiciona o valor do primeiro parâmetro da sql
				
				pstm.setDouble(2, reserva.getValor_total());
				
				// Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(3, reserva.getPagamento());
				
				// Adiciona o valor do 4  parâmetro da sql
				pstm.setInt(4, reserva.getId_Reserva());
			
				
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

		public List<Reserva> getReserva() {

			String sql = "select * from todos_reserva2;";

			List<Reserva> reservas = new ArrayList<Reserva>();

			// Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça
				while (rset.next()) {

					Usuario usuario = new Usuario();
					Reserva reserva = new Reserva();
					Cliente cliente = new Cliente();

					
					reserva.setId_Reserva(rset.getInt("Id_Reserva"));

					reserva.setValor_total(rset.getDouble("Valor_total"));
					
					reserva.setPagamento(rset.getString("Pagamento"));
					
					usuario.setId(rset.getInt("Id_Usuario"));
					
					usuario.setEmail(rset.getString("Email"));
					
					usuario.setSenha(rset.getString("Senha"));
					
					cliente.setEstado(rset.getString("Estado"));
					
					cliente.setData_cli(rset.getDate("Data_cli"));
					
					cliente.setNome(rset.getString("Nome"));
					
					cliente.setCPF(rset.getString("Cpf"));
					
					cliente.setTelefone(rset.getString("Telefone"));
					
					usuario.setCliente(cliente);
					
					reserva.setUsuario(usuario);
				
					reservas.add(reserva);
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

			return reservas;
		}

		public Reserva getReservaById(int id) {

				String sql = "select * from todos_reserva2 where id_Reserva = ?";
				Usuario usuario = new Usuario();
				Reserva reserva = new Reserva();
				
				
				ResultSet rset = null;

				try {
					conn = Conexao.createConnectionToMySQL();
					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, id);
					rset = pstm.executeQuery();

					rset.next();

					// Recupera o id do banco e atribui ele ao objeto
					usuario.setId(rset.getInt("Id_Usuario"));

	Cliente cliente = new Cliente();

					
					reserva.setId_Reserva(rset.getInt("Id_Reserva"));

					reserva.setValor_total(rset.getDouble("Valor_total"));
					
					reserva.setPagamento(rset.getString("Pagamento"));
					
					usuario.setId(rset.getInt("Id_Usuario"));
					
					usuario.setEmail(rset.getString("Email"));
					
					usuario.setSenha(rset.getString("Senha"));
					
					
					cliente.setData_cli(rset.getDate("Data_cli"));
					
					cliente.setEstado(rset.getString("Estado"));
					
					cliente.setNome(rset.getString("Nome"));
					
					cliente.setCPF(rset.getString("Cpf"));
					
					cliente.setTelefone(rset.getString("Telefone"));
					
					usuario.setCliente(cliente);
					
					reserva.setUsuario(usuario);
					
					
			
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
				return reserva;

	}

}
