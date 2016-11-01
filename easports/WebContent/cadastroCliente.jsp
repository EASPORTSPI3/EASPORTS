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
<link rel="stylesheet" type="text/css"
	href="/easports/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="/easports/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>

<title>EA Sports</title>
</head>
<body style="max-height: 100%; max-width: 100%">
	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<hgroup>
	<h1 style="padding-left: 0%; margin-left: 35%; color: gray; text-shadow: 2px 2px 5px #000000;">Cadastro de clientes:</h1>
	</hgroup>


	<div style="width: 100%;" class="col-md-4">
		<form  name="formulario" method="post"
			action="ControlePessoa?acao=cadastrarpf">

			<div class="col-md-3"style="width: 70%; float: right; margin-right: 5px; padding: 0px;">
				<div class="panel" style="background-color: #b4b4b4; width: 100%;">
					<div class="panel-heading">
					
						<fieldset id="fieldCli" style="width: 100%;">			
							<h4>Endereço:</h4>
							<hr>
			
							<label>Logradouro:
								<input required="required" style="width: 350px" type="text" name="logradouro" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>Número:
								<input required="required" style="width: 100px" type="text" name="numero" class="form-control" placeholder="Digite aqui"/>
							</label>
				
							<label>CEP:
								<input required="required" style="width: 200px" type="text" name="cep" class="form-control" placeholder="Digite aqui"/>
							</label>
							
							
							<label>Bairro:
								<input required="required" style="width: 250px" type="text" name="bairro" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
							
							<label>Cidade:
								<input required="required" style="width: 250px" type="text" name="cidade" class="form-control" placeholder="Digite aqui"/>
							</label>

							
							<label>Estado:
								<input required="required" style="width: 200px" type="text" name="estado" class="form-control" placeholder="Digite aqui"/>
							</label>
													
							<label>País:
								<input required="required" style="width: 250px" type="text" name="pais" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/><hr>
					
						<input type="submit" value="Cadastrar" id="enviar" class="btn btn-success" style="width: 100px;"/> 
						<input type="reset" value="Limpar" id="limpar" class="btn btn-warning" style="width: 100px;">				
						</fieldset>	
					</div>
				</div>
			</div>


			<div class="col-md-3" style="width: 29%; margin-left: 5px;padding: 0px;">
				<div class="panel" style="background-color: #b4b4b4;width: 100%">
					<div class="panel-heading">		
						<fieldset id="fieldCli" style="width: 100%;">
									
							<h4>Dados Gerais:</h4>
							<hr>	
			
							<label>Nome do Cliente:
								<input required="required" style="width: 350px" type="text" name="nome" class="form-control" placeholder="Digite aqui" />
							</label>
							<br/>
						
							<label>Telefone:
								<input required="required" style="width: 200px" type="text" name="telefone" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
				
							<label>CPF:
								<input required="required" style="width: 250px" type="text" name="cpf" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
							
							<label>Data Nasc.:
								<input required="required" style="width: 200px" type="date" name="datanasc" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>					
						</fieldset>		
					</div>
				</div>
			</div>
		</form>
	</div>
	<div><h4 style="color: green; text-align: center;">${mensagem}</h4>
</body>
</html>


<!-- 		<form name="formulario" method="post" -->
<!-- 			action="ControlePessoa?acao=cadastrarpf"> -->
<!-- 			<fieldset id="fieldCli"> -->
<!-- 				<legend>Dados pessoais</legend> -->
<!-- 				<p> -->
<!-- 					<label>Nome:</label> <input type="text" name="nome" required="required"/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>Telefone:</label> <input type="text" name="telefone" required="required" /> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>CPF:</label> <input type="text" name="cpf" required="required"/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>Data Nasc:</label> <input type="date" name="datanasc" required="required"/> -->
<!-- 				</p> -->
<!-- 			</fieldset> -->
<!-- 			<br> -->
<!-- 			<fieldset id="fieldEnd"> -->
<!-- 				<legend>Endereço</legend> -->
<!-- 				<p> -->
<!-- 					<label>Logradouro:</label> <input type="text" name="logradouro" required="required" /> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>Número:</label> <input type="text" name="numero" required="required"/> -->
<!-- 				</p> -->

<!-- 				<p> -->
<!-- 					<label>CEP:</label> <input type="text" name="cep" required="required"/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>Bairro:</label> <input type="text" name="bairro" required="required"/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>Cidade:</label> <input type="text" name="cidade" required="required"/> -->
<!-- 				</p> -->
<!-- 				<p> -->
<!-- 					<label>Estado:</label> <input type="text" name="estado" required="required"/> -->
<!-- 				</p> -->
<!-- 				<label>País:</label> <input type="text" name="pais" required="required"/> -->
<!-- 			</fieldset> -->
<!-- 			<input type="submit" value="Cadastrar" id="enviar" class="botoes"/> <input -->
<!-- 				type="reset" value="Limpar" id="limpar" class="botoes"> -->

<!-- 		</form> -->

<%-- 	<h4 style="color:red">${mensagem}</h4> --%>

