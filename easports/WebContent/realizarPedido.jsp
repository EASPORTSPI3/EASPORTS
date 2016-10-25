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

	<div style="padding-left: 8%" class="col-md-4" >
		
		<form style="background-color: #7f7f7f" name="formulario" method="post" 
			  action="ControlePessoa?acao=realizarPedido">
			
			<div class="col-md-3" style="width: 700; margin-left: 50%">
				<div class="panel panel-success">
					<div class="panel-heading">
					
						<h3 class="text-center"><strong>${produto.nome}</strong></h3>
						
					</div>
					
					<div class="panel-body" style="background-color: #f0fff0">
						<img src="img/${produto.imagem}" width="210" height="160" align="left"/>
						
						<div class="panel-body" style="margin-top: -10px">
						
							<h4><strong style="color: black; margin-left: 15px">C�digo: </strong>${produto.codigo}</h4>
							<h4><strong style="color: black; margin-left: 15px">Fornecedor: </strong>${produto.fornecedor.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Categoria: </strong>${produto.categoria.nome}</h4>
							<h4><strong style="color: black; margin-left: 15px">Pre�o: </strong>${produto.valorVendaFormatado}</h4>
							<h4><strong style="color: black; margin-left: 15px">Quantidade em Estoque: </strong>${produto.quantidade}</h4>		
							<br/><hr>
							
							<label>Quantidade:</label> <input type="text" name="quantidade" placeholder="Digite aqui"required="required"/>
							<br/><br/>
							
							<label>ID Cliente:</label> <input type="text" name="idCliente" placeholder="Digite aqui"required="required" style="margin-left: 14px"/>
							<br/><br/>
							
							<input type="submit" value="Confirmar" id="enviar" class="botoes"/> 
							<input type="reset" value="Limpar" id="limpar" class="botoes">
							
						</div>
						
					</div>
					
				</div>
			</div>
			
		</form>			
	</div>
	
</body>
</html>