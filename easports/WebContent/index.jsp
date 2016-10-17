<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
	<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
	
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body>

<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<div id="botoes" style="padding-top: 20px">

			<label id="cadastro" style="padding-left: 25%"><a a href="cadastroCliente.jsp"> 
				<img src="img/btn_cadastrar.png" /></a>
			</label>
				
			<label id="consulta" style="padding-left: 3%"><a a href="consultaCliente.jsp"> 
				<img src="img/btn_consultar.png" /></a>
			</label>
			
			<label id="relatorio" style="padding-left: 3%"><a> 
				<img src="img/btn_relatorio.png" /></a>
			</label>
			
			<label id="vendas" style="padding-left: 3%"><a> 
				<img src="img/btn_vendas.png" /></a>
			</label>
			
			<label id="ajuda" style="padding-left: 3%"><a> 
				<img src="img/btn_ajuda.png" /></a>
			</label>
			
	</div>
	
	<center>
		<img src="img/Logo_EA.gif" width="350" style="padding-top: 2%"/>
	</center>
	
</body>
</html>