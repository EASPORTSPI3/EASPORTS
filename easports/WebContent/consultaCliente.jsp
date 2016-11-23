<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/easports/js/js.js"></script>


<title>EA Sports</title>

</head>
<body>

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<hgroup>
		<h1
			style="padding-left: 0%; margin-left: 37%; color: gray; text-shadow: 2px 2px 5px #000000;">Consulta de Clientes:</h1>
	</hgroup>
	<br/>
	
	<div style="width: 50%; padding: 0px;" class="col-md-4">
	
		
		<form id="pesquisa" name="pesquisa" method="post" style="margin-left: 50%" action="ControlePessoa?acao=consultarpf">
				  
			<input type="submit" class="btn btn-sm" value="Consultar" style="background-color: #cacaff; 
				   width: 105; font-size: 14; font: bold;text-align: right;border-color: black"/>
				<span class="glyphicon glyphicon-search" style="margin-left: -100"></span>
					    
				<div class="col-md-3" style="width: 250">
					<input type="text" id="cpf" name="cpf" class="form-control" required="required" placeholder="Informe o CPF..."/>
					
					<h4 style="color: red">${mensagem}</h4>
					
				</div>
				
				<br/>
	
		</form>
	
		<form style="background-color: #7f7f7f; padding-left: 4%;" action="ControlePessoa?acao=editarPessoa">
			<div class="col-md-3"
				style="width: 100%; margin-left: 50%; padding: 0px;">
				<div class="panel"
					style="background-color: #b4b4b4; width: 100%; margin: 0px;">
					<div class="panel-heading">

						<fieldset id="fieldCli" style="width: 100%;">
							<hr>
							<h4>Dados Gerais:</h4>
							<hr>
							<label>ID do Cliente: &nbsp <input required="required"
								style="width: 100px" type="text" disabled name="idFornecedor"
								class="form-control" value="${cliente.idCliente}" />
							</label> <label>Nome do Cliente: <input required="required"
								style="width: 250px" type="text" disabled name="nome"
								class="form-control" id="name" value="${cliente.nome}" />
							</label> <label>Telefone: <input required="required"
								style="width: 200px" type="text" disabled name="telefone"
								class="form-control" value="${cliente.telefone}" />
							</label> <label>CPF: <input required="required"
								style="width: 250px" type="text" disabled name="cpf"
								class="form-control" value="${cliente.cpf}" />
							</label> <label>Data Nasc.: <input required="required"
								style="width: 200px" type="text" disabled name="datanasc"
								class="form-control"
								value="<fmt:formatDate value="${cliente.dataNasc}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/>" />
							</label> <br />

							<hr>
							<h4>Endere�o:</h4>
							<hr>

							<label>Logradouro: <input required="required"
								style="width: 300px" type="text" disabled  name="logradouro" 
								class="form-control" value="${cliente.endereco.logradouro}" />
							</label> <label>N�mero: <input required="required"
								style="width: 100px" type="text" disabled name="numero"
								class="form-control" value="${cliente.endereco.numero}" />
							</label> <label>CEP: <input required="required"
								style="width: 120px" type="text" disabled name="cep"
								class="form-control" value="${cliente.endereco.cep}" />
							</label> <label>Bairro: <input required="required"
								style="width: 220px" type="text" disabled name="bairro"
								class="form-control" value="${cliente.endereco.bairro}" />
							</label> <label>Cidade: <input required="required"
								style="width: 250px" type="text" disabled name="cidade"
								class="form-control" value="${cliente.endereco.cidade}" />
							</label> <label>Estado: <input required="required"
								style="width: 80px" type="text" disabled name="estado"
								class="form-control" value="${cliente.endereco.estado}" />
							</label> <label>Pa�s: <input required="required"
								style="width: 250px" type="text" disabled name="pais"
								class="form-control" value="${cliente.endereco.pais}" />
							</label>
						</fieldset>
						<br/>
						<input type="button" value="Editar" id="editar" class="btn btn-success"/> 
						<input type="button" value="Salvar" id="enviar" class="btn btn-success"/> 
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>