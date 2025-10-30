package com.example.lumi.Servlet.Industria;

import com.example.lumi.DAO.IndustriaDAO;
import com.example.lumi.DAO.PlanoDAO;
import com.example.lumi.DAO.TelefoneIndustriaDAO;
import com.example.lumi.Model.Industria;
import com.example.lumi.Model.Plano;
import com.example.lumi.Model.TelefoneIndustria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cadastro-industria", "/adicionar-industria"})
public class ServletAdicionarIndustria extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath();

        if (caminho.equals("/cadastro-industria")) {
            // recebendo os nomes dos planos para o dropdown
            PlanoDAO planoDAO = new PlanoDAO();
            List<Plano> listaPlanos = planoDAO.buscarNomePlano();
            request.setAttribute("planos-lista", listaPlanos);

            request.getRequestDispatcher("WEB-INF/view/cadastro_industria.jsp").forward(request, response); // redirecionando para a página de cadastro
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String caminho = request.getServletPath(); // recebendo o caminho do usuário
        TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();
        IndustriaDAO industriaDAO = new IndustriaDAO();


        if (caminho.equals("/adicionar-industria")) {
            // recebendo parâmetros para fazer a inserção
            String email = request.getParameter("e-mail").trim();
            if (!email.matches("^[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}\\.[a-z]+")) {
                request.setAttribute("mensagemErro", "E-mail inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String cnpj = request.getParameter("cnpj").replaceAll("[^0-9]","");
            if (!cnpj.matches("^[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}$")) {
                request.setAttribute("mensagemErro", "CNPJ inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
            }
            String nome = request.getParameter("nome").trim();
            String objetivo = request.getParameter("objetivo").trim();
            String senha = request.getParameter("senha").trim();
            String plano = request.getParameter("plano").trim();

            // setando os dados no objeto
            Industria industria = new Industria(cnpj, nome, objetivo, email, plano, senha);

            // inserindo o objeto
            industriaDAO.inserirIndustria(industria);

            // buscando o ID da última indústria adicionada
            int idIndustria = industriaDAO.buscarIdIndustria();

            // recebendo os telefones da indústria
            String telefone;
            List<String> telefones = new ArrayList<>();
            for (int i = 1; i < 1000; i++) {
                if (request.getParameter("telefone-"+i) != null) {
                    telefone = request.getParameter("telefone-"+i).replaceAll("[^0-9]","").trim();
                } else {
                    break;
                }
                telefones.add(telefone);
            }

            // adicionando os telefones
            for (int i = 0; i < telefones.size(); i++) {
                TelefoneIndustria telefoneIndustria = new TelefoneIndustria(telefones.get(i), idIndustria);
                telefoneIndustriaDAO.adicionarTelIndustria(telefoneIndustria);
            }

            // redirecionando para a página da industria
            response.sendRedirect("industrias");
        }
    }
}
