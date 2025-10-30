document.addEventListener("DOMContentLoaded", () => {
    const botaoVoltar = document.querySelector(".botaoVoltar"); // botão "Voltar"

    botaoVoltar.addEventListener("click", (e) => {
        e.preventDefault();

        // Obtém a página anterior real
        const referrer = document.referrer;

        // Se a página anterior contiver palavras-chave de páginas de cadastro, edição ou negócio
        const paginasValidas = ["cadastro", "editar", "ingredientes", "alergias", "clientes", "produtos", "industria"];
        const paginaAnteriorValida = paginasValidas.some(p => referrer.includes(p));

        if (paginaAnteriorValida) {
            // Vai para a página anterior real
            window.location.href = referrer;
        } else {
            // Se não tiver página válida no histórico, vai para o portal principal
            window.location.href = "portal";
        }
    });
});
