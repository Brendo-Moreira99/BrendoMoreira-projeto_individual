<<<<<<< HEAD
package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.Itens_Compra;
import modelo.Pacote;
import modelo.Reserva;
import modelo.Voo;

public class Itens_CompraDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Itens_Compra itens) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO Itens_Compra(Id_itens_Pacote,Id_Voo ,Valor_Itens,Quantidade,Id_Reserva) VALUES(?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o primeiro parâmetro da sql
			pstm.setInt(1, itens.getPack().getId_itens_Pacote());

			pstm.setInt(2, itens.getVoo().getId_Voo());

			pstm.setDouble(3, itens.getValor_itens());

			pstm.setInt(4, itens.getQuantidade());

			pstm.setInt(5, itens.getReserva().getId_Reserva());

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

		String sql = "DELETE FROM Itens_compra WHERE Id_ItensCompra = ?";

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

	public void update(Itens_Compra itens) {

		String sql = "UPDATE Itens_compra SET Id_itens_Pacote = ?, Id_Voo = ?, Valor_Itens = ?, Quantidade = ?, Id_Reserva = ?"
				+ " WHERE Id_ItensCompra = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona os valores dos parâmetros da sql
			pstm.setInt(1, itens.getPack().getId_itens_Pacote());

			pstm.setInt(2, itens.getVoo().getId_Voo());

			pstm.setDouble(3, itens.getValor_itens());

			pstm.setInt(4, itens.getQuantidade());

			pstm.setInt(5, itens.getReserva().getId_Reserva());

			pstm.setInt(6, itens.getId_itensCompra());

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

	public List<Itens_Compra> getItensCompra() {

		String sql = "select * from Itens_geral1";

		List<Itens_Compra> itens_compra = new ArrayList<Itens_Compra>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Reserva reserva = new Reserva();
			
				Pacote pacote = new Pacote();
				Voo voo = new Voo();
				Itens_Compra itens = new Itens_Compra();

				// pacote
				pacote.getHotelaria().setId_Hotel(rset.getInt("Id_Hotel"));
				pacote.setValor_Pacote(rset.getDouble("Valor_Pacote"));
				pacote.setValor_Pacote(rset.getInt("Quantidade"));
				pacote.setTipo(rset.getString("tipo"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				pacote.setPacote_ida(dateFormat.format(rset.getDate("Pacote_ida")));

				SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
				pacote.setPacote_volta(dateFormat2.format(rset.getDate("Pacote_volta")));

				pacote.setDestino(rset.getString("Destino"));
				pacote.setTransfer_pacote(rset.getString("transfer_pacote"));
				pacote.setTransfer_pacote(rset.getString("transfer_pacote"));

				itens.setPack(pacote);

				// reserva
				reserva.getUsuario().setId(rset.getInt("transfer_pacote"));
				reserva.setValor_total(rset.getInt("Valor_total"));
				reserva.setPagamento(rset.getString("pagamento"));

				itens.setReserva(reserva);

				// voo
				voo.setQuantidade_Pessoas(rset.getInt("quantidade_pessoas"));
				voo.setDestino(rset.getString("destino_voo"));

				SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setData_ida(dateFormat3.format(rset.getDate("Data_ida")));

				SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setData_volta(dateFormat1.format(rset.getDate("Data_volta")));

				voo.setTransfer(rset.getString("transfer"));

				itens.setVoo(voo);

				// itens
				itens.setId_itensCompra(rset.getInt("Id_itensCompra"));
				itens.getPack().setId_itens_Pacote(rset.getInt("Id_Itens_Pacote"));
				itens.getReserva().setId_Reserva(rset.getInt("Id_Reserva"));
				itens.getVoo().setId_Voo(rset.getInt("id_Voo"));
				itens.setValor_itens(rset.getInt("Valor_Itens"));
				itens.setQuantidade(rset.getInt("Quantidade"));

				itens_compra.add(itens);

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

		return itens_compra;
	}

	public Itens_Compra getItens_CompraById(int id) {

		String sql = "select * from Itens_geral1 where id_ItensCompra = ?";
		Reserva reserva = new Reserva();
		Pacote pacote = new Pacote();
		Voo voo = new Voo();
		Itens_Compra itens = new Itens_Compra();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			// pacote
			pacote.getHotelaria().setId_Hotel(rset.getInt("Id_Hotel"));
			pacote.setValor_Pacote(rset.getDouble("Valor_Pacote"));
			pacote.setValor_Pacote(rset.getInt("Quantidade"));
			pacote.setTipo(rset.getString("tipo"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			pacote.setPacote_ida(dateFormat.format(rset.getDate("Pacote_ida")));

			SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
			pacote.setPacote_volta(dateFormat2.format(rset.getDate("Pacote_volta")));

			pacote.setDestino(rset.getString("Destino"));
			pacote.setTransfer_pacote(rset.getString("transfer_pacote"));
			pacote.setTransfer_pacote(rset.getString("transfer_pacote"));

			itens.setPack(pacote);

			// reserva
			reserva.getUsuario().setId(rset.getInt("transfer_pacote"));
			reserva.setValor_total(rset.getInt("Valor_total"));
			reserva.setPagamento(rset.getString("pagamento"));

			itens.setReserva(reserva);

			// voo
			voo.setQuantidade_Pessoas(rset.getInt("quantidade_pessoas"));
			voo.setDestino(rset.getString("destino_voo"));

			SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
			voo.setData_ida(dateFormat3.format(rset.getDate("Data_ida")));

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			voo.setData_volta(dateFormat1.format(rset.getDate("Data_volta")));

			voo.setTransfer(rset.getString("transfer"));

			itens.setVoo(voo);

			// itens
			itens.setId_itensCompra(rset.getInt("Id_itensCompra"));
			itens.getPack().setId_itens_Pacote(rset.getInt("Id_Itens_Pacote"));
			itens.getReserva().setId_Reserva(rset.getInt("Id_Reserva"));
			itens.getVoo().setId_Voo(rset.getInt("id_Voo"));
			itens.setValor_itens(rset.getInt("Valor_Itens"));
			itens.setQuantidade(rset.getInt("Quantidade"));

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
		return itens;

	}
}
=======
package ClassesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectionMySQL.Conexao;
import modelo.Itens_Compra;
import modelo.Pacote;
import modelo.Reserva;
import modelo.Voo;

public class Itens_CompraDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Itens_Compra itens) {

		// Os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO Itens_Compra(Id_itens_Pacote,Id_Voo ,Valor_Itens,Quantidade,Id_Reserva) VALUES(?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o primeiro parâmetro da sql
			pstm.setInt(1, itens.getPack().getId_itens_Pacote());

			pstm.setInt(2, itens.getVoo().getId_Voo());

			pstm.setDouble(3, itens.getValor_itens());

			pstm.setInt(4, itens.getQuantidade());

			pstm.setInt(5, itens.getReserva().getId_Reserva());

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

		String sql = "DELETE FROM Itens_compra WHERE Id_ItensCompra = ?";

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

	public void update(Itens_Compra itens) {

		String sql = "UPDATE Itens_compra SET Id_itens_Pacote = ?, Id_Voo = ?, Valor_Itens = ?, Quantidade = ?, Id_Reserva = ?"
				+ " WHERE Id_ItensCompra = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona os valores dos parâmetros da sql
			pstm.setInt(1, itens.getPack().getId_itens_Pacote());

			pstm.setInt(2, itens.getVoo().getId_Voo());

			pstm.setDouble(3, itens.getValor_itens());

			pstm.setInt(4, itens.getQuantidade());

			pstm.setInt(5, itens.getReserva().getId_Reserva());

			pstm.setInt(6, itens.getId_itensCompra());

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

	public List<Itens_Compra> getItensCompra() {

		String sql = "select * from Itens_geral1";

		List<Itens_Compra> itens_compra = new ArrayList<Itens_Compra>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Reserva reserva = new Reserva();
			
				Pacote pacote = new Pacote();
				Voo voo = new Voo();
				Itens_Compra itens = new Itens_Compra();

				// pacote
				pacote.getHotelaria().setId_Hotel(rset.getInt("Id_Hotel"));
				pacote.setValor_Pacote(rset.getDouble("Valor_Pacote"));
				pacote.setValor_Pacote(rset.getInt("Quantidade"));
				pacote.setTipo(rset.getString("tipo"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				pacote.setPacote_ida(dateFormat.format(rset.getDate("Pacote_ida")));

				SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
				pacote.setPacote_volta(dateFormat2.format(rset.getDate("Pacote_volta")));

				pacote.setDestino(rset.getString("Destino"));
				pacote.setTransfer_pacote(rset.getString("transfer_pacote"));
				pacote.setTransfer_pacote(rset.getString("transfer_pacote"));

				itens.setPack(pacote);

				// reserva
				reserva.getUsuario().setId(rset.getInt("transfer_pacote"));
				reserva.setValor_total(rset.getInt("Valor_total"));
				reserva.setPagamento(rset.getString("pagamento"));

				itens.setReserva(reserva);

				// voo
				voo.setQuantidade_Pessoas(rset.getInt("quantidade_pessoas"));
				voo.setDestino(rset.getString("destino_voo"));

				SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setData_ida(dateFormat3.format(rset.getDate("Data_ida")));

				SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				voo.setData_volta(dateFormat1.format(rset.getDate("Data_volta")));

				voo.setTransfer(rset.getString("transfer"));

				itens.setVoo(voo);

				// itens
				itens.setId_itensCompra(rset.getInt("Id_itensCompra"));
				itens.getPack().setId_itens_Pacote(rset.getInt("Id_Itens_Pacote"));
				itens.getReserva().setId_Reserva(rset.getInt("Id_Reserva"));
				itens.getVoo().setId_Voo(rset.getInt("id_Voo"));
				itens.setValor_itens(rset.getInt("Valor_Itens"));
				itens.setQuantidade(rset.getInt("Quantidade"));

				itens_compra.add(itens);

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

		return itens_compra;
	}

	public Itens_Compra getItens_CompraById(int id) {

		String sql = "select * from Itens_geral1 where id_ItensCompra = ?";
		Reserva reserva = new Reserva();
		Pacote pacote = new Pacote();
		Voo voo = new Voo();
		Itens_Compra itens = new Itens_Compra();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			// pacote
			pacote.getHotelaria().setId_Hotel(rset.getInt("Id_Hotel"));
			pacote.setValor_Pacote(rset.getDouble("Valor_Pacote"));
			pacote.setValor_Pacote(rset.getInt("Quantidade"));
			pacote.setTipo(rset.getString("tipo"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			pacote.setPacote_ida(dateFormat.format(rset.getDate("Pacote_ida")));

			SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
			pacote.setPacote_volta(dateFormat2.format(rset.getDate("Pacote_volta")));

			pacote.setDestino(rset.getString("Destino"));
			pacote.setTransfer_pacote(rset.getString("transfer_pacote"));
			pacote.setTransfer_pacote(rset.getString("transfer_pacote"));

			itens.setPack(pacote);

			// reserva
			reserva.getUsuario().setId(rset.getInt("transfer_pacote"));
			reserva.setValor_total(rset.getInt("Valor_total"));
			reserva.setPagamento(rset.getString("pagamento"));

			itens.setReserva(reserva);

			// voo
			voo.setQuantidade_Pessoas(rset.getInt("quantidade_pessoas"));
			voo.setDestino(rset.getString("destino_voo"));

			SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
			voo.setData_ida(dateFormat3.format(rset.getDate("Data_ida")));

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			voo.setData_volta(dateFormat1.format(rset.getDate("Data_volta")));

			voo.setTransfer(rset.getString("transfer"));

			itens.setVoo(voo);

			// itens
			itens.setId_itensCompra(rset.getInt("Id_itensCompra"));
			itens.getPack().setId_itens_Pacote(rset.getInt("Id_Itens_Pacote"));
			itens.getReserva().setId_Reserva(rset.getInt("Id_Reserva"));
			itens.getVoo().setId_Voo(rset.getInt("id_Voo"));
			itens.setValor_itens(rset.getInt("Valor_Itens"));
			itens.setQuantidade(rset.getInt("Quantidade"));

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
		return itens;

	}
}
>>>>>>> 0f8b9f6a000d2ff7c19dcd3b1c91c4acee1454da
