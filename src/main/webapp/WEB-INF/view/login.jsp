<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Login</title>
    <link rel="icon" href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/cores.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <script src="https://unpkg.com/feather-icons"></script>
</head>
<body class="bg-gray-50 min-h-screen flex flex-col">
<header>
    <h1><img src="${pageContext.request.contextPath}/assets/logo branca.png" width="80%" style="align-items: center;"></h1>
</header>

<main class="flex-column flex items-center justify-center relative overflow-hidden mb-[5%] mt-[5%]">
    <section class="login">
        <div class="login-form-container w-full max-w-[37.5rem] mx-auto p-8" data-aos="fade-up">
            <div class="text-center mb-8">
                <h2 class="text-[200%] font-semibold text-[#333333] mb-2">Ei ADM,
                    faça seu login!</h2>
            </div>

            <form action="login" method="post" class="space-y-6">
                <div>
                    <input
                            type="text"
                            placeholder="Login"
                            name="username"
                            class="w-full p-[20px] border border-gray-300 rounded-full focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent outline-none transition-all shadow-sm"
                            required>
                </div>

                <div>
                    <input
                            type="password"
                            placeholder="Senha"
                            name="password"
                            class="w-full p-[20px] border border-gray-300 rounded-full focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent outline-none transition-all shadow-sm"
                            required>
                </div>

                <button
                        type="submit"
                        class="w-[30%] p-[15px] mt-[5%] bg-[#C6F500] hover:bg-lime-500 text-black font-semibold rounded-full transition-all transform hover:scale-105 shadow-md ml-[35%]">
                    Entrar
                </button>
            </form>
        </div>
    </section>
</main>

<footer class="bg-black text-white py-16">
    <div class="container mx-auto px-6">
        <div class="grid md:grid-cols-3 gap-8 items-center">
            <div>
                <h1 class="text-[200%] font-bold mb-3">CONTATO</h1>
                <div class="space-y-2 text-gray-400 mt-[-2%]">
                    <p>lumibrasil.contato@gmail.com</p>
                    <p>+55 (11) 95367-3814</p>
                    <p>+55 (11) 9874-1188</p>
                    <p>São Paulo, SP</p>
                </div>
                <a href="site" class="site inline-block mt-5 text-center">Site</a>
            </div>

            <div class="text-center">
                <div class="flex justify-center space-x-6 mb-4">
                    <a href="#" class="text-gray-400 hover:text-white transition">
                        <i data-feather="linkedin" class="w-6 h-6"></i>
                    </a>
                    <a href="https://www.instagram.com/lumi.brasil" class="text-gray-400 hover:text-white transition" target="_blank">
                        <i data-feather="instagram" class="w-6 h-6"></i>
                    </a>
                </div>
                <p class="text-gray-400">&copy; 2025 Lumi. Todos os direitos reservados.</p>
            </div>

            <div class="flex justify-center md:justify-end">
                <img src="${pageContext.request.contextPath}/assets/Group 191.png" alt="Logo Lumi" width="60%" style="margin-top: 5%;">
            </div>
        </div>
    </div>

    <script>
        AOS.init({
            duration: 800,
            easing: 'ease-in-out',
            once: true
        });

        feather.replace();
    </script>
</footer>
</body>
</html>