<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lumi.Model.Alergia" %>
<%
    @SuppressWarnings("unchecked")
    List <Alergia> listaAlergias = (List<Alergia>) request.getAttribute("alergias-lista");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head> <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Adicionar Cliente</title>
    <link rel="icon" href="/src/main/webapp/assets/logo-infoone.ico">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/style/carregando.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body class="bg-gray-50 min-h-screen">
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
         class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

    <main class="sm:ml-64 flex-1 sm:p-8">
        <a href="clientes" onclick="mostrarRedirecionando()"><h1 class="text-left"><i data-feather="arrow-left"></i></h1></a>
        <h1
                class="text-[2.25rem] font-bold text-[#333333] mb-8 text-center mt-[3%]"
                data-aos="fade-down">Adicionar Cliente</h1>
        <div id="input"
             class="bg-white rounded-[15px] shadow-md p-8 max-w-lg mx-auto mt-[3%]"
             data-aos="fade-up" data-aos-delay="100">
            <form class="formAE" action="adicionar-cliente" method="post">
                <div class="mb-6">
                    <label for="cpf"
                           class="block text-gray-700 text-sm font-medium mb-2">CPF:</label>
                    <input type="text" id="cpf" name="cpf" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: 432.654.789-01">

                    <label for="nome"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Nome:</label>
                    <input type="text" id="nome" name="nome" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Digite o nome do cliente...">

                    <label for="sobrenome"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Sobrenome:</label>
                    <input type="text" id="sobrenome" name="sobrenome" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Digite o sobrenome do cliente...">

                    <label for="peso"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Peso
                        (kg):</label>
                    <input type="number" step="0.01" min="0" id="peso" name="peso" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: 76">

                    <label for="altura"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Altura
                        (m):</label>
                    <input type="number" step="0.01" min="0" id="altura" name="altura" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: 1,90">

                    <label for="hta"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Pressão
                        Alta:</label>
                    <select required
                            class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                            name="hta" id="hta">
                        <option disabled hidden selected value>Selecione uma
                            opção</option>
                        <option value="true">Sim</option>
                        <option value="false">Não</option>
                    </select>

                    <label for="diabetes"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Diabetes:</label>
                    <select required
                            class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                            name="diabetes" id="diabetes">
                        <option disabled hidden selected value>Selecione uma
                            opção</option>
                        <option value="Tipo 1">Tipo 1</option>
                        <option value="Tipo 2">Tipo 2</option>
                        <option value="Gestacional">Gestacional</option>
                        <option value="Não possui">Não possui</option>
                    </select>

                    <label for="alergias-container"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Alergias:</label>
                    <div id="alergias-container" class="mb-2">
                    </div>
                    <button type="button" id="add-alergia"
                            class="flex items-center space-x-2 text-[#7F3FBF] hover:text-[#5B2E85] text-sm font-medium w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-3 py-2 rounded-[6px] ">
                        <span>Adicionar alergia</span>
                    </button>

                    <label for="data"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Data
                        de nascimento:</label>
                    <input type="date" id="data" name="data" required min="1940-01-01"
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent">

                    <label for="e-mail"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">E-mail:</label>
                    <input type="email" id="e-mail" name="e-mail" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: nome@exemplo.com">

                    <label for="telefone"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Telefone:</label>
                    <input type="text" id="telefone" name="telefone" required class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: 11946789823">


                    <label for="senha"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Senha:</label>
                    <input type="text" id="senha" name="senha" required ^[^ ]{8,20}$
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Digite a senha do cliente... (De 8 a 20 caracteres)">

                    <label for="cidade"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Cidade:</label>
                    <input type="text" id="cidade" name="cidade" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: Águas de Lindóia">

                    <label for="estado"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Estado:</label>
                    <select name="estado" id="estado" required
                            class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent">
                        <option disabled hidden selected value>Selecione um
                            estado</option>
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="ap">Amapá</option>
                        <option value="am">Amazonas</option>
                        <option value="ba">Bahia</option>
                        <option value="ce">Ceará</option>
                        <option value="df">Distrito Federal</option>
                        <option value="es">Espírito Santo</option>
                        <option value="go">Goiás</option>
                        <option value="ma">Maranhão</option>
                        <option value="mt">Mato Grosso</option>
                        <option value="ms">Mato Grosso do Sul</option>
                        <option value="mg">Minas Gerais</option>
                        <option value="pa">Pará</option>
                        <option value="pb">Paraíba</option>
                        <option value="pr">Paraná</option>
                        <option value="pe">Pernambuco</option>
                        <option value="pi">Piauí</option>
                        <option value="rj">Rio de Janeiro</option>
                        <option value="rn">Rio Grande do Norte</option>
                        <option value="rs">Rio Grande do Sul</option>
                        <option value="ro">Rondônia</option>
                        <option value="rr">Roraima</option>
                        <option value="sc">Santa Catarina</option>
                        <option value="sp">São Paulo</option>
                        <option value="se">Sergipe</option>
                        <option value="to">Tocantins</option>
                    </select>

                    <label for="cep"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">CEP:</label>
                    <input type="text" id="cep" name="cep" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: 01234-567">
                </div> <div class="text-center">
                    <button type="submit" id="btn-adicionar"
                    class="bg-[#C6F500] text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-[#B4DF00] transition-colors">
                <span id="btn-texto">Adicionar</span>
            </button>
            </div>
            </form>
        </div> </main>
</div>

<script>
    AOS.init({ duration: 800, once: true });
    feather.replace();

    const alergiasOp = [ <% 
            if (listaAlergias != null) {
                for (int i = 0; i < listaAlergias.size(); i++) {
                    Alergia alergia = listaAlergias.get(i);
                    String separador = (i < listaAlergias.size() - 1) ? "," : "";
        %>
                    "<%= alergia.getNome() %>"<%= separador %>
        <% 
                }
            }
        %>
        ];
</script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
<script src="${pageContext.request.contextPath}/js/carregandoAdicionar.js"></script>
<script src="${pageContext.request.contextPath}/js/alergias.js"></script>
<script src="${pageContext.request.contextPath}/js/mostrarTelas.js"></script>
</body>
</html>