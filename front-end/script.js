const registerForm = document.getElementById('register-form');

registerForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const birthDate = document.getElementById('birthDate').value;

    // Validação básica dos dados (opcional)

    const userData = {
        name,
        email,
        password,
        birthDate
    };

    // Enviar dados para o backend Java Spring Boot
    // (substitua fetch por seu método de requisição HTTP preferido)
    fetch('/api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('Usuário registrado com sucesso!');
                // Redirecionar para página de login ou outra página
            } else {
                alert('Erro ao registrar usuário: ' + data.message);
            }
        })
        .catch(error => {
            console.error('Erro ao enviar dados para o backend:', error);
            alert('Erro ao registrar usuário. Tente novamente mais tarde.');
        });
});