<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lumi.Model.Industria" %>
<%
    @SuppressWarnings("unchecked")
    List <Industria> listaIndustrias = (List<Industria>) request.getAttribute("industrias-lista");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Adicionar Produto</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/style/carregando.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body class="bg-gray-50 min-h-screen">

<header
        class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md">
    <div
            class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
        <h1 class="flex items-center"><img
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
                        <i data-feather="user"
                           class="text-[#7F3FBF]"></i>
                    </div>
                    <h2 class="font-bold text-lg">ADM</h2>
                    <p class="text-sm text-gray-600"><%=session.getAttribute("adm")%></p>
                </div>
            </div>

            <div class="p-4 flex-grow overflow-y-auto">
                <ul class="space-y-2">
                    <li><a href="portal"
                            onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="home"
                                class="mr-3"></i>Portal
                            ADM</a></li>
                    <li><a href="ingredientes"
                            onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                                data-feather="package"
                                class="mr-3"></i>Ingredientes</a></li>
                    <li><a href="alergias"
                            onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                                data-feather="alert-triangle"
                                class="mr-3"></i>Alergias</a></li>
                    <li><a href="clientes"
                            onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                                data-feather="users"
                                class="mr-3"></i>Cliente</a></li>
                    <li><a href="industrias"
                            onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                                data-feather="tool"
                                class="mr-3"></i>Indústria</a></li>
                    <li><a href="produtos"
                            onclick="mostrarRedirecionando()"
                            class="flex items-center p-3 bg-purple-100 rounded-lg text-[#333333] font-medium"><i
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
        <a href="produtos" onclick="mostrarRedirecionando()"><h1 class="text-left sm:mt-3"><i
            data-feather="arrow-left"></i></h1></a>
        <h1
                class="text-[2.25rem] font-bold text-[#333333] mb-8 text-center mt-[3%]"
                data-aos="fade-down">Adicionar Produto</h1>
        <div
                class="bg-white rounded-[15px] shadow-md p-8 max-w-lg mx-auto mt-[3%]"
                data-aos="fade-up" data-aos-delay="100">
            <form class="formAE" action="adicionar-produto" method="post">

                <div id="etapa1" class="mb-6">
                    <label for="codigo-barras"
                           class="block text-gray-700 text-sm font-medium mb-2">Código
                        de Barras:</label>
                    <input type="text" id="codigo-barras" name="codigo-barras" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2"
                           placeholder="Digite o número do código de barras...">
                    <label for="nome"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Nome:</label>
                    <input type="text" id="nome" name="nome" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2"
                           placeholder="Digite o nome do produto...">
                    <label for="fabricante"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Fabricante:</label>
                    <input type="text" id="fabricante" name="fabricante" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2"
                           placeholder="Digite o nome correspondente ao fabricante do produto...">
                    <label for="industria"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Indústria:</label>
                    <select
                            class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                            name="industria" id="industria" required>
                        <option disabled hidden selected value>Selecione
                            uma opção</option>
                        <%for (int i = 0; i < listaIndustrias.size(); i++) {%>
                            <option value="<%=listaIndustrias.get(i).getNome()%>"><%=listaIndustrias.get(i).getNome()%></option>
                        <%}%>
                    </select>
                    <label for="descricao"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Descrição:</label>
                    <textarea id="descricao" name="descricao" required
                              class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent resize-none overflow-hidden"
                              placeholder="Digite a descrição..."
                              rows="2"
                              oninput="autoResizeTextarea(this)"></textarea>
                    <label for="massa"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Massa
                        (kg):</label>
                    <input type="number" step="0.001" min="0" id="massa"
                           name="massa" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                           placeholder="Ex: 1.807">

                </div>
                <div class="text-center" id="botaoProximo">
                    <button type="button"
                            class="bg-[#C6F500] text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-lemon-500 transition-colors">
                        Próximo >
                    </button>
                </div>

                <div id="etapa2" class="hidden mb-6">
                    <h2
                            class="text-xl font-bold text-[#333333] mb-4 text-center">Informação
                        Nutricional</h2>

                    <label for="calorias"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Valor
                        energético (kcal):</label>
                    <input type="number" id="calorias" name="calorias" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2">

                    <label for="proteinas"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Proteínas
                        (g):</label>
                    <input type="number" step="0.01" id="proteinas"
                           name="proteinas" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2">

                    <label for="fibras"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Fibras
                        (g):</label>
                    <input type="number" step="0.01" id="fibras"
                           name="fibras" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2">

                    <label for="carboidratos"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Carboidratos
                        (g):</label>
                    <input type="number" step="0.01" id="carboidratos"
                           name="carboidratos" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2">

                    <label for="sodio"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Sódio
                        (g):</label>
                    <input type="number" step="0.01" id="sodio"
                           name="sodio" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-2">

                    <label for="gorduras-sat"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Gorduras
                        Saturadas (g):</label>
                    <input type="number" step="0.01" id="gorduras-sat"
                           name="gorduras-sat" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-4">

                    <label for="gorduras-tot"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Gorduras
                        Totais (g):</label>
                    <input type="number" step="0.01" id="gorduras-tot"
                           name="gorduras-tot" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-4">

                    <label for="gorduras-tr"
                           class="block text-gray-700 text-sm font-medium mb-2 mt-2">Gorduras
                        Trans (g):</label>
                    <input type="number" step="0.01" id="gorduras-tr"
                           name="gorduras-tr" min="0" max="99999" required
                           class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mb-4">

                    <div class="flex justify-between mt-8">
                        <button type="button" id="botaoVoltar"
                                class="bg-gray-200 text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-gray-300 transition-colors">
                            < Voltar
                        </button>
                        <button type="submit" id="btn-adicionar"
                        class="bg-[#C6F500] text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-[#B4DF00] transition-colors">
                        <span id="btn-texto">Adicionar</span>
                        </button>
                    </div>
                </div>
            </form>
        </div>
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
<script src="${pageContext.request.contextPath}/js/aumentar-texto.js"></script>
<script src="${pageContext.request.contextPath}/js/informacao-nutricional.js"></script>
<script src="${pageContext.request.contextPath}/js/mostrarTelas.js"></script>

</body>
</html>