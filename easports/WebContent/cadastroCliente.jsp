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
	
	<hgroup>
		<h2 style="padding-left: 4%; margin-left: 35%;">Cadastro de Clientes:</h2>
	</hgroup>


	<div style="padding-left: 5%;  width: 100%; margin-top: 20px;" class="col-md-4" >		
		<form style="background-color: #7f7f7f" name="formulario" method="post" 
			  action="ControlePessoa?acao=cadastrarpf">
			  			  
			 <div class="col-md-3" style="width: 70%; float: right; margin-right: 30px;"  >
				<div class="panel" style="background-color: #b4b4b4;">
					<div class="panel-heading">			
						<fieldset id="fieldCli" style="width: 100%; height: 300px;">			
							<h4>Endereço:</h4>
							<hr>
			
							<label>Logradouro:
								<input style="width: 350px" type="text" name="logradouro" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>Número:
								<input style="width: 100px" type="text" name="numero" class="form-control" placeholder="Digite aqui"/>
							</label>
				
							<label>CEP:
								<input style="width: 200px" type="text" name="cep" class="form-control" placeholder="Digite aqui"/>
							</label>
							
							
							<label>Bairro:
								<input style="width: 250px" type="text" name="bairro" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
							
							<label>Cidade:
								<input style="width: 250px" type="text" name="cidade" class="form-control" placeholder="Digite aqui"/>
							</label>

							
							<label>Estado:
								<input style="width: 200px" type="text" name="estado" class="form-control" placeholder="Digite aqui"/>
							</label>
													
							<label>País:
								<input style="width: 250px" type="text" name="pais" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/><hr>
					
						<input type="submit" value="Cadastrar" id="enviar" class="btn btn-success" style="width: 100px;"/> 
						<input type="reset" value="Limpar" id="limpar" class="btn btn-warning" style="width: 100px;">
					
						<h4 style="color:red">${mensagem}</h4>
					
						</fieldset>			
					</div>
				</div>		
			</div>	
			  	  
			<div class="col-md-3" style="width: 30%; margin-left: -50px;">
				<div class="panel" style="background-color: #b4b4b4">
					<div class="panel-heading">		
						<fieldset id="fieldCli" style="height: 300px;">
									
							<h4>Dados Gerais:</h4>
							<hr style="width: 80%; margin-left: 0px">	
			
							<label>Nome do Cliente:
								<input style="width: 350px" type="text" name="nome" class="form-control" placeholder="Digite aqui" />
							</label>
							<br/>
						
							<label>Telefone:
								<input style="width: 200px" type="text" name="telefone" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
				
							<label>CPF:
								<input style="width: 250px" type="text" name="cpf" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
							
							<label>Data Nasc.:
								<input style="width: 200px" type="date" name="datanasc" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>					
						</fieldset>		
					</div>
				</div>
			</div>	
		</form>			
	</div>
				<jsp:include page="footer.jsp"></jsp:include>
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

