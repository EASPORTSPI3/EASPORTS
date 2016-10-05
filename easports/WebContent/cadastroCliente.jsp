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
	<header>
		EA SPORTS
		<nav id="menu">
			<ul>
				<li id="home"><a a href="index.jsp">Home</a></li>
				<li id="consultar"><a>Consultar</a></li>
				<li id="relatorio"><a>Relatorio</a></li>
			</ul>
		</nav>
	</header>
	<hgroup>
		<h2>Cadastro de Clientes:</h2>
	</hgroup>

		<div id="logo">
			<img src="img/EA_Sports2.png"/>
		</div>
	<section>
		<form name="formulario" method="post"
			action="ControlePessoa?acao=cadastrarpf">
			<fieldset id="fieldCli">
				<legend>Dados pessoais</legend>
				<p>
					<label>Nome:</label> <input type="text" name="nome" />
				</p>
				<p>
					<label>Telefone:</label> <input type="text" name="telefone" />
				</p>
				<p>
					<label>CPF:</label> <input type="text" name="cpf" />
				</p>
				<p>
					<label>Data Nasc:</label> <input type="date" name="datanasc" />
				</p>
			</fieldset>
			<br>
			<fieldset id="fieldEnd">
				<legend>Endereço</legend>
				<p>
					<label>Logradouro:</label> <input type="text" name="logradouro" />
				</p>
				<p>
					<label>Número:</label> <input type="text" name="numero" />
				</p>

				<p>
					<label>CEP:</label> <input type="text" name="cep" />
				</p>
				<p>
					<label>Bairro:</label> <input type="text" name="bairro" />
				</p>
				<p>
					<label>Cidade:</label> <input type="text" name="cidade" />
				</p>
				<p>
					<label>Estado:</label> <input type="text" name="estado" />
				</p>
				<label>País:</label> <input type="text" name="pais" />
			</fieldset>
			<input type="submit" value="Cadastrar" id="enviar" class="botoes"/> <input
				type="reset" value="Limpar" id="limpar" class="botoes">
		</form>
	</section>
	<footer id="rodape">
		Copyright &copy; 2016 - by While(true)
		<p>
			<a href="http://facebook.com.br" target="_blank">Facebook </a>| <a
				href="http://twiter.com.br" target="_blank">Twitter </a>
		</p>
	</footer>
</body>
</html>