<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Referenciar os ManagedBeans -->
    
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
	
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body>
	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<hgroup>
		<h2 style="padding-left: 9%">Cadastro de Produtos:</h2>
	</hgroup>

	<div id="logo">
		<img src="img/EA_Sports2.png"/>
	</div>
		
	<div style="padding-left: 8%" class="col-md-4" >
		
		<form style="background-color: #7f7f7f" name="formulario" method="post" enctype="multipart/form-data" 
			  action="ControleProdut?acao=cadastrar">
			
			<div class="col-md-3" style="width: 410; margin-left: -40px">
				<div class="panel" style="background-color: #b4b4b4">
					<div class="panel-heading">
			
						<fieldset id="fieldCli">
			
							<h4>Dados Gerais:</h4>
							<hr>
			
							<label>Nome do Produto:
								<input style="width: 350px" type="text" name="nome" class="form-control" placeholder="Digite aqui" />
							</label>
							<br/>
						
							<label>C�digo:
								<input style="width: 350px" type="text" name="codigo" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
				
							<label>Fornecedor:
								<select name="fornecedor" class="form-control">
									<option value="">- Selecione uma Op��o -</option>
					
								<c:forEach items="${mbFornecedor.listagemFornecedores}" var="f">
									<option value="${f.idFornecedor}"> ${f.nome} </option>
								</c:forEach>
					
								</select>
							</label>
							<br/>
							
							<label>Categoria:
								<select name="categoria" class="form-control">
									<option value="">- Selecione uma Op��o -</option>
					
								<c:forEach items="${mbCategoria.listagemCategorias}" var="c">
									<option value="${c.idCategoria}"> ${c.nome} </option>
								</c:forEach>
					
								</select>
							</label>
							<br/>
							
							<label>Imagem do Produto:
								<input type="file" name="imagem" class="form-control"/>
							</label>
							<br/>
							
							<label>Valor de Venda:
								<input type="text" name="valorVenda" class="form-control"/>
							</label>
							<br/>
							
							<label>Valor de Custo:
								<input type="text" name="valorCusto" class="form-control"/>
							</label>
							<br/>
				
							<label>Quantidade:
								<input type="text" name="quantidade" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/><hr>
		
							<input type="submit" value="Cadastrar" id="enviar" class="botoes"/> 
							<input type="reset" value="Limpar" id="limpar" class="botoes">
					
							<h4 style="color:red">${mensagem}</h4>
					
						</fieldset>
			
					</div>
				</div>
			</div>
			
		</form>			
	</div>
		
</body>
</html>