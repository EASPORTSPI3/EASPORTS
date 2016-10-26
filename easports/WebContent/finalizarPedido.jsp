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
		<h2 style="padding-left: 8%">Listagem de Pedidos:</h2>
	</hgroup>
	
	<br/>
	
	<form name="formulario" method="post" style=" padding-left: 6%" 
			 action="ControlePessoa?acao=pesquisarPedidos">
			
		<div class="col-md-3" style="width: 410">
			
		<label>CPF do Cliente:</label> <input type="text" name="cpf" required="required"/>
		
		<input type="submit" value="Pesquisar" id="enviar" class="botoes"/>
		
		<h4 style="color:red">${mensagem}</h4>
			
		</div>
			
	</form><br/><br/><br/>

	<div style="padding-left: 8%" class="col-md-4" >
		
		<form style="background-color: #7f7f7f" name="formulario" method="post" 
			  action="/easports/ControleProduto?acao=">
			
			<div class="col-md-3" style="width: 700; margin-left: 50%">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${produto.nome}</strong></h3>
						
					</div>
					
					<div class="panel-body" style="background-color: #f0fff0">
						<img src="img/${produto.imagem}" width="210" height="160" align="left"/>
						
						<div class="panel-body" style="margin-top: -10px">
						
							<h4><strong style="color: black; margin-left: 15px">C�digo: </strong>${produto.codigo}</h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: </strong>${produto.categoria.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Pre�o: </strong>${produto.valorVendaFormatado}</h4>
							<h4><strong style="color: black; margin-left: 15px">Quantidade: </strong>${produto.quantidade}</h4>		
							<br/><hr>
							
							<label>Quantidade:</label> <input type="text" name="quantidade" placeholder="Digite aqui"required="required"/>
							<br/><br/>
							
							<label>ID Cliente:</label> <input type="text" name="idCliente" placeholder="Digite aqui"required="required" style="margin-left: 14px"/>
							<hr>
							
							<input type="submit" value="Confirmar" id="enviar" class="btn btn-sm" style="background-color: #ffb0b0; font-size: 14 ; 
								color: black; width: 100px"/> 
							<input type="reset" value="Limpar" id="limpar" class="btn btn-sm" style="background-color: #cacaff; font-size: 14; 
								color: black; margin-left: 20px; width: 100px">
							<br/><br/>
							
							<label style="color:red">${mensagem}</label>
							
						</div>
						
					</div>
					
				</div>
			</div>
			
		</form>			
	</div>
	
</body>
</html>