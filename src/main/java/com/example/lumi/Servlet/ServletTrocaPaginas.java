package com.example.lumi.Servlet;

import com.example.lumi.DAO.*;
import com.example.lumi.Model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/site")
public class ServletTrocaPaginas extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirecionando para a página do site
        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
