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
				<li id="consultar"><a a href="consultaCliente.jsp">Consultar</a></li>
				<li id="relatorio"><a>Relatorio</a></li>
			</ul>
		</nav>
	</header>
	<hgroup>
	
	<form name="formulario" method="post"
			action="ControlePessoa?acao=consultarpf">
			
		<h2>Consulta de Clientes:</h2>
		
		<label>CPF:</label> <input type="text" name="cpf" />
		
		<input type="submit" value="Consultar" id="enviar" class="botoes"/>
		
	</hgroup>

		<div id="logo">
			<img src="img/EA_Sports2.png"/>
		</div>
	</form>
	<section>
		<form>
			<fieldset id="fieldCli">
				<legend>Dados pessoais</legend>
				<p>
					<label>Nome:</label>${cliente.nome}
				</p>
				<p>
					<label>Telefone:</label>${cliente.telefone}
				</p>
				<p>
					<label>CPF:</label>${cliente.cpf}
				</p>
				<p>
					<label>Data Nasc:${cliente.data_nascimento}
				</p>
			</fieldset>
			<br>
			<fieldset id="fieldEnd">
				<legend>Endereço</legend>
				<p>
					<label>Logradouro:</label>${cliente.endereco.logradouro}
				</p>
				<p>
					<label>Número:</label>${cliente.endereco.numero}
				</p>

				<p>
					<label>CEP:</label>${cliente.endereco.cep}
				</p>
				<p>
					<label>Bairro:</label>${cliente.endereco.bairro}
				</p>
				<p>
					<label>Cidade:</label>${cliente.endereco.cidade}
				</p>
				<p>
					<label>Estado:</label>${cliente.endereco.estado}
				</p>
				<label>País:</label>${cliente.endereco.pais}
			</fieldset>
				
		</form>
	</section>
	
		
	<h4 style="color:red">${mensagem}</h4>
	
			
	<footer id="rodape">
		Copyright &copy; 2016 - by While(true)
		<p>
			<a href="http://facebook.com.br" target="_blank">Facebook </a>| <a
				href="http://twiter.com.br" target="_blank">Twitter </a>
		</p>
	</footer>
	
</body>
</html>