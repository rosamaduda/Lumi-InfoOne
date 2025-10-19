 // Ação de remover
 document.getElementById("remover").addEventListener("click", function() {
    if (confirm("Tem certeza que deseja remover?")) {
    const itemId = this.getAttribute('id'); 
    window.location.href = "removerItem?id=" + itemId;
}});
