

document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.formAE'); 
    const submitBotao = document.getElementById('btn-adicionar');
    const botao = document.getElementById('btn-texto');

    if (form && submitBotao && botao) {
        form.addEventListener('submit', function(event) {
            // verifica se o formulário é válido antes de enviar
            if (form.checkValidity()) {
                // desabilita o botão para evitar múltiplos envios
                submitBotao.disabled = true;
                
                // muda o conteúdo do botão para o indicador de carregamento
                botao.innerHTML = `
                    <svg class="animate-spin -ml-1 mr-2 h-5 w-5 text-gray-800 inline-block" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                        <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
                        <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
                    </svg>
                    <span class="inline-block">Salvando...</span>
                `;
            }
        });
    }
});
