function iniciar(){
	
	var perfil=  document.querySelector("#perfil").textContent;
	
	// Menu principal
	
	var menuRelatorio = document.querySelector("#menuRelatorio");
	var menuRelatorio = document.querySelector("#menuConsultar");
	var menuRelatorio = document.querySelector("#menuCadastrar");
	
	var cadastrarProduto = document.querySelector("#cadastrarProduto");
	var cadastrarFornecedor = document.querySelector("#cadastrarFornecedor");
	var cadastrarCliente = document.querySelector("#cadastrarCliente");
	var cadastrarFuncionario = document.querySelector("#cadastrarFuncionario");
	
	var consultarCliente = document.querySelector("#consultarCliente");
	var consultarFornecedor = document.querySelector("#consultarFornecedor");
	var consultarFuncionario = document.querySelector("#consultarFuncionario");
	var consultarProduto = document.querySelector("#consultarProduto");
	var consultarPedido = document.querySelector("#consultarPedido");
	
	var relatorioCliente = document.querySelector("#relatorioCliente");
	var relatorioPedido = document.querySelector("#relatorioPedido");
	var relatorioEstoque = document.querySelector("#relatorioEstoque");
	
	// Botões de acesso rápido
	
	var consultarCliente = document.querySelector("#consultarCliente");
	var consultarFornecedor = document.querySelector("#consultarFornecedor");
	var consultarFuncionario = document.querySelector("#consultarFuncionario");
	var consultarProduto = document.querySelector("#consultarProduto");
	var consultarPedido = document.querySelector("#consultarPedido");

	filtrar(perfil);
}

function filtrar(perfil){
	
	if(perfil == "Vendedor"){
		
		cadastrarFornecedor.style.display = "none";
		cadastrarProduto.style.display = "none";
		cadastrarFuncionario.style.display = "none";
		
		consultarFuncionario.style.display = "none";
		
		menuRelatorio.style.display = "none";
		
	}else if(perfil == "Gerente de Produtos"){
		
		cadastrarCliente.style.display = "none";
		cadastrarFuncionario.style.display = "none";
		
		consultarCliente.style.display = "none";
		consultarFuncionario.style.display = "none";
		
		relatorioCliente.style.display = "none";
		
	}else{
		
	}
}

window.addEventListener("load",iniciar);