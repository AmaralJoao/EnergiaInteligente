// toggle da visibilidade da senha e efeito sutil no botão
document.addEventListener('DOMContentLoaded', function () {
    const toggle = document.getElementById('togglePwd');
    const pwd = document.getElementById('senha');

    if (toggle && pwd) {
        toggle.addEventListener('click', function () {
            if (pwd.type === 'password') {
                pwd.type = 'text';
                toggle.innerHTML = '<i class="pi pi-eye-slash"></i>';
            } else {
                pwd.type = 'password';
                toggle.innerHTML = '<i class="pi pi-eye"></i>';
            }
            // pequeno efeito
            toggle.animate([{ transform: 'scale(1.0)' }, { transform: 'scale(1.08)' }, { transform: 'scale(1.0)' }], {
                duration: 240,
                easing: 'ease-out'
            });
        });
    }

    // pequena animação do título (flicker neon)
    const title = document.querySelector('.neon-title');
    if (title) {
        setInterval(() => {
            title.animate([{ opacity: 1 }, { opacity: 0.85 }, { opacity: 1 }], { duration: 2600 });
        }, 3000);
    }
});
