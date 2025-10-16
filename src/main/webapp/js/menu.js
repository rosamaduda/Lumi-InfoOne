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