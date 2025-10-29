document.addEventListener("DOMContentLoaded", () => {
    const telaCarregamento = document.getElementById("tela-carregamento");

    const formsExclusao = document.querySelectorAll("form[action*='exclusao']");

    formsExclusao.forEach(form => {
        form.addEventListener("submit", () => {
            // Aqui só chega se o usuário confirmou
            telaCarregamento.classList.remove("hidden");
            telaCarregamento.classList.add("flex");
        });
    });
});