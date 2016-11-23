
function iniciar(){
	var btnEditar =  document.querySelector("#editar");
	btnEditar.addEventListener("click",editar);
}

function editar(){
	var all = document.querySelectorAll(".form-control");
	
	
	for(var i = 0; i < all.length; i++){
		
		if(all[i].name  == "idCliente"){
			all[i].disabled = true;
		}else{
			all[i].disabled = false;
		}
	}
}

window.addEventListener("load",iniciar);