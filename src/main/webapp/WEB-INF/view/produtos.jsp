<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Favoritos</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
</head>
<body class="min-h-screen overflow-x-hidden">
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
                    <li><a href="portal"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                            data-feather="home"
                            class="mr-3"></i>Portal
                        ADM</a></li>
                    <li><a href="ingredientes"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="package"
                            class="mr-3"></i>Ingredientes</a></li>
                    <li><a href="alergias"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="alert-triangle"
                            class="mr-3"></i>Alergias</a></li>
                    <li><a href="cliente"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="users"
                            class="mr-3"></i>Cliente</a></li>
                    <li><a href="industria"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="tool"
                            class="mr-3"></i>Indústria</a></li>
                    <li><a href="produtos"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333]"><i
                            data-feather="users" class="mr-3"
                            class="mr-3"></i>Produtos</a></li>
                    <li><a href="avaliacoes"
                           class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333] "><i
                            data-feather="star"
                            class="mr-3"></i>Avaliações</a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/index.html"
                            class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-red-500"><i
                            data-feather="log-out"
                            class="mr-3"></i>Sair</a></li>
                </ul>
            </div>
        </div>
</div>

    </nav>

    <div id="sidebar-overlay"
         class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

    <main class="flex-1 p-4 sm:p-8 sm:ml-64">

        <h1
                class="text-2xl sm:text-[2.25rem] font-bold text-gray-800 mb-6 sm:mb-8"
                data-aos="fade-down">Produtos</h1>

        <!-- Busca com filtros -->
        <div class="mb-6 relative z-10" data-aos="fade-up">
            <div class="relative">
                <div class="flex items-center bg-white rounded-full shadow-lg px-5 py-3 w-full">
                    <!-- Dropdown -->
                    <div class="relative" id="dropdown">
                        <button id="filtro-btn"
                                class="flex items-center bg-[#3C9D9B] text-white text-sm font-semibold rounded-full px-3 py-2 focus:outline-none cursor-pointer transition-all">
                            <span id="filtro-texto">Produto</span>
                        </button>
                        <!-- Menu -->
                    </div>

                    <!-- Campo de pesquisa -->
                    <input type="text" placeholder="Pesquisar"
                           class="flex-1 ml-4 bg-transparent text-gray-700 placeholder-gray-400 text-lg focus:outline-none">

                    <button type="submit" class="ml-2">
                        <i class="text-gray-500 hover:text-[#3C9D9B] cursor-pointer text-2xl" data-feather="search"></i>
                    </button>
                </div>
            </div>
        </div>


        <div class="bg-white rounded-lg shadow overflow-hidden"
             data-aos="fade-up" data-aos-delay="200">

            <table class="w-full hidden sm:table">
                <thead>
                <tr class="bg-[#3C9D9B] text-white">
                    <th class="p-3 text-left">Produto</th>
                    <th class="p-3 text-left">Email do Cliente</th>
                    <th class="p-3 text-right"></th>
                </tr>
                </thead>
                <tbody>
                <tr class="bg-white">
                    <td class="p-3 border-b"></td>
                    <td class="p-3 border-b"></td>
                    <td class="p-3 border-b text-right">
                        <div class="flex space-x-2 justify-end">
                            <button
                                    class="p-1 text-blue-600 hover:text-blue-800">
                                <i data-feather="edit"
                                   class="w-4 h-4"></i>
                            </button>
                            <button
                                    class="p-1 text-red-600 hover:text-red-800">
                                <i data-feather="trash-2"
                                   class="w-4 h-4"></i>
                            </button>
                        </div>
                    </td>
                </tr>
                <tr class="bg-[#C5E2E1]">
                    <td class="p-3 border-b"></td>
                    <td class="p-3 border-b"></td>
                    <td class="p-3 border-b text-right">
                        <div class="flex space-x-2 justify-end">
                            <button
                                    class="p-1 text-blue-600 hover:text-blue-800">
                                <i data-feather="edit"
                                   class="w-4 h-4"></i>
                            </button>
                            <button
                                    class="p-1 text-red-600 hover:text-red-800">
                                <i data-feather="trash-2"
                                   class="w-4 h-4"></i>
                            </button>
                        </div>
                    </td>
                </tr>
                <tr class="bg-white">
                    <td class="p-3 border-b"></td>
                    <td class="p-3 border-b"></td>
                    <td class="p-3 border-b text-right">
                        <div class="flex space-x-2 justify-end">
                            <button
                                    class="p-1 text-blue-600 hover:text-blue-800">
                                <i data-feather="edit"
                                   class="w-4 h-4"></i>
                            </button>
                            <button
                                    class="p-1 text-red-600 hover:text-red-800">
                                <i data-feather="trash-2"
                                   class="w-4 h-4"></i>
                            </button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="sm:hidden divide-y divide-gray-200">
                <div
                        class="p-4 bg-white text-center text-gray-500 italic">
                    Nenhum favorito cadastrado
                </div>
            </div>

        </div>

        <div
                class="mt-6 flex flex-col sm:flex-row justify-between items-center space-y-4 sm:space-y-0">
            <a href="cadastro-favorito"
               class="w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-6 py-2 rounded-lg flex items-center justify-center">
                <i data-feather="plus" class="mr-2 w-4 h-4"></i>
                Adicionar
            </a>
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