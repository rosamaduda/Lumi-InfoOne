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
        String login = request.getParameter("username");
        String senha = request.getParameter("password");
        AdmDAO admDAO = new AdmDAO();

        HttpSession session = request.getSession();
        session.setAttribute("adm", login);
        if (admDAO.validarSenhaAdm(login, senha)) {
            request.getRequestDispatcher("WEB-INF/view/portal.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagemErro", "Não foi possível realizar o login");
            request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
        }
    }
}
