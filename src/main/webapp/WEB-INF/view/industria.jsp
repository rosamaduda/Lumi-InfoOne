<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lumi.Model.Industria" %>
<%@ page import="com.example.lumi.Model.TelefoneIndustria" %>
<%
@SuppressWarnings("unchecked")
List<Industria> industrias = (List<Industria>)
        request.getAttribute("industrias-lista");
        List<List<TelefoneIndustria>> telefones = (List<List<TelefoneIndustria>>)
                request.getAttribute("telefones-lista");
                %>
                <!DOCTYPE html>
                <html lang="pt-BR">

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport"
                            content="width=device-width, initial-scale=1.0">
                        <title>Lumi - Indústria</title>
                        <link rel="icon"
                            href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
                        <link rel="stylesheet"
                              href="${pageContext.request.contextPath}/style/carregando.css">
                        <script src="https://cdn.tailwindcss.com"></script>
                        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css"
                            rel="stylesheet">
                        <script
                            src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
                        <script
                            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
                    </head>

                    <body class="h-screen overflow-hidden">
                        <header
                            class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md overflow-visible">
                            <div
                                class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
                                <h1 class="flex items-center">
                                    <img
                                        src="${pageContext.request.contextPath}/assets/logo branca.png"
                                        alt="Logo Lumi"
                                        class="h-8 sm:h-10 w-auto object-contain mx-auto sm:mx-0">
                                </h1>
                                <button id="menu-botao" class="sm:hidden p-2">
                                    <i data-feather="menu" class="w-6 h-6"></i>
                                </button>
                            </div>
                        </header>

                        <div class="flex pt-16 sm:pt-20 h-full">
                            <nav id="sidebar"
                                class="fixed left-0 top-16 sm:top-20 h-full w-64 bg-white shadow-lg z-40 transform -translate-x-full sm:translate-x-0 transition-transform duration-300">
                                <div class="flex flex-col h-full">
                                    <div class="p-4 border-b flex-shrink-0">
                                        <div class="text-center mb-2 mt-2">
                                            <div
                                                class="w-16 h-16 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-2">
                                                <i data-feather="user"
                                                    class="text-[#7F3FBF]"></i>
                                            </div>
                                            <h2
                                                class="font-bold text-lg">ADM</h2>
                                            <p class="text-sm text-gray-600"><%=session.getAttribute("adm")%></p>
                                        </div>
                                    </div>

                                    <div class="p-4 flex-grow overflow-y-auto">
                                        <ul class="space-y-2">
                                            <li><a href="portal" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                    data-feather="home" class="mr-3"></i>Portal
                                                ADM</a></li>
                                            <li><a href="ingredientes" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                    data-feather="package"
                                                    class="mr-3"></i>Ingredientes</a></li>
                                            <li><a href="alergias" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                                                    data-feather="alert-triangle"
                                                    class="mr-3"></i>Alergias</a></li>
                                            <li><a href="clientes" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                                                    data-feather="users"
                                                    class="mr-3"></i>Cliente</a></li>
                                            <li><a href="industrias" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 bg-purple-100 rounded-lg text-[#333333] font-medium"><i
                                                    data-feather="tool"
                                                    class="mr-3"></i>Indústria</a></li>
                                            <li><a href="produtos" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                                    data-feather="tag"
                                                    class="mr-3"></i>Produtos</a></li>
                                            <li><a href="site" onclick="mostrarRedirecionando()"
                                                   class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-red-500"><i
                                                    data-feather="log-out"
                                                    class="mr-3"></i>Sair</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </nav>

                            <div id="sidebar-overlay"
                                class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

                            <main
                                class="flex-1 p-4 sm:p-8 sm:ml-64 h-full flex flex-col overflow-x-hidden overflow-y-auto">
                                <h1
                                    class="text-2xl sm:text-[2.25rem] font-bold text-gray-800 mb-6 sm:mb-8"
                                    data-aos="fade-down">Indústria</h1>

                               <!-- Busca com filtros -->
                               <form action="filtro-industria" method="get" class="mb-6 relative z-10" data-aos="fade-up">
                                <div class="flex items-center bg-white rounded-full shadow-lg px-5 py-3 w-full">
                                    <!-- Dropdown -->
                                    <div class="relative" id="dropdown">
                                        <button id="filtro-botao"
                                                type="button"
                                                class="flex items-center bg-[#3C9D9B] text-white text-sm font-semibold rounded-full px-3 py-1.5 focus:outline-none cursor-pointer transition-all">
                                            <span id="filtro-texto"><%=request.getAttribute("filtro-selecionado") == null ? "Todos" : request.getAttribute("filtro-selecionado")%></span>
                                            <i class="ml-2 text-white w-4 h-4" data-feather="chevron-down"></i>
                                        </button>

                                        <!-- Menu -->
                                        <div id="menu" class="absolute hidden mt-2 bg-white rounded-lg shadow-lg w-max z-50">
                                            <button type="button" data-value="Todos" class="block text-gray-700 text-sm px-4 py-2 w-full text-left hover:bg-gray-100">Todos</button>
                                            <button type="button" data-value="Nome" class="block text-gray-700 text-sm px-4 py-2 w-full text-left hover:bg-gray-100">Nome</button>
                                            <button type="button" data-value="Plano" class="block text-gray-700 text-sm px-4 py-2 w-full text-left hover:bg-gray-100">Plano</button>
                                        </div>
                                    </div>

                                    <!-- Campo oculto -->
                                    <input type="hidden" id="filtro" name="filtro" value="<%= request.getAttribute("filtro-selecionado") == null ? "Todos" : request.getAttribute("filtro-selecionado") %>">

                                    <!-- Campo de pesquisa -->
                                    <input type="text" id="pesquisa" name="pesquisa" placeholder="Pesquisar" value="<%=request.getAttribute("pesquisa-anterior") == null ? "" : request.getAttribute("pesquisa-anterior")%>"
                                           class="flex-1 ml-4 bg-transparent text-gray-700 placeholder-gray-400 text-lg focus:outline-none">

                                    <button type="submit" class="ml-2">
                                        <i class="text-gray-500 hover:text-[#3C9D9B] cursor-pointer text-2xl" data-feather="search"></i>
                                    </button>
                                </div>
                            </form>

                                <div
                                    class="bg-white rounded-lg shadow overflow-x-auto overflow-y-auto w-full"
                                    data-aos="fade-up" data-aos-delay="200">

                                    <table
                                        class="table-auto text-left align-top hidden sm:table min-w-full">
                                        <thead>
                                            <tr class="bg-[#3C9D9B] text-white">
                                                <th
                                                    class="p-3 text-left">CNPJ</th>
                                                <th
                                                    class="p-3 text-left">Nome</th>
                                                <th
                                                    class="p-3 text-left">E-mail</th>
                                                <th
                                                    class="p-3 text-left">Senha</th>
                                                <th
                                                    class="p-3 text-left">Objetivo</th>
                                                <th
                                                    class="p-3 text-left">Plano</th>
                                                <th
                                                    class="p-3 text-left">Telefones</th>
                                                <th class="p-3 text-right"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (int i = 0; i <
                                            industrias.size(); i++) { %>
                                            <tr
                                                class="<%= (i % 2 == 0) ? "bg-white"
                                                : "bg-[#C5E2E1]" %>">
                                                <td class="p-3 border-b max-w-full whitespace-nowrap"><%
                                                    String cnpj = industrias.get(i).getCnpj();
                                                    cnpj = cnpj.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1.$2.$3/$4-$5");
                                                    %>
                                                    <%= cnpj %></td>
                                                <td class="p-3 border-b"><%=
                                                    industrias.get(i).getNome()
                                                    %></td>
                                                <td class="p-3 border-b"><%=
                                                    industrias.get(i).getEmail()
                                                    %></td>
                                                <td class="p-3 border-b"><%=
                                                    industrias.get(i).getSenha()
                                                    %></td>
                                                <td
                                                    class="p-3 border-b max-w-[20%] whitespace-normal break-words align-top"
                                                    style="overflow-wrap: anywhere"><%=
                                                    industrias.get(i).getObjetivo()
                                                    %></td>
                                                <td class="p-3 border-b"><%=
                                                    industrias.get(i).getNomePlano()
                                                    %></td>
                                                <td>
                                                    <div
                                                        class="relative w-full">
                                                        <select id="dropdown-telefone"
                                                            class="appearance-none w-full bg-transparent border border-gray-300 rounded-md text-sm font-medium text-[#333333] cursor-pointer py-2 px-2 truncate">
                                                            <% if
                                                            (telefones.get(i) !=
                                                            null) { %>
                                                            <% for (int j = 0; j
                                                            <
                                                            telefones.get(i).size();
                                                            j++) { %>
                                                            <option value="<%=i%>" id="telefoneSelecionado-<%=i%>"><%=
                                                                telefones.get(i).get(j).getTelefone()
                                                                %></option>
                                                            <% } %>
                                                            <% } %>
                                                        </select>
                                                        <i
                                                            data-feather="chevron-down"
                                                            class="pointer-events-none absolute right-1 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i>
                                                    </div>
                                                </td>
                                                <td
                                                    class="p-3 border-b text-right">
                                                    <div
                                                        class="flex space-x-2 justify-end">
                                                        <a onclick="mostrarRedirecionando()"
                                                            href="alteracao-industria?idIndustria=<%= industrias.get(i).getId() %>"
                                                            class="p-1 text-blue-600 hover:text-blue-800">
                                                            <i
                                                                data-feather="edit"
                                                                class="w-4 h-4"></i>
                                                        </a>
                                                        <form action="exclusao-industria"
                                                              method="post"
                                                              class="formRemover"
                                                              style="display:inline;">
                                                            <input type="hidden"
                                                                   name="idIndustria"
                                                                   value="<%=industrias.get(i).getId()%>">
                                                            <button type="button"
                                                                    class="botaoRemover p-1 text-red-600 hover:text-red-800"
                                                                    style="background:none; border:none;">
                                                                <i data-feather="trash-2" class="w-4 h-4"></i>
                                                            </button>
                                                        </form>
                                                    </div>
                                                </td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>

                                    <div class="block sm:hidden space-y-3 p-3">
                                        <% if (industrias.isEmpty()) { %>
                                        <div
                                            class="p-4 text-center text-gray-500 italic">
                                            Nenhuma indústria cadastrada
                                        </div>
                                        <% } else { %>
                                        <% for (int i = 0; i <
                                        industrias.size(); i++) { %>
                                        <div
                                            class="bg-[#FCFCFC] rounded-xl p-4 shadow-md border border-[#B8D9D8]">
                                            <div class="space-y-1">
                                                <p
                                                    class="font-bold text-[#333333]">
                                                    <%=
                                                    industrias.get(i).getNome()
                                                    %>
                                                </p>
                                                <p
                                                    class="text-sm text-[#333333]">
                                                    <span
                                                        class="font-bold text-gray-700">CNPJ:</span>
                                                    <span
                                                        class="font text-gray-800">
                                                        <%
                                                        String cnpj = industrias.get(i).getCnpj();
                                                        cnpj = cnpj.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1.$2.$3/$4-$5");
                                                        %>
                                                    <%= cnpj %>
                                                    </span>
                                                </p>
                                                <p
                                                    class="text-sm text-[#333333]">
                                                    <span
                                                        class="font-bold text-gray-700">E-mail:</span>
                                                    <span
                                                        class="font text-gray-800">
                                                        <%=
                                                        industrias.get(i).getEmail()
                                                        %>
                                                    </span>
                                                </p>
                                                <p
                                                    class="text-sm text-[#333333]">
                                                    <span
                                                        class="font-bold text-gray-700">Senha:</span>
                                                    <span
                                                        class="font text-gray-800">
                                                        <%=
                                                        industrias.get(i).getSenha()
                                                        %>
                                                    </span>
                                                </p>
                                                <p
                                                    class="text-sm text-[#333333]">
                                                    <span
                                                        class="font-bold text-gray-700">Objetivo:</span>
                                                    <span
                                                        class="font text-gray-800 max-w-[20%] whitespace-normal break-words break-all">
                                                        <%=
                                                        industrias.get(i).getObjetivo()
                                                        %>
                                                    </span>
                                                </p>

                                                <p
                                                    class="text-sm text-[#333333]">
                                                    <span
                                                        class="font-bold text-gray-700">Plano:</span>
                                                    <span
                                                        class="font text-gray-800">
                                                        <%=
                                                        industrias.get(i).getNomePlano()
                                                        %>
                                                    </span>
                                                </p>

                                                <div class="pt-2">
                                                    <span
                                                        class="font-bold text-gray-700 text-sm block mb-1">Telefones:</span>
                                                    <% if (telefones.get(i) !=
                                                    null &&
                                                    !telefones.get(i).isEmpty())
                                                    { %>
                                                    <% for (int j = 0; j <
                                                    telefones.get(i).size();
                                                    j++) { %>
                                                    <span
                                                        class="text-sm text-gray-800 block">-
                                                        <%=
                                                        telefones.get(i).get(j).getTelefone()
                                                        %></span>
                                                    <% } %>
                                                    <% } else { %>
                                                    <span
                                                        class="text-sm text-gray-500 italic block">Nenhum
                                                        telefone.</span>
                                                    <% } %>
                                                </div>
                                            </div>

                                            <div
                                                class="flex justify-end space-x-3 mt-3">
                                                <a onclick="mostrarRedirecionando()"
                                                    href="alteracao-industria?idIndustria=<%= industrias.get(i).getId() %>"
                                                    class="p-1.5 text-blue-600 hover:text-blue-800 transition-colors duration-200">
                                                    <i data-feather="edit"
                                                        class="w-4 h-4"></i>
                                                </a>
                                                <form action="exclusao-industria"
                                                      method="post"
                                                      class="formRemover"
                                                      style="display:inline;">
                                                    <input type="hidden"
                                                           name="idIndustria"
                                                           value="<%=industrias.get(i).getId()%>">
                                                    <button type="button"
                                                            class="botaoRemover p-1 text-red-600 hover:text-red-800"
                                                            style="background:none; border:none;">
                                                        <i data-feather="trash-2" class="w-4 h-4"></i>
                                                    </button>
                                                </form>
                                            </div>
                                        </div> <% } %>
                                        <% } %>
                                    </div> </div>
                                <div
                                    class="mt-6 flex flex-col sm:flex-row justify-between items-center space-y-4 sm:space-y-0">
                                    <a href="cadastro-industria" onclick="mostrarRedirecionando()"
                                        class="w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-6 py-2 rounded-lg flex items-center justify-center">
                                        <i data-feather="plus"
                                            class="mr-2 w-4 h-4"></i>Adicionar
                                    </a>
                                </div>
                            </main>
                        </div>

                        <div id="tela-carregamento"
                             class="fixed inset-0 bg-gray-50 z-[9999] flex-col items-center justify-center hidden">
                            <div class="logo-container absolute top-6 left-6">
                                <img id="logo"
                                     src="${pageContext.request.contextPath}/assets/Group 28.png"
                                     alt="Logo Lumi" class="w-16 h-16 object-contain">
                            </div>

                            <div
                                    class="carregando flex flex-col items-center justify-center h-full">
                                <div class="loader">
                                    <div class="bolinhas"></div>
                                    <div class="bolinhas"></div>
                                    <div class="bolinhas"></div>
                                    <div class="bolinhas"></div>
                                </div>
                                <h1
                                        class="text-2xl font-medium mt-8 text-gray-700">Removendo...</h1>
                                <p class="text-gray-500 mt-2">Organizando tudo por aqui,
                                    rapidinho...</p>
                            </div>
                        </div>

                        <div id="tela-redirecionamento"
                             class="fixed inset-0 bg-gray-50 z-[9999] flex-col items-center justify-center hidden">
                            <div class="logo-container absolute top-6 left-6">
                                <img id="logo1" src="${pageContext.request.contextPath}/assets/Group 28.png" alt="Logo Lumi" class="w-16 h-16 object-contain">
                            </div>

                            <div class="carregando flex flex-col items-center justify-center h-full">
                                <div class="loader">
                                    <div class="bolinhas"></div>
                                    <div class="bolinhas"></div>
                                    <div class="bolinhas"></div>
                                    <div class="bolinhas"></div>
                                </div>
                                <h1 class="text-2xl font-medium mt-8 text-gray-700">Redirecionando...</h1>
                                <p class="text-gray-500 mt-2">Só um instante...</p>
                            </div>
                        </div>


                        <div id="popupConfirmacao"
                             class="hidden fixed inset-0 bg-black/40 backdrop-blur-sm items-center justify-center z-50">
                            <div class="bg-white rounded-2xl shadow-xl p-6 w-90 text-center animate-fadeIn">
                                <div class="w-16 h-16 bg-red-100 rounded-full flex items-center justify-center mx-auto mb-4">
                                    <i data-feather="alert-triangle" class="w-8 h-8 text-red-500"></i>
                                </div>
                                <h2 class="text-xl font-semibold text-gray-800 mb-2">Remover?</h2>
                                <p class="text-gray-600 mb-6 leading-relaxed w-[100%] text-center">
                                    Tem certeza que deseja remover este item?  <br>
                                    Esta ação não poderá ser desfeita.
                                </p>
                                <div class="flex justify-center gap-3">
                                    <button type="button"
                                            class="botaoCancelar px-4 py-2 bg-gray-200 rounded-lg hover:bg-gray-300 transition-colors">
                                        Cancelar
                                    </button>
                                    <button type="button"
                                            class="botaoConfirmar px-4 py-2 bg-red-600 text-white rounded-lg hover:bg-red-700 transition-colors">
                                        Sim, remover
                                    </button>
                                </div>
                            </div>
                        </div>




                        <script>
                            AOS.init({ duration: 800, once: true });
                            feather.replace();
                        </script>
                        <script src="${pageContext.request.contextPath}/js/dropdown.js"></script>
                        <script src="${pageContext.request.contextPath}/js/mostrarTelas.js"></script>
                        <script src="${pageContext.request.contextPath}/js/remover.js"></script>
                        <script src="${pageContext.request.contextPath}/js/menu.js"></script>


                    </body>
                </html>