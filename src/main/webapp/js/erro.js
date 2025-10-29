function voltar(){
    window.history.back(); // Leva o usuário a página anterior
}

// Efeito de shake ao carregar a página
document.addEventListener('DOMContentLoaded', function() {
    const textoErro = document.querySelector('.shake-animacao');
    // Define o tempo de animação do X
    setTimeout(() => {
        textoErro.classList.remove('shake-animacao');
        setTimeout(() => {
            textoErro.classList.add('shake-animacao');
        }, 50);
    }, 1000);
});