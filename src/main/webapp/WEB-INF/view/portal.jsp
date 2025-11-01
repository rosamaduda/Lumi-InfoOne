<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.lumi.Model.*"%>
<%@ page import="java.util.List"%>
<%
    @SuppressWarnings("unchecked")
    List<Ingrediente> listaIngredientes = (List<Ingrediente>) request.getAttribute("ingredientes-lista");
    @SuppressWarnings("unchecked")
    List<Alergia> listaAlergias = (List<Alergia>) request.getAttribute("alergias-lista");
    @SuppressWarnings("unchecked")
    List<Industria> listaIndustrias = (List<Industria>) request.getAttribute("industrias-lista");
    @SuppressWarnings("unchecked")
    List<List<TelefoneIndustria>> listaTelefones = (List<List<TelefoneIndustria>>) request.getAttribute("telefones-lista");
    @SuppressWarnings("unchecked")
    List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("clientes-lista");
    @SuppressWarnings("unchecked")
    List <Produto> listaProdutos = (List<Produto>) request.getAttribute("produtos-lista");
    @SuppressWarnings("unchecked")
    List <Industria> listaNomeIndustria = (List<Industria>) request.getAttribute("nomeIndustria-lista");
    @SuppressWarnings("unchecked")
    List <InformacaoNutricional> listaInfoNutri = (List <InformacaoNutricional>) request.getAttribute("infoNutri-lista");

%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Portal ADM</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/cores.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/carregando.css">
    <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body class="min-h-screen">
<header class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md overflow-visible">
    <div class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
        <h1 class="flex items-center">
            <img
                    src="${pageContext.request.contextPath}/assets/logo branca.png"
                    alt="Logo Lumi"
                    class="h-8 sm:h-10 w-auto object-contain mx-auto sm:mx-0"
            >
        </h1>

        <button id="menu-botao" class="sm:hidden p-2">
            <i data-feather="menu" class="w-6 h-6"></i>
        </button>
    </div>
</header>

<div class="flex pt-16 sm:pt-20 min-h-screen">

    <nav id="sidebar"
         class="fixed left-0 top-16 sm:top-20 h-[calc(100vh-4rem)] sm:h-[calc(100vh-5rem)] w-64 bg-white shadow-lg z-40 transform -translate-x-full sm:translate-x-0 transition-transform duration-300">

        <div class="flex flex-col h-full">

            <div class="p-4 border-b flex-shrink-0">
                <div class="text-center mb-2 mt-2">
                    <div
                            class="w-16 h-16 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-2">
                        <i data-feather="user"
                           class="text-[#7F3FBF]"></i>
                    </div>
                    <h2 class="font-bold text-lg">ADM</h2>
                    <p class="text-sm text-gray-600">ID: #<%=session.getAttribute("adm")%></p>
                </div>
            </div>

            <div class="p-4 flex-grow overflow-y-auto">
                <ul class="space-y-2">
                    <li><a href="portal" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 bg-purple-100 rounded-lg text-[#333333] font-medium"><i
                                data-feather="home" class="mr-3"></i>Portal
                            ADM</a></li>
                    <li><a href="ingredientes" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="package"
                                class="mr-3"></i>Ingredientes</a></li>
                    <li><a href="alergias" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="alert-triangle"
                                class="mr-3"></i>Alergias</a></li>
                    <li><a href="clientes" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="users" class="mr-3"></i>Cliente</a>
                    </li>
                    <li><a href="industrias" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="tool" class="mr-3"></i>Indústria</a>
                    </li>
                    <li><a href="produtos" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="tag" class="mr-3"></i>Produtos</a>
                    </li>
                    <li><a href="site" onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-red-500"><i
                                data-feather="log-out" class="mr-3"></i>Sair</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="sidebar-overlay"
         class="fixed inset-0 bg-black opacity-0 transition-opacity duration-300 pointer-events-none z-30 sm:hidden">
    </div>

    <main id="main-content"
          class="flex-1 p-4 sm:p-8 sm:ml-64 transition-all duration-300 overflow-x-hidden">
        <h1
                class=" text-left text-[2.25rem] font-bold text-[cinza-escuro] mb-8"
                data-aos="fade-down">Portal ADM</h1>

        <section class="mb-12">
            <div class="flex justify-between items-center mb-4">
                <h2
                        class="text-xl font-semibold text-[cinza-escuro]">Ingredientes</h2>
                <a href="ingredientes" onclick="mostrarRedirecionandoo()"
                   class="text-[#3C9D9B] hover:underline">Ver tabela
                    completa →</a>
            </div>
            <div class="bg-white rounded-lg shadow overflow-auto">
                <table class="w-full hidden sm:table">
                    <thead>
                    <tr class="bg-[#3C9D9B] text-white">
                        <th class="p-3 text-left">Nome</th>
                        <th class="p-3 text-left">Descrição</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < listaIngredientes.size(); i++) {
                            if (i % 2 == 0) { %>
                    <tr class="bg-white">
                        <td class="p-3 border-b">
                            <%=listaIngredientes.get(i).getNome()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIngredientes.get(i).getDescricao()%>
                        </td>
                    </tr>
                    <%} else {%>
                    <tr class="bg-[#C5E2E1]">
                        <td class="p-3 border-b">
                            <%=listaIngredientes.get(i).getNome()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIngredientes.get(i).getDescricao()%>
                        </td>
                    </tr>
                    <% } } %>
                    </tbody>
                </table>
                <div class="sm:hidden">
                    <div class="p-4 bg-white text-center text-gray-600 italic rounded-lg shadow">
                      Tabela disponível apenas na versão completa
                    </div>
                  </div>
            </div>
        </section>

        <section>
            <div class="flex justify-between items-center mb-4 mt-[4%]">
                <h2
                        class="text-xl font-semibold text-[cinza-escuro]">Alergias</h2>
                <a href="alergias" onclick="mostrarRedirecionando"
                   class="text-[#3C9D9B] hover:underline">Ver tabela
                    completa →</a>
            </div>
            <div class="bg-white rounded-lg shadow overflow-auto">
                <table class="w-full hidden sm:table">
                    <thead>
                    <tr class="bg-[#3C9D9B] text-white">
                        <th class="p-3 text-left">Nome</th>
                        <th class="p-3 text-left">Alérgeno</th>
                        <th class="p-3 text-left">Descrição</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < listaAlergias.size(); i++) {
                            if (i % 2 == 0) { %>
                    <tr class="bg-white">
                        <td class="p-3 border-b">
                            <%=listaAlergias.get(i).getNome()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaAlergias.get(i).getAlergeno()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaAlergias.get(i).getDescricao()%>
                        </td>
                    </tr>
                    <%} else {%>
                    <tr class="bg-[#C5E2E1]">
                        <td class="p-3 border-b">
                            <%=listaAlergias.get(i).getNome()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaAlergias.get(i).getAlergeno()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaAlergias.get(i).getDescricao()%>
                        </td>
                    </tr>
                    <% }
                    } %>
                    </tbody>
                </table>
                <div class="sm:hidden">
                    <div class="p-4 bg-white text-center text-gray-600 italic rounded-lg shadow">
                      Tabela disponível apenas na versão completa
                    </div>
                  </div>
            </div>
        </section>

        <section>
            <div class="flex justify-between items-center mb-4 mt-[4%]">
                <h2
                        class="text-xl font-semibold text-[cinza-escuro]">Cliente</h2>
                <a href="clientes" onclick="mostrarRedirecionando()"
                   class="text-[#3C9D9B] hover:underline">Ver tabela
                    completa →</a>
            </div>
            <div class="bg-white rounded-lg shadow overflow-auto">
                <table class="w-full hidden sm:table">
                    <thead>
                    <tr class="bg-[#3C9D9B] text-white">
                        <th class="p-3 text-left">CPF</th>
                        <th class="p-3 text-left">Nome Completo</th>
                        <th class="p-3 text-left">Data de Nascimento</th>
                        <th class="p-3 text-left">Peso</th>
                        <th class="p-3 text-left">Altura</th>
                        <th class=" p-3 text-left">HTA</th>
                        <th class=" p-3 text-left">Colesterol Alto</th>
                        <th class="p-3 text-left">Diabetes</th>
                        <th class="p-3 text-left">Telefone</th>
                        <th class="p-3 text-left">E-mail</th>
                        <th class="p-3 text-left">Senha</th>
                        <th class="p-3 text-left">Endereço</th>
                    </tr>
                    </thead>
                    <tbody>
                        <%
                        for (int i = 0; i < listaClientes.size(); i++) {
                            if (i % 2 == 0) { %>
                    <tr class="bg-white">
                        <td class="p-3 border-b max-w-full whitespace-nowrap"> <%
                            String cpf = listaClientes.get(i).getCpf();
                            cpf = cpf.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
                        %>
                        <%= cpf %>
                        </td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getNome() + " " + listaClientes.get(i).getNomeSobrenome()%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getPeso()%>kg</td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getAltura()%>m</td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).isPressaoAlta() ? "Sim" : "Não"%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).isColesterolAlto() ? "Sim" : "Não"%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getDiabetes()%></td>
                        <td class="p-3 border-b"></td>
                        <td class="p-3 border-b max-w-full whitespace-nowrap"><%
                            String telefone = listaClientes.get(i).getTelefone();
                            telefone = telefone.replaceFirst("([0-9]{2})([0-9]{5})([0-9]{4})", "($1) $2-$3");
                        %>
                        <%= telefone %></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getEmail()%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getSenha()%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getEnderecoUf() + ", " + listaClientes.get(i).getEnderecoCidade() + ", " + listaClientes.get(i).getEnderecoCep()%></td>
                    </tr>
                    <% } else {%>
                    <tr class="bg-[#C5E2E1]">
                        <td class="p-3 border-b max-w-full whitespace-nowrap">  <%
                            String cpf = listaClientes.get(i).getCpf();
                            cpf = cpf.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
                        %>
                        <%= cpf %>
                        </td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getNome() + " " + listaClientes.get(i).getNomeSobrenome()%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getPeso()%>kg</td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getAltura()%>m</td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).isPressaoAlta() ? "Sim" : "Não"%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).isColesterolAlto() ? "Sim" : "Não"%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getDiabetes()%></td>
                        <td class="p-3 border-b max-w-full whitespace-nowrap"><%
                            String telefone = listaClientes.get(i).getTelefone();
                            telefone = telefone.replaceFirst("([0-9]{2})([0-9]{5})([0-9]{4})", "($1) $2-$3");
                        %>
                        <%= telefone %></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getEmail()%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getSenha()%></td>
                        <td class="p-3 border-b"><%=listaClientes.get(i).getEnderecoUf() + ", " + listaClientes.get(i).getEnderecoCidade() + ", " + listaClientes.get(i).getEnderecoCep()%></td>
                    </tr>
                    <%}
                    }%>
                    </tbody>
                </table>
                <div class="sm:hidden">
                    <div class="p-4 bg-white text-center text-gray-600 italic rounded-lg shadow">
                      Tabela disponível apenas na versão completa
                    </div>
                  </div>
            </div>
        </section>

        <section>
            <div class="flex justify-between items-center mb-4 mt-[4%]">
                <h2
                        class="text-xl font-semibold text-[cinza-escuro]">Indústria</h2>
                <a href="industrias" onclick="mostrarRedirecionando()"
                   class="text-[#3C9D9B] hover:underline">Ver tabela
                    completa →</a>
            </div>
            <div class="bg-white rounded-lg shadow overflow-auto">
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
                        <tr class="bg-[#3C9D9B] text-white">
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < listaIndustrias.size(); i++) {
                            if (i % 2 == 0) { %>
                    <tr class="bg-white">
                        <td class="p-3 border-b max-w-full whitespace-nowrap">
                            <%
                                  String cnpj = listaIndustrias.get(i).getCnpj();
                                     cnpj = cnpj.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1.$2.$3/$4-$5");
                             %>
                            <%= cnpj %>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getNome()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getEmail()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getSenha()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getObjetivo()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getNomePlano()%>
                        </td>
                        <td class="p-3 border-b">
                            <div class="relative w-full">
                                <select
                                        class="appearance-none w-full bg-transparent  border-gray-300 rounded-md text-sm font-semibold text-[#333333] cursor-pointer py-2">
                                    <% for (int j=0; j < listaTelefones.get(i).size();
                                            j++) { %>
                                    <option>
                                        <%= listaTelefones.get(i).get(j).getTelefone() %>
                                    </option>
                                    <% } %>
                                </select>
                                <i data-feather="chevron-down"
                                   class="ml-[-4%] pointer-events-none absolute right-3 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i></i>
                            </div>
                        </td>
                    </tr>
                    <%} else {%>
                    <tr class="bg-[#C5E2E1]">
                        <td class="p-3 border-b">
                            <%
                            String cnpj = listaIndustrias.get(i).getCnpj();
                               cnpj = cnpj.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})", "$1.$2.$3/$4-$5");
                       %>
                      <%= cnpj %>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getNome()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getEmail()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getSenha()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getObjetivo()%>
                        </td>
                        <td class="p-3 border-b">
                            <%=listaIndustrias.get(i).getNomePlano()%>
                        </td>
                        <td class="p-3 border-b">
                            <div class="relative w-full">
                                <select
                                        class="appearance-none w-full bg-transparent  border-gray-300 rounded-md text-sm font-semibold text-[#333333] cursor-pointer py-2">
                                    <% for (int j=0; j <
                                            listaTelefones.get(i).size(); j++) { %>
                                    <option>
                                        <%= listaTelefones.get(i).get(j).getTelefone() %>
                                    </option>
                                    <% } %>
                                </select>
                                <i data-feather="chevron-down"
                                   class="ml-[-4%] pointer-events-none absolute right-3 top-1/2 transform -translate-y-1/2 w-4 h-4 text-[#333333]"></i></i>
                            </div>
                        </td>
                    </tr>
                    <% } } %>
                    </tbody>
                </table>
                <div class="sm:hidden">
                    <div class="p-4 bg-white text-center text-gray-600 italic rounded-lg shadow">
                      Tabela disponível apenas na versão completa
                    </div>
                  </div>
            </div>
        </section>

        <section>
            <div class="flex justify-between items-center mb-4 mt-[4%]">
                <h2
                        class="text-xl font-semibold text-[cinza-escuro]">Produtos</h2>
                <a href="produtos" onclick="mostrarRedirecionando()"
                   class="text-[#3C9D9B] hover:underline">Ver tabela
                    completa →</a>
            </div>
            <div class="bg-white rounded-lg shadow overflow-auto">
                <table class="w-full hidden sm:table">
                    <thead>
                    <tr class="bg-[#3C9D9B] text-white">
                        <th class="p-3 text-left">Código de Barras</th>
                        <th class="p-3 text-left">Nome</th>
                        <th class="p-3 text-left">Indústria</th>
                        <th class="p-3 text-left">Fabricante</th>
                        <th class="p-3 text-left">Descrição</th>
                        <th class="p-3 text-left">Massa</th>
                        <th class="p-3 text-left">Informação Nutricional</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < listaProdutos.size(); i++) {
                            if (i % 2 == 0) { %>
                    <tr class="bg-white">
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getCodigoBarras()%></td>
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getNome()%></td>
                        <td class="p-3 border-b"><%=listaNomeIndustria.get(i).getNome()%></td>
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getFabricante()%></td>
                        <td class="p-3 border-b max-w-[20%] whitespace-normal break-words align-top"><%=listaProdutos.get(i).getDescricao()%></td>
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getMassa()%></td>
                        <td class="p-3 border-b">
                            <strong>Carboidratos: </strong><%=listaInfoNutri.get(i).getCarboidratos()%>,
                            <strong>Fibras: </strong><%=listaInfoNutri.get(i).getFibras()%>,<br>
                            <strong>Gorduras Saturadas: </strong><%=listaInfoNutri.get(i).getGorduraSaturada()%>,
                            <strong>Gorduras Trans: </strong><%=listaInfoNutri.get(i).getGorduraTrans()%>,<br>
                            <strong>Gorduras Totais: </strong><%=listaInfoNutri.get(i).getGordurasTotais()%>,
                            <strong>Proteína: </strong><%=listaInfoNutri.get(i).getProteina()%>,<br>
                            <strong>Sódio: </strong><%=listaInfoNutri.get(i).getSodio()%>,
                            <strong>Kcal: </strong><%=listaInfoNutri.get(i).getValorEnergetico()%>,<br>
                        </td>
                    </tr>
                    <%} else {%>
                    <tr class="bg-[#C5E2E1]">
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getCodigoBarras()%></td>
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getNome()%></td>
                        <td class="p-3 border-b"><%=listaNomeIndustria.get(i).getNome()%></td>
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getFabricante()%></td>
                        <td class="p-3 border-b max-w-[20%] whitespace-normal break-words align-top"><%=listaProdutos.get(i).getDescricao()%></td>
                        <td class="p-3 border-b"><%=listaProdutos.get(i).getMassa()%></td>
                        <td class="p-3 border-b">
                            <strong>Carboidratos: </strong><%=listaInfoNutri.get(i).getCarboidratos()%>,
                            <strong>Fibras: </strong><%=listaInfoNutri.get(i).getFibras()%>,<br>
                            <strong>Gorduras Saturadas: </strong><%=listaInfoNutri.get(i).getGorduraSaturada()%>,
                            <strong>Gorduras Trans: </strong><%=listaInfoNutri.get(i).getGorduraTrans()%>,<br>
                            <strong>Gorduras Totais: </strong><%=listaInfoNutri.get(i).getGordurasTotais()%>,
                            <strong>Proteína: </strong><%=listaInfoNutri.get(i).getProteina()%>,<br>
                            <strong>Sódio: </strong><%=listaInfoNutri.get(i).getSodio()%>,
                            <strong>Kcal: </strong><%=listaInfoNutri.get(i).getValorEnergetico()%>,<br>
                        </td>
                    </tr>
                    <%}
                    }%>
                    </tbody>
                </table>
                <div class="sm:hidden">
                    <div class="p-4 bg-white text-center text-gray-600 italic rounded-lg shadow">
                      Tabela disponível apenas na versão completa
                    </div>
                  </div>
            </div>
        </section>

    </main>
</div>

<div id="tela-redirecionamento"
     class="fixed inset-0 bg-gray-50 z-[9999] flex-col items-center justify-center hidden">
    <div class="logo-container absolute top-6 left-6">
        <img id="logo" src="${pageContext.request.contextPath}/assets/Group 28.png" alt="Logo Lumi" class="w-16 h-16 object-contain">
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

<script>
    AOS.init({ duration: 800, once: true });
    feather.replace();

</script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
<script src="${pageContext.request.contextPath}/js/mostrarTelas.js"></script>
</body>
</html>