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
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body>

	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>


	<form name="formulario" method="post" action="ControleProduto?acao=consultarPedidos">
			
		<div class="col-md-3" style="width: 410">
			
		<label>CPF:</label> <input type="text" name="cpf" required="required"/>
		
		<input type="submit" value="Pesquisar" id="enviar" class="botoes"/>
		
		<h4 style="color:red">${mensagem}</h4>
			
		</div>
			
	</form>
	
</body>
</html>