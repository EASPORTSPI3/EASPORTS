<%@page import="br.com.easports.util.FormataValor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanCategoria" id="mbCategoria"></jsp:useBean>
<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanFornecedor" id="mbFornecedor"></jsp:useBean>

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
			text-shadow: 2px 2px 5px #000000;">Relatório de Estoque:</h1>
	</hgroup>
	<br/>
	
	<div class="col-md-12">
		
		<div class="col-md-3" style="width: 100%">
			<div class="panel panel-success">
				<div class="panel-heading">
		
		<form name="formulario" method="post" action="/easports/ControleProduto?acao=filtrarEstoque">
		
			<label style="color: black">Categoria:
				<select required="required" name="categoria" class="form-control">
					<option value="">- Selecione -</option>
							
					<c:forEach items="${mbCategoria.listagemCategorias}" var="c">
						<option value="${c.idCategoria}"> ${c.nome} </option>
					</c:forEach>
							
				</select>
			</label>
			
			<label style="color: black">Fornecedor:
				<select required="required" name="fornecedor" class="form-control">
					<option value="">- Selecione -</option>
							
					<c:forEach items="${mbFornecedor.listagemFornecedores}" var="f">
						<option value="${f.idFornecedor}"> ${f.nome} </option>
					</c:forEach>
							
				</select>
			</label>
			
			<input type="submit" class="btn btn-sm" value="Filtrar resultados" style="background-color: #ffc8a4; 
				   width: 150; font-size: 14; font: bold;text-align: right;border-color: black;color: black;margin-left: 10px"/>
				<span class="glyphicon glyphicon-search" style="margin-left: -145;color: black"></span>
		
		</form>
		
		<label style="color: red; text-align: right;font-size: 16px">${mensagem}</label>
		
		<hr style="border-width: 3px">
		
		<table class="table table houver">
			<thead>
				<tr>
					<th>ID Produto:</th>
					<th>Código:</th>
					<th>Nome:</th>
					<th>Fornecedor:</th>
					<th>Categoria:</th>
					<th>Valor Custo:</th>
					<th>Valor Venda:</th>
					<th>Quantidade:</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="produto">
					<tr>
						
						<td>${produto.idProduto}</td>
						
						<td>${produto.codigo}</td>
						
						<td>${produto.nome}</td>
						
						<td>${produto.fornecedor.nome}</td>
						
						<td>${produto.categoria.nome}</td>
						
						<td>${produto.valorCustoFormatado}</td>
						
						<td>${produto.valorVendaFormatado}</td>
						
						<td>${produto.quantidade}</td>
						
						<td>
						
						<a href="/easports/ControleProduto?acao=detalhesProdutoEstoque&id=${produto.idProduto}"
								class="btn btn-sm" style="background-color: #cacaff; font-size: 14 ; 
								color: black; border-color: black">
								
								<span class="glyphicon glyphicon-search" aria-hidden="true" style="margin-right: 5px"></span> Visualizar
								
						</a>						
						<a href="/easports/ControleProduto?acao=excluirProduto&idProduto=${produto.idProduto}"
								class="btn btn-sm" onclick="return confirm('Deseja excluir este Produto ?')" style="background-color: #ffb0b0; font-size: 14; 
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

				</div>	
				
			</div>			
		</div>		
	</div>
</body>
</html>