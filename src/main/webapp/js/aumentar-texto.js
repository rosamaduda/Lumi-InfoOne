function aumentarTexto(elemento) {
    // reseta a altura para recalcular a altura correta 
    elemento.style.height = 'auto'; 
    // define a altura como a altura de scroll do conteúdo
    elemento.style.height = (elemento.scrollHeight) + 'px';
}