<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
	<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	<script type="text/javascript" src="/easports/js/filtro.js"></script>
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body style="min-width: 1024px;">

<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<div id="botoes" style="padding-top: 20px; text-align: center">
			
		<c:if test="${usuarioLogado.cargo.cargo=='Gerente' || usuarioLogado.cargo.cargo=='Vendedor' }">			
			<label id="cadastroCli"><a href="/easports/areaRestrita/cadastroCliente.jsp" title="Cadastro de Clientes"> 
				<img src="/easports/img_projeto/btn_cadastrar.png" /></a>
			</label>
				
			<label id="consultaCli" style="padding-left: 3%"><a href="/easports/areaRestrita/consultaCliente.jsp" title="Consultar Clientes"> 
				<img src="/easports/img_projeto/btn_consultar.png" /></a>
			</label>
			
			<label id="consultaProd" style="padding-left: 3%"><a href="/easports/areaRestrita/consultaProduto.jsp" title="Consultar Produtos"> 
				<img src="/easports/img_projeto/btn_relatorio.png" /></a>
			</label>
			
			<label id="consultaPedi" style="padding-left: 3%"><a href="/easports/areaRestrita/consultaPedido.jsp" title="Consultar Pedidos">  
				<img src="/easports/img_projeto/btn_vendas.png" /></a>
			</label>
			
			<label id="sobre" style="padding-left: 3%"><a href="/easports/areaRestrita/sobre.jsp" title="Sobre"> 
				<img src="/easports/img_projeto/btn_ajuda.png" /></a>
			</label>
		</c:if>	
		
		<c:if test="${usuarioLogado.cargo.cargo=='Gerente de Produtos'}">			
			<label id="cadastroCli"><a href="/easports/areaRestrita/cadastroProduto.jsp" title="Cadastro de Produtos"> 
				<img src="/easports/img_projeto/btn_cadastrar.png" /></a>
			</label>
				
			<label id="consultaCli" style="padding-left: 3%"><a href="/easports/areaRestrita/consultaProduto.jsp" title="Consultar Produtos"> 
				<img src="/easports/img_projeto/btn_consultar.png" /></a>
			</label>
			
			<label id="consultaProd" style="padding-left: 3%"><a href="/easports/areaRestrita/relatorioEstoque.jsp" title="Relatório de Estoque"> 
				<img src="/easports/img_projeto/btn_relatorio.png" /></a>
			</label>
			
			<label id="sobre" style="padding-left: 3%"><a href="/easports/areaRestrita/sobre.jsp" title="Sobre"> 
				<img src="/easports/img_projeto/btn_ajuda.png" /></a>
			</label>
		</c:if>	
			
	</div>
	
	<center>
		<img src="/easports/img_projeto/Logo_EA.gif" width="350" style="padding-top: 2%"/>
	</center>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="/easports/js/filtro.js"></script>
	
</body>
</html>