function aumentarTexto(elemento) {
    // Reseta a altura para recalcular a altura correta 
    elemento.style.height = 'auto'; 
    // Define a altura como a altura de scroll do conteúdo
    elemento.style.height = (elemento.scrollHeight) + 'px';
}