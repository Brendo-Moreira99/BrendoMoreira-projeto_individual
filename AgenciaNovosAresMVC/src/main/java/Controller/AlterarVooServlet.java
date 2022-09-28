package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Voo;
import Model.VooDAO2;



@WebServlet("/editarvoo")
public class AlterarVooServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_voo = Integer.parseInt(req.getParameter("id_voo"));
		VooDAO2 vdao = new VooDAO2();
		Voo VooSelecionado = vdao.getVooById(id_voo);

		req.setAttribute("viagem", VooSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/AlterarVoo.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Voo VooAlterado = new Voo();		
		VooAlterado.setLocal_Partida(req.getParameter("local_partida"));
		VooAlterado.setDestino(req.getParameter("destino"));
		VooAlterado.setQuantidade_Pessoas(Integer.parseInt(req.getParameter("quantidade_pessoas")));
		VooAlterado.setData_ida(req.getParameter("data_ida"));
		VooAlterado.setData_volta(req.getParameter("data_volta"));
		VooAlterado.setTransfer(req.getParameter("transfer"));
		VooAlterado.setValor_viagem(Double.parseDouble(req.getParameter("valor_viagem")));
		VooAlterado.setID_Voo(Integer.parseInt(req.getParameter("id_voo")));
		
		VooDAO2 vd = new VooDAO2();
		vd.update(VooAlterado);
		resp.sendRedirect("listarvoo");
	}

}


