//package com.example.lumi.Servlet;
//
//import com.example.lumi.DAO.*;
//import com.example.lumi.Model.Industria;
//import com.example.lumi.Model.Plano;
//import com.example.lumi.Model.TelefoneIndustria;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/cadastro-industria", "/adicionar-industria", "/alteracao-industria", "/alterar-industria", "/exclusao-industria"})
//public class ServletIndustria extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String caminho = request.getServletPath();
//        IndustriaDAO industriaDAO = new IndustriaDAO();
//        Industria industria = new Industria();
//
//        if (caminho.equals("/cadastro-industria")) {
//            // recebendo os nomes dos planos para o dropdown
//            PlanoDAO planoDAO = new PlanoDAO();
//            List<Plano> listaPlanos = planoDAO.buscarNomePlano();
//            request.setAttribute("planos-lista", listaPlanos);
//
//            request.getRequestDispatcher("WEB-INF/view/cadastro_industria.jsp").forward(request, response); // redirecionando para a página de cadastro
//        } else if (caminho.equals("/alteracao-industria")) {
//            PlanoDAO planoDAO = new PlanoDAO();
//            List<Plano> listaPlanos = planoDAO.buscarNomePlano();
//            request.setAttribute("planos-lista", listaPlanos);
//
//            int idIndustria = Integer.parseInt(request.getParameter("idIndustria")); // recebendo o ID do ingrediente que será alterado
//            industria.setId(idIndustria); // setando o id no model
//            industria = industriaDAO.buscarIndustria(industria); // buscando as informações do id para poder setar como atributos
//            // setando os atributos
//            request.setAttribute("idIndustria", industria.getId());
//            request.setAttribute("cnpjIndustria", industria.getCnpj());
//            request.setAttribute("nomeIndustria", industria.getNome());
//            request.setAttribute("emailIndustria", industria.getEmail());
//            request.setAttribute("objetivoIndustria", industria.getObjetivo());
//            request.setAttribute("senhaIndustria", industria.getSenha());
//            request.setAttribute("planoIndustria", industria.getNomePlano());
//
//            request.getRequestDispatcher("WEB-INF/view/editar_industria.jsp").forward(request, response); // redirecionando para a página de editar
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String caminho = request.getServletPath();
//        IndustriaDAO industriaDAO = new IndustriaDAO();
//        Industria industria = new Industria();
//
//        if (caminho.equals("/adicionar-industria")) {
//            // recebendo parâemtros para fazer a inserção
//            String email = request.getParameter("e-mail");
//            if (!email.matches("^[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}\\.[a-z]+")) {
//                request.setAttribute("mensagemErro", "E-mail inválido");
//                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
//            }
//            String cnpj = request.getParameter("cnpj");
//            if (!cnpj.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}$")) {
//                request.setAttribute("mensagemErro", "CNPJ inválido");
//                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
//            }
//            String nome = request.getParameter("nome");
//            String objetivo = request.getParameter("objetivo");
//            String senha = request.getParameter("senha");
//            String plano = request.getParameter("plano");
//
//            // setando os dados no objeto
//            industria.setCnpj(cnpj);
//            industria.setNome(nome);
//            industria.setEmail(email);
//            industria.setObjetivo(objetivo);
//            industria.setSenha(senha);
//            industria.setNomePlano(plano);
//
//            // inserindo o objeto
//            industriaDAO.inserirIndustria(industria);
//
//            // redirecionando para a página da industria
//            response.sendRedirect("industrias");
//        } else if (caminho.equals("/alterar-industria")) {
//            // recebendo os parâmetros do form
//            int id = Integer.parseInt(request.getParameter("id"));
//            String email = request.getParameter("e-mail");
//            if (!email.matches("^[A-Za-z0-9]{1,}@[A-Za-z0-9]{1,}\\.[a-z]+")) {
//                request.setAttribute("mensagemErro", "E-mail inválido");
//                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
//            }
//            String cnpj = request.getParameter("cnpj");
//            if (!cnpj.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}$")) {
//                request.setAttribute("mensagemErro", "CNPJ inválido");
//                request.getRequestDispatcher("WEB-INF/view/erro.jsp").forward(request, response);
//            }
//            String nome = request.getParameter("nome");
//            String objetivo = request.getParameter("objetivo");
//            String senha = request.getParameter("senha");
//            String plano = request.getParameter("plano");
//
//            // setando os dados no objeto
//            industria.setId(id);
//            industria.setCnpj(cnpj);
//            industria.setNome(nome);
//            industria.setEmail(email);
//            industria.setObjetivo(objetivo);
//            industria.setSenha(senha);
//            industria.setNomePlano(plano);
//
//            // fazendo a alteração
//            industriaDAO.alterarIndustria(industria);
//
//            // redirecionando para a página de industrias
//            response.sendRedirect("industrias");
//        } else if (caminho.equals("/exclusao-industria")) {
//            // instancioando objetos de tabelas que precisam ter campos deletados por causa das fks
//            ProdutoDAO produtoDAO = new ProdutoDAO();
//            TelefoneIndustriaDAO telefoneIndustriaDAO = new TelefoneIndustriaDAO();
//
//            // recebendo o ID da alergia que será removida
//            int idIndustria = Integer.parseInt(request.getParameter("idIndustria"));
//
//            // removendo os campos que possuem o id
//            produtoDAO.removerProdutoIndustria(idIndustria);
//            telefoneIndustriaDAO.deletarTelIdIndustria(idIndustria);
//            industriaDAO.deletarIndustria(idIndustria);
//
//            // recarregando a página
//            response.sendRedirect("industrias");
//        }
//    }
//}
