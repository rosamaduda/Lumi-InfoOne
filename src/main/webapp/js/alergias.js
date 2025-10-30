document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('alergias-container');
    const addBotao = document.getElementById('add-alergia');
    let alergiaCount = 0;

    const opcoesAlergias = ['Glúten', 'Lactose', 'Amendoim', 'Ovo']; // teste

    function atualizarCampo() {
        const campos = container.querySelectorAll('div[id^="alergia-"]');
        campos.forEach((campo, index) => {
            campo.id = `alergia-${index + 1}`;
            const select = campo.querySelector('select');
            select.name = `alergia-${index + 1}`;
        });
        alergiaCount = campos.length;
    }

    function criarCampoAlergia(initialValue = '') {
        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-center space-x-2 mb-2';
        wrapper.id = `alergia-${++alergiaCount}`;

        const removerBotao = document.createElement('button');
        removerBotao.type = 'button';
        removerBotao.className = 'text-red-500 hover:text-red-700 p-1';
        removerBotao.innerHTML = '<i data-feather="minus" class="w-5 h-5"></i>';
        removerBotao.addEventListener('click', () => {
            wrapper.remove();
            atualizarCampo();
        });

        const campoSelect = document.createElement('select');
        campoSelect.name = `alergia-${alergiaCount}`;
        campoSelect.className = 'w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';

        const optionPadrao = document.createElement('option');
        optionPadrao.value = '';
        optionPadrao.textContent = 'Selecione uma alergia';
        optionPadrao.disabled = true;
        optionPadrao.hidden = true;
        optionPadrao.selected = true;
        campoSelect.appendChild(optionPadrao);

        opcoesAlergias.forEach(alergia => {
            const option = document.createElement('option');
            option.value = alergia;
            option.textContent = alergia;
            campoSelect.appendChild(option);
        });

        const optionOutro = document.createElement('option');
        optionOutro.value = 'Outro';
        optionOutro.textContent = 'Outro';
        campoSelect.appendChild(optionOutro);

        campoSelect.addEventListener('change', () => {
            let outroInput = wrapper.querySelector('input[type="text"]');

            if (campoSelect.value === 'Outro') {
                if (!outroInput) {
                    outroInput = document.createElement('input');
                    outroInput.type = 'text';
                    outroInput.name = `alergia-outro-${alergiaCount}`;
                    outroInput.placeholder = 'Digite a alergia';
                    outroInput.className = 'flex-grow px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent mt-2';
                    wrapper.appendChild(outroInput);
                }
            } else if (outroInput) {
                outroInput.remove();
            }
        });

        // Se quiser usar initialValue no futuro:
        if (initialValue) campoSelect.value = initialValue;

        wrapper.appendChild(removerBotao);
        wrapper.appendChild(campoSelect);

        return wrapper;
    }

    addBotao.addEventListener('click', () => {
        const campoNovo = criarCampoAlergia();
        container.appendChild(campoNovo);
        if (typeof feather !== 'undefined') feather.replace();
    });

    if (typeof feather !== 'undefined') feather.replace();
});
