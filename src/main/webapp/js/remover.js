document.addEventListener("DOMContentLoaded", () => {
    const popupConfirmacao = document.getElementById("popupConfirmacao");
    const botaoCancelar = popupConfirmacao.querySelector(".botaoCancelar");
    const botaoConfirmar = popupConfirmacao.querySelector(".botaoConfirmar");

    let formParaExcluir = null;

    // abre popup de confirmação
    document.querySelectorAll(".botaoRemover").forEach(botao => {
        botao.addEventListener("click", (e) => {
            e.preventDefault();
            formParaExcluir = botao.closest(".formRemover");
            popupConfirmacao.classList.remove("hidden");
            popupConfirmacao.classList.add("flex");
        });
    });

    // cancela
    botaoCancelar.addEventListener("click", () => {
        popupConfirmacao.classList.add("hidden");
        popupConfirmacao.classList.remove("flex");
        formParaExcluir = null;
    });

    // confirma
    botaoConfirmar.addEventListener("click", () => {
        if (formParaExcluir) {
            popupConfirmacao.classList.add("hidden");
            popupConfirmacao.classList.remove("flex");

            const telaCarregamento = document.getElementById("tela-carregamento");
            if (telaCarregamento) {
                telaCarregamento.classList.remove("hidden");
                telaCarregamento.classList.add("flex");
            }

            formParaExcluir.submit();
        }
    });
});




