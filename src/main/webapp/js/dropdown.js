const filtroBtn = document.getElementById("filtro-botao");
const menu = document.getElementById("menu");
const filtroTexto = document.getElementById("filtro-texto");
const filtroInput = document.getElementById("filtro");

// abre/fecha menu
filtroBtn.addEventListener("click", () => {
    menu.classList.toggle("hidden");
});

// seleciona opção
menu.querySelectorAll("button").forEach((btn) => {
    btn.addEventListener("click", () => {
        filtroTexto.textContent = btn.textContent;
        filtroInput.value = btn.getAttribute("data-value"); // <-- aqui define o valor que vai pro servlet
        menu.classList.add("hidden");
    });
});

// fecha menu clicando fora
document.addEventListener("click", (e) => {
    if (!filtroBtn.contains(e.target) && !menu.contains(e.target)) {
        menu.classList.add("hidden");
    }
});
