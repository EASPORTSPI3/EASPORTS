function iniciar(){
	var perfil=  document.querySelector("#perfil").textContent;
	var produto = document.querySelector("#produto");
	var fornecedor = document.querySelector("#fornecedor");
	var cliente = document.querySelector("#cliente");
	var funcionario = document.querySelector("#funcionario");
	var relatorio = document.querySelector("#relatorio");

	filtrar(perfil);
}

function filtrar(perfil){
	if(perfil == "vendedor"){
		fornecedor.style.display = "none";
		produto.style.display = "none";
		funcionario.style.display = "none";
		relatorio.style.display = "none";
	}
}
window.addEventListener("load",iniciar);