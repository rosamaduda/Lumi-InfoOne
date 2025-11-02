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
        String caminho = request.getServletPath(); // recebendo o caminho do usuário

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

        // instanciando classes DAOs
        TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();
        IndustriaDAO industriaDAO = new IndustriaDAO();

        if (caminho.equals("/adicionar-industria")) {
            // recebendo parâmetros para fazer a inserção
            String email = request.getParameter("e-mail").trim();
            if (!email.matches("^[A-Za-z0-9._]{1,}@[A-Za-z]{1,}\\.[A-Za-z.]{1,}$")) {
                request.setAttribute("mensagemErro", "E-mail inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return; // interrompe o método caso encontre um erro
            }
            String cnpj = request.getParameter("cnpj").trim();
            if (!cnpj.matches("^[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}$")) {
                request.setAttribute("mensagemErro", "CNPJ inválido");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return; // interrompe o método caso encontre um erro
            }
            String nome = request.getParameter("nome");
            String objetivo = request.getParameter("objetivo");
            String senha = request.getParameter("senha");
            String plano = request.getParameter("plano");

            // recebendo os telefones da indústria antes de inserir a indústria, para caso o formato esteja errado
            String telefone;
            List<String> telefones = new ArrayList<>();
            for (int i = 1; i < 1000; i++) {
                telefone = request.getParameter("telefone-"+i);
                if (telefone != null) {
                    telefone = telefone.trim();
                    if (!telefone.matches("^\\(?[0-9]{2}\\)? ?[0-9]?[0-9]{4}-?[0-9]{4}$")) {
                        request.setAttribute("mensagemErro", "Telefone inválido");
                        request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                        return; // interrompe o método caso encontre um erro
                    } else {
                        telefone = telefone.replaceAll("[^0-9]",""); // tirando os caracteres especiais
                    }
                } else {
                    break;
                }
                telefones.add(telefone);
            }

            // tirando os caracteres especiais do CNPJ
            cnpj = cnpj.replaceAll("[^0-9]","");

            // setando os dados no objeto
            Industria industria = new Industria(cnpj, nome, objetivo, email, plano, senha);

            // inserindo o objeto
            int retornoInsercao = industriaDAO.inserirIndustria(industria);
            if (retornoInsercao == 0 || retornoInsercao == -1) {
                request.setAttribute("mensagemErro", "Não foi possível inserir a indústria");
                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                return; // interrompe o método caso encontre um erro
            }

            // buscando o ID da última indústria adicionada
            int idIndustria = industriaDAO.buscarIdIndustria();

            // adicionando os telefones
            for (int i = 0; i < telefones.size(); i++) {
                TelefoneIndustria telefoneIndustria = new TelefoneIndustria(telefones.get(i), idIndustria);
                retornoInsercao = telefoneIndustriaDAO.inserirTelIndustria(telefoneIndustria);
                if (retornoInsercao == 0 || retornoInsercao == -1) {
                    request.setAttribute("mensagemErro", "Não foi possível inserir o telefone da indústria");
                    request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
                    return; // interrompe o método caso encontre um erro
                }
            }

            // redirecionando para a página da industria
            response.sendRedirect("industrias");
        }
    }
}
