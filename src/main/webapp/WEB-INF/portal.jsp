<%@ page contentType="text/jsp;charset=UTF-8" language="java" %>
<!DOCTYPE jsp>
<jsp lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lumi - Portal ADM</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="/cores.css">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    </head>
    <body class="min-h-screen">
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
                            <p class="text-sm text-gray-600">ID: #ADM001</p>
                        </div>
                    </div>

                    <div class="p-4 flex-grow overflow-y-auto">
                        <ul class="space-y-2">
                            <li><a href="portal.jsp"
                                    class="flex items-center p-3 bg-purple-100 rounded-lg text-[cinza-escuro] font-medium"><i
                                        data-feather="home"
                                        class="mr-3"></i>Portal
                                    ADM</a></li>
                            <li><a href="ingredientes.jsp"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro] "><i
                                        data-feather="package"
                                        class="mr-3"></i>Ingredientes</a></li>
                            <li><a href="alergias.jsp"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro] "><i
                                        data-feather="alert-triangle"
                                        class="mr-3"></i>Alergias</a></li>
                            <li><a href="cliente.jsp"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                        data-feather="users"
                                        class="mr-3"></i>Cliente</a></li>
                            <li><a href="industria.jsp"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                        data-feather="tool"
                                        class="mr-3"></i>Indústria</a></li>
                            <li><a href="favoritos.jsp"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                        data-feather="heart"
                                        class="mr-3"></i>Favoritos</a></li>
                            <li><a href="avaliacoes.jsp"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                        data-feather="star"
                                        class="mr-3"></i>Avaliações</a></li>
                            <li><a href="${pageContext.request.contextPath}/index.html"
                                    class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[cinza-escuro]"><i
                                        data-feather="globe"
                                        class="mr-3"></i>Site</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div id="sidebar-overlay"
                class="fixed inset-0 bg-black opacity-0 transition-opacity duration-300 pointer-events-none z-30 sm:hidden">
            </div>

            <main id="main-content"
                class="flex-1 p-4 sm:p-8 sm:ml-64 transition-all duration-300">
                <h1
                    class=" text-left text-[2.25rem] font-bold text-[cinza-escuro] mb-8"
                    data-aos="fade-down">Portal ADM</h1>

                <section class="mb-12" data-aos="fade-up" data-aos-delay="100">
                    <div class="flex justify-between items-center mb-4">
                        <h2
                            class="text-xl font-semibold text-[cinza-escuro]">Ingredientes</h2>
                        <a href="ingredientes.jsp"
                            class="text-[#3C9D9B] hover:underline">Ver tabela
                            completa →</a>
                    </div>
                    <div class="bg-white rounded-lg shadow overflow-hidden">
                        <table class="w-full hidden sm:table">
                            <thead>
                                <tr class="bg-[#3C9D9B] text-white">
                                    <th class="p-3 text-left">Nome</th>
                                    <th class="p-3 text-left">Descrição</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-[#C5E2E1]">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="sm:hidden divide-y divide-gray-200">
                            <div
                                class="p-4 bg-white text-center text-gray-500 italic">
                                Nenhum ingrediente cadastrado
                            </div>
                        </div>
                    </div>
                </section>

                <section data-aos="fade-up" data-aos-delay="200">
                    <div class="flex justify-between items-center mb-4 mt-[4%]">
                        <h2
                            class="text-xl font-semibold text-[cinza-escuro]">Alergias</h2>
                        <a href="alergias.jsp"
                            class="text-[#3C9D9B] hover:underline">Ver tabela
                            completa →</a>
                    </div>
                    <div class="bg-white rounded-lg shadow overflow-hidden">
                        <table class="w-full hidden sm:table">
                            <thead>
                                <tr class="bg-[#3C9D9B] text-white">
                                    <th class="p-3 text-left">Nome</th>
                                    <th class="p-3 text-left">Alérgeno</th>
                                    <th class="p-3 text-left">Descrição</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-[#C5E2E1]">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="sm:hidden divide-y divide-gray-200">
                            <div
                                class="p-4 bg-white text-center text-gray-500 italic">
                                Nenhuma alergia cadastrada
                            </div>
                        </div>
                    </div>
                </section>

                <section data-aos="fade-up" data-aos-delay="200">
                    <div class="flex justify-between items-center mb-4 mt-[4%]">
                        <h2
                            class="text-xl font-semibold text-[cinza-escuro]">Cliente</h2>
                        <a href="cliente.jsp"
                            class="text-[#3C9D9B] hover:underline">Ver tabela
                            completa →</a>
                    </div>
                    <div class="bg-white rounded-lg shadow overflow-hidden">
                        <table class="w-full hidden sm:table">
                            <thead>
                                <tr class="bg-[#3C9D9B] text-white">
                                    <th class="p-3 text-left">CPF</th>
                                    <th class="p-3 text-left">Nome</th>
                                    <th class="p-3 text-left">Sobrenome</th>
                                    <th class="p-3 text-left">Data de
                                        nascimento</th>
                                    <th class="p-3 text-left">Peso</th>
                                    <th class="p-3 text-left">Altura</th>
                                    <th class="p-3 text-left">Telefone</th>
                                    <th class="p-3 text-left">E-Mail</th>
                                    <th class="p-3 text-left">Senha</th>
                                    <th class="p-3 text-left">Endereço (UF,
                                        Cidade e CEP)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-[#C5E2E1]">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="sm:hidden divide-y divide-gray-200">
                            <div
                                class="p-4 bg-white text-center text-gray-500 italic">
                                Nenhum cliente cadastrado
                            </div>
                        </div>
                    </div>
                </section>

                <section data-aos="fade-up" data-aos-delay="200">
                    <div class="flex justify-between items-center mb-4 mt-[4%]">
                        <h2
                            class="text-xl font-semibold text-[cinza-escuro]">Indústria</h2>
                        <a href="industria.jsp"
                            class="text-[#3C9D9B] hover:underline">Ver tabela
                            completa →</a>
                    </div>
                    <div class="bg-white rounded-lg shadow overflow-hidden">
                        <table class="w-full hidden sm:table">
                            <thead>
                                <tr class="bg-[#3C9D9B] text-white">
                                    <th class="p-3 text-left">CNPJ</th>
                                    <th class="p-3 text-left">Nome</th>
                                    <th class="p-3 text-left">E-Mail</th>
                                    <th class="p-3 text-left">Telefone</th>
                                    <th class="p-3 text-left">Objetivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-[#C5E2E1]">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="sm:hidden divide-y divide-gray-200">
                            <div
                                class="p-4 bg-white text-center text-gray-500 italic">
                                Nenhuma indústria cadastrada
                            </div>
                        </div>
                    </div>
                </section>

                <section data-aos="fade-up" data-aos-delay="200">
                    <div class="flex justify-between items-center mb-4 mt-[4%]">
                        <h2
                            class="text-xl font-semibold text-[cinza-escuro]">Favoritos</h2>
                        <a href="favoritos.jsp"
                            class="text-[#3C9D9B] hover:underline">Ver tabela
                            completa →</a>
                    </div>
                    <div class="bg-white rounded-lg shadow overflow-hidden">
                        <table class="w-full hidden sm:table">
                            <thead>
                                <tr class="bg-[#3C9D9B] text-white">
                                    <th class="p-3 text-left">Produto</th>
                                    <th class="p-3 text-left">Email do Cliente</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-[#C5E2E1]">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
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
                </section>

                <section data-aos="fade-up" data-aos-delay="200">
                    <div class="flex justify-between items-center mb-4 mt-[4%]">
                        <h2
                            class="text-xl font-semibold text-[cinza-escuro]">Avaliações</h2>
                        <a href="avaliacoes.jsp"
                            class="text-[#3C9D9B] hover:underline">Ver tabela
                            completa →</a>
                    </div>
                    <div class="bg-white rounded-lg shadow overflow-hidden">
                        <table class="w-full hidden sm:table">
                            <thead>
                                <tr class="bg-[#3C9D9B] text-white">
                                    <th class="p-3 text-left">Produto</th>
                                    <th class="p-3 text-left">Email do Cliente</th>
                                    <th class="p-3 text-left">Avaliação</th>
                                    <th class="p-3 text-left">Data e horário</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-[#C5E2E1]">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                                <tr class="bg-white">
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                    <td class="p-3 border-b"></td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="sm:hidden divide-y divide-gray-200">
                            <div
                                class="p-4 bg-white text-center text-gray-500 italic">
                                Nenhuma avaliação cadastrada
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>

        <script>
            AOS.init({ duration: 800, once: true });
            feather.replace();

             // Menu Lateral
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

        // Fecha o menu ao clicar em um link 
        document.querySelectorAll('#sidebar a').forEach(item => {
            item.addEventListener('click', () => {
                // Fecha apenas se a sidebar estiver visível (i.e., em mobile)
                if (window.innerWidth < 640) { // O breakpoint sm é 640px
                    toggleSidebar();
                }
            });
        });

        </script>
    </body>
</jsp>