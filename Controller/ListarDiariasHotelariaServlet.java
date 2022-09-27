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

import Model.DiariasHotelaria;
import Model.DiariasHotelariaDAO;

@WebServlet("/listardiarias")
public class ListarDiariasHotelariaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<DiariasHotelaria> diarias = new ArrayList<DiariasHotelaria>();
        DiariasHotelariaDAO diariasdao = new DiariasHotelariaDAO();
        diarias = diariasdao.getDiariasHotelaria();
        request.setAttribute("listaDiarias", diarias);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarDiariasHotelaria.jsp");
        dispatcher.forward(request, response);

    }

}

