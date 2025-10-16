<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lumi - Alterar Cliente</title>
    <link rel="icon"
      href="${pageContext.request.contextPath}/assets/logo-infoone.ico">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
  </head>
  <body class="bg-gray-50 min-h-screen">
    <header
      class="bg-[#7F3FBF] text-white fixed top-0 left-0 right-0 z-50 h-16 sm:h-20 shadow-md">
      <div
        class="container mx-auto px-4 py-3 sm:py-4 h-full flex items-center justify-between">
        <h1 class="sm:ml-[-5%]"><img
            src="${pageContext.request.contextPath}/assets/logo branca.png"
            width="80%" class="h-8 sm:h-auto"
            style="align-items: center;"></h1>

        <button id="menu-botao" class="sm:hidden p-2">
          <i data-feather="menu" class="w-6 h-6"></i>
        </button>
      </div>
    </header>

    <div class="flex pt-16 sm:pt-20 min-h-screen">

      <nav id="sidebar"
        class="fixed left-0 top-16 sm:top-20 h-full w-64 bg-white shadow-lg z-40 transform -translate-x-full sm:translate-x-0 transition-transform duration-300">

        <div class="flex flex-col h-full">

          <div class="p-4 border-b flex-shrink-0">
            <div class="text-center mb-2 mt-2">
              <div
                class="w-16 h-16 bg-purple-100 rounded-full flex items-center justify-center mx-auto mb-2">
                <i data-feather="user" class="text-[#7F3FBF]"></i>
              </div>
              <h2 class="font-bold text-lg">ADM</h2>
              <p class="text-sm text-gray-600">ID: #ADM001</p>
            </div>
          </div>

          <div class="p-4 flex-grow overflow-y-auto">
            <ul class="space-y-2">
              <li><a href="portal.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                    data-feather="home" class="mr-3"></i>Portal
                  ADM</a></li>
              <li><a href="ingredientes.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333] "><i
                    data-feather="package"
                    class="mr-3"></i>Ingredientes</a></li>
              <li><a href="alergias.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100  text-[#333333] "><i
                    data-feather="alert-triangle"
                    class="mr-3"></i>Alergias</a></li>
              <li><a href="cliente.html"
                  class="flex items-center p-3 bg-purple-100 rounded-lg  text-[#333333] font-medium"><i
                    data-feather="users"
                    class="mr-3"></i>Cliente</a></li>
              <li><a href="industria.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                    data-feather="tool"
                    class="mr-3"></i>Indústria</a></li>
              <li><a href="favoritos.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                    data-feather="heart"
                    class="mr-3"></i>Favoritos</a></li>
              <li><a href="avaliacoes.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                    data-feather="star"
                    class="mr-3"></i>Avaliações</a></li>
              <li><a href="${pageContext.request.contextPath}/index.html"
                  class="flex items-center p-3 rounded-lg hover:bg-gray-100 text-[#333333]"><i
                    data-feather="globe"
                    class="mr-3"></i>Site</a></li>
            </ul>
          </div>
        </div>
      </nav>
      <div id="sidebar-overlay"
        class="fixed inset-0 bg-black opacity-0 sm:hidden z-30 pointer-events-none transition-opacity duration-300"></div>

      <main class="sm:ml-64 flex-1 sm:p-8">
        <a href="cliente.jsp"><h1 class="text-left"><i
              data-feather="arrow-left"></i></h1></a>
        <h1
          class="text-[2.25rem] font-bold text-[#333333] mb-8 text-center mt-[3%]"
          data-aos="fade-down">Alterar Cliente</h1>
        <div id="input"
          class="bg-white rounded-[15px] shadow-md p-8 max-w-lg mx-auto mt-[3%]"
          data-aos="fade-up" data-aos-delay="100">
          <form action="#" method="post">
            <div class="mb-6">
              <label for="cpf"
                class="block text-gray-700 text-sm font-medium mb-2">CPF:</label>
              <input type="text" id="cpf" name="cpf"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Ex: 432.654.789-01">

              <label for="nome"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Nome:</label>
              <input type="text" id="nome" name="nome"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Digite o nome do cliente...">

              <label for="sobrenome"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Sobrenome:</label>
              <input type="text" id="sobrenome" name="sobrenome"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Digite o sobrenome do cliente...">

              <label for="peso"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Peso
                (kg):</label>
              <input type="number" step="0.01" min="0" id="peso" name="peso"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Ex: 76">

              <label for="altura"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Altura
                (m):</label>
              <input type="number" step="0.01" min="0" id="altura" name="altura"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Ex: 1,90">

              <label for="data"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Data
                de nascimento:</label>
              <input type="date" id="data" name="data"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent">

              <label for="e-mail"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">E-mail:</label>
              <input type="email" id="e-mail" name="e-mail"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Ex: nome@exemplo.com">

              <label for="telefones-container"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Telefone:</label>
              <div id="telefones-container" class="mb-2">
              </div>
              <button type="button" id="add-telefone"
                class="flex items-center space-x-2 text-[#7F3FBF] hover:text-[#5B2E85] text-sm font-medium w-full sm:w-auto border-[2px] border-[#7F3FBF] text-[#7F3FBF] px-3 py-2 rounded-[6px] ">
                <span>Alterar telefone</span>
              </button>

              <label for="senha"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Senha:</label>
              <input type="text" id="senha" name="senha"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Digite a senha do cliente...">

              <label for="cidade"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Cidade:</label>
              <input type="text" id="cidade" name="cidade"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Ex: Águas de Lindóia">

              <label for="estado"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">Estado:</label>
              <select name="estado" id="estado"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"">
                <option value selected>Selecione um estado</option>
                <option value="ac">Acre</option>
                <option value="al">Alagoas</option>
                <option value="ap">Amapá</option>
                <option value="am">Amazonas</option>
                <option value="ba">Bahia</option>
                <option value="ce">Ceará</option>
                <option value="df">Distrito Federal</option>
                <option value="es">Espírito Santo</option>
                <option value="go">Goiás</option>
                <option value="ma">Maranhão</option>
                <option value="mt">Mato Grosso</option>
                <option value="ms">Mato Grosso do Sul</option>
                <option value="mg">Minas Gerais</option>
                <option value="pa">Pará</option>
                <option value="pb">Paraíba</option>
                <option value="pr">Paraná</option>
                <option value="pe">Pernambuco</option>
                <option value="pi">Piauí</option>
                <option value="rj">Rio de Janeiro</option>
                <option value="rn">Rio Grande do Norte</option>
                <option value="rs">Rio Grande do Sul</option>
                <option value="ro">Rondônia</option>
                <option value="rr">Roraima</option>
                <option value="sc">Santa Catarina</option>
                <option value="sp">São Paulo</option>
                <option value="se">Sergipe</option>
                <option value="to">Tocantins</option>
              </select>

              <label for="cep"
                class="block text-gray-700 text-sm font-medium mb-2 mt-2">CEP:</label>
              <input type="text" id="cidade" name="cidade"
                class="w-full px-4 py-3 border border-gray-300 rounded-[15px] focus:ring-2 focus:ring-[#7F3FBF] focus:border-transparent"
                placeholder="Ex: 01234-567">
            </div>
            <div class="text-center">
              <button
                class="bg-[#C6F500] text-gray-800 font-bold py-3 px-6 rounded-[15px] hover:bg-lemon-500 transition-colors">
                Alterar
              </button>
            </div>
          </form>
        </div>
      </main>
    </div>
    <script>
        AOS.init({ duration: 800, once: true });
        feather.replace();

         // Menu Lateral
         const sidebar = document.getElementById('sidebar');
        const menuBotao = document.getElementById('menu-botao');
        const overlay = document.getElementById('sidebar-overlay');

        function toggleSidebar() {
            sidebar.classList.toggle('-translate-x-full');
            overlay.classList.toggle('opacity-0');
            overlay.classList.toggle('opacity-50');
            overlay.classList.toggle('pointer-events-none');
        }

        menuBotao.addEventListener('click', toggleSidebar);
        overlay.addEventListener('click', toggleSidebar);

        // Fecha o menu ao clicar em um link 
        document.querySelectorAll('#sidebar a').forEach(item => {
            item.addEventListener('click', () => {
                // Fecha apenas se a sidebar estiver visível (i.e., em mobile)
                if (window.innerWidth < 640) { // O breakpoint sm é 640px
                    toggleSidebar();
                }
            });
        });


        document.addEventListener('DOMContentLoaded', () => {
        const container = document.getElementById('telefones-container');
        const addButton = document.getElementById('add-telefone');
        let telefoneCount = 0;

        /**
         * Cria e retorna o elemento html para um novo campo de telefone.
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
            removeButton.innerHTML = '<span class="text-xl">⊖</span>';

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
    </script>
  </body>
</html>