<%@page import="br.com.easports.util.FormataValor"%>
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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body>

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	
	
	
	<div class="col-md-12">
	
		<h3 class="text-center"><b>Consulta de Pedidos</b></h3>
		<hr/><br/>
		
		<div class="col-md-3" style="width: 100%">
			<div class="panel panel-success">
				<div class="panel-heading">
		
		<table class="table table houver">
			<thead>
				<tr>
					<th>ID Pedido:</th>
					<th>Cliente:</th>
					<th>Nome do produto:</th>
					<th>Código:</th>
					<th>Quantidade:</th>
					<th>Valor Unitário:</th>
					<th>Valor Total:</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="pedido">
					<tr>
						
						<td>${pedido.idPedido}</td>
						
						<td>${pedido.cliente.nome}</td>
						
						<td>${pedido.produto.nome}</td>
						
						<td>${pedido.produto.codigo}</td>
						
						<td>${pedido.quantidade}</td>
						
						<td>${pedido.produto.valorVendaFormatado}</td>
						
						<td>${pedido.valorTotalFormatado}</td>
						
						<td>
						
						<a href="ControleProduto?acao=visualizarPedido&idPedido=${pedido.idPedido}" 
								class="btn btn-sm" style="width: 80; font-size: 12; background-color: #b3b3ff; margin-right: 5%">
								<span class="glyphicon glyphicon-pencil" style="width: 16;font-size: 12;margin-left: -6;color: #FFFFFF"></span> Editar
						</a>
						
						<a href="ControleProduto?acao=excluirPedido&idPedido=${pedido.idPedido}&idCliente=${pedido.cliente.idCliente}"
								class="btn btn-sm" style="width: 80; font-size: 12; background-color: #ff9999; margin-right: 5%"
								onclick="return confirm('Deseja excluir este Pedido ?');">
								<span class="glyphicon glyphicon-trash" style="width: 16;font-size: 12;margin-left: -6;color: #FFFFFF"></span> Excluir
						</a>

						</td>
						
					</tr>
				</c:forEach>
				
			</tbody>

		</table>
		
				<label style="margin-left: 0%; font-size: 16px; color: red"><b>Valor total da compra : ${valorTotal}</b></label>
		
				</div>
			</div>
		</div>
		
	</div>
	
	<h4 style="margin-left: 30px">Quantidade de Registros : ${fnc:length(lista)}</h4>
	
</body>
</html>