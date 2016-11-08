<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanCargo" id="mbCargo"></jsp:useBean>
<jsp:useBean class="br.com.easports.managedbeans.ManagedBeanDepartamento" id="mbDepartamento"></jsp:useBean>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />
<link rel="stylesheet" type="text/css"
	href="/easports/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="/easports/css/bootstrap-theme.min.css" />
<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
<title>EA Sports</title>
</head>
<body style="max-height: 100%; max-width: 100%">
	<jsp:include page="cabecalhoRodape2.jsp"></jsp:include>

	<hgroup>
	<h1
		style="padding-left: 0%; margin-left: 35%; color: gray; text-shadow: 2px 2px 5px #000000;">Cadastro
		de funcionários:</h1>
	</hgroup>


		<div style="width: 100%;" class="col-md-4">
		<form  name="formulario" method="post"
			action="ControlePessoa?acao=cadastrarfuncionario">

			<div class="col-md-3"style="width: 70%; float: right; margin-right: 5px; padding: 0px;">
				<div class="panel" style="background-color: #b4b4b4; width: 100%;">
					<div class="panel-heading">
					
						<fieldset id="fieldCli" style="width: 100%;">			
							<h4>Endereço:</h4>
							<hr>
			
							<label>Logradouro:
								<input required="required" style="width: 350px" type="text" name="logradouro" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>Número:
								<input required="required" style="width: 100px" type="text" name="numero" class="form-control" placeholder="Digite aqui"/>
							</label>
				
							<label>CEP:
								<input required="required" style="width: 200px" type="text" name="cep" class="form-control" placeholder="Digite aqui"/>
							</label>
							
							
							<label>Bairro:
								<input required="required" style="width: 250px" type="text" name="bairro" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
							
							<label>Cidade:
								<input required="required" style="width: 250px" type="text" name="cidade" class="form-control" placeholder="Digite aqui"/>
							</label>

							
							<label>Estado:
								<input required="required" style="width: 200px" type="text" name="estado" class="form-control" placeholder="Digite aqui"/>
							</label>
													
							<label>País:
								<input required="required" style="width: 250px" type="text" name="pais" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/><hr>
					
						<input type="submit" value="Cadastrar" id="enviar" class="btn btn-success" style="width: 100px;"/> 
						<input type="reset" value="Limpar" id="limpar" class="btn btn-warning" style="width: 100px;">				
						</fieldset>	
					</div>
				</div>
			</div>


			<div class="col-md-3" style="width: 29%; margin-left: 5px;padding: 0px;">
				<div class="panel" style="background-color: #b4b4b4;width: 100%">
					<div class="panel-heading">		
						<fieldset id="fieldCli" style="width: 100%;">
									
							<h4>Dados Gerais:</h4>
							<hr>	
			
							<label>Nome do Funcionário:
								<input required="required" style="width: 250px" type="text" name="nome" class="form-control" placeholder="Digite aqui" />
							</label>
						
							<label>Telefone:
								<input required="required" style="width: 140px" type="text" name="telefone" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>
				
							<label>CPF:
								<input required="required" style="width: 135px" type="text" name="cpf" class="form-control" placeholder="Digite aqui"/>
							</label>
							<label for="pwd">Password:
							  <input type="password" required="required" style="width: 100px" class="form-control" id="pwd" name="senha">
							  </label>
							
							<label>Data Nasc.:
								<input required="required" style="width: 160px" type="date" name="datanasc" class="form-control" placeholder="Digite aqui"/>
							</label>
							<br/>	
							
						
							<label>Departamento:
								<select name="departamento" class="form-control">
									<option value="">- Selecione uma Opção -</option>
					
								<c:forEach items="${mbDepartamento.listagemDepartamentos}" var="d">
									<option value="${d.idDepartamento}"> ${d.departamento} </option>
								</c:forEach>					
								</select>
							</label>
							
							<label>Cargo:
								<select name="cargo" class="form-control">
									<option value="">- Selecione uma Opção -</option>
					
								<c:forEach items="${mbCargo.listagemCargos}" var="c">
									<option value="${c.idCargo}"> ${c.cargo} </option>
								</c:forEach>					
								</select>
							</label>
							</br>												
							
										
						</fieldset>		
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div><h4 style="color: green; text-align: center;">${mensagem}</h4>

</body>
</html>