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
		<h2 style="padding-left: 8%">Consulta de Fornecedores:</h2>
	</hgroup>
	
	<br/>
	
	<form name="formulario" method="post" style=" padding-left: 6%" 
			 action="ControlePessoa?acao=consultarFornecedor">
			
		<div class="col-md-3" style="width: 410">
			
		<label>CNPJ:</label> <input type="text" name="cnpj" required="required"/>
		
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
			
						<label>ID do Fornecedor:
						</label>${fornecedor.idFornecedor}
						<br/>
			
						<label>Nome do Fornecedor:
						</label>${fornecedor.nome}
						<br/>
						
						<label>Razão Social:
						</label>${fornecedor.razaoSocial}
						<br/>
						
						<label>Telefone:
						</label>${fornecedor.telefone}
						<br/>
				
						<label>CNPJ:
						</label>${fornecedor.cnpj}
						<br/>
							
					</fieldset>
			
				</div>
			</div>
		</div>
			
		<div class="col-md-3" style="width: 410">
			<div class="panel" style="background-color: #b4b4b4">
				<div class="panel-heading">
			
					<fieldset id="fieldCli">
			
						<h4>Endereço:</h4>
						<hr style="width: 340px; margin-left: 4px">
			
						<label>Logradouro:
						</label>${fornecedor.endereco.logradouro}
						<br/>
						
						<label>Número:
						</label>${fornecedor.endereco.numero}
						<br/>
				
						<label>CEP:
						</label>${fornecedor.endereco.cep}
						<br/>
							
						<label>Bairro:
						</label>${fornecedor.endereco.bairro}
						<br/>
							
						<label>Cidade:
						</label>${fornecedor.endereco.cidade}
						<br/>
							
						<label>Estado:
						</label>${fornecedor.endereco.estado}
						<br/>
							
						<label>País:
						</label>${fornecedor.endereco.pais}
						<br/>
					
					</fieldset>
			
				</div>
			</div>
				
		</div>
			
	</form>			

</body>
</html>