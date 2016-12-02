<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- TagLibraries (JSTL) -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/loginForm.css" />

<link rel="stylesheet" type="text/css" href="css/menuRodape.css" />
<link rel="stylesheet" type="text/css" href="css/cadastroCliente.css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/easports/css/bootstrap-theme.min.css" />

<script type="text/javascript" src="/easports/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/easports/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/easports/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/easports/js/filtro.js"></script>

<title>EA Sports</title>

</head>

<body class="container" style=" overflow-x:hidden; 
	  background-repeat:center" background="/easports/img/login_Background.jpg">

    <div class="container" style="margin-top:9%">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<strong> Faça login para continuar</strong>
					</div>
					<div class="panel-body">
						<form id="pesquisa" name="pesquisa" method="post" 
							  action="/easports/ControlePessoa?acao=autenticar">
							<fieldset>
								<div class="row">
									<div class="center-block" style="padding-right: 32%">
										<img class="profile-img" src="img/Logo_EA.gif">
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1" style="padding-right: 32%; padding-left: 0%">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<input class="form-control" placeholder="CPF" name="cpf" type="text" autofocus>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
												<input class="form-control" placeholder="Senha" name="senha" type="password">
											</div>
										</div>
										<hr>
										<div class="form-group" style="margin-left: 10%">
										
											<input type="submit" class="btn btn-sm" value="Continuar" style="background-color: #d7d7d7; 
				   								   width: 105; font-size: 14; font: bold;text-align: right;border-color: black"/>
				   								   
				   								   <span class="glyphicon glyphicon-log-in" style="margin-left: -100"></span>
				   								   
				   							<input type="reset" class="btn btn-sm" value="Limpar" style="background-color: #b1b1b1; 
				   								   width: 90; font-size: 14; font: bold;text-align: right;border-color: black; 
				   								   margin-left: 40%"/>
				   								   
				   								   <span class="glyphicon glyphicon-erase" style="margin-left: -83"></span>
				   								   
										</div>
										
										<div class="panel-heading text-center">
											<label style="color:red;">${mensagem}</label>
										</div>
										
									</div>
								</div>
							</fieldset>
						</form>
					</div>
                </div>
			</div>
		</div>
	</div>

</body>
</html>