
function iniciar(){

	var btnEditar =  document.querySelector("#editar");
	btnEditar.addEventListener("click",editar);
	
}

function editar(){
	
	var nome = document.querySelector("#name");
	nome.disabled = false;
	
}



window.addEventListener("load",iniciar);