document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('telefones-container');
    const addBotao = document.getElementById('add-telefone');
    let telefoneCount = 0; // contador de campos

    // atualiza o name dos inputs
    function atualizarCampos() {
        const campos = container.querySelectorAll('div[data-telefone]');
        campos.forEach((campo, index) => {
            campo.dataset.telefone = index + 1; // reindexa wrapper
            const input = campo.querySelector('input[type="tel"]');
            input.name = `telefone-${index + 1}`; // atualiza o name
        });
        telefoneCount = campos.length; // atualiza contador
    }

   
    function criarCampoTelefone(valor = '') {
        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-center space-x-2 mb-2';
        wrapper.dataset.telefone = telefoneCount + 1;

        // input de telefone
        const input = document.createElement('input');
        input.type = 'tel';
        input.name = `telefone-${telefoneCount + 1}`;
        input.value = valor;
        input.placeholder = 'Ex: 11987654321';
        input.className = 'flex-grow px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';

        // botão de remover
        const btnRemover = document.createElement('button');
        btnRemover.type = 'button';
        btnRemover.innerHTML = '<i data-feather="minus"></i>';
        btnRemover.className = 'text-red-500 hover:text-red-700 p-1';
        btnRemover.addEventListener('click', () => {
            wrapper.remove(); // remove o campo
            atualizarCampos(); // reindexa campos restantes
        });

        // adiciona elementos ao wrapper
        wrapper.appendChild(btnRemover);
        wrapper.appendChild(input);

        return wrapper;
    }

    // adiciona novo campo
    if (addBotao && container) {
        addBotao.addEventListener('click', () => {
            const campoNovo = criarCampoTelefone();
            container.appendChild(campoNovo);
            atualizarCampos(); // reindexa todos
            if (typeof feather !== 'undefined') feather.replace();
        });
    }
});
