const filtroBtn = document.getElementById("filtro-botao");
const menu = document.getElementById("menu");
const filtroTexto = document.getElementById("filtro-texto");

// Abre/fecha menu
filtroBtn.addEventListener("click", () => {
    menu.classList.toggle("hidden");
});

// Seleciona opção
menu.querySelectorAll("button").forEach((btn) => {
    btn.addEventListener("click", () => {
        filtroTexto.textContent = btn.textContent;
        menu.classList.add("hidden");
    });
});

// Fecha menu clicando fora
document.addEventListener("click", (e) => {
    if (!filtroBtn.contains(e.target) && !menu.contains(e.target)) {
        menu.classList.add("hidden");
    }
});