document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('telefones-container');
    const addBotao = document.getElementById('add-telefone');
    // Inicializa o contador de telefones. Ele será ajustado por atualizarCampo.
    let telefoneCount = 0;

    /**
     * Atualiza os IDs e Nomes de todos os campos de telefone após uma remoção ou carregamento.
     */
    function atualizarCampo(){
        // Seleciona todos os wrappers de telefone existentes
        const campos = container.querySelectorAll('div[id^="telefone-"]');

        campos.forEach((campo, index) => {
            // Renomeia o ID sequencialmente (telefone-1, telefone-2, ...)
            campo.id = `telefone-${index + 1}`;

            const input = campo.querySelector('input[type="tel"]');
            // Renomeia o atributo 'name' sequencialmente
            input.name = `telefone-${index + 1}`;
        });

        // Atualiza a contagem total
        telefoneCount = campos.length;
    }

    /**
     * Cria e retorna o elemento para um novo campo de telefone.
     * @param {string} initialValue - Valor inicial do campo.
     */
    function criarCampoTelefone(initialValue = '') {

        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-center space-x-2 mb-2';
        // Define um ID temporário/base. O atualizarCampo dará o ID correto.
        wrapper.id = `telefone-temp-${Date.now()}`;

        // botão de remover
        const removerBotao = document.createElement('button');
        removerBotao.type = 'button';
        removerBotao.className = 'remover-telefone text-red-500 hover:text-red-700 p-1';
        removerBotao.title = 'Remover';
        removerBotao.innerHTML = '<i data-feather="minus" class="w-5 h-5"></i>';

        removerBotao.addEventListener('click', () => {
            // Remove o wrapper (que contém o botão e o input)
            wrapper.remove();
            // Reorganiza IDs e Names após a remoção
            atualizarCampo();
        });

        // input
        const campoInput = document.createElement('input');
        campoInput.type = 'tel';
        // Define um 'name' temporário. O atualizarCampo dará o name correto.
        campoInput.name = `telefone-temp`;
        campoInput.className = 'flex-grow px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';
        campoInput.placeholder = 'Ex: 11987654321';
        campoInput.value = initialValue;

        // monta o wrapper
        wrapper.appendChild(removerBotao);
        wrapper.appendChild(campoInput);

        return wrapper;
    }

    // adiciona telefone
    if (addBotao && container) {
        addBotao.addEventListener('click', () => {
            const campoNovo = criarCampoTelefone();
            container.appendChild(campoNovo);
            // Corrige os nomes e IDs imediatamente
            atualizarCampo();

            if (typeof feather !== 'undefined'){
                feather.replace();
            }
        });
    }

    /**
     * FUNÇÃO GLOBAL: Chamada pelo JSP para carregar os telefones salvos.
     * @param {Array<string>} telefones - Array de strings com os números de telefone.
     */
    window.carregarTelefonesIniciais = function(telefones) {
        if (!container) return; // garante que estamos na página com o container

        // limpa o container, caso haja algum HTML prévio
        container.innerHTML = '';

        // se tem telefones salvos, crie um campo para cada um.
        if (telefones && telefones.length > 0) {
            telefones.forEach(tel => {
                const campoNovo = criarCampoTelefone(tel);
                container.appendChild(campoNovo);
            });
        } else {
            // se não tiver telefones salvos, adicione um campo vazio.
            const campoNovo = criarCampoTelefone('');
            container.appendChild(campoNovo);
        }

        // garante que a contagem, IDs e Nomes estão corretos
        atualizarCampo();

        // Renderiza os ícones
        if (typeof feather !== 'undefined'){
            feather.replace();
        }
    };


    // se o container estiver vazio, adiciona pelo menos um campo vazio.
    if (container && container.children.length === 0 && !document.querySelector('.remover-telefone')) {
        // se for uma página de cadastro, onde o jsp não chama a função carregarTelefonesIniciais,
        // garante  que há um campo inicial.
        if (!window.carregarTelefonesIniciais) { // Garante que não é a página de alteração
            const campoNovo = criarCampoTelefone('');
            container.appendChild(campoNovo);
            atualizarCampo();
        }
    }

    if (typeof feather !== 'undefined'){
        feather.replace();
    }
});