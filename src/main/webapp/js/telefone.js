document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('telefones-container');
    const addBotao = document.getElementById('add-telefone');
    let telefoneCount = 0;

    function atualizarCampo(){
        const campos = container.querySelectorAll('div[id^="telefone-"]');
        campos.forEach((campo, index) => {
            campo.id = `telefone-${index + 1}`;
            const input = campo.querySelector('input[type="tel"]');
            input.name = `telefone-${index + 1}`;
        });
        telefoneCount = campos.length;
    }

    /**
     * Cria e retorna o elemento jsp para um novo campo de telefone.
     * @param {string} initialValue - Valor inicial para o campo.
     */
    function criarCampoTelefone(initialValue = '') {
        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-center space-x-2 mb-2';
        wrapper.id = `telefone-${++telefoneCount}`; // ID único

        // Botão de remover
        const removerBotao = document.createElement('button');
        removerBotao.type = 'button';
        removerBotao.className = 'remover-telefone text-red-500 hover:text-red-700 p-1';
        removerBotao.title = 'Remover';
        removerBotao.innerHTML = '<i data-feather="minus" class="w-5 h-5"></i>';

        removerBotao.addEventListener('click', () => {
            // Remove o wrapper (que contém o botão e o input)
            wrapper.remove();
            atualizarCampo();
        });

        // Input
        const campoInput = document.createElement('input');
        campoInput.type = 'tel';
        // Vetor para que o java receba um array de telefones
        campoInput.name = `telefone-${telefoneCount}`;
        campoInput.className = 'flex-grow px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';
        campoInput.placeholder = 'Ex: 11987654321';
        campoInput.value = initialValue; 

        // Monta o wrapper
        wrapper.appendChild(removerBotao);
        wrapper.appendChild(campoInput);

        return wrapper;
    }

    // Adiciona o telefone
    addBotao.addEventListener('click', () => {
        const campoNovo = criarCampoTelefone();
        container.appendChild(campoNovo);

        if (typeof feather !== 'undefined'){
            feather.replace();
        }
    });
    
    if (typeof feather !== 'undefined'){
        feather.replace();
    }


});