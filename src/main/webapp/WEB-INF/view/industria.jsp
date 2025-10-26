<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="com.example.lumi.Model.Industria" %>
            <% @SuppressWarnings("unchecked") List<Industria> industrias = (List<Industria>)
                    request.getAttribute("industrias-lista");
                    List<List> telefones = (List<List>) request.getAttribute("telefones-lista");
                            %>
                            <!DOCTYPE html>
                            <html lang="pt-BR">

                            <head>
                                <meta charset="UTF-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                <title>Lumi - Indústria</title>
                                <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
                                <script src="https://cdn.tailwindcss.com"></script>
                                <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
                                <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
                                <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
                            </head>

                            <body class="min-h-screen overflow-x-hidden">
                                <header
                                    class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md">
                                    <div
                                        class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
                                        <h1 class="sm:ml-[-5%]"><img
                                                src="${pageContext.request.contextPath}/assets/logo%20branca.png"
                                                width="80%" class="h-8 sm:h-auto" style="align-items: center;"></h1>

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
                                                    <p class="text-sm text-gray-600">ID: #<%=session.getAttribute("adm")%>
                                                    </p>
                                                </div>
                                            </div>


                                            <div class="p-4 flex-grow overflow-y-auto">
                                                <ul class="space-y-2">
                                                    <li><a href="portal"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                                                                data-feather="home" class="mr-3"></i>Portal
                                                            ADM</a></li>
                                                    <li><a href="ingredientes"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                                data-feather="package" class="mr-3"></i>Ingredientes</a>
                                                    </li>
                                                    <li><a href="alergias"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                                data-feather="alert-triangle"
                                                                class="mr-3"></i>Alergias</a></li>
                                                    <li><a href="clientes"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                                data-feather="users" class="mr-3"></i>Cliente</a></li>
                                                    <li><a href="industrias"
                                                            class="flex items-center p-3 bg-purple-100 rounded-lg  text-[#333333] font-medium"><i
                                                                data-feather="tool" class="mr-3"></i>Indústria</a></li>
                                                    <li><a href="favoritos"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                                data-feather="heart" class="mr-3"></i>Favoritos</a></li>
                                                    <li><a href="avaliacoes"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333] "><i
                                                                data-feather="star" class="mr-3"></i>Avaliações</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/index.html"
                                                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-red-500"><i
                                                                data-feather="log-out" class="mr-3"></i>Sair</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </nav>




                                    <div id="sidebar-overlay"
                                        class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300">
                                    </div>

                                    <main class="flex-1 p-4 sm:p-8 sm:ml-64">

                                        <h1 class="text-2xl sm:text-[2.25rem] font-bold text-gray-800 mb-6 sm:mb-8"
                                            data-aos="fade-down">Indústria</h1>

                                        <div class="mb-6" data-aos="fade-up" data-aos-delay="100">
                                            <div class="relative">
                                                <i data-feather="search"
                                                    class="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400"></i>
                                                <input type="text" placeholder="Buscar indústrias..."
                                                    class="w-full pl-10 pr-4 py-2 sm:py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-[#bg-[#7F3FBF]] focus:border-transparent">
                                            </div>
                                        </div>

                                        <div class="bg-white rounded-lg shadow overflow-hidden" data-aos="fade-up"
                                            data-aos-delay="200">

                                            <table class="w-full hidden sm:table">
                                                <thead>
                                                    <tr class="bg-[#3C9D9B] text-white">
                                                        <th class="p-3 text-left">CNPJ</th>
                                                        <th class="p-3 text-left">Nome</th>
                                                        <th class="p-3 text-left">E-mail</th>
                                                        <th class="p-3 text-left">Senha</th>
                                                        <th class="p-3 text-left">Objetivo</th>
                                                        <th class="p-3 text-left">Plano</th>
                                                        <th class="p-3 text-left">Telefones</th>
                                                        <th class="p-3 text-right"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%for (int i=0; i < industrias.size(); i++) { if (i % 2==0) { %>
                                                        <tr class="bg-white">
                                                            <td class="p-3 border-b">
                                                                <%=industrias.get(i).getCnpj()%>
                                                            </td>
                                                            <td class="p-3 border-b">
                                                                <%=industrias.get(i).getNome()%>
                                                            </td>
                                                            <td class="p-3 border-b">
                                                                <%=industrias.get(i).getEmail()%>
                                                            </td>
                                                            <td class="p-3 border-b">
                                                                <%=industrias.get(i).getSenha()%>
                                                            </td>
                                                            <td class="p-3 border-b">
                                                                <%=industrias.get(i).getObjetivo()%>
                                                            </td>
                                                            <td class="p-3 border-b">
                                                                <%=industrias.get(i).getNomePlano()%>
                                                            </td>
                                                            <td class="p-3 border-b">
                                                                <div class="relative w-full">
                                                                    <select
                                                                        class="appearance-none w-full bg-transparent  border-gray-300 rounded-md text-sm font-semibold text-[#333333] cursor-pointer py-2">
                                                                        <% for (int j=0; j < telefones.get(i).size();
                                                                            j++) { %>
                                                                            <option>
                                                                                <%= telefones.get(i).get(j) %>
                                                                            </option>
                                                                            <% } %>
                                                                    </select>
                                                                    <i data-feather="chevron-down"
                                                                        class="ml-[-4%] pointer-events-none absolute right-3 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i></i>
                                                                </div>
                                                            </td>
                                                            <td class="p-3 border-b text-right">
                                                                <div class="flex space-x-2 justify-end">
                                                                    <a href="alteracao-industria?idIndustria=<%=industrias.get(i).getId()%>"
                                                                        class="p-1 text-blue-600 hover:text-blue-800">
                                                                        <i data-feather="edit" class="w-4 h-4"></i>
                                                                    </a>
                                                                    <form action="exclusao-industria" method="post"
                                                                        style="display:inline;">
                                                                        <input type="hidden" name="idIndustria"
                                                                            value="<%=industrias.get(i).getId()%>">
                                                                        <button type="submit" class="remover"
                                                                            class="p-1 text-red-600 hover:text-red-800"
                                                                            style="background:none; border:none;">
                                                                            <i data-feather="trash-2"
                                                                                class="w-4 h-4"></i>
                                                                        </button>
                                                                    </form>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <%} else {%>
                                                            <tr class="bg-[#C5E2E1]">
                                                                <td class="p-3 border-b">
                                                                    <%=industrias.get(i).getCnpj()%>
                                                                </td>
                                                                <td class="p-3 border-b">
                                                                    <%=industrias.get(i).getNome()%>
                                                                </td>
                                                                <td class="p-3 border-b">
                                                                    <%=industrias.get(i).getEmail()%>
                                                                </td>
                                                                <td class="p-3 border-b">
                                                                    <%=industrias.get(i).getSenha()%>
                                                                </td>
                                                                <td class="p-3 border-b">
                                                                    <%=industrias.get(i).getObjetivo()%>
                                                                </td>
                                                                <td class="p-3 border-b">
                                                                    <%=industrias.get(i).getNomePlano()%>
                                                                </td>
                                                                <td class="p-3 border-b">
                                                                    <div class="relative w-full">
                                                                        <select
                                                                            class="appearance-none w-full bg-transparent  border-gray-300 rounded-md text-sm font-semibold text-[#333333] cursor-pointer py-2">
                                                                            <% for (int j=0; j <
                                                                                telefones.get(i).size(); j++) { %>
                                                                                <option>
                                                                                    <%= telefones.get(i).get(j) %>
                                                                                </option>
                                                                                <% } %>
                                                                        </select>
                                                                        <i data-feather="chevron-down"
                                                                            class="ml-[-4%] pointer-events-none absolute right-3 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i></i>
                                                                    </div>
                                                                </td>
                                                                <td class="p-3 border-b text-right">
                                                                    <div class="flex space-x-2 justify-end">
                                                                        <a href="alteracao-industria?idIndustria=<%=industrias.get(i).getId()%>"
                                                                            class="p-1 text-blue-600 hover:text-blue-800">
                                                                            <i data-feather="edit" class="w-4 h-4"></i>
                                                                        </a>
                                                                        <form action="exclusao-industria" method="post"
                                                                            style="display:inline;">
                                                                            <input type="hidden" name="idIndustria"
                                                                                value="<%=industrias.get(i).getId()%>">
                                                                            <button type="submit"
                                                                                class="p-1 text-red-600 hover:text-red-800"
                                                                                style="background:none; border:none;">
                                                                                <i data-feather="trash-2"
                                                                                    class="w-4 h-4"></i>
                                                                            </button>
                                                                        </form>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <% } } %>
                                                </tbody>
                                            </table>

                                            <div class="sm:hidden divide-y divide-gray-200">
                                                <div class="p-4 bg-white text-center text-gray-500 italic">
                                                    Nenhum favorito cadastrado
                                                </div>
                                            </div>

                                        </div>

                                        <div class="mt-6 flex flex-col sm:flex-row justify-between items-center space-y-4 sm:space-y-0"
                                            data-aos="fade-up" data-aos-delay="300">
                                            <a href="cadastro-industria"
                                                class="w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-6 py-2 rounded-lg flex items-center justify-center">
                                                <i data-feather="plus" class="mr-2 w-4 h-4"></i>
                                                Adicionar
                                            </a>
                                            <div
                                                class="w-full sm:w-auto flex flex-col sm:flex-row items-center justify-between sm:justify-end space-y-4 sm:space-y-0 sm:space-x-4">
                                                <div class="flex items-center">
                                                    <span class="text-sm text-gray-600 mr-2">Linhas por
                                                        página:</span>
                                                    <select class="border border-gray-300 rounded px-2 py-1 text-sm">
                                                        <option selected>5</option>
                                                        <option>10</option>
                                                        <option>25</option>
                                                        <option>50</option>
                                                        <option>75</option>
                                                    </select>
                                                </div>
                                                <div class="flex items-center space-x-2">
                                                    <button class="p-1 text-gray-600 hover:text-[#7F3FBF]">
                                                        <i data-feather="arrow-left-circle" class="w-4 h-4"></i>
                                                    </button>
                                                    <span class="text-sm text-gray-600">Página X de
                                                        Y</span>
                                                    <button class="p-1 text-gray-600 hover:text-[#7F3FBF]">
                                                        <i data-feather="arrow-right-circle" class="w-4 h-4"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </main>
                                </div>

                                <script>
                                    AOS.init({ duration: 800, once: true });
                                    feather.replace();
                                </script>
                                <script src="${pageContext.request.contextPath}/js/menu.js"></script>
                                <script src="${pageContext.request.contextPath}/js/remover.js"></script>
                            </body>

                            </html>