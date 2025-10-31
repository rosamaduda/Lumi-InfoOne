package com.example.lumi.Servlet;

import com.example.lumi.DAO.AdmDAO;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login", "/entrar"})
public class ServletLoginAdm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // recebendo os parâmetros do form
        String login = request.getParameter("username");
        String senha = request.getParameter("password");
        AdmDAO admDAO = new AdmDAO();

        // setando o atributo do login do adm para aparecer nas páginas
        HttpSession session = request.getSession();
        session.setAttribute("adm", login);

        // fazendo a validação das informações
        if (admDAO.validarSenhaAdm(login, senha)) {
            response.sendRedirect("portal");
        } else {
            request.setAttribute("mensagemErro", "Não foi possível realizar o login");
            request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
        }
    }
}
