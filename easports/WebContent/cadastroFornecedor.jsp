<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<h2>Cadastro de Fornecedor:</h2>
	</hgroup>

		<div id="logo">
			<img src="img/EA_Sports2.png"/>
		</div>
	<section>
		<form name="formulario" method="post"
			action="ControlePessoa?acao=cadastrarpf">
			<fieldset id="fieldCli">
				<legend>Dados do Fornecedor</legend>
				<p>
					<label>Razão social:</label> <input type="text" name="razaosocial" required="required"/>
				</p>
				<p>
					<label>Nome fantasia:</label> <input type="text" name="nome" required="required"/>
				</p>
				<p>
					<label>Telefone:</label> <input type="text" name="telefone" required="required" />
				</p>
				<p>
					<label>CNPJ:</label> <input type="text" name="cnpj" required="required"/>
				</p>

			</fieldset>
			<br>
			<fieldset id="fieldEnd">
				<legend>Endereço</legend>
				<p>
					<label>Logradouro:</label> <input type="text" name="logradouro" required="required" />
				</p>
				<p>
					<label>Número:</label> <input type="text" name="numero" required="required"/>
				</p>

				<p>
					<label>CEP:</label> <input type="text" name="cep" required="required"/>
				</p>
				<p>
					<label>Bairro:</label> <input type="text" name="bairro" required="required"/>
				</p>
				<p>
					<label>Cidade:</label> <input type="text" name="cidade" required="required"/>
				</p>
				<p>
					<label>Estado:</label> <input type="text" name="estado" required="required"/>
				</p>
				<label>País:</label> <input type="text" name="pais" required="required"/>
			</fieldset>
			<input type="submit" value="Cadastrar" id="enviar" class="botoes"/> <input
				type="reset" value="Limpar" id="limpar" class="botoes">
				
		</form>
	</section>
	
		
	<h4 style="color:red">${mensagem}</h4>
	
	
</body>
</html>