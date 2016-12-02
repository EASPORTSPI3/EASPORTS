<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>

<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<div id="botoes" style="padding-top: 20px">

			<label id="cadastro" style="padding-left: 25%"><a href="/easports/areaRestrita/cadastroCliente.jsp" title="Cadastro de Clientes"> 
				<img src="/easports/img/btn_cadastrar.png" /></a>
			</label>
				
			<label id="consulta" style="padding-left: 3%"><a href="/easports/areaRestrita/consultaCliente.jsp" title="Consultar Clientes"> 
				<img src="/easports/img/btn_consultar.png" /></a>
			</label>
			
			<label id="relatorio2" style="padding-left: 3%"><a href="/easports/areaRestrita/relatorioClientes.jsp" title="Relatório de Clientes"> 
				<img src="/easports/img/btn_relatorio.png" /></a>
			</label>
			
			<label id="vendas" style="padding-left: 3%"><a href="/easports/areaRestrita/relatorioPedidos.jsp" title="Relatório de Clientes">  
				<img src="/easports/img/btn_vendas.png" /></a>
			</label>
			
			<label id="sobre" style="padding-left: 3%"><a href="/easports/areaRestrita/sobre.jsp" title="Sobre"> 
				<img src="/easports/img/btn_ajuda.png" /></a>
			</label>
			
	</div>
	
	<center>
		<img src="/easports/img/Logo_EA.gif" width="350" style="padding-top: 2%"/>
	</center>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>