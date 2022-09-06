package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.Permissao;

public class PermissaoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Permissao permissao) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO permissao (Tipo)" + " VALUES(?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, permissao.getTipo());

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

		String sql = "DELETE FROM permissao WHERE Id_Permissao = ?";

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

	public void update(Permissao permissao) {

		String sql = "UPDATE permissao SET Tipo = ?" + " WHERE Id_Permissao = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, permissao.getTipo());

			// Passa o Id para a busca
			pstm.setInt(2, permissao.getId_Permissao());

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

	public List<Permissao> getPermissao() {

		String sql = "SELECT * FROM permissao";

		List<Permissao> permissoes = new ArrayList<Permissao>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Permissao permissao = new Permissao();

				// Recupera o id do banco e atribui ele ao objeto
				permissao.setId_Permissao(rset.getInt("Id_Permissao"));

				// Recupera o Nome do banco e atribui ele ao objeto
				permissao.setTipo(rset.getString("Tipo"));

				// Adiciono o cliente recuperado, a lista de clientes
				permissoes.add(permissao);
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

		return permissoes;
	}

	public Permissao getPermissaoById(int id) {

		String sql = "SELECT * FROM permissao where Id_Permissao = ?";
		Permissao permissao = new Permissao();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			// Recupera o id do banco e atribui ele ao objeto
			permissao.setId_Permissao(rset.getInt("Id_Permissao"));

			// Recupera a rua do banco e atribui ele ao objeto
			permissao.setTipo(rset.getString("Tipo"));

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
		return permissao;
	}
}
