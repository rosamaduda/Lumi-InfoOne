package com.example.lumi.Servlet.Alergia;

import com.example.lumi.DAO.AlergiaDAO;
import com.example.lumi.Model.Alergia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/cadastro-alergia", "/adicionar-alergia"})
public class ServletAdicionarAlergia extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/cadastro-alergia")) {
            request.getRequestDispatcher("WEB-INF/view/cadastro_alergias.jsp").forward(request, response); // redirecionando para a página de cadastro
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlergiaDAO alergiaDAO = new AlergiaDAO();
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

        if (caminho.equals("/adicionar-alergia")) {
            // recebendo os parâmetros do form
            String nome = request.getParameter("nome");
            String alergeno = request.getParameter("alergeno");
            String descricao = request.getParameter("descricao");

            // instanciando o objeto
            Alergia alergia = new Alergia(nome, alergeno, descricao);

            // adicionando a alergia
            alergiaDAO.inserirAlergia(alergia);

            // redirecionando para a página de alergia novamente
            response.sendRedirect("alergias");
        }
    }
}
