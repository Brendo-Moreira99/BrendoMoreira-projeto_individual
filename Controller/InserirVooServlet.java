package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Voo;
import Model.VooDAO2;

@WebServlet("/Inserirvoo")
public class InserirVooServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5129721630518639061L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recebendo os dados do formulario via parametro
		String partida = request.getParameter("local_partida");
		int quantidade = Integer.parseInt(request.getParameter("quantidade_pessoas"));
		String destino = request.getParameter("destino_voo");
		String volta = request.getParameter("data_volta");
		String ida = request.getParameter("data_ida");
		String transfer = request.getParameter("transfer");
		double valor = Double.parseDouble(request.getParameter("valor_viagem"));

		// criando o objeto contato
		Voo objVoo = new Voo();

		// guardando os dados do formulario do objeto
		objVoo.setLocal_Partida(partida);
		objVoo.setDestino(destino);
		objVoo.setQuantidade_Pessoas(quantidade);
		objVoo.setData_volta(volta);
		objVoo.setData_ida(ida);
		objVoo.setTransfer(transfer);
		objVoo.setValor_viagem(valor);

		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		VooDAO2 vdao = new VooDAO2();
		vdao.save(objVoo);

		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("listarvoo");

	}

}
