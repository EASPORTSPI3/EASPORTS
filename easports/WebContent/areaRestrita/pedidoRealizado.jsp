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
<body style="min-width: 1024px;">
	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<div style="padding-left: 8%" class="col-md-4" >
		
		<form style="background-color: #7f7f7f" name="pedidoRealizado">
			
			<div class="col-md-3" style="width: 700; margin-left: 50%">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${produto.nome}</strong></h3>
						
					</div>
					
					<div class="panel-body" style="background-color: #f0fff0">
						<img src="/easports/img/${produto.imagem}" width="260" height="210" align="left"/>
						
						<div class="panel-body">
						
							<h4><strong style="color: black; margin-left: 15px">C�digo: </strong>${produto.codigo}</h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: </strong>${produto.categoria.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Pre�o: </strong>${produto.valorVendaFormatado}</h4>
							<h4><strong style="color: black; margin-left: 15px">Quantidade pedida: </strong>${pedido.quantidade}</h4>		
							<br/><hr>
							
							<label style="color:red; font-size: 16px">${mensagem}</label>
							<br/><hr>
							
							<a href="/easports/areaRestrita/consultaProduto.jsp"
								class="btn btn-sm" style="background-color: #cacaff; font-size: 14; 
								color: black; border-color: black; margin-left: 10px">
								
								<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> Retornar
							</a>
						</div>
					</div>
				</div>
			</div>			
		</form>			
	</div>

</body>
</html>