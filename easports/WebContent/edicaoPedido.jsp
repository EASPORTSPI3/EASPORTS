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
			<b>Detalhes do Pedido</b>
		</h3>
		<hr/>		
		<br/>
		
		<form style="background-color: #7f7f7f" name="formulario" method="post" action="/easports/ControleProduto?acao=editarPedido&idPedido=${pedido.idPedido}&idProduto=${pedido.produto.idProduto}">
			<div class="col-md-3" style="width: 1000; margin-left: 85px">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${pedido.produto.nome}</strong></h3>
						
					</div>
					<div class="panel-body" style="background-color: #f0fff0">
						<img src="img/${pedido.produto.imagem}" width="510" height="450" align="left"/>
						
						<div class="panel-body" style="margin-top: -10px">
						
							<h4><strong style="color: black; margin-left: 15px">Código do pedido: </strong>${pedido.idPedido}</h4>
							<h4><strong style="color: black; margin-left: 15px">Produto: </strong>${pedido.produto.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: </strong>${pedido.produto.categoria.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Preço: </strong>${pedido.produto.valorCustoFormatado}</h4>					
							<h4><strong style="color: black; margin-left: 15px">Disponível: </strong>${pedido.produto.quantidade}</h4>	
						
						
							<label><h4 style="margin-left: 15px"><strong>Quantidade:</strong></h4>
								<input style="width: 100px; margin-left: 15px" type="text" name="quantidade" class="form-control" 
									   value="${pedido.quantidade}" required="required" />
							</label>
							<hr>
							
<%-- 							<a href="/easports/ControleProduto?acao=editarPedido&idPedido=${pedido.idPedido}&idProduto=${pedido.produto.idProduto}"
								class="btn btn-sm" style="background-color: #ffb0b0; font-size: 14 ; 
								color: black; margin-top: 20px; margin-left: 15%">Salvar
							</a> --%>
							
							<input type="submit" value="Confirmar" id="enviar" class="btn btn-sm" style="background-color: #ffb0b0; 
								   margin-left: 13%; font-size: 14; color: black; width: 100px"/>
						
							<a href="/easports/ControleProduto?acao=consultarPedidos&cpf=${pedido.cliente.cpf}"
								class="btn btn-sm" style="background-color: #cacaff; font-size: 14; 
								color: black; margin-left: 1%">Cancelar
							</a>
							<hr>
						
							<h4 style="color: green; text-align: center;">${mensagem}</h4>
						
						</div>
						
					</div>
					
				</div>
			</div>
			</form>
	</div>

</body>
</html>