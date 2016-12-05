var btnEditar, btnLimpar;
function iniciar(){
	btnEditar =  document.querySelector("#editar");
	btnEditar.addEventListener("click",editar);
	habilitarEditar	();
	
	btnLimpar =  document.querySelector("#btnLimpar");
	btnLimpar.addEventListener("click",limparCampos);
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
	var restrito = document.querySelector("#restrito");
	id.disabled = true;
	restrito.disabled = true;
	}

function habilitarEditar(){
	var idCliente = document.querySelector("#id");
	
	if(idCliente.value == ""){
		btnEditar.disabled = true;
		
	}else{
		btnEditar.disabled = false;
	}
}


function limparCampos(){
	
	var logradouro = document.querySelector("#logradouro").value = "";
	var numero = document.querySelector("#numero").value = "";
	var cep = document.querySelector("#cep".value = "");
	var bairro = document.querySelector("#bairro").value = "";
	var cidade = document.querySelector("#cidade").value = "";
	var estado = document.querySelector("#estado").value = "";
	var pais = document.querySelector("#pais").value = "";
	
}

window.addEventListener("load",iniciar);