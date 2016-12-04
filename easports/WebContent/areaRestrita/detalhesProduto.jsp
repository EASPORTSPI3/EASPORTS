<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
	<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix ="fnc" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EA Sports</title>

	<link rel="stylesheet" type="text/css" href="css/imageZoom.css" />

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>

	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	
</head>
<body class="container">

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	

		<div class="row" >
	
		<h3 class="text-center">
		
		<a href="/easports/areaRestrita/consultaProduto.jsp" class="btn btn-sm" 
		   style="background-color: #fbfecf; font-size: 14; color: black; margin-left: -350px; 
		   margin-right: 110px; border-color: black">
								
			<span class="glyphicon glyphicon-arrow-left" aria-hidden="true" style="margin-right: 7px"></span> Retornar
								
		</a>
		
		
		<b style="padding-left: 10%">Detalhes do Produto</b>
		
		</h3>
		<hr/>
		
		<form name="alteraProduto" method="post" action="/easports/ControleProduto?acao=alteraProduto&idProduto=${produto.idProduto}">
			<div class="col-md-3" style="width: 1000; margin-left: 85px">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${produto.nome}</strong></h3>
						
					</div>
					
					<div class="panel-body" style="background-color: #f0fff0">
					
						<ul class="list-inline gallery">  
 							<img class="img-rounded zoom" src="/easports/img/${produto.imagem}" width="300" height="250" align="left">
						</ul>
						
						<div class="panel-body" style="margin-top: -10px">
							 
							<h4><strong style="color: black; margin-left: 15px">Código: <input type="text" disabled name="codigo" style="color: gray" value="${produto.codigo}"></input></strong></h4>
							<h4><strong style="color: black; margin-left: 15px">Fornecedor: <input type="text" disabled name="fornecedor" style="color: gray" value="${produto.fornecedor.nome}"></strong></h4>
							<h4><strong style="color: black; margin-left: 15px">Razão Social: <input type="text" disabled name="razaoSocial" style="color: gray" value="${produto.fornecedor.razaoSocial}"></strong></h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: <input type="text" disabled name="categoria" style="color: gray" value="${produto.categoria.nome}"></strong></h4>
							<h4><strong style="color: black; margin-left: 15px">Preço de Custo: <input type="text" name="precoCusto" required="required" style="color: gray" value="${produto.valorCusto}"></strong></h4>
							<h4><strong style="color: black; margin-left: 15px">Preço de Venda: <input type="text" name="precoVenda" required="required" style="color: gray" value="${produto.valorVenda}"></strong></h4>
							<h4><strong style="color: black; margin-left: 15px">Quantidade em Estoque: <input type="text" name="quantidadeEstoque" required="required" style="color: gray" value="${produto.quantidade}"></strong></h4>							
						
							<div style="padding-left: 50%; padding-top: 3%">
							
								<input type="button" class="btn btn-sm" value=Editar id="editar" style="background-color: #beeab5; 
							   width: 95; font-size: 14; font: bold; text-align: right; border-color: black" />
							<span class="glyphicon glyphicon-check" style="margin-left: -90"></span>
								
								<input type="submit" class="btn btn-sm" value="Salvar" id="enviar" style="background-color: #cacaff;
							   margin-left:18%; width: 85; font-size: 14; font: bold; text-align: right; border-color: black" />
							<span class="glyphicon glyphicon-erase" style="margin-left: -80"></span><br/><br/>
							<h4 style="color:green">${mensagem}</h4>
 							</div>
							
							</div>
						
						</div>
						
					</div>
					
				</div>
				</form>
				
			</div>
			
</body>
</html>