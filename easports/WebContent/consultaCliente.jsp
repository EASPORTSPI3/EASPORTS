<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc" %>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
	<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
	
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
	
</head>
<body>

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<div id="logo" style="padding-top: 5%">
		<img src="img/EA_Sports2.png"/>
	</div>

	<hgroup>
		<h2 style="padding-left: 8%">Consulta de Clientes:</h2>
	</hgroup>
	
	<br/>
	
	<form name="formulario" method="post" style=" padding-left: 6%" 
			 action="ControlePessoa?acao=consultarpf">
			
		<div class="col-md-3" style="width: 410">
			
		<label>CPF:</label> <input type="text" name="cpf" required="required"/>
		
		<input type="submit" value="Pesquisar" id="enviar" class="btn btn-primary"/>
		
		<h4 style="color:red">${mensagem}</h4>
			
		</div>
			
	</form><br/><br/><br/>
		
	<form style="background-color: #7f7f7f; padding-left: 4%">
		<div class="col-md-3" style="width: 410">
			<div class="panel" style="background-color: #b4b4b4">
				<div class="panel-heading">
			
					<fieldset id="fieldCli">
			
						<h4>Dados Gerais:</h4>
						<hr style="width: 340px; margin-left: 4px">
			
						<label>ID do Cliente: &nbsp 
						</label>${cliente.idCliente}
						<br/>
			
						<label>Nome do Cliente: &nbsp
						</label>${cliente.nome}
						<br/>
						
						<label>Telefone: &nbsp
						</label>${cliente.telefone}
						<br/>
				
						<label>CPF: &nbsp
						</label>${cliente.cpf}
						<br/>
							
						<label>Data Nasc.: &nbsp
						</label>${cliente.dataNasc}
						<br/>
					
					</fieldset>
			
				</div>
			</div>
		</div>
			
		<div class="col-md-3" style="width: 410">
			<div class="panel" style="background-color: #b4b4b4">
				<div class="panel-heading">
			
					<fieldset id="fieldCli">
			
						<h4>Endere�o:</h4>
						<hr style="width: 340px; margin-left: 4px">
			
						<label>Logradouro: &nbsp
						</label>${cliente.endereco.logradouro}
						<br/>
						
						<label>N�mero: &nbsp
						</label>${cliente.endereco.numero}
						<br/>
				
						<label>CEP: &nbsp
						</label>${cliente.endereco.cep}
						<br/>
							
						<label>Bairro: &nbsp
						</label>${cliente.endereco.bairro}
						<br/>
							
						<label>Cidade: &nbsp
						</label>${cliente.endereco.cidade}
						<br/>
							
						<label>Estado: &nbsp
						</label>${cliente.endereco.estado}
						<br/>
							
						<label>Pa�s:&nbsp 
						</label>${cliente.endereco.pais}
						<br/>
					
					</fieldset>
			
				</div>
			</div>
				
		</div>
			
	</form>			
		
</body>
</html>