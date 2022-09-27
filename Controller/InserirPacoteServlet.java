package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DiariasHotelaria;
import Model.Pacote;
import Model.PacoteDAO;

@WebServlet("/Inserirpacote")
public class InserirPacoteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5129721630518639061L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recebendo os dados do formulario via parametro
		int idhotel = Integer.parseInt(request.getParameter("id_hotel"));
		double valor_pac = Double.parseDouble(request.getParameter("valor_pacote"));
		int quantidade = Integer.parseInt(request.getParameter("qtd_pessoas_pac"));
		String data_ida = request.getParameter("data_ida");
		String data_volta = request.getParameter("data_volta");
		String destino = request.getParameter("destino");
		String transfer = request.getParameter("transfer_pacote");
		
		
	

		// criando o objeto contato
		Pacote objpacote = new Pacote();
		DiariasHotelaria objdiarias = new DiariasHotelaria();
		
		// guardando os dados do formulario do objeto
		objpacote.setHotelaria(objdiarias);
		objpacote.getHotelaria().setId_Hotel(idhotel);
		objpacote.setDestino(destino);
		objpacote.setQuantidade_Pessoas(quantidade);
		objpacote.setValor_Pacote(valor_pac);
		objpacote.setPacote_ida(data_ida);
		objpacote.setPacote_volta(data_volta);
		objpacote.setTransfer_pacote(transfer);
		objpacote.Tipo_saber(quantidade);
	

		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		PacoteDAO pdao = new PacoteDAO();
		pdao.save(objpacote);

		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("listarpacotes");

	}

}
