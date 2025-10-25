// Inicializa AOS
AOS.init({
    duration: 1000,
    once: true
});

// Inicializa Feather Icons
feather.replace();

// Funcionalidade dos ícones
document.querySelectorAll('.funcionalidades-item').forEach(item => {
    item.addEventListener('click', function () {
        // Remove classe active de todos os ícones
        document.querySelectorAll('.funcionalidades-icon').forEach(icon => {
            icon.classList.remove('active');
        });

        // Adiciona classe active ao ícone clicado
        this.querySelector('.funcionalidades-icon').classList.add('active');

        // Muda a imagem do mock-up conforme a funcionalidade
        const funcionalidades = this.getAttribute('data-func');
        const phoneScreen = document.getElementById('phone-screen');

        switch (funcionalidades) {
            case 'scanner':
                phoneScreen.innerHTML = `
                    <img id="scanner-img" 
                        src="assets/mockup-scanner.png" 
                        alt="Tela do app - Scanner" 
                        style="transform: scale(2); transition: opacity 1s ease-in-out;" 
                        class="mt-[15%] object-cover">
                `;

                const scannerImg = document.getElementById('scanner-img');
                setTimeout(() => {
                    scannerImg.style.opacity = 0;
                    setTimeout(() => {
                        scannerImg.src = "assets/mockup-scanner2.png";
                        scannerImg.style.opacity = 1;

                    }, 1000);
                }, 2000);
                break;
            case 'memoria':
                phoneScreen.innerHTML = '<img src="assets/mockup-memoria.png" alt="Tela do app/Memória" style="transform: scale(2);" class=" mt-[15%] object-cover">';
                break;
            case 'vagalumi':
                phoneScreen.innerHTML = '<img src="assets/mockup-ia.png" alt="Tela do app/Vagalumi" style="transform: scale(2);" class=" mt-[15%] object-cover">';
                break;
            case 'industria':
                phoneScreen.innerHTML = `
                        <img id="industria-img" 
                            src="assets/mockup-pi.png" 
                            alt="Página Inicial - Indústria" 
                            style="transform: scale(2); transition: opacity 1s ease-in-out;" 
                            class="mt-[15%] object-cover">
                    `;

                const industriaImg = document.getElementById('industria-img');

                
                setTimeout(() => {
                    industriaImg.style.opacity = 0;

                    setTimeout(() => {
                        industriaImg.src = "assets/mockup-relatorios.png";
                        industriaImg.style.opacity = 1;

                        
                        setTimeout(() => {
                            industriaImg.style.opacity = 0;

                            setTimeout(() => {
                                industriaImg.src = "assets/mockup-cronograma.png";
                                industriaImg.style.opacity = 1;

                               
                                setTimeout(() => {
                                    industriaImg.style.opacity = 0;

                                    setTimeout(() => {
                                        industriaImg.src = "assets/mockup-cp.png";
                                        industriaImg.style.opacity = 1;

                                        
                                        setTimeout(() => {
                                            industriaImg.style.opacity = 0;

                                            setTimeout(() => {
                                                industriaImg.src = "assets/mockup-cp2.png";
                                                industriaImg.style.opacity = 1;

                                                ;

                                            }, 1000);

                                        }, 3000);

                                    }, 1000);

                                }, 3000);

                            }, 1000);

                        }, 3000);

                    }, 1000);

                }, 3000);
                break;


        }
    });
});

// Faz o blur do header ao scrollar o mouse
window.addEventListener("scroll", function () {
    const header = document.querySelector("header");
    if (window.scrollY > 10) {
        header.classList.add("scrolled");
    } else {
        header.classList.remove("scrolled");
    }
});

const menuBotao = document.getElementById('menu-botao');
const navbar = document.getElementById('navbar');

menuBotao.addEventListener('click', function () {
    // Alterna a classe 'active' que ativa o estilo de dropdown no CSS
    navbar.classList.toggle('active');
});

// Adiciona/Remove a classe 'scrolled' no header ao rolar
window.addEventListener('scroll', function () {
    const header = document.querySelector('header');
    if (window.scrollY > 50) {
        header.classList.add('scrolled');
    } else {
        header.classList.remove('scrolled');
    }
});