function mostrarRedirecionando() {
    document.getElementById("tela-redirecionamento").classList.remove("hidden");
}

function mostrarCarregando() {
    document.getElementById("tela-carregamento").classList.remove("hidden");
}

window.addEventListener("pageshow", function(evento){

    const telaRedirecionamento = document.getElementById("tela-redirecionamento");
    const telaCarregamento = document.getElementById("tela-carregamento");

    // Sempre esconde as telas ao voltar ou recarregar
    if (telaRedirecionamento) telaRedirecionamento.classList.add("hidden");
    if (telaCarregamento) telaCarregamento.classList.add("hidden");
});