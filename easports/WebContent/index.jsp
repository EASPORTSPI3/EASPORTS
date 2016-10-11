<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<title>EA Sports</title>
</head>
<body>
<jsp:include page="cabecalhoRodape.jsp"></jsp:include>
	
	<section>
	<div id="botoes">
		<ul>
			<li id="cadastro"><a a href="cadastroCliente.jsp"> 
			<img src="img/btn_cadastrar.png" /></a>
				<div id="divCad">Cadastro</div></li>
				
			<li id="consultar"><a a href="consultaCliente.jsp">
			<img src="img/btn_consultar.png" /></a>
			<div id="divCad">Consultar</div></li>
			
			<li id="relatorio"><a>
			<img src="img/btn_relatorio.png" /></a>
			<div id="divCad">Relatórios</div></li>
			
			<li id="vendas"><a>
			<img src="img/btn_vendas.png" /></a>
			<div id="divCad">Vendas</div></li>
			
			<li id="ajuda"><a>
			<img src="img/btn_ajuda.png" /></a>
			<div id="divCad">Ajuda</div></li>
		</ul>
	</div>
	</section>
	<section>
	<div id="logo">
		<img src="img/Logo_EA.gif" />
	</div>
	</section>

	
</body>
</html>