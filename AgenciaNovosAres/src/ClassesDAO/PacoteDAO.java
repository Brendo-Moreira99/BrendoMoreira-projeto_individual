package ClassesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.DiariasHotelaria;
import modelo.Pacote;

public class PacoteDAO {

	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void save(Pacote pacote) {
		
	
	// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO pacote (Id_Hotel,Valor_Pacote,Qtd_Pessoas_Pac,Tipo,Pacote_volta,Pacote_ida,Destino, Transfer_pacote) VALUES(?,?,?,?,?,?,?,?)";

		try
		{
			
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor dos  parâmetros da sql
			
			pstm.setInt(1, pacote.getHotelaria().getId_Hotel());
			
			pstm.setDouble(2, pacote.getValor_Pacote());
			
			pstm.setInt(3, pacote.getQuantidade_Pessoas());
			
			pstm.setString(4, pacote.getTipo());
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(5, new Date(formatter.parse(pacote.getPacote_volta()).getTime()));
	
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(6, new Date(formatter2.parse(pacote.getPacote_ida()).getTime()));
			
			pstm.setString(7, pacote.getDestino());
			
			pstm.setString(8, pacote.getTransfer_pacote());

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

			String sql = "DELETE FROM pacote WHERE Id_Itens_Pacote = ?";

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

		public void update(Pacote pacote) {

			String sql = "UPDATE Pacote SET Id_Hotel = ?, Valor_Pacote = ?, Qtd_Pessoas_Pac = ?,Tipo = ?,Pacote_volta = ?,Pacote_ida = ?, Destino = ?, Transfer_pacote = ? "+
			" WHERE id_Itens_Pacote = ?";
			
			
			try {
				// Cria uma conexão com o banco
				conn = Conexao.createConnectionToMySQL();

				// Cria um PreparedStatment, classe usada para executar a query
				pstm = conn.prepareStatement(sql);


				// Adiciona o valor dos parâmetros da sql
				
				pstm.setInt(1, pacote.getHotelaria().getId_Hotel());
				
				pstm.setDouble(2, pacote.getValor_Pacote());
				
				pstm.setInt(3, pacote.getQuantidade_Pessoas());
				
				pstm.setString(4, pacote.getTipo());
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				pstm.setDate(5, new Date(formatter.parse(pacote.getPacote_volta()).getTime()));
		
				SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
				pstm.setDate(6, new Date(formatter2.parse(pacote.getPacote_ida()).getTime()));
				
				pstm.setString(7, pacote.getDestino());
				
				pstm.setString(8, pacote.getTransfer_pacote());
				
				pstm.setInt(9, pacote.getId_itens_Pacote());
				
				
				
				
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

		public List<Pacote> getPacote() {

			String sql = " select * from Pacote_todos4;";

			List<Pacote> pacotes = new ArrayList<Pacote>();

			// Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça
				while (rset.next()) {

					Pacote pacote = new Pacote();
					DiariasHotelaria diarias = new DiariasHotelaria();
			
					diarias.setNome_Hotel(rset.getString("Nome_Hotel"));
					
					diarias.setEstado(rset.getString("Estado"));
					
					
					diarias.setRua(rset.getString("Rua"));
					
					
					diarias.setNumero(rset.getInt("numero"));
			
					diarias.setQtd_dias(rset.getInt("Qtd_dias"));
				
					diarias.setQtd_Quartos(rset.getInt("Qtd_Quartos"));
					
					diarias.setMunicipio(rset.getString("Municipio"));
					
					pacote.setHotelaria(diarias);
					
					pacote.getHotelaria().setId_Hotel(rset.getInt("Id_Hotel"));
							
					
					pacote.setId_itens_Pacote(rset.getInt("Id_Itens_Pacote"));
							
					
					pacote.setQuantidade_Pessoas(rset.getInt("Qtd_Pessoas_Pac"));;
					
					pacote.setTipo(rset.getString("Tipo"));
				
					pacote.setValor_Pacote(rset.getDouble("Valor_Pacote"));
					
				
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					pacote.setPacote_ida(dateFormat.format(rset.getDate("Pacote_ida")));
					
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
					pacote.setPacote_volta(dateFormat1.format(rset.getDate("Pacote_volta")));
					
					
					pacote.setTransfer_pacote(rset.getString("Transfer_pacote"));
					
					pacote.setDestino(rset.getString("destino"));
		
					pacotes.add(pacote);
					
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

			return pacotes;
		}

		public Pacote getPacoteById(int id) {

				String sql = " select * from Pacote_todos4 where Id_Itens_Pacote = ?";
				Pacote pacote = new Pacote();
				DiariasHotelaria diarias = new DiariasHotelaria();
				
				ResultSet rset = null;

				try {
					conn = Conexao.createConnectionToMySQL();
					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, id);
					rset = pstm.executeQuery();

					rset.next();

					// Recupera o id do banco e atribui ele ao objeto
					pacote.setId_itens_Pacote((rset.getInt("Id_Itens_Pacote")));
					

					// Buscando os dados no banco de dados
					
					diarias.setNome_Hotel(rset.getString("Nome_Hotel"));
					
					diarias.setEstado(rset.getString("Estado"));
					
					
					diarias.setRua(rset.getString("Rua"));
					
					
					diarias.setNumero(rset.getInt("numero"));
			
					diarias.setQtd_dias(rset.getInt("Qtd_dias"));
				
					diarias.setQtd_Quartos(rset.getInt("Qtd_Quartos"));
					
					diarias.setMunicipio(rset.getString("Municipio"));
					
					pacote.setHotelaria(diarias);
					
					pacote.getHotelaria().setId_Hotel(rset.getInt("Id_Hotel"));
							
					
					pacote.setId_itens_Pacote(rset.getInt("Id_Itens_Pacote"));
							
					
					pacote.setQuantidade_Pessoas(rset.getInt("Qtd_Pessoas_Pac"));;
					
					pacote.setTipo(rset.getString("Tipo"));
				
					pacote.setValor_Pacote(rset.getDouble("Valor_Pacote"));
					
				
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					pacote.setPacote_ida(dateFormat.format(rset.getDate("Pacote_ida")));
					
					SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
					pacote.setPacote_volta(dateFormat1.format(rset.getDate("Pacote_volta")));
					
					pacote.setTransfer_pacote(rset.getString("Transfer_pacote"));
					
					pacote.setDestino(rset.getString("destino"));
					
					
			
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
				return pacote;

	}

	
	
	
	
}
