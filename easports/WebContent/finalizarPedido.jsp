<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanPedido" id="mb"></jsp:useBean>

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

<c:forEach items="${mb.listagemPedidos}" var="pedido">

	<div style="padding-left: 8%" class="col-md-4" >
		
		<form style="background-color: #7f7f7f" name="finalizar">
			
			<div class="col-md-3" style="width: 700; margin-left: 50%">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${pedido.produto.nome}</strong></h3>
						
					</div>
					
					<div class="panel-body" style="background-color: #f0fff0">
						<img src="img/${pedido.produto.imagem}" width="210" height="160" align="left"/>
						
						<div class="panel-body" style="margin-top: -10px">
						
							<h4><strong style="color: black; margin-left: 15px">Código: </strong>${pedido.produto.codigo}</h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: </strong>${pedido.produto.categoria.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Preço: </strong>${pedido.produto.valorVendaFormatado}</h4>
							<h4><strong style="color: black; margin-left: 15px">Quantidade pedida: </strong>${pedido.quantidade}</h4>		
							<br/><hr>
							
							<label style="color:red; font-size: 16px">${mensagem}</label>
							<br/><hr>
							
						</div>
						
					</div>
					
				</div>
			</div>
			
		</form>			
	</div>
	
</c:forEach>
	
</body>
</html>