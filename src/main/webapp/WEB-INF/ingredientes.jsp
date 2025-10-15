<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lumi - Ingredientes</title>
        <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
        <script src="https://cdn.tailwindcss.com"></script>
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    </head>
    <body class="min-h-screen overflow-x-hidden"> 
        
        <%
            // Coleta de dados (do Servlet) e Parâmetros
            // É necessário fazer o casting dos atributos
            List<Ingrediente> ingredientesPaginados = (List<Ingrediente>) request.getAttribute("ingredientesPaginados");
            int paginaAtual = (Integer) request.getAttribute("paginaAtual");
            int totalPaginas = (Integer) request.getAttribute("totalPaginas");
            
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            String linhasStr = request.getParameter("linhas");
            int linhasPorPagina = 5; // Valor padrão
            try {
                if (linhasStr != null) linhasPorPagina = Integer.parseInt(linhasStr);
            } catch (NumberFormatException ignored) {}
            
            // Variável para checar se a lista está vazia
            boolean listaVazia = ingredientesPaginados == null || ingredientesPaginados.isEmpty();
            
            // Função auxiliar para manter os parâmetros de busca e linhas
            String getParametros() {
                return "&linhas=" + linhasPorPagina + "&busca=" + busca;
            }
        %>
        
        <header
            class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md">
            <div
                class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
                <h1 class="sm:ml-[-5%]"><img
                        src="${pageContext.request.contextPath}/assets/logo branca.png"
                        width="80%" class="h-8 sm:h-auto"
                        style="align-items: center;"></h1>

                <button id="menu-botao" class="sm:hidden p-2">
                    <i data-feather="menu" class="w-6 h-6"></i>
                </button>
            </div>
        </header>
        
        <div class="flex pt-16 sm:pt-20 min-h-screen"> 

            <nav id="sidebar"
                class="fixed left-0 top-16 sm:top-20 h-full w-64 bg-white shadow-lg z-40 transform -translate-x-full sm:translate-x-0 transition-transform duration-300">
                
                <div class="flex flex-col h-full"> 
                    <div class="p-4 border-b flex-shrink-0"> 
                        <div class="text-center mb-2 mt-2"> 
                            <div
                                class="w-16 h-16 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-2">
                                <i data-feather="user" class="text-[#7F3FBF]"></i>
                            </div>
                            <h2 class="font-bold text-lg">ADM</h2>
                            <p class="text-sm text-gray-600">ID: #ADM001</p>
                        </div>
                    </div>
                    <div class="p-4 flex-grow overflow-y-auto"> 
                        <ul class="space-y-2">
                            <li><a href="portal" class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i data-feather="home" class="mr-3"></i>Portal ADM</a></li>
                            <li><a href="ingredientes" class="flex items-center p-3 bg-purple-100 rounded-lg  text-[#333333] font-medium"><i data-feather="package" class="mr-3"></i>Ingredientes</a></li>
                            <li><a href="alergias" class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i data-feather="alert-triangle" class="mr-3"></i>Alergias</a></li>
                            <li><a href="cliente" class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i data-feather="users" class="mr-3"></i>Cliente</a></li>
                            <li><a href="industria" class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i data-feather="tool" class="mr-3"></i>Indústria</a></li>
                            <li><a href="favoritos" class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i data-feather="heart" class="mr-3"></i>Favoritos</a></li>
                            <li><a href="avaliacoes" class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333] "><i data-feather="star" class="mr-3"></i>Avaliações</a></li>
                            <li><a href="${pageContext.request.contextPath}/index.html" class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i data-feather="globe" class="mr-3"></i>Site</a></li>
                        </ul>
                    </div>
                </div>
                
            </nav>

            <div id="sidebar-overlay"
                class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

            <main class="flex-1 p-4 sm:p-8 sm:ml-64"> 

                <h1
                    class="text-2xl sm:text-[2.25rem] font-bold text-gray-800 mb-6 sm:mb-8"
                    data-aos="fade-down">Ingredientes</h1>
                
                <form action="ingredientes" method="GET" class="mb-6" data-aos="fade-up" data-aos-delay="100">
                    <div class="relative">
                        <i data-feather="search"
                            class="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400"></i>
                        <input type="text" name="busca" placeholder="Buscar ingredientes..."
                            class="w-full pl-10 pr-4 py-2 sm:py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                            value="<%= busca %>" onchange="this.form.submit()">
                        <input type="hidden" name="linhas" value="<%= linhasPorPagina %>">
                        <noscript>
                           <button type="submit" class="hidden"></button>
                        </noscript>
                    </div>
                </form>

                <div class="bg-white rounded-lg shadow overflow-hidden"
                    data-aos="fade-up" data-aos-delay="200">

                    <table class="w-full hidden sm:table">
                        <thead>
                            <tr class="bg-[#3C9D9B] text-white">
                                <th class="p-3 text-left">Nome</th>
                                <th class="p-3 text-left">Descrição</th>
                                <th class="p-3 text-right"></th>
                            </tr>
                        </thead>
                        <tbody id="tabela-ingredientes">
                            <% 
                            if (!listaVazia) { 
                                for (int i = 0; i < ingredientesPaginados.size(); i++) {
                                    Ingrediente ingrediente = ingredientesPaginados.get(i);
                                    String linhaClass = (i % 2 == 0) ? "bg-white" : "bg-[#C5E2E1]";
                            %>
                                <tr class="<%= linhaClass %>">
                                    <td class="p-3 border-b"><%= ingrediente.getNome() %></td>
                                    <td class="p-3 border-b"><%= ingrediente.getDescricao() %></td>
                                    <td class="p-3 border-b text-right">
                                        <div class="flex space-x-2 justify-end">
                                            <a href="cadastro_ingredientes?id=<%= ingrediente.getId() %>" class="p-1 text-blue-600 hover:text-blue-800">
                                                <i data-feather="edit" class="w-4 h-4"></i>
                                            </a>
                                            <a href="ingredientes?acao=deletar&id=<%= ingrediente.getId() %>&pagina=<%= paginaAtual %><%= getParametros() %>" 
                                               onclick="return confirm('Tem certeza que deseja deletar <%= ingrediente.getNome() %>?')"
                                               class="p-1 text-red-600 hover:text-red-800">
                                                <i data-feather="trash-2" class="w-4 h-4"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            <% 
                                }
                            }
                            %>
                        </tbody>
                    </table>

                    <div class="sm:hidden divide-y divide-gray-200">
                        <% if (!listaVazia) { %>
                            <% for (Ingrediente ingrediente : ingredientesPaginados) { %>
                                <div class="p-4 bg-white space-y-1">
                                    <div class="flex justify-between items-center">
                                        <span class="font-bold text-gray-800"><%= ingrediente.getNome() %></span>
                                        <div class="flex space-x-2">
                                            <a href="cadastro_ingredientes?id=<%= ingrediente.getId() %>" class="p-1 text-blue-600 hover:text-blue-800">
                                                <i data-feather="edit" class="w-4 h-4"></i>
                                            </a>
                                            <a href="ingredientes?acao=deletar&id=<%= ingrediente.getId() %>&pagina=<%= paginaAtual %><%= getParametros() %>" 
                                               onclick="return confirm('Tem certeza que deseja deletar <%= ingrediente.getNome() %>?')"
                                               class="p-1 text-red-600 hover:text-red-800">
                                                <i data-feather="trash-2" class="w-4 h-4"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <p class="text-sm text-gray-600"><%= ingrediente.getDescricao() %></p>
                                </div>
                            <% } %>
                        <% } %>

                        <% if (listaVazia) { %>
                            <div id="vazio-mobile"
                                class="p-4 bg-white text-center text-gray-500 italic">
                                Nenhum ingrediente cadastrado
                            </div>
                        <% } %>
                    </div>

                </div>

                <div
                    class="mt-6 flex flex-col sm:flex-row justify-between items-center space-y-4 sm:space-y-0"
                    data-aos="fade-up" data-aos-delay="300">
                    <a href="cadastro_ingredientes.html"
                        class="w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-6 py-2 rounded-lg flex items-center justify-center">
                        <i data-feather="plus" class="mr-2 w-4 h-4"></i>
                        Adicionar
                    </a>
                    <div
                        class="w-full sm:w-auto flex flex-col sm:flex-row items-center justify-between sm:justify-end space-y-4 sm:space-y-0 sm:space-x-4">
                        
                        <form action="ingredientes" method="GET" class="flex items-center">
                            <input type="hidden" name="busca" value="<%= busca %>">
                            <span class="text-sm text-gray-600 mr-2">Linhas por
                                página:</span>
                            <select name="linhas"
                                class="border border-gray-300 rounded px-2 py-1 text-sm" onchange="this.form.submit()">
                                <option value="5" <%= linhasPorPagina == 5 ? "selected" : "" %>>5</option>
                                <option value="10" <%= linhasPorPagina == 10 ? "selected" : "" %>>10</option>
                                <option value="25" <%= linhasPorPagina == 25 ? "selected" : "" %>>25</option>
                                <option value="50" <%= linhasPorPagina == 50 ? "selected" : "" %>>50</option>
                                <option value="75" <%= linhasPorPagina == 75 ? "selected" : "" %>>75</option>
                            </select>
                            <noscript>
                                <button type="submit" class="hidden"></button>
                            </noscript>
                        </form>

                        <div class="flex items-center space-x-2">
                            <% 
                            String linkAnterior = "ingredientes?pagina=" + (paginaAtual - 1) + getParametros();
                            String classAnterior = paginaAtual <= 1 ? "pointer-events-none opacity-50" : "";
                            %>
                            <a href="<%= linkAnterior %>"
                               class="<%= classAnterior %> p-1 text-gray-600 hover:text-[#7F3FBF]">
                                <i data-feather="arrow-left-circle" class="w-4 h-4"></i>
                            </a>
                            
                            <span id="info-paginacao" class="text-sm text-gray-600">Página <%= paginaAtual %> de <%= totalPaginas %></span>
                            
                            <% 
                            String linkProxima = "ingredientes?pagina=" + (paginaAtual + 1) + getParametros();
                            String classProxima = paginaAtual >= totalPaginas ? "pointer-events-none opacity-50" : "";
                            %>
                            <a href="<%= linkProxima %>"
                               class="<%= classProxima %> p-1 text-gray-600 hover:text-[#7F3FBF]">
                                <i data-feather="arrow-right-circle" class="w-4 h-4"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </main>
        </div>

        <script>
        AOS.init({ duration: 800, once: true });
        feather.replace();

        // Menu Lateral (código existente)
        const sidebar = document.getElementById('sidebar');
        const menuBotao = document.getElementById('menu-botao');
        const overlay = document.getElementById('sidebar-overlay');

        function toggleSidebar() {
            sidebar.classList.toggle('-translate-x-full');
            overlay.classList.toggle('opacity-0');
            overlay.classList.toggle('opacity-50');
            overlay.classList.toggle('pointer-events-none');
        }

        menuBotao.addEventListener('click', toggleSidebar);
        overlay.addEventListener('click', toggleSidebar);

        document.querySelectorAll('#sidebar a').forEach(item => {
            item.addEventListener('click', () => {
                if (window.innerWidth < 640) {
                    toggleSidebar();
                }
            });
        });
        </script>
    </body>
</html>