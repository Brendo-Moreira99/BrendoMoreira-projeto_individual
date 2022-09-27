package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.VooDAO2;

@WebServlet("/excluirvoo")
public class ExcluirVooServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1218301195132418886L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idVoo = Integer.parseInt(req.getParameter("id_voo"));


		VooDAO2 vdao = new VooDAO2();

		vdao.removeById(idVoo);

		resp.sendRedirect("listarvoo");
	}

}
