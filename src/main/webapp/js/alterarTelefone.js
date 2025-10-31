document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('telefones-container');
    const addBotao = document.getElementById('add-telefone');
    
  
    let telefoneCount = container.querySelectorAll('div[data-telefone]').length; 

    // função para reindexar e renomear os campos
    function atualizarCampos() {
        // seleciona os campos APENAS dentro do container
        const campos = container.querySelectorAll('div[data-telefone]');
        
        campos.forEach((campo, index) => {
            const novoIndice = index + 1;
            
            campo.dataset.telefone = novoIndice;
            
            const input = campo.querySelector('input[type="tel"]');
            input.name = `telefone-${novoIndice}`;
        });
        
        // atualiza a variável global de contagem
        telefoneCount = campos.length; 
    }

    // lida com a remoção de um campo de telefone
    function removerCampo(event) {
        const wrapper = event.currentTarget.closest('div[data-telefone]');
        if (wrapper) {
            wrapper.remove();
            atualizarCampos(); // Reindexa os campos restantes
            if (typeof feather !== 'undefined') feather.replace();
        }
    }

    // função para criar um novo campo de telefone
    function criarCampoTelefone(valor = '') {
        const novoIndice = telefoneCount + 1;

        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-center space-x-2 mb-2';
        wrapper.dataset.telefone = novoIndice; 

        // botão de remover com listener
        const btnRemover = document.createElement('button');
        btnRemover.type = 'button';
        btnRemover.innerHTML = '<i data-feather="minus"></i>';
        btnRemover.className = 'text-red-500 hover:text-red-700 p-1 btn-remover-tel';
        btnRemover.addEventListener('click', removerCampo); 

        // input do telefone
        const input = document.createElement('input');
        input.type = 'tel';
        input.name = `telefone-${novoIndice}`;
        input.value = valor;
        input.placeholder = 'Ex: 11987654321';
        input.className = 'flex-grow px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';
        
        wrapper.appendChild(btnRemover);
        wrapper.appendChild(input);

        return wrapper;
    }


    // busca os botões DENTRO do container
    container.querySelectorAll('.btn-remover-tel').forEach(btn => {
        btn.addEventListener('click', removerCampo);
    });

    //  anexa o listener de adição
    if (addBotao && container) {
        addBotao.addEventListener('click', () => {
            const campoNovo = criarCampoTelefone();
            container.appendChild(campoNovo);
            // incrementa o contador para a próxima adição
            telefoneCount++; 
            if (typeof feather !== 'undefined') feather.replace();
        });
    }
});