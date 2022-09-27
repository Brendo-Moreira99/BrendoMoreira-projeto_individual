package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Voo;
import Model.VooDAO2;

@WebServlet("/listarvoo")
public class ListarVooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Voo> viagem = new ArrayList<Voo>();
		VooDAO2 voodao = new VooDAO2();
		viagem = voodao.getVoo();
		request.setAttribute("listaVoos", viagem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarVoo.jsp");
		dispatcher.forward(request, response);

	}

}
