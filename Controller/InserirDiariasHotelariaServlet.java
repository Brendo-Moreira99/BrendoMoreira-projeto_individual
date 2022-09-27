package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DiariasHotelaria;
import Model.DiariasHotelariaDAO;


@WebServlet("/Inserirdiarias")
public class InserirDiariasHotelariaServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5129721630518639061L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recebendo os dados do formulario via parametro
		int dias = Integer.parseInt(request.getParameter("qtd_dias"));
		String rua = request.getParameter("rua");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String municipio = request.getParameter("municipio");
		String nome = request.getParameter("nome_hotel");
		int quartos = Integer.parseInt(request.getParameter("qtd_quartos"));
		
		
		// criando o objeto contato 
		DiariasHotelaria objDiarias =  new DiariasHotelaria();
		
		// guardando os dados do formulario do objeto
		objDiarias.setQtd_dias(dias);
		objDiarias.setRua(rua);
		objDiarias.setNumero(numero);
		objDiarias.setCep(cep);
		objDiarias.setEstado(estado);
		objDiarias.setMunicipio(municipio);
		objDiarias.setNome_Hotel(nome);
		objDiarias.setQtd_Quartos(quartos);
	
		
		
		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDAO
		DiariasHotelariaDAO ddao = new DiariasHotelariaDAO();	
		ddao.save(objDiarias);
		
		// Redirecionando o usuario para a pagina inicial da aplicação.
		response.sendRedirect("listardiarias");
		
		
		
	}

}

