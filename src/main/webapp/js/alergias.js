document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('alergias-container');
    const addBotao = document.getElementById('add-alergia');
    
    // Inicializa a contagem baseada nos campos existentes (deve ser 0, mas verifica)
    let alergiaCount = container.querySelectorAll('div[data-alergia-wrapper]').length; 

    // --- Funções de Lógica e Renderização ---

    /**
     * Reindexa todos os campos após uma remoção para garantir que
     * os nomes (ex: alergia-1, alergia-2) sejam sequenciais.
     */
    function atualizarCampo() {
        const campos = container.querySelectorAll('div[data-alergia-wrapper]');
        alergiaCount = campos.length; // Reseta o contador para o número atual de campos

        campos.forEach((campo, index) => {
            const novoIndice = index + 1;
            
            // Atualiza IDs e names com o novo índice
            campo.id = `alergia-wrapper-${novoIndice}`;
            
            const select = campo.querySelector('select');
            if (select) {
                select.name = `alergia-${novoIndice}`;
            }

            const outroInput = campo.querySelector('input[type="text"]');
            if (outroInput) {
                outroInput.name = `alergia-outro-${novoIndice}`;
            }
        });
    }

    /**
     * Cria e retorna o wrapper completo de um novo campo de alergia.
     */
    function criarCampoAlergia() {
        // Incrementa a contagem de forma segura antes de criar o campo
        alergiaCount++; 
        const indice = alergiaCount; 

        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-start space-x-2 mb-2'; 
        wrapper.setAttribute('data-alergia-wrapper', ''); 
        wrapper.id = `alergia-wrapper-${indice}`;

        // 1. Botão de Remoção
        const removerBotao = document.createElement('button');
        removerBotao.type = 'button';
        removerBotao.className = 'text-red-500 hover:text-red-700 p-2 mt-2';
        removerBotao.innerHTML = '<i data-feather="minus" class="w-5 h-5"></i>';

        removerBotao.addEventListener('click', () => {
            wrapper.remove();
            // A atualização do campo (e do alergiaCount) ocorre APÓS a remoção
            atualizarCampo();
            if (typeof feather !== 'undefined') feather.replace();
        });

        // 2. Container para Select e Input Outro
        const selectInputContainer = document.createElement('div');
        selectInputContainer.className = 'flex flex-col flex-grow';
        
        // 3. Campo Select
        const campoSelect = document.createElement('select');
        campoSelect.name = `alergia-${indice}`;
        campoSelect.className = 'w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';

        const optionPadrao = document.createElement('option');
        optionPadrao.value = '';
        optionPadrao.textContent = 'Selecione uma alergia';
        optionPadrao.disabled = true;
        optionPadrao.hidden = true;
        optionPadrao.selected = true;
        campoSelect.appendChild(optionPadrao);

        // Preenche opções a partir do array injetado (opcoesAlergias)
        if (typeof opcoesAlergias !== 'undefined' && Array.isArray(opcoesAlergias)) {
            opcoesAlergias.forEach(alergia => {
                const option = document.createElement('option');
                option.value = alergia;
                option.textContent = alergia; 
                campoSelect.appendChild(option);
            });
        }

        const optionOutro = document.createElement('option');
        optionOutro.value = 'Outro';
        optionOutro.textContent = 'Outro (digitar)';
        campoSelect.appendChild(optionOutro);
        
        selectInputContainer.appendChild(campoSelect);

        // 4. Lógica para campo 'Outro'
        campoSelect.addEventListener('change', () => {
            let outroInput = selectInputContainer.querySelector('input[type="text"]');

            if (campoSelect.value === 'Outro') {
                if (!outroInput) {
                    outroInput = document.createElement('input');
                    outroInput.type = 'text';
                    outroInput.name = `alergia-outro-${indice}`; 
                    outroInput.placeholder = 'Digite a nova alergia...';
                    outroInput.required = true;
                    outroInput.className = 'px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mt-2';
                    selectInputContainer.appendChild(outroInput);
                }
            } else if (outroInput) {
                outroInput.remove();
            }
            
            // Reajusta o 'name' do input 'Outro' caso ele já exista
            if (outroInput) {
                 const currentCampos = container.querySelectorAll('div[data-alergia-wrapper]');
                 const currentWrapperIndex = Array.from(currentCampos).findIndex(c => c === wrapper);
                 if (currentWrapperIndex !== -1) {
                    outroInput.name = `alergia-outro-${currentWrapperIndex + 1}`;
                 }
            }
        });

        // Montagem final do Wrapper
        wrapper.appendChild(removerBotao);
        wrapper.appendChild(selectInputContainer);

        return wrapper;
    }
    
    // --- Event Listener ---

    addBotao.addEventListener('click', () => {
        const campoNovo = criarCampoAlergia();
        container.appendChild(campoNovo);
        
        // A reindexação não é estritamente necessária aqui porque 'criarCampoAlergia'
        // já usou o 'alergiaCount' incrementado.
        
        if (typeof feather !== 'undefined') feather.replace();
    });

    // Inicializa: Garante que a contagem e os nomes estão corretos ao carregar.
    atualizarCampo();
    if (typeof feather !== 'undefined') feather.replace();
});