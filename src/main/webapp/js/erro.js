document.addEventListener("DOMContentLoaded", () => {
    const botaoVoltar = document.querySelector(".botaoVoltar"); // botão "Voltar"

    botaoVoltar.addEventListener("click", (e) => {
        e.preventDefault();

        // pega a página anterior real
        const referrer = document.referrer;

        // se a página anterior contiver palavras-chave de páginas de cadastro, edição ou item
        const paginasValidas = ["cadastro", "editar", "ingredientes", "alergias", "clientes", "produtos", "industria", "login"];
        const paginaAnteriorValida = paginasValidas.some(p => referrer.includes(p));

        if (paginaAnteriorValida) {
            // vai para a página anterior real
            window.location.href = referrer;
        } else {
            // se não tiver página válida no histórico, vai para o portal principal
            window.location.href = "portal";
        }
    });
});
