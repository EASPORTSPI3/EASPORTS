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
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
	
</head>
<body>

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<hgroup>
	<h1 style="padding-left: 0%; margin-left: 37%; color: gray; text-shadow: 2px 2px 5px #000000;">Consulta de Funcionários:</h1>
	</hgroup>	
	
	<br/>
	
		<div style="width: 50%; padding:0px;"class="col-md-4">
		
		
		<form id="pesquisa" name="pesquisa" method="post" style="margin-left: 50%" action="ControlePessoa?acao=consultarFuncionario">
				  
			<input type="submit" class="btn btn-sm" value="Consultar" style="background-color: #cacaff; 
				   width: 105; font-size: 14; font: bold;text-align: right;border-color: black"/>
				<span class="glyphicon glyphicon-search" style="margin-left: -100"></span>
					    
				<div class="col-md-3" style="width: 260">
					<input type="text" id="cnpj" name="cpf" class="form-control" required="required" placeholder="Informe o CPF..."/>
					
					<h4 style="color: red">${mensagem}</h4>
					
				</div>
				
				<br/>
	
		</form>
	
	<form style="background-color: #7f7f7f; padding-left: 4%; ">
			<div class="col-md-3"style="width: 100%; margin-left: 50%; padding: 0px;">
				<div class="panel" style="background-color: #b4b4b4; width: 100%; margin: 0px;">
					<div class="panel-heading" >
					
						<fieldset id="fieldCli" style="width: 100%;">				
							<hr>							
							<h4>Dados Gerais:</h4>
							<hr>	
							<label>ID:
								<input required="required" style="width: 60px" type="text" disabled name="idFuncionario" class="form-control" value="${funcionario.idFuncionario}"/> 
							</label>

			
							<label>Nome do Funcionário:
								<input required="required" style="width: 250px" type="text" disabled name="nome" class="form-control" value="${funcionario.nome}" />
							</label>
						
							<label>Telefone:
								<input required="required" style="width: 170px" type="text" disabled name="telefone" class="form-control" value="${funcionario.telefone}"/>
							</label>

				
							<label>CPF:
								<input required="required" style="width: 220px" type="text" disabled name="cpf" class="form-control" value="${funcionario.cpf}"/>
							</label>
							
							<label>Data Nasc.: <input required="required"
								style="width: 200px" type="text" disabled name="datanasc"
								class="form-control"
								value="<fmt:formatDate value="${funcionario.dataNasc}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/>" />
							</label> <br/>
							
							<hr>									
							<h4>Endereço:</h4>
							<hr>
			
							<label>Logradouro:
								<input required="required" style="width: 300px" type="text" disabled name="logradouro" class="form-control" value="${funcionario.endereco.logradouro}" />
							</label>
						
							<label>Número:
								<input required="required" style="width: 100px" type="text" disabled name="numero" class="form-control" value="${funcionario.endereco.numero}"/>
							</label>
				
							<label>CEP:
								<input required="required" style="width: 120px" type="text" disabled name="cep" class="form-control" value="${funcionario.endereco.cep}"/>
							</label>
							
							
							<label>Bairro:
								<input required="required" style="width: 220px" type="text" disabled name="bairro" class="form-control" value="${funcionario.endereco.bairro}"/>
							</label>

							
							<label>Cidade:
								<input required="required" style="width: 150px" type="text" disabled name="cidade" class="form-control" value="${funcionario.endereco.cidade}"/>
							</label>

							
							<label>Estado:
								<input required="required" style="width: 150px" type="text" disabled name="estado" class="form-control" value="${funcionario.endereco.estado}"/>
							</label>
													
							<label>País:
								<input required="required" style="width: 250px" type="text" disabled name="pais" class="form-control" value="${funcionario.endereco.pais}"/>
							</label>	
					</fieldset>	
				</div>
			</div>
		</div>			
	</form>			
	
	</div>
</body>
</html>