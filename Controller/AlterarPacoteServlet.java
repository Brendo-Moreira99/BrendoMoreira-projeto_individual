package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DiariasHotelaria;
import Model.Pacote;
import Model.PacoteDAO;

@WebServlet("/editarpacote")
public class AlterarPacoteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_pacote = Integer.parseInt(req.getParameter("id_pacote"));
		PacoteDAO pdao = new PacoteDAO();
		Pacote PacoteSelecionado = pdao.getPacoteById(id_pacote);

		req.setAttribute("pacote", PacoteSelecionado);

		RequestDispatcher rd = req.getRequestDispatcher("/AlterarPacote.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pacote PacoteAlterado = new Pacote();
		DiariasHotelaria Hotelalterado = new DiariasHotelaria();
		
		
		
		PacoteAlterado.setHotelaria(Hotelalterado);
		
		PacoteAlterado.getHotelaria().setId_Hotel(Integer.parseInt(req.getParameter("id_hotel")));
		PacoteAlterado.setDestino(req.getParameter("destino"));
		PacoteAlterado.setQuantidade_Pessoas(Integer.parseInt(req.getParameter("quantidade_pessoas")));
		PacoteAlterado.setValor_Pacote(Double.parseDouble(req.getParameter("valor_pacote")));
		PacoteAlterado.setPacote_volta(req.getParameter("data_volta"));
		PacoteAlterado.setPacote_ida(req.getParameter("data_ida"));
		PacoteAlterado.setTransfer_pacote(req.getParameter("transfer"));
		PacoteAlterado.Tipo_saber(Integer.parseInt(req.getParameter("quantidade_pessoas")));
		PacoteAlterado.setId_itens(Integer.parseInt(req.getParameter("id_itens")));
	


		PacoteDAO pd = new PacoteDAO();
		pd.update(PacoteAlterado);
		resp.sendRedirect("listarpacotes");
	}

}

