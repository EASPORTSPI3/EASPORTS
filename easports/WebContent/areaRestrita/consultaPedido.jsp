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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css" />
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body>

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<hgroup>
		<h1 style="padding-left: 0%; margin-left: 37%; color: gray; 
			text-shadow: 2px 2px 5px #000000;">Consulta de Pedidos:</h1>
	</hgroup>
	<br/>
	
	<div class="col-md-12">
		
		<form id="pesquisa" name="pesquisa" method="post" 
			  action="../ControleProduto?acao=consultarPedidos" style="margin-left: 20px">
				  
			<input type="submit" class="btn btn-sm" value="Consultar" style="background-color: #cacaff; 
				   width: 105; font-size: 14; font: bold;text-align: right;border-color: black"/>
				<span class="glyphicon glyphicon-search" style="margin-left: -100"></span>
					    
				<div class="col-md-3" style="width: 250; margin-left: -15px ">
					<input type="text" id="cpf" name="cpf" class="form-control" placeholder="Informe o CPF..."/>
				</div>
	
		</form>
		
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
								class="btn btn-sm" style="background-color: #ffb0b0; font-size: 14 ; 
								color: black; border-color: black">
								
								<span class="glyphicon glyphicon-pencil" aria-hidden="true" style="margin-right: 5px"></span> Editar
								
						</a>						
						<a href="ControleProduto?acao=excluirPedido&idPedido=${pedido.idPedido}&idCliente=${pedido.cliente.idCliente}"
								class="btn btn-sm" style="background-color: #cacaff; font-size: 14; 
								color: black; border-color: black; margin-left: 10px">
								
								<span class="glyphicon glyphicon-trash" aria-hidden="true" style="margin-right: 5px"></span> Excluir
						</a>
						</td>	
					</tr>
				</c:forEach>				
			</tbody>
		</table>
				<hr style="border-width: 3px">
				<label style="margin-left: 0%; font-size: 15px; color: black"><b>Quantidade de Registros : ${fnc:length(lista)}</b></label>
				<br/>
				<label style="margin-left: 0%; font-size: 18px; color: red"><b>Valor total da compra : ${valorTotal}</b></label>
				<br/><br/>

				<a href="ControleProduto?acao=finalizarPedidos&cpf=${cpf}"
						class="btn btn-sm" style="background-color: #fbfecf; font-size: 14 ; 
						color: black; border-color: black" aria-label="Left Align">								
						<span class="glyphicon glyphicon-ok" style="margin-right: 5px" aria-hidden="true"></span> Finalizar Pedidos
								
				</a>
							
				</div>	
				
				<label style="color: green; text-align: right;">${mensagem}</label>
							
			</div>			
		</div>		
	</div>
</body>
</html>