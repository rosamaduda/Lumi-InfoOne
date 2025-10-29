const etapa1 = document.getElementById("etapa1");
const etapa2 = document.getElementById("etapa2");
const botaoProximo = document.getElementById("botaoProximo"); // Seleciona a div do botão
const botaoVoltar = document.getElementById("botaoVoltar");

botaoProximo.addEventListener("click", (event) => {
    event.preventDefault(); // Necessário para evitar o recarregamento, como discutido anteriormente

    etapa1.classList.add("hidden");
    botaoProximo.classList.add("hidden"); // <<< NOVO: Oculta a div do botão "Próximo"

    etapa2.classList.remove("hidden");
    window.scrollTo({ top: 0, behavior: 'smooth' });
});

botaoVoltar.addEventListener("click", () => {
    etapa2.classList.add("hidden");

    etapa1.classList.remove("hidden");
    botaoProximo.classList.remove("hidden"); // <<< NOVO: Mostra a div do botão "Próximo" novamente

    window.scrollTo({ top: 0, behavior: 'smooth' });
});