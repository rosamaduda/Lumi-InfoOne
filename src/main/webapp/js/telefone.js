document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('telefones-container');
    const addButton = document.getElementById('add-telefone');
    let telefoneCount = 0;

    /**
     * Cria e retorna o elemento jsp para um novo campo de telefone.
     * @param {string} initialValue - Valor inicial para o campo.
     */
    function createTelefoneField(initialValue = '') {
        const wrapper = document.createElement('div');
        wrapper.className = 'flex items-center space-x-2 mb-2';
        wrapper.id = `telefone-field-${telefoneCount++}`; // ID único

        // Botão de remover
        const removeButton = document.createElement('button');
        removeButton.type = 'button';
        removeButton.className = 'remover-telefone text-red-500 hover:text-red-700 p-1';
        removeButton.title = 'Remover';
        removeButton.innerjsp = '<span class="text-xl">⊖</span>';

        removeButton.addEventListener('click', () => {
            // Remove o wrapper (que contém o botão e o input)
            wrapper.remove();
        });

        // Input
        const inputField = document.createElement('input');
        inputField.type = 'tel';
        // Vetor para que o java receba um array de telefones
        inputField.name = 'telefone[]';
        inputField.className = 'flex-grow px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent';
        inputField.placeholder = 'Ex: 11987654321';
        inputField.value = initialValue; 

        // Monta o wrapper
        wrapper.appendChild(removeButton);
        wrapper.appendChild(inputField);

        return wrapper;
    }

    // Adiciona o telefone
    addButton.addEventListener('click', () => {
        const newField = createTelefoneField();
        container.appendChild(newField);
    });


});