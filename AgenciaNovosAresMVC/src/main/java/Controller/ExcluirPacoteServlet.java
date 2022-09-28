package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.PacoteDAO;

@WebServlet("/excluirpacote")
public class ExcluirPacoteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1218301195132418886L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idItens = Integer.parseInt(req.getParameter("id_pacote"));


		PacoteDAO pdao = new PacoteDAO();

		pdao.removeById(idItens);

		resp.sendRedirect("listarpacotes");
	}

}
