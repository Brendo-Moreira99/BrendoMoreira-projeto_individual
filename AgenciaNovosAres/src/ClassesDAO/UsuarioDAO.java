package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.Cliente;
import modelo.Permissao;
import modelo.Usuario;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;
	

	public void save(Usuario usuario) {

	// Os ? são os parâmetros que nós vamos adicionar na base de dados

	String sql = "INSERT INTO Usuario  (Email,Senha,Id_Permissao,Id_Cliente) VALUES(?,?,?,?)";

	try
	{
		// Cria uma conexão com o banco
		conn = Conexao.createConnectionToMySQL();

		// Cria um PreparedStatment, classe usada para executar a query
		pstm = conn.prepareStatement(sql);

		// Adiciona o valor do primeiro parâmetro da sql
		pstm.setString(1, usuario.getEmail());
		
		// Adiciona o valor do primeiro parâmetro da sql
		pstm.setString(2, usuario.getSenha());
		
		// Adiciona o valor do primeiro parâmetro da sql
		pstm.setInt(3, usuario.getPermissao().getId_Permissao());
		
		// Adiciona o valor do primeiro parâmetro da sql
		pstm.setInt(4, usuario.getCliente().getId_Cliente());

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

		String sql = "DELETE FROM Usuario WHERE Id_Usuario = ?";

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

	public void update(Usuario usuario) {

		String sql = "UPDATE usuario SET Email = ?, Senha= ? , Id_Permissao = ? , Id_Cliente = ? " + " WHERE id_Usuario = ?";
		
		
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getEmail());
			
			// Adiciona o valor do segundo parâmetro da sql
			pstm.setString(2, usuario.getSenha());
			
			// Adiciona o valor do terceiroparâmetro da sql
			pstm.setInt(3, usuario.getPermissao().getId_Permissao());
			
			// Adiciona o valor do querto parâmetro da sql
			pstm.setInt(4, usuario.getCliente().getId_Cliente());
			
			// Adiciona o valor do quinto parâmetro da sql
			pstm.setInt(5, usuario.getId());
			
		
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

	public List<Usuario> getUsuario() {

		String sql = "select * from usuarios_completo; ";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Usuario usuario = new Usuario();
				Cliente cliente = new Cliente();
				Permissao permissao = new Permissao();

				
				usuario.setId(rset.getInt("Id_Usuario"));

			
				usuario.setEmail(rset.getString("Email"));
				
				
				usuario.setSenha(rset.getString("Senha"));
				
				
				cliente.setId_Cliente(rset.getInt("Id_Cliente"));
				
				
				cliente.setNome(rset.getString("Nome"));
				
				
				cliente.setEstado(rset.getString("Estado"));
				

		
				cliente.setTelefone(rset.getString("Telefone"));
				
			
				cliente.setCPF(rset.getString("Cpf"));
				
				
				cliente.setMunicipio(rset.getString("Municipio"));
				
				usuario.setCliente(cliente);
				
				
				permissao.setId_Permissao(rset.getInt("Id_Permissao"));
				
				
				permissao.setTipo(rset.getString("Tipo"));
				
				usuario.setPermissao(permissao);
		
			
				usuarios.add(usuario);
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

		return usuarios;
	}

	public Usuario getUsuarioById(int id) {

			String sql = "select * from usuarios_completo where id_Usuario = ?";
			Usuario usuario = new Usuario();
			Cliente cliente = new Cliente();
			Permissao permissao = new Permissao();
			
			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rset = pstm.executeQuery();

				rset.next();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setId(rset.getInt("Id_Usuario"));

				// Recupera o Email do banco e atribui ele ao objeto
				usuario.setEmail(rset.getString("Email"));
				
				// Recupera a senha do banco e atribui ele ao objeto
				usuario.setSenha(rset.getString("Senha"));
				
				// Recuperao id do banco e atribui ele ao objeto
				cliente.setId_Cliente(rset.getInt("Id_Cliente"));
				
				// Recupera o Nome do banco e atribui ele ao objeto
				cliente.setNome(rset.getString("Nome"));
				
				// Recupera o Estdo do banco e atribui ele ao objeto
				cliente.setEstado(rset.getString("Estado"));
				

				// Recupera o Bairro do banco e atribui ele ao objeto
				cliente.setTelefone(rset.getString("Telefone"));
				
				// Recupera o Cpf do banco e atribui ele ao objeto
				cliente.setCPF(rset.getString("Cpf"));
				
				// Recupera o Municipio do banco e atribui ele ao objeto
				cliente.setMunicipio(rset.getString("Municipio"));
				
				usuario.setCliente(cliente);
				
				// Recupera a permissao do banco e atribui ele ao objeto
				permissao.setId_Permissao(rset.getInt("Id_Permissao"));
				
				// Recupera o Nome do banco e atribui ele ao objeto
				permissao.setTipo(rset.getString("Tipo"));
				
				usuario.setPermissao(permissao);
		
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
			return usuario;

}
	}
