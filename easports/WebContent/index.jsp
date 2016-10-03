<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EA Sports</title>
</head>

<body>

<h2>Cadastro de Clientes:</h2>

<h3>Dados Pessoais:</h3>

<hr><br/>

	<form name="formulario" method="post" 
		  action="ControlePessoa?acao=cadastrarpf">
	
		<label>Nome:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>Telefone:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>CPF:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>Data Nasc:</label>
		<input type="date" name="nome" />
		
		<br/><br/><hr><br/>
		
		<h3>Endereço:</h3>
		<hr><br/>
		 
		<label>Logradouro:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>Número:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>CEP:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>Bairro:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>Cidade:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>Estado:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<label>País:</label>
		<input type="text" name="nome" />
		
		<br/><br/>
		
		<input type="submit" value="Cadastrar" />
		
	</form>
</body>

</html>