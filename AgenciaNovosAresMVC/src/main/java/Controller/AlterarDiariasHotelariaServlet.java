package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DiariasHotelaria;
import Model.DiariasHotelariaDAO;

@WebServlet("/editardiarias")
public class AlterarDiariasHotelariaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_hotel = Integer.parseInt(req.getParameter("id_hotel"));
		DiariasHotelariaDAO hdao = new DiariasHotelariaDAO();
		DiariasHotelaria hotelSelecionado = hdao.getDiariasHotelariaById(id_hotel);

		req.setAttribute("diarias", hotelSelecionado);

		RequestDispatcher rd = req.getRequestDispatcher("/AlterarDiariasHotelaria.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiariasHotelaria hotelAlterado = new DiariasHotelaria();
		hotelAlterado.setQtd_dias(Integer.parseInt(req.getParameter("qtd_dias")));
		hotelAlterado.setRua(req.getParameter("rua"));
		hotelAlterado.setNumero(Integer.parseInt(req.getParameter("numero")));
		hotelAlterado.setCep(req.getParameter("cep"));
		hotelAlterado.setMunicipio(req.getParameter("municipio"));
		hotelAlterado.setEstado(req.getParameter("estado"));
		hotelAlterado.setNome_Hotel(req.getParameter("nome_hotel"));
		hotelAlterado.setQtd_Quartos(Integer.parseInt(req.getParameter("qtd_quartos")));
		hotelAlterado.setId_Hotel(Integer.parseInt(req.getParameter("id_hotel")));

		DiariasHotelariaDAO dhd = new DiariasHotelariaDAO();
		dhd.update(hotelAlterado);
		resp.sendRedirect("listardiarias");
	}

}
