package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;
import Model.ClienteDAO;


@WebServlet("/Inserircliente")
public class InserirClienteServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5129721630518639061L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String bairro = request.getParameter("bairro");
		String rua = request.getParameter("rua");
		String municipio = request.getParameter("municipio");
		String estado = request.getParameter("estado");
		String telefone = request.getParameter("telefone");
		String cep = request.getParameter("cep");
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		
		// criando o objeto contato 
		Cliente objCliente =  new Cliente();
		
		// guardando os dados do formulario do objeto
		objCliente.setNome(nome);
		objCliente.setCPF(cpf);
		objCliente.setBairro(bairro);
		objCliente.setRua(rua);
		objCliente.setMunicipio(municipio);
		objCliente.setEstado(estado);
		objCliente.setTelefone(telefone);
		objCliente.setCep(cep);
		objCliente.setNumero(numero);
		objCliente.setData_cli(new Date());
		
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		ClienteDAO cdao = new ClienteDAO();	
		cdao.save(objCliente);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("listarcliente");
		
		
		
	}

}

