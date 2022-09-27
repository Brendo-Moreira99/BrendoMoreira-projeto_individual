package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;
import Model.ClienteDAO;



@WebServlet("/editarcliente")
public class AlterarClienteServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_cliente = Integer.parseInt(req.getParameter("id_cliente"));
		ClienteDAO cdao = new ClienteDAO();
		Cliente clienteSelecionado = cdao.getClienteById(id_cliente);

		req.setAttribute("cliente", clienteSelecionado);
	
		RequestDispatcher rd = req.getRequestDispatcher("/AlterarCliente.jsp");

        rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente clienteAlterado = new Cliente();		
		clienteAlterado.setNome(req.getParameter("nome"));
		clienteAlterado.setCep(req.getParameter("cep"));
		clienteAlterado.setCPF(req.getParameter("cpf"));
		clienteAlterado.setData_cli(new Date());
		clienteAlterado.setEstado(req.getParameter("estado"));
		clienteAlterado.setMunicipio(req.getParameter("municipio"));
		clienteAlterado.setNumero(Integer.parseInt(req.getParameter("numero")));
		clienteAlterado.setTelefone(req.getParameter("telefone"));
		clienteAlterado.setBairro(req.getParameter("bairro"));
		clienteAlterado.setRua(req.getParameter("rua"));
		clienteAlterado.setId_Cliente(Integer.parseInt(req.getParameter("id_cliente")));
		
		
		ClienteDAO cd = new ClienteDAO();
		cd.update(clienteAlterado);	
		resp.sendRedirect("listarcliente");
	}

}


