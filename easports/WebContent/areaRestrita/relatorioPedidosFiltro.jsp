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
			text-shadow: 2px 2px 5px #000000;">Relatório de Pedidos:</h1>
	</hgroup>
	<br/>
	
	<div class="col-md-12">
	
		<div class="col-md-3" style="width: 100%">
			<div class="panel panel-success">
				<div class="panel-heading">
		
		<form name="formulario" method="post" action="/easports/ControleProduto?acao=filtrarPedidos">
		
			<label style="color: black">ID Cliente:
				<input style="width: 80px" type="text" name="idCliente" 
					   class="form-control" placeholder="Informe"/>
			</label>
			
			<label style="color: black">ID Vendedor:
				<input style="width: 80px" type="text" name="idVendedor" 
					   class="form-control" placeholder="Informe"/>
			</label>
		
			<label style="color: black">Status:
				<select name="status" class="form-control">
					<option value="0">- Selecione -</option>
					<option value="1">Finalizados</option>
					<option value="2">Não Finalizados</option>
							
				</select>
			</label>
			
			<input type="submit" class="btn btn-sm" value="Filtrar resultados" style="background-color: #ffc8a4; 
				   width: 150; font-size: 14; font: bold;text-align: right;border-color: black;color: black;margin-left: 10px"/>
				<span class="glyphicon glyphicon-search" style="margin-left: -145;color: black"></span>
		
		</form>
		
		<hr style="border-width: 3px">
		
		<label style="color: red; text-align: right;font-size: 16px">${mensagem}</label>
		
		<table class="table table houver">
			<thead>
				<tr>
					<th>ID Pedido:</th>
					<th>ID Vendedor:</th>
					<th>Vendedor:</th>
					<th>ID Cliente:</th>
					<th>CPF:</th>
					<th>Produto:</th>
					<th>Quantidade:</th>
					<th>Valor Unitário:</th>
					<th>Valor Total:</th>
					<th>Status:</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="pedido">
					<tr>
						
						<td>${pedido.idPedido}</td>
						
						<td>${pedido.venda.funcionario.idFuncionario}</td>
						
						<td>${pedido.venda.funcionario.nome}</td>
						
						<td>${pedido.cliente.idCliente}</td>
						
						<td>${pedido.cliente.cpf}</td>
						
						<td>${pedido.produto.nome}</td>
						
						<td>${pedido.quantidade}</td>
						
						<td>${pedido.produto.valorCustoFormatado}</td>
						
						<td>${pedido.valorTotalFormatado}</td>
						
						<td>${pedido.status}</td>
						
						<td>
						
<%-- 						<a href="ControlePessoa?acao=consultarpf&cpf=${pedido.cliente.cpf}" --%>
<!-- 								class="btn btn-sm" style="background-color: #cacaff; font-size: 14 ;  -->
<!-- 								color: black; border-color: black"> -->
								
<!-- 								<span class="glyphicon glyphicon-search" aria-hidden="true" style="margin-right: 5px"></span> Visualizar -->
								
<!-- 						</a>						 -->
<%-- 						<a href="ControlePessoa?acao=excluirpf&idCliente=${pedido.cliente.idCliente}" --%>
<!-- 								class="btn btn-sm" style="background-color: #ffb0b0; font-size: 14;  -->
<!-- 								color: black; border-color: black; margin-left: 10px"> -->
								
<!-- 								<span class="glyphicon glyphicon-trash" aria-hidden="true" style="margin-right: 5px"></span> Excluir -->
<!-- 						</a> -->
						</td>	
					</tr>
				</c:forEach>				
			</tbody>
		</table>
				<hr style="border-width: 3px">
				<label style="margin-left: 0%; font-size: 15px; color: black"><b>Quantidade de Registros : ${fnc:length(lista)}</b></label>
				<br/>

				</div>	
				
			</div>			
		</div>		
	</div>
</body>
</html>