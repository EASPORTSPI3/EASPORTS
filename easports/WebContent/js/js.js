
function iniciar(){
	var btnEditar =  document.querySelector("#editar");
	btnEditar.addEventListener("click",editar);
}

function editar(){
	var all = document.querySelectorAll(".form-control");
	var btnEnviar =  document.querySelector("#enviar");
	var btnEditar =  document.querySelector("#editar");	

	if(btnEditar.value == "Editar"){
		btnEditar.value = "Cancelar";
		btnEnviar.disabled = false;
		
		for(var i = 0; i < all.length; i++){
			
			if(all[i].name  == "idCliente" || all[i].name  == "idFornecedor" || all[i].name  == "idFuncionario"){
				all[i].disabled = true;

			}else{
				all[i].disabled = false;
				btnEnviar.disabled = false;
			}
		}
	}else{
		btnEnviar.disabled = true;
		btnEditar.value = "Editar";
		for(var i = 0; i < all.length; i++){
				all[i].disabled = true;
				all[i].disabled = true;
				btnEnviar.disabled = true;
			}
		}
	var id = document.querySelector(".form-control");
	var cpf = document.querySelector("#cpf");
	id.disabled = true;
	cpf.disabled = true;
	}


window.addEventListener("load",iniciar);