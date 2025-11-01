document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('alergias-container');
    const addBotao = document.getElementById('add-alergia');

    // inicializa a contagem de campos existentes
    let alergiaCount = container.querySelectorAll('div[data-alergia-wrapper]').length;

    // --- Função para reindexar campos e names após remoções ---
    function atualizarCampo() {
        const campos = container.querySelectorAll('div[data-alergia-wrapper]');
        alergiaCount = campos.length; // atualiza a contagem
        for (let i = 0; i < campos.length; i++) {
            const campo = campos[i];
            // atualiza o id do wrapper
            campo.id = `alergia-wrapper-${i+1}`;
            // atualiza o name do select para manter sequência correta
            campo.querySelector('select').name = `alergia-${i+1}`;
        }
    }

--
    function removerCampo(event) {
        const wrapper = event.currentTarget.closest('div[data-alergia-wrapper]');
        if (wrapper) {
            wrapper.remove(); // remove o campo do DOM
            atualizarCampo(); // reindexa os campos restantes
            atualizarOpcoes(); // atualiza os selects para evitar duplicidade
            if (typeof feather !== 'undefined') feather.replace(); // atualiza ícones Feather
        }
    }

    function atualizarOpcoes() {
        const campos = container.querySelectorAll('div[data-alergia-wrapper]');
        const selecionados = [];

        // Pega os valores selecionados em todos os selects
        for (let i = 0; i < campos.length; i++) {
            const val = campos[i].querySelector('select').value;
            if (val) selecionados.push(val);
        }

        // percorre cada select e desabilita as opções já selecionadas em outros selects
        for (let i = 0; i < campos.length; i++) {
            const select = campos[i].querySelector('select');
            const valorAtual = select.value;

            for (let j = 0; j < select.options.length; j++) {
                const opt = select.options[j];
                if (opt.value && opt.value !== valorAtual) {
                    opt.disabled = selecionados.includes(opt.value);
                } else {
                    opt.disabled = false;
                }
            }
        }
    }


    function criarCampoAlergia() {
        alergiaCount++; // incrementa contador

        // cria o wrapper do campo
        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-start space-x-2 mb-2';
        wrapper.dataset.alergiaWrapper = '';
        wrapper.id = `alergia-wrapper-${alergiaCount}`;
    
        // botão de remover
        const btnRemover = document.createElement('button');
        btnRemover.type = 'button';
        btnRemover.className = 'text-red-500 hover:text-red-700 p-2 mt-2';
        btnRemover.innerHTML = '<i data-feather="minus" class="w-5 h-5"></i>';
        btnRemover.addEventListener('click', removerCampo); 
    
        // criação do select
        const select = document.createElement('select');
        select.name = `alergia-${alergiaCount}`;
        select.className = 'w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';
    
        // opção padrão 
        const optionPadrao = document.createElement('option');
        optionPadrao.value = '';
        optionPadrao.textContent = 'Selecione uma alergia';
        optionPadrao.disabled = true;
        optionPadrao.hidden = true;
        optionPadrao.selected = true;
        select.appendChild(optionPadrao);
    
        // preenche opções do array  'alergiasOp'
        for (let i = 0; i < alergiasOp.length; i++) {
            const opt = document.createElement('option');
            opt.value = alergiasOp[i];
            opt.textContent = alergiasOp[i];
            select.appendChild(opt);
        }
    
        // atualiza opções sempre que muda o select
        select.addEventListener('change', atualizarOpcoes);
    
        // adiciona elementos ao wrapper
        wrapper.appendChild(btnRemover);
        wrapper.appendChild(select);
    
        return wrapper;
    }
    
    // coloca remover nos elementos ja existentes
    const btnsRemover = container.querySelectorAll('.btn-remover-alergia');
    for (let i = 0; i < btnsRemover.length; i++) {
        btnsRemover[i].addEventListener('click', removerCampo);
    }

    // adiciona um novo campo
    addBotao.addEventListener('click', () => {
        const novoCampo = criarCampoAlergia();
        container.appendChild(novoCampo);
        atualizarOpcoes(); // evita duplicidade
        alergiaCount = container.querySelectorAll('div[data-alergia-wrapper]').length;
        if (typeof feather !== 'undefined') feather.replace();
    });

    // inicializa campos e opções ao carregar a página
    atualizarCampo();
    atualizarOpcoes();
    if (typeof feather !== 'undefined') feather.replace();
});
