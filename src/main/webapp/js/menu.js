const sidebar = document.getElementById('sidebar');
        const menuBotao = document.getElementById('menu-botao');
        const overlay = document.getElementById('sidebar-overlay'); 

        function toggleSidebar() { // aciona a sidebar
            sidebar.classList.toggle('-translate-x-full');
            overlay.classList.toggle('opacity-0');
            overlay.classList.toggle('opacity-50');
            overlay.classList.toggle('pointer-events-none');
        }

        menuBotao.addEventListener('click', toggleSidebar);
        overlay.addEventListener('click', toggleSidebar);

        // fecha o menu ao clicar em um link 
        document.querySelectorAll('#sidebar a').forEach(item => {
            item.addEventListener('click', () => {
                // fecha apenas se a sidebar estiver visível
                if (window.innerWidth < 640) { // 
                    toggleSidebar();
                }
            });
        });