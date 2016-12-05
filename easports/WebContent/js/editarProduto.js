var btnEditar, btnSalvar, precoCusto, precoVenda, estoque;

function iniciar(){
	
	estoque = document.querySelector("#estoque");
	precoVenda = document.querySelector("#precoVenda");
	precoCusto = document.querySelector("#precoCusto");
	btnSalvar = document.querySelector("#salvar");
	btnEditar = document.querySelector("#editar");
	btnEditar.addEventListener("click",editar);
	
	
}

function editar(){
	if(btnEditar.value == "Editar"){
		btnEditar.value = "Cancelar";
		btnSalvar.disabled = false;
		precoCusto.disabled = false;
		precoVenda.disabled = false;
		estoque.disabled = false;
	}else{
		btnEditar.value = "Editar";
		btnSalvar.disabled = true;
		precoCusto.disabled = true;
		precoVenda.disabled = true;
		estoque.disabled = true;
	}	
}	













window.addEventListener("load",iniciar);