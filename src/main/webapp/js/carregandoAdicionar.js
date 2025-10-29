document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const telaCarregamento = document.getElementById("tela-carregamento");

    if (form && telaCarregamento) {
        form.addEventListener("submit", () => {
            telaCarregamento.classList.remove("hidden");
            telaCarregamento.classList.add("flex");
        });
    }
});
