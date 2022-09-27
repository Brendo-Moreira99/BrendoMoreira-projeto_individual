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

import Model.Pacote;
import Model.PacoteDAO;

@WebServlet("/listarpacotes")
public class ListarPacoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Pacote> pacote = new ArrayList<Pacote>();
        PacoteDAO pacotedao = new PacoteDAO();
        pacote = pacotedao.getPacote();
        request.setAttribute("listapacotes", pacote);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarPacotes.jsp");
        dispatcher.forward(request, response);

    }

}