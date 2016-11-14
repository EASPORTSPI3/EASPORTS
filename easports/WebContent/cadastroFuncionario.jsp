<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanDepartamento" id="mbDepartamento"></jsp:useBean>
	<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanCargo" id="mbCargo"></jsp:useBean>

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
<body>
	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>
	
	<hgroup>
	<h1 style="padding-left: 0%; margin-left: 35%; color: gray; text-shadow: 2px 2px 5px #000000;">Cadastro de Funcion�rio:</h1>
	</hgroup>

		<div style="width: 50%; padding:0px;"class="col-md-4">
		<form  name="formulario" method="post"
			action="ControlePessoa?acao=cadastrarfuncionario">

			<div class="col-md-3"style="width: 100%; margin-left: 50%; padding: 0px;">
				<div class="panel" style="background-color: #b4b4b4; width: 100%; margin: 0px;">
					<div class="panel-heading" >
					
						<fieldset id="fieldCli" style="width: 100%;">						
							<hr>							
							<h4>Dados Gerais:</h4>
							<hr>	
			
							<label>Nome do Funcion�rio:
								<input required="required" style="width: 285px" type="text" name="nome" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>Telefone:
								<input required="required" style="width: 140px" type="text" name="telefone" class="form-control" placeholder="Digite aqui"/>
							</label>
				
							<label>CPF:
								<input required="required" style="width: 200px" type="text" name="cpf" class="form-control" placeholder="Digite aqui"/>
							</label>
							
							<label>Data Nasc.:
								<input required="required" style="width: 160px" type="date" name="datanasc" class="form-control" placeholder="Digite aqui"/>
							</label>

							<label for="pwd">Senha:
							  <input type="password" required="required" style="width: 140px" class="form-control" id="pwd" name="senha" placeholder="Digite aqui">
							</label>
						
							<label>Departamento:
								<select name="departamento" class="form-control" style="width: 135px">
									<option value="">- Selecione -</option>
					
								<c:forEach items="${mbDepartamento.listagemDepartamentos}" var="d">
									<option value="${d.idDepartamento}"> ${d.departamento} </option>
								</c:forEach>					
								</select>
							</label>
							
							<label>Cargo:
								<select name="cargo" class="form-control" style="width: 135px">
									<option value="">- Selecione -</option>
					
								<c:forEach items="${mbCargo.listagemCargos}" var="c">
									<option value="${c.idCargo}"> ${c.cargo} </option>
								</c:forEach>					
								</select>
							</label>
							<hr>
									
							<h4>Endere�o:</h4>
							<hr>
			
							<label>Logradouro:
								<input required="required" style="width: 300px" type="text" name="logradouro" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>N�mero:
								<input required="required" style="width: 100px" type="text" name="numero" class="form-control" placeholder="Digite aqui"/>
							</label>
				
							<label>CEP:
								<input required="required" style="width: 120px" type="text" name="cep" class="form-control" placeholder="Digite aqui"/>
							</label>
							
							
							<label>Bairro:
								<input required="required" style="width: 220px" type="text" name="bairro" class="form-control" placeholder="Digite aqui"/>
							</label>

							
							<label>Cidade:
								<input required="required" style="width: 180px" type="text" name="cidade" class="form-control" placeholder="Digite aqui"/>
							</label>

							
							<label>Estado:
								<input required="required" style="width: 180px" type="text" name="estado" class="form-control" placeholder="Digite aqui"/>
							</label>
													
							<label>Pa�s:
								<input required="required" style="width: 250px" type="text" name="pais" class="form-control" placeholder="Digite aqui"/>
							</label>
							<hr>
											
						<input type="submit" value="Cadastrar" id="enviar" class="btn btn-success" style="width: 100px;"/> 
						<input type="reset" value="Limpar" id="limpar" class="btn btn-warning" style="width: 100px;">	
						<h4 style="color:green">${mensagem}</h4>			
						</fieldset>	
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>