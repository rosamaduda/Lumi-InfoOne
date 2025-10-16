<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lumi - Erro</title>
        <link rel="stylesheet"
            href="${pageContext.request.contextPath}/style/erro.css">
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="https://unpkg.com/feather-icons"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    </head>
    <body class="bg-gray-100 min-h-screen flex items-center justify-center">
        <!-- Logo no canto superior esquerdo -->
        <div
            class="absolute top-4 left-4 rounded-lg flex items-center justify-center">
            <img src="${pageContext.request.contextPath}/assets/Group 28.png"
                alt="Logo" class="w-[80%]">
        </div>

        <div
            class="max-w-md w-full bg-white rounded-2xl shadow-xl p-8 relative overflow-hidden">
            <!-- Conteúdo principal -->
            <div class="text-center mt-12">
                <!-- X animado -->
                <div class="relative w-24 h-24 mx-auto mb-6">
                    <svg class="w-full h-full" viewBox="0 0 100 100">
                        <line x1="20" y1="20" x2="80" y2="80" stroke="#ef4444"
                            stroke-width="8" class="x-animation" />
                        <line x1="80" y1="20" x2="20" y2="80" stroke="#ef4444"
                            stroke-width="8" class="x-animation"
                            style="animation-delay: 0.3s;" />
                    </svg>
                </div>

                <!-- Mensagem de erro -->
                <h1
                    class="text-2xl font-bold text-gray-800 mb-2 shake-animation">Ops!
                    Algo deu errado</h1>
                <p class="text-gray-600 mb-6">Erro</p>

                <p class="text-sm text-gray-500 mb-8">
                    <%=request.getAttribute("mensagemErro")%>
                </p>

                <!-- Botão para voltar -->
                <button
                    onclick="voltar()"
                    class="bg-[#7F3FBF] hover:bg-[#6A33A1] text-white font-medium py-3 px-6 rounded-lg transition-colors flex items-center justify-center mx-auto">
                    <i data-feather="home" class="mr-2 w-4 h-4"></i>
                    Voltar para página anterior
                </button>
            </div>
        </div>

        <script>
        feather.replace();

        function voltar(){
            window.history.back();
        }
        
        // Efeito de shake ao carregar a página
        document.addEventListener('DOMContentLoaded', function() {
            const textoErro = document.querySelector('.shake-animation');
            setTimeout(() => {
                textoErro.classList.remove('shake-animation');
                setTimeout(() => {
                    textoErro.classList.add('shake-animation');
                }, 50);
            }, 1000);
        });
    </script>
    </body>
</html>