package com.example.lumi.Servlet.Alergia;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.Model.Alergia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/alergias")
public class ServletVisualizarAlergia extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // instanciando o objeto da classe AlergiaDAO para ter acesso ao método de buscar
        AlergiaDAO alergiaDAO = new AlergiaDAO();

        // buscando as informações aqui para quando entrar na hora página as informações já estiverem carregadas
        List<Alergia> listaAlergias = alergiaDAO.buscarAlergia();
        request.setAttribute("alergias-lista", listaAlergias);

        // redirecionando do portal para a página de alergias
        request.getRequestDispatcher("WEB-INF/view/alergias.jsp").forward(request, response);
    }
}
