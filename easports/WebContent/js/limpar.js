var btnLimpar;
function iniciar(){
	
	btnLimpar =  document.querySelector("#btnLimpar");
	btnLimpar.addEventListener("click",limparCampos);
}

function limparCampos(){
	
	var logradouro = document.querySelector("#logradouro").value = "";
	var numero = document.querySelector("#numero").value = "";
	var bairro = document.querySelector("#bairro").value = "";
	var cidade = document.querySelector("#cidade").value = "";
	var estado = document.querySelector("#estado").value = "";
	var pais = document.querySelector("#pais").value = "";
	var cep = document.querySelector("#cep").value = "";
}

function limparCampos(){
	var all = document.querySelectorAll(".form-control");

	for(var i = 0; i < all.length; i++){
				all[i].value = "";
				}
}
window.addEventListener("load",iniciar);