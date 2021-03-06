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
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css"/>
	
	<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
	
	<title>EA Sports</title>
</head>
<body style="min-width: 1024px;">
	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<hgroup>
		<h1 style="padding-left: 0%; margin-left: 37%; color: gray; text-shadow: 2px 2px 5px #000000;">Cadastro de Produto:</h1>
		
	</hgroup>
			
	<div style="width: 100%;" class="col-md-4" >
		
		<form name="formulario" method="post" enctype="multipart/form-data" 
			  action="/easports/ControleProduto?acao=cadastrar" style="width: 60%; margin: auto">
			
			<div class="col-md-3" style="width: 100%; margin-left: 0px;">
				<div class="panel" style="background-color: #b4b4b4; width: 100%;">
					<div class="panel-heading" style="width: 100% 	;">			
						<fieldset id="fieldCli" style="width: 100%;">
			
							<h4>Dados Gerais:</h4>
							<hr>
			
							<label>Nome do Produto:
								<input required="required" style="width: 100%" type="text" name="nome" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>C�digo:
								<input required="required" style="width: 100%" type="text" name="codigo" class="form-control" placeholder="Digite aqui"/>
							</label>
											
							<label>Fornecedor:
								<select required="required" name="fornecedor" class="form-control">
									<option value="">- Selecione uma Op��o -</option>
					
								<c:forEach items="${mbFornecedor.listagemFornecedores}" var="f">
									<option value="${f.idFornecedor}"> ${f.nome} </option>
								</c:forEach>
					
								</select>
							</label>

							
							<label>Categoria:
								<select required="required" name="categoria" class="form-control">
									<option value="">- Selecione uma Op��o -</option>
					
								<c:forEach items="${mbCategoria.listagemCategorias}" var="c">
									<option value="${c.idCategoria}"> ${c.nome} </option>
								</c:forEach>
					
								</select>
							</label>

							<label>Imagem do Produto:
								<input required="required" type="file" name="imagem" class="form-control"/>
							</label>
							<br/>
							
							<label>Valor de Venda:
								<input required="required" type="text" name="valorVenda" class="form-control" placeholder="Digite aqui" style="width: 120px"/>
							</label>
							
							<label>Valor de Custo:
								<input required="required" type="text" name="valorCusto" class="form-control" placeholder="Digite aqui" style="width: 120px"/>
							</label>

				
							<label>Quantidade:
								<input required="required" type="text" name="quantidade" class="form-control" placeholder="Digite aqui" style="width: 110px"/>
							</label>
							<br/><hr>
		
							<input type="submit" class="btn btn-sm" value="Cadastrar" style="background-color: #beeab5; 
								   width: 105; font-size: 14; font: bold; text-align: right; border-color: black" />
								<span class="glyphicon glyphicon-check" style="margin-left: -100"></span>
								
							<input type="reset" class="btn btn-sm" value="Limpar" style="background-color: #cacaff;margin-left:12%; 
								   width: 90; font-size: 14; font: bold; text-align: right; border-color: black" />
								<span class="glyphicon glyphicon-erase" style="margin-left: -86"></span>
									
							<h4 style="color:green">${mensagem}</h4>
							<h4 style="color:red">${mensagem2}</h4>	
							
						</fieldset>
			
					</div>
				</div>
			</div>
			
		</form>			
	</div>	
  </div>
  </div>
</body>
</html>