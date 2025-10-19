<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lumi - Adicionar Alergia</title>
        <link rel="icon"
            href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
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
                <h1 class="ml-0 sm:ml-[-5%]"><img
                        src="${pageContext.request.contextPath}/assets/logo%20branca.png"
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
                        <li><a href="portal"
                               class="flex items-center p-3 bg-purple-100 rounded-lg text-[cinza-escuro] font-medium"><i
                                data-feather="home"
                                class="mr-3"></i>Portal
                            ADM</a></li>
                        <li><a href="ingredientes"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro] "><i
                                data-feather="package"
                                class="mr-3"></i>Ingredientes</a></li>
                        <li><a href="alergias"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro] "><i
                                data-feather="alert-triangle"
                                class="mr-3"></i>Alergias</a></li>
                        <li><a href="clientes"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                data-feather="users"
                                class="mr-3"></i>Cliente</a></li>
                        <li><a href="industrias"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                data-feather="tool"
                                class="mr-3"></i>Indústria</a></li>
                        <li><a href="favoritos"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                data-feather="heart"
                                class="mr-3"></i>Favoritos</a></li>
                        <li><a href="avaliacoes"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                data-feather="star"
                                class="mr-3"></i>Avaliações</a></li>
                        <li><a href="site"
                               class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                data-feather="globe"
                                class="mr-3"></i>Site</a></li>
                    </ul>
                </div>
                </div>
            </nav>

            <div id="sidebar-overlay"
                class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

            <main class="ml-64 flex-1 sm:p-8">
                <a href="alergias"><h1 class="text-left"><i
                            data-feather="arrow-left"></i></h1></a>
                <h1
                    class="text-[2.25rem] font-bold text-[#333333] mb-8 text-center mt-[2%]"
                    data-aos="fade-down">Adicionar Alergia</h1>
                <div
                    class="bg-white rounded-[15px] shadow-md p-8 max-w-lg mx-auto mt-[3%]"
                    data-aos="fade-up" data-aos-delay="100">

                    <form action="adicionar-alergia" method="post">
                        <div class="mb-6">
                            <label for="nome"
                                class="block text-gray-700 text-sm font-medium mb-2">Nome:</label>
                            <input type="text" id="nome" name="nome"
                                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                                placeholder="Digite o nome da alergia...">

                            <label for="nome"
                                class="block text-gray-700 text-sm font-medium mb-2">Alérgeno:</label>
                            <input type="text" id="nome" name="nome"
                                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                                placeholder="Digite o alérgeno relacionado à alergia...">

                            <label for="descricao"
                                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Descrição:</label>
                            <input type="text" id="descricao" name="descricao"
                                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                                placeholder="Digite a descrição da alergia...">

                        </div>
                        <div class="text-center">
                            <button type="submit"
                                class="bg-[#C6F500] text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-lemon-500 transition-colors">
                                Adicionar
                            </button>
                        </div>
                    </form>
                </div>
            </main>
        </div>
        <script>
        AOS.init({ duration: 800, once: true });
        feather.replace();
    </script>
    <script src="${pageContext.request.contextPath}/js/menu.js"></script>
    </body>
</html>