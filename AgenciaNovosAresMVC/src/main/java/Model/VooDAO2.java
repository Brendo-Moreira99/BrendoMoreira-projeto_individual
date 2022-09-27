package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class VooDAO2{
	
	Connection conn = null;
	PreparedStatement pstm = null;
	

	public void save(Voo voo) {

		String sql = "INSERT INTO Voo(Local_Partida, Quantidade_Pessoas, destino_voo,Data_volta, Valor_viagem, Data_ida, Transfer)" + " VALUES(?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, voo.getLocal_Partida());
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(2, voo.getQuantidade_Pessoas());
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(3, voo.getDestino());
			
			// Adiciona o valor do primeiro parâmetro da sql
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(4, new Date(formatter.parse(voo.getData_volta()).getTime()));
			
			pstm.setDouble(5, voo.getValor_viagem());
			
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(6, new Date(formatter2.parse(voo.getData_ida()).getTime()));
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(7, voo.getTransfer());
			
		
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

		String sql = "DELETE FROM Voo WHERE Id_Voo = ?";

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

	public void update(Voo voo) {

		String sql = "UPDATE voo SET Local_Partida = ?,  Quantidade_Pessoas = ?, destino_voo = ?, Data_volta = ?, Data_ida = ?, Transfer = ?, Valor_viagem =?  " + " WHERE Id_Voo = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, voo.getLocal_Partida());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, voo.getQuantidade_Pessoas());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, voo.getDestino());
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(4, new Date(formatter.parse(voo.getData_volta()).getTime()));
			
			SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(5, new Date(formatter2.parse(voo.getData_ida()).getTime()));
			
			// Adiciona o valor do sexto parâmetro da sql
			pstm.setString(6,voo.getTransfer());
			// Adiciona o valor do sétimo parâmetro da sql
			pstm.setDouble(7,voo.getValor_viagem());
			
			pstm.setInt(8, voo.getID_Voo());

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

	public List<Voo> getVoo() {

		String sql = "SELECT * FROM Voo";

		List<Voo> voos = new ArrayList<Voo>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Voo voo = new Voo();

				//id
				voo.setID_Voo(rset.getInt("Id_Voo"));
				// 1
				voo.setLocal_Partida(rset.getString("Local_Partida")); 
				//2
				voo.setQuantidade_Pessoas(rset.getInt("Quantidade_Pessoas"));
				//3
				voo.setDestino(rset.getString("destino_voo"));
				//4
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				voo.setData_ida(dateFormat.format(rset.getDate("Data_ida"))); 
				//5
				voo.setValor_viagem(rset.getDouble("Valor_viagem"));
		
				//6
				SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setData_volta(dateFormat2.format(rset.getDate("Data_volta")));
				//7
				voo.setTransfer(rset.getString("Transfer"));
				
				// Adiciono o voo recuperado, a lista de voos
				voos.add(voo);
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

		return voos;
	}
	
	public Voo getVooById(int id) {

		String sql = "SELECT * FROM Voo where Id_Voo = ?";
		Voo voo = new Voo();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			// 1
			voo.setLocal_Partida(rset.getString("Local_Partida")); 
			//2
			voo.setQuantidade_Pessoas(rset.getInt("Quantidade_Pessoas"));
			//3
			voo.setDestino(rset.getString("destino_voo"));
			//4
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			voo.setData_ida(dateFormat.format(rset.getDate("Data_ida"))); 
			//5
			voo.setValor_viagem(rset.getDouble("Valor_viagem"));
			
			//6
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
			voo.setData_volta(dateFormat2.format(rset.getDate("Data_volta")));
			//7
			voo.setTransfer(rset.getString("Transfer"));
			
			
			//buscar id
			voo.setID_Voo(rset.getInt("Id_Voo"));
			
			

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
		return voo;
	}
}


