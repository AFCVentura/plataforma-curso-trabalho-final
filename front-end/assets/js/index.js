if (localStorage.getItem("token") == null){
    alert("Voce precisa estar logado para acessar essa pagina")
    window.location.href = "./assets/html/signin.html";

}

let userLogado = JSON.parse(localStorage.getItem("userLogoado"));
userLogado.innerHTML = "Olá ${userLogado.nome}";

function sair(){
    localStorage.removeItem("token");
    localStorage.removeItem("userLogado");
    window.location.href = "./assets/html/signin.html";
}