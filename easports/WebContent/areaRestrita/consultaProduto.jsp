<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanProduto" id="mb"></jsp:useBean>

<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />

<link rel="stylesheet" type="text/css"
	href="/easports/css/bootstrap-theme.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>

<title>EA Sports</title>

</head>
<body class="container" style="min-width: 1024px;">

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<div class="row">

		<form id="pesquisa" name="pesquisa" method="post"
			action="/easports/ControleProduto?acao=pesquisar"
			style="margin-left: 700px">

			<input type="submit" class="btn btn-sm" value="Pesquisar"
				style="background-color: #cacaff; width: 105; font-size: 14; font: bold; text-align: right; border-color: black" />
			<span class="glyphicon glyphicon-search" style="margin-left: -100"></span>

			<div class="col-md-3" style="width: 350; margin-left: -15px">
				<input type="text" id="pesquisa" name="pesquisa"
					class="form-control" placeholder="Digite aqui..." />
			</div>
		</form>
		<hr />
		<br />

		<c:forEach items="${mb.listagemProdutos}" var="produto">

			<div class="col-md-3" style="width: 290">
				<div class="panel panel-success">
					<div class="panel-heading">
						<span class="glyphicon glyphicon-credit-card"
							style="width: 16px; font-size: 12px; margin-left: -6px;"></span>
						<b>Código: ${produto.codigo}</b>
					</div>
					<div class="panel-body text-center">
						<img src="../img/${produto.imagem}" width="160" height="135" />
						<hr />
						<strong>${produto.nome}</strong>
						<hr>

						<strong>Categoria: </strong>${produto.categoria.nome} <br /> <strong>Preço:
						</strong>${produto.valorVendaFormatado} <br /> 
						<c:if test="${usuarioLogado.cargo.cargo=='Gerente' || usuarioLogado.cargo.cargo=='Vendedor' }">	
						<a
							href="/easports/ControleProduto?acao=adicionarProduto&id=${produto.idProduto}"
							class="btn btn-sm"
							style="background-color: #ffb0b0; font-size: 14; color: black; margin-top: 20px; border-color: black">

							<span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
							Adicionar

						</a> <a
							href="/easports/ControleProduto?acao=detalhesProduto&id=${produto.idProduto}"
							class="btn btn-sm"
							style="background-color: #cacaff; font-size: 14; color: black; margin-top: 20px; margin-left: -215px; border-color: black">

							<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
							Visualizar

						</a>
						</c:if>
						
					<c:if test="${usuarioLogado.cargo.cargo=='Gerente de Produtos'}">	
<a
							href="/easports/ControleProduto?acao=detalhesProduto&id=${produto.idProduto}"
							class="btn btn-sm"
							style="background-color: #cacaff; font-size: 14; color: black; margin-top: 20px; border-color: black">

							<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
							Visualizar

						</a>
					</c:if>
						
						
						
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>