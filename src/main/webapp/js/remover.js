 // Ação de remover
 document.querySelectorAll("remover").forEach(function(form){
 form.addEventListener("submit",function(e){
    if (!confirm("Tem certeza que deseja remover?")) {
    e.preventDefault(); // Cancela a ação de remover se o usuário clicar em 'Cancelar'
}
});
});
