<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
	<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
	<title>EA Sports</title>
</head>
<body>
	<jsp:include page="cabecalhoRodape.jsp"></jsp:include>
	<hgroup>
	
	<form name="formulario" method="post"
			action="ControlePessoa?acao=consultarFornecedor">
			
		<h2>Consulta de Fornecedores:</h2>
		
		<label>CNPJ:</label> <input type="text" name="cnpj" required="required"/>
		
		<input type="submit" value="Consultar" id="enviar" class="botoes"/>
		
	</hgroup>

		<div id="logo">
			<img src="img/EA_Sports2.png"/>
		</div>
	</form>
	
	<section>
		<form>
			<fieldset id="fieldForn">
				<legend>Dados do Fornecedor</legend>
				<p>
					<label>Nome:</label>${fornecedor.nome}
				</p>
				<p>
					<label>Telefone:</label>${fornecedor.telefone}
				</p>
				<p>
					<label>CNPJ:</label>${fornecedor.cnpj}
				</p>
				<p>
					<label>Razão Social:</label>${fornecedor.razaoSocial}
				</p>
			</fieldset>
			<br>
			<fieldset id="fieldEnd">
				<legend>Endereço</legend>
				<p>
					<label>Logradouro:</label>${fornecedor.endereco.logradouro}
				</p>
				<p>
					<label>Número:</label>${fornecedor.endereco.numero}
				</p>

				<p>
					<label>CEP:</label>${fornecedor.endereco.cep}
				</p>
				<p>
					<label>Bairro:</label>${fornecedor.endereco.bairro}
				</p>
				<p>
					<label>Cidade:</label>${fornecedor.endereco.cidade}
				</p>
				<p>
					<label>Estado:</label>${fornecedor.endereco.estado}
				</p>
				<label>País:</label>${fornecedor.endereco.pais}
			</fieldset>
				
		</form>
	</section>
	
		
	<h4 style="color:red">${mensagem}</h4>
	
	
</body>
</html>