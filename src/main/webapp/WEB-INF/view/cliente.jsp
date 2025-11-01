<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lumi.Model.Cliente" %>
<%@ page import="com.example.lumi.Model.Alergia" %>
<%@ page import="java.util.List" %>
<%
    @SuppressWarnings("unchecked")
    List<Cliente> clientes = (List<Cliente>)
            request.getAttribute("clientes-lista");
    @SuppressWarnings("unchecked")
    List<List> alergias = (List<List>)
            request.getAttribute("alergias-lista");
%>


<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <title>Lumi - Cliente</title>
    <link rel="icon"
          href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/style/carregando.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css"
          rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body class="bg-gray-50 min-h-screen">
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
<div class="flex pt-16 sm:pt-20 min-h-screen">
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
                    <h2 class="font-bold text-lg">ADM</h2>
                    <p class="text-sm text-gray-600">ID:
                        #<%=session.getAttribute("adm")%>
                    </p>
                </div>
            </div>

            <div class="p-4 flex-grow overflow-y-auto">
                <ul class="space-y-2">
                    <li><a href="portal" onclick="mostrarRedirecionando()"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="home" class="mr-3"></i>Portal
                        ADM</a></li>
                    <li><a href="ingredientes" onclick="mostrarRedirecionando()"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="package"
                            class="mr-3"></i>Ingredientes</a></li>
                    <li><a href="alergias" onclick="mostrarRedirecionando()"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="alert-triangle"
                            class="mr-3"></i>Alergias</a></li>
                    <li><a href="clientes"  onclick="mostrarRedirecionando()"
                           class="flex items-center p-3 bg-purple-100 rounded-lg text-[#333333] font-medium"><i
                            data-feather="users"
                            class="mr-3"></i>Cliente</a></li>
                    <li><a href="industrias" onclick="mostrarRedirecionando()"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
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
         class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300">
    </div>

    <main
            class="flex-1 p-4 sm:p-8 sm:ml-64 h-full flex flex-col overflow-x-hidden overflow-y-auto">

        <h1
                class="text-2xl sm:text-[2.25rem] font-bold text-gray-800 mb-6 sm:mb-8"
                data-aos="fade-down">Clientes</h1>

        <!-- Busca com filtros -->
        <form action="filtro-cliente" method="get" class="mb-6 relative z-10" data-aos="fade-up">
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
                        <button type="button" data-value="UF" class="block text-gray-700 text-sm px-4 py-2 w-full text-left hover:bg-gray-100">UF</button>
                        <button type="button" data-value="Cidade" class="block text-gray-700 text-sm px-4 py-2 w-full text-left hover:bg-gray-100">Cidade</button>
                        <button type="button" data-value="Nome" class="block text-gray-700 text-sm px-4 py-2 w-full text-left hover:bg-gray-100">Nome Completo</button>
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
                class="bg-white rounded-lg shadow overflow-x-auto overflow-y-auto w-full flex-1 max-h-full"
                data-aos="fade-up"
                data-aos-delay="200">

            <table
                    class="hidden sm:table table-auto text-left align-top min-w-full">
                <thead>
                <tr class="bg-[#3C9D9B] text-white">
                    <th class="p-3 text-left">CPF</th>
                    <th class="p-3 text-left">Nome Completo</th>
                    <th class="p-3 text-left">Data de <br> Nascimento</th>
                    <th class="p-3 text-left">Peso</th>
                    <th class="p-3 text-left">Altura</th>
                    <th class=" p-3 text-left">HTA</th>
                    <th class=" p-3 text-left">Colesterol Alto</th>
                    <th class="p-3 text-left">Diabetes</th>
                    <th class="p-3 text-left">Alergias</th>
                    <th class="p-3 text-left">Telefone</th>
                    <th class="p-3 text-left">Email</th>
                    <th class="p-3 text-left">Senha</th>
                    <th class="p-3 text-left">Endereço</th>
                    <th class="p-3 text-right"></th>
                </tr>
                </thead>
                <tbody>
                <%for (int i=0; i < clientes.size(); i++){
                    if (i % 2==0) { %>
                <tr class="bg-white">
                    <td class="p-3 border-b max-w-full whitespace-nowrap">
                        <%
                            String cpf = clientes.get(i).getCpf();
                            cpf = cpf.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
                        %>
                        <%= cpf %>
                    </td>
                    <td class="p-3 border-b max-w-full whitespace-nowrap">
                        <%=clientes.get(i).getNome()%>
                    </td>
                    <td
                            class="p-3 border-b">
                        <%=clientes.get(i).getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))%>
                    </td>
                    <td class="p-3 border-b"><%=clientes.get(i).getPeso()%>kg</td>
                    <td class="p-3 border-b"><%=clientes.get(i).getAltura()%>m</td>
                    <td class="p-3 border-b"><%=clientes.get(i).isPressaoAlta() ? "Sim" : "Não"%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).isColesterolAlto() ? "Sim" : "Não"%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).getDiabetes()%></td>
                    <td class="p-3 border-b">
                        <div
                                class="relative w-full">
                            <select id="dropdown-alergias-<%=i%>" class="appearance-none w-full bg-transparent border border-gray-300 rounded-md text-sm font-medium text-[#333333] cursor-pointer py-2 px-2 truncate">
                                <% for (int j = 0; j < alergias.get(i).size(); j++) { %>
                                <option value="<%=j%>"><%= alergias.get(i).get(j) %></option>
                                <% } %>
                            </select>
                            <i
                                    data-feather="chevron-down"
                                    class="pointer-events-none absolute right-1 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i>
                        </div>
                    </td>
                    <td class="p-3 border-b max-w-full whitespace-nowrap"><%
                        String telefone = clientes.get(i).getTelefone();
                        telefone = telefone.replaceFirst("([0-9]{2})([0-9]{5})([0-9]{4})", "($1) $2-$3");
                    %>
                        <%= telefone %>
                    </td>
                    <td class="p-3 border-b"><%=clientes.get(i).getEmail()%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).getSenha()%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).getEnderecoUf() + ", " + clientes.get(i).getEnderecoCidade() + ", " + clientes.get(i).getEnderecoCep()%></td>
                    <td class="p-3 border-b text-right">
                        <div
                                class="flex space-x-2 justify-end">
                            <a onclick="mostrarRedirecionando()"
                               href="alteracao-cliente?emailCliente=<%=clientes.get(i).getEmail()%>"
                               class="p-1 text-blue-600 hover:text-blue-800">
                                <i data-feather="edit"
                                   class="w-4 h-4"></i>
                            </a>
                            <form action="exclusao-cliente"
                                  method="post"
                                  class="formRemover"
                                  style="display:inline;">
                                <input type="hidden"
                                       name="emailCliente"
                                       value="<%=clientes.get(i).getEmail()%>">
                                <button type="button"
                                        class="botaoRemover p-1 text-red-600 hover:text-red-800"
                                        style="background:none; border:none;">
                                    <i data-feather="trash-2" class="w-4 h-4"></i>
                                </button>
                            </form>
                        </div>
                    </td>
                </tr>
                <%} else {%>
                <tr class="bg-[#C5E2E1]">
                    <td class="p-3 border-b max-w-full whitespace-nowrap">
                        <%
                        String cpf = clientes.get(i).getCpf();
                        cpf = cpf.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
                    %>
                    <%= cpf %>
                    </td>
                    <td class="p-3 border-b max-w-full whitespace-nowrap">
                        <%=clientes.get(i).getNome()%>
                    </td>
                    <td
                            class="p-3 border-b">
                        <%=clientes.get(i).getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))%>
                    </td>
                    <td class="p-3 border-b"><%=clientes.get(i).getPeso()%>kg</td>
                    <td class="p-3 border-b"><%=clientes.get(i).getAltura()%>m</td>
                    <td class="p-3 border-b"><%=clientes.get(i).isPressaoAlta() ? "Sim" : "Não"%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).isColesterolAlto() ? "Sim" : "Não"%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).getDiabetes()%></td>
                    <td class="p-3 border-b">
                        <div
                        class="relative w-full">
                        <select id="dropdown-alergias-<%=i%>" class="appearance-none w-full bg-transparent border border-gray-300 rounded-md text-sm font-medium text-[#333333] cursor-pointer py-2 px-2 truncate">
                            <% for (int j = 0; j < alergias.get(i).size(); j++) { %>
                                <option value="<%=j%>"><%= alergias.get(i).get(j) %></option>
                            <% } %>
                        </select>
                        <i
                            data-feather="chevron-down"
                            class="pointer-events-none absolute right-1 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i>
                    </div>
                    </td>
                    <td class="p-3 border-b max-w-full whitespace-nowrap"><%
                        String telefone = clientes.get(i).getTelefone();
                        telefone = telefone.replaceFirst("([0-9]{2})([0-9]{5})([0-9]{4})", "($1) $2-$3");
                    %>
                    <%= telefone %>
</td>
                    <td class="p-3 border-b"><%=clientes.get(i).getEmail()%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).getSenha()%></td>
                    <td class="p-3 border-b"><%=clientes.get(i).getEnderecoUf() + ", " + clientes.get(i).getEnderecoCidade() + ", " + clientes.get(i).getEnderecoCep()%></td>
                    <td class="p-3 border-b text-right">
                        <div
                                class="flex space-x-2 justify-end">
                            <a onclick="mostrarRedirecionando()"
                                    href="alteracao-cliente?emailCliente=<%=clientes.get(i).getEmail()%>"
                                    class="p-1 text-blue-600 hover:text-blue-800">
                                <i data-feather="edit"
                                   class="w-4 h-4"></i>
                            </a>
                            <form action="exclusao-cliente"
                                  method="post"
                                  class="formRemover"
                                  style="display:inline;">
                                <input type="hidden"
                                       name="emailCliente"
                                       value="<%=clientes.get(i).getEmail()%>">
                                <button type="button"
                                        class="botaoRemover p-1 text-red-600 hover:text-red-800"
                                        style="background:none; border:none;">
                                    <i data-feather="trash-2" class="w-4 h-4"></i>
                                </button>
                            </form>
                        </div>
                    </td>
                </tr>
                <% } } %>
                </tbody>
            </table>

            <div
                    class="block sm:hidden space-y-3 p-3 max-h-[70vh] overflow-y-auto overflow-x-auto">
                <% if (clientes.isEmpty()) { %>
                <div
                        class="p-4 text-center text-gray-500 italic">
                    Nenhum cliente cadastrado
                </div>
                <% } else { %>
                <% for (int i = 0; i < clientes.size(); i++) {
                %>
                <div
                        class="bg-[#FCFCFC] rounded-xl p-4 shadow-md border border-[#B8D9D8]">
                    <div class="space-y-1">
                        <p class="font-bold text-[#333333]">
                            <%= clientes.get(i).getNome() %>
                        </p>
                        <p class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">CPF:</span>
                            <span class="font text-gray-800">
                                <%
                                String cpf = clientes.get(i).getCpf();
                                cpf = cpf.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
                            %>
                            <%= cpf %>
                                            </span>
                        </p>
                        <p
                                class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">Data de Nascimento:</span>
                            <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                                %>
                                            </span>
                        </p>
                        <p
                                class="text-sm text-[#33333]">
                                            <span
                                                    class="font-bold text-gray-700">Peso:</span>
                            <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).getPeso() + "kg"
                                                %>
                                            </span>
                        </p>
                    </div>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">Altura:</span>
                        <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).getAltura() + "m"
                                                %>
                                            </span>
                    </p>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700]">Pressão alta?</span>
                        <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).isPressaoAlta() ? "Sim" : "Não"%>

                                            </span>
                    </p>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">Colesterol Alto? </span>
                        <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).isColesterolAlto() ? "Sim" : "Não"
                                                %>
                                            </span>
                    </p>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">Diabetes: </span>
                        <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).getDiabetes()
                                                %>
                                            </span>
                    </p>
                    <div class="pt-2 mb-1">
                        <span
                            class="font-bold text-gray-700 text-sm block mb-1">Alergias:</span>
                        <% if (alergias.get(i) !=
                        null &&
                        !alergias.get(i).isEmpty())
                        { %>
                        <% for (int j = 0; j <
                        alergias.get(i).size();
                        j++) { %>
                        <span
                            class="text-sm text-gray-800 block">-
                            <%=
                            alergias.get(i).get(j)
                            %></span>
                        <% } %>
                        <% } else { %>
                        <span
                            class="text-sm text-gray-500 italic block">Nenhuma
                            alergia.</span>
                        <% } %>
                    </div>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">Telefone:</span>
                        <span class="font text-gray-800">
                            <% String telefone = clientes.get(i).getTelefone();
                            telefone = telefone.replaceFirst("([0-9]{2})([0-9]{5})([0-9]{4})", "($1) $2-$3");
                            %>
                        <%= telefone %>
                            
                                            </span>
                    </p>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">E-mail:</span>
                        <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).getEmail()
                                                %>
                                            </span>
                    </p>
                    <p
                            class="text-sm text-[#333333]">
                                            <span
                                                    class="font-bold text-gray-700">Endereço:</span>
                        <span class="font text-gray-800">
                                                <%=
                                                clientes.get(i).getEnderecoUf() + ", " + clientes.get(i).getEnderecoCidade() + ", " + clientes.get(i).getEnderecoCep()%>

                                            </span>
                    </p>

                    <div
                            class="flex justify-end space-x-3 mt-3">
                        <a onclick="mostrarRedirecionando()"
                                href="alteracao-cliente?emailCliente=<%= clientes.get(i).getEmail() %>"
                                class="p-1.5 text-blue-600 hover:text-blue-800 transition-colors duration-200">
                            <i data-feather="edit"
                               class="w-4 h-4"></i>
                        </a>
                        <form action="exclusao-cliente"
                              method="post"
                              class="formRemover"
                              style="display:inline;">
                            <input type="hidden"
                                   name="emailCliente"
                                   value="<%=clientes.get(i).getEmail()%>">
                            <button type="button"
                                    class="botaoRemover p-1 text-red-600 hover:text-red-800"
                                    style="background:none; border:none;">
                                <i data-feather="trash-2" class="w-4 h-4"></i>
                            </button>
                        </form>
                    </div>
                </div>
                <% } %>
                <% } %>
            </div>
        </div>

        <div
                class="mt-6 flex flex-col sm:flex-row justify-between items-center space-y-4 sm:space-y-0">
            <a href="cadastro-cliente" onclick="mostrarRedirecionando()"
               class="w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-6 py-2 rounded-lg flex items-center justify-center">
                <i data-feather="plus"
                   class="mr-2 w-4 h-4"></i>
                Adicionar
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