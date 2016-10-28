<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix ="fnc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EA Sports</title>

	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>

	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>

</head>
<body class="container">

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	

		<div class="row" >
	
		<h3 class="text-center">
		
		<a href="/easports/consultaProduto.jsp" class="btn btn-sm" 
		   style="background-color: #cacaff; font-size: 14; color: black; margin-left: -350px; 
		   margin-right: 110px">Retornar para a página anterior
		</a>
		
		<b>Detalhes do Produto</b>
		
		</h3>
		<hr/>
		
		<br/>
		
			<div class="col-md-3" style="width: 1000; margin-left: 85px">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${produto.nome}</strong></h3>
						
					</div>
					
					<div class="panel-body" style="background-color: #f0fff0">
						<img src="img/${produto.imagem}" width="510" height="450" align="left"/>
						
						<div class="panel-body" style="margin-top: -10px">
						
							<h4><strong style="color: black; margin-left: 15px">Código: </strong>${produto.codigo}</h4>
							<h4><strong style="color: black; margin-left: 15px">Fornecedor: </strong>${produto.fornecedor.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Razão Social: </strong>${produto.fornecedor.razaoSocial}</h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: </strong>${produto.categoria.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Preço de Custo: </strong>${produto.valorCustoFormatado}</h4>
							<h4><strong style="color: black; margin-left: 15px">Preço de Venda: </strong>${produto.valorVendaFormatado}</h4>
							<h4><strong style="color: black; margin-left: 15px">Quantidade em Estoque: </strong>${produto.quantidade}</h4>							
						
						</div>
						
					</div>
					
				</div>
			</div>
			
	</div>

</body>
</html>