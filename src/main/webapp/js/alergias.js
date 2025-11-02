document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('alergias-container');
    const addBotao = document.getElementById('add-alergia');

    // inicializa a contagem de campos existentes
    let alergiaCount = container.querySelectorAll('div[data-alergia-wrapper]').length; 


    // desabilita as opções que já foram selecionadas em outros campos
    function atualizarOpcoes() {
        const campos = container.querySelectorAll('div[data-alergia-wrapper]');
        const selecionados = [];

        // armazena os valores selecionados em todos os selects
        campos.forEach(campo => {
            const val = campo.querySelector('select').value;
            if (val) selecionados.push(val);
        });

        // atualiza cada select para desabilitar opções duplicadas
        campos.forEach(campo => {
            const select = campo.querySelector('select');
            const valorAtual = select.value;

            Array.from(select.options).forEach(opt => {
                if (opt.value && opt.value !== valorAtual) {
                    opt.disabled = selecionados.includes(opt.value);
                } else {
                    opt.disabled = false;
                }
            });
        });
    }


    function atualizarCampo() {
        const campos = container.querySelectorAll('div[data-alergia-wrapper]');
        alergiaCount = campos.length; // atualiza a contagem

        campos.forEach((campo, index) => {
            const novoIndice = index + 1;
            campo.id = `alergia-wrapper-${novoIndice}`;
            const select = campo.querySelector('select');
            if (select) select.name = `alergia-${novoIndice}`;
        });

        atualizarOpcoes(); // atualiza opções para evitar duplicatas
    }

    
    function criarCampoAlergia() {
        alergiaCount++;
        const indice = alergiaCount;

        // cria o wrapper do campo
        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-start space-x-2 mb-2';
        wrapper.setAttribute('data-alergia-wrapper', '');
        wrapper.id = `alergia-wrapper-${indice}`;

        // botão de remover o campo
        const removerBotao = document.createElement('button');
        removerBotao.type = 'button';
        removerBotao.className = 'text-red-500 hover:text-red-700 p-2 mt-2';
        removerBotao.innerHTML = '<i data-feather="minus" class="w-5 h-5"></i>';

        // remove o campo
        removerBotao.addEventListener('click', () => {
            wrapper.remove();
            atualizarCampo(); // reindexa e atualiza opções
            if (typeof feather !== 'undefined') feather.replace();
        });

        // container do select
        const selectContainer = document.createElement('div');
        selectContainer.className = 'flex flex-col flex-grow';

        // criação do select
        const campoSelect = document.createElement('select');
        campoSelect.name = `alergia-${indice}`;
        campoSelect.className = 'w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';

        // opção padrão
        const optionPadrao = document.createElement('option');
        optionPadrao.value = '';
        optionPadrao.textContent = 'Selecione uma alergia';
        optionPadrao.disabled = true;
        optionPadrao.hidden = true;
        optionPadrao.selected = true;
        campoSelect.appendChild(optionPadrao);

        // preenche as opções com o array 'alergiasOp'
        if (typeof alergiasOp !== 'undefined' && Array.isArray(alergiasOp)) {
            alergiasOp.forEach(alergia => {
                const option = document.createElement('option');
                option.value = alergia;
                option.textContent = alergia; 
                campoSelect.appendChild(option);
            });
        }

        // atualiza opções sempre que muda
        campoSelect.addEventListener('change', atualizarOpcoes);

        selectContainer.appendChild(campoSelect);
        wrapper.appendChild(removerBotao);
        wrapper.appendChild(selectContainer);

        // atualiza opções ao criar
        atualizarOpcoes();

        return wrapper;
    }

    // adiciona um novo campo
    addBotao.addEventListener('click', () => {
        const campoNovo = criarCampoAlergia();
        container.appendChild(campoNovo);
        if (typeof feather !== 'undefined') feather.replace();
    });

    // inicializa contagem e atualiza opções ao carregar
    atualizarCampo();
    if (typeof feather !== 'undefined') feather.replace();
});
