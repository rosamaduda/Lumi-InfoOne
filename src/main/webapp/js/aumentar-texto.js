function aumentarTexto(elemento) {
    // Reset a altura para recalcular a altura correta (necessário para encolher se o texto for apagado)
    elemento.style.height = 'auto'; 
    // Define a altura como a altura de scroll do conteúdo
    elemento.style.height = (elemento.scrollHeight) + 'px';
}