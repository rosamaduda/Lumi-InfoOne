function voltar(){
    window.history.back();
}

// Efeito de shake ao carregar a página
document.addEventListener('DOMContentLoaded', function() {
    const textoErro = document.querySelector('.shake-animacao');
    setTimeout(() => {
        textoErro.classList.remove('shake-animacao');
        setTimeout(() => {
            textoErro.classList.add('shake-animacao');
        }, 50);
    }, 1000);
});