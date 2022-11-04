<<<<<<< HEAD
package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.DiariasHotelaria;

public class DiariasHotelariaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(DiariasHotelaria diarias) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO DiariasHotelaria(Qtd_dias, Rua, Numero,Cep, Estado, Municipio, Nome_Hotel,Qtd_Quartos)"
				+ " VALUES(?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, diarias.getQtd_dias());

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(2, diarias.getRua());

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(3, diarias.getNumero());

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(4, diarias.getCep());

			pstm.setString(5, diarias.getEstado());

			pstm.setString(6, diarias.getMunicipio());

			pstm.setString(7, diarias.getNome_Hotel());

			pstm.setInt(8, diarias.getQtd_Quartos());

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

		String sql = "DELETE FROM DiariasHotelaria WHERE Id_Hotel = ?";

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

	public void update(DiariasHotelaria diarias) {

		String sql = "UPDATE DiariasHotelaria SET Qtd_dias = ?, Rua=?, Numero=?,Cep=?, Estado=?, Municipio=?, Nome_Hotel=?,Qtd_Quartos=?"
				+ " WHERE Id_Hotel= ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, diarias.getQtd_dias());

			pstm.setString(2, diarias.getRua());

			pstm.setInt(3, diarias.getNumero());

			pstm.setString(4, diarias.getCep());

			pstm.setString(5, diarias.getEstado());

			pstm.setString(6, diarias.getMunicipio());

			pstm.setString(7, diarias.getNome_Hotel());

			pstm.setInt(8, diarias.getQtd_Quartos());

			pstm.setInt(9, diarias.getId_Hotel());

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

	public List<DiariasHotelaria> getDiariasHotelaria() {

		String sql = "SELECT * FROM DiariasHotelaria";

		List<DiariasHotelaria> diariasH = new ArrayList<DiariasHotelaria>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				DiariasHotelaria diarias = new DiariasHotelaria();

				// id
				diarias.setId_Hotel(rset.getInt("Id_Hotel"));
				// 1
				diarias.setQtd_dias(rset.getInt("Qtd_dias"));
				// 2 
				diarias.setRua(rset.getString("Rua"));
				// 3 
				diarias.setNumero(rset.getInt("Numero"));
				// 4
				diarias.setCep(rset.getString("Cep"));
				// 5
				diarias.setEstado(rset.getString("Estado"));
				// 6
				diarias.setMunicipio(rset.getString("Municipio"));
				// 7 
				diarias.setNome_Hotel(rset.getString("Nome_Hotel"));
				// 8 
				diarias.setQtd_Quartos(rset.getInt("Qtd_Quartos"));
				
				
				
				// Adiciono o voo recuperado, a lista de voos
				diariasH.add(diarias);
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

		return diariasH;
	}

	public DiariasHotelaria getDiariasHotelariaById(int id) {

		String sql = "SELECT * FROM DiariasHotelaria where Id_Hotel = ?";
		DiariasHotelaria diarias = new DiariasHotelaria();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			// 1
			diarias.setId_Hotel(rset.getInt("Id_Hotel"));
			// 1
			diarias.setQtd_dias(rset.getInt("Qtd_dias"));
			// 2 
			diarias.setRua(rset.getString("Rua"));
			// 3 
			diarias.setNumero(rset.getInt("Numero"));
			// 4
			diarias.setCep(rset.getString("Cep"));
			// 5
			diarias.setEstado(rset.getString("Estado"));
			// 6
			diarias.setMunicipio(rset.getString("Municipio"));
			// 7 
			diarias.setNome_Hotel(rset.getString("Nome_Hotel"));
			// 8 
			diarias.setQtd_Quartos(rset.getInt("Qtd_Quartos"));

			// buscar id
			diarias.setId_Hotel((rset.getInt("Id_Hotel")));

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
		return diarias;
	}

}
=======
package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.DiariasHotelaria;

public class DiariasHotelariaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(DiariasHotelaria diarias) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO DiariasHotelaria(Qtd_dias, Rua, Numero,Cep, Estado, Municipio, Nome_Hotel,Qtd_Quartos)"
				+ " VALUES(?,?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, diarias.getQtd_dias());

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(2, diarias.getRua());

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(3, diarias.getNumero());

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(4, diarias.getCep());

			pstm.setString(5, diarias.getEstado());

			pstm.setString(6, diarias.getMunicipio());

			pstm.setString(7, diarias.getNome_Hotel());

			pstm.setInt(8, diarias.getQtd_Quartos());

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

		String sql = "DELETE FROM DiariasHotelaria WHERE Id_Hotel = ?";

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

	public void update(DiariasHotelaria diarias) {

		String sql = "UPDATE DiariasHotelaria SET Qtd_dias = ?, Rua=?, Numero=?,Cep=?, Estado=?, Municipio=?, Nome_Hotel=?,Qtd_Quartos=?"
				+ " WHERE Id_Hotel= ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, diarias.getQtd_dias());

			pstm.setString(2, diarias.getRua());

			pstm.setInt(3, diarias.getNumero());

			pstm.setString(4, diarias.getCep());

			pstm.setString(5, diarias.getEstado());

			pstm.setString(6, diarias.getMunicipio());

			pstm.setString(7, diarias.getNome_Hotel());

			pstm.setInt(8, diarias.getQtd_Quartos());

			pstm.setInt(9, diarias.getId_Hotel());

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

	public List<DiariasHotelaria> getDiariasHotelaria() {

		String sql = "SELECT * FROM DiariasHotelaria";

		List<DiariasHotelaria> diariasH = new ArrayList<DiariasHotelaria>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				DiariasHotelaria diarias = new DiariasHotelaria();

				// id
				diarias.setId_Hotel(rset.getInt("Id_Hotel"));
				// 1
				diarias.setQtd_dias(rset.getInt("Qtd_dias"));
				// 2 
				diarias.setRua(rset.getString("Rua"));
				// 3 
				diarias.setNumero(rset.getInt("Numero"));
				// 4
				diarias.setCep(rset.getString("Cep"));
				// 5
				diarias.setEstado(rset.getString("Estado"));
				// 6
				diarias.setMunicipio(rset.getString("Municipio"));
				// 7 
				diarias.setNome_Hotel(rset.getString("Nome_Hotel"));
				// 8 
				diarias.setQtd_Quartos(rset.getInt("Qtd_Quartos"));
				
				
				
				// Adiciono o voo recuperado, a lista de voos
				diariasH.add(diarias);
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

		return diariasH;
	}

	public DiariasHotelaria getDiariasHotelariaById(int id) {

		String sql = "SELECT * FROM DiariasHotelaria where Id_Hotel = ?";
		DiariasHotelaria diarias = new DiariasHotelaria();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			// 1
			diarias.setId_Hotel(rset.getInt("Id_Hotel"));
			// 1
			diarias.setQtd_dias(rset.getInt("Qtd_dias"));
			// 2 
			diarias.setRua(rset.getString("Rua"));
			// 3 
			diarias.setNumero(rset.getInt("Numero"));
			// 4
			diarias.setCep(rset.getString("Cep"));
			// 5
			diarias.setEstado(rset.getString("Estado"));
			// 6
			diarias.setMunicipio(rset.getString("Municipio"));
			// 7 
			diarias.setNome_Hotel(rset.getString("Nome_Hotel"));
			// 8 
			diarias.setQtd_Quartos(rset.getInt("Qtd_Quartos"));

			// buscar id
			diarias.setId_Hotel((rset.getInt("Id_Hotel")));

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
		return diarias;
	}

}
>>>>>>> 0f8b9f6a000d2ff7c19dcd3b1c91c4acee1454da
