
    <!-- MENU DO SISTEMA -->
    
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid"style="background-color: #7f7f7f">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            
                <ul class="nav navbar-nav">
                
                    <li><a href="/easports/index.jsp" style="background-color: #7f7f7f; 
                    	   color: #ffffff;"><b>Página inicial</b></a></li>
                    
                    <li class="dropdown">
                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Cadastrar</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/easports/cadastroCliente.jsp">Cliente</a></li>
                            <li><a href="/easports/cadastroFornecedor.jsp">Fornecedor</a></li>
                            <li><a href="/easports/cadastroFuncionario.jsp">Funcionário</a></li>
                            <li><a href="/easports/cadastroProduto.jsp">Produto</a></li>
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Consultar</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/easports/consultaCliente.jsp">Cliente</a></li>
                            <li><a href="/easports/consultaFornecedor.jsp">Fornecedor</a></li>
                            <li><a href="/easports/consultaFuncionario.jsp">Funcionário</a></li>
                            <li><a href="consultaProduto.jsp">Produto</a></li>
                            <li><a href="/easports/consultaPedido.jsp">Pedidos</a></li>
                        </ul>
                    </li>
                    
		    		<li class="dropdown">
		    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Relatórios</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            
                        </ul>
                    </li>
                    
                </ul>
                
            </div>
        </div>

    </nav>
    
    

    <!-- TOPO DO SISTEMA -->
    
    <div class="well text-center" style="margin-top: 40px;width: 100%;height: 65px">
        
		<div style="padding-left: 50%">
		
			<strong>Bem-vindo: </strong>
			
			<label style="color: green; font-size: 18px; padding-right: 100px">${usuarioLogado.nome}
			
				<a href="/easports/ControlePessoa?acao=logout" class="btn btn-sm" 
				   style="background-color: #fbfecf; font-size: 14; color: black;border-color: black">
									
				   <span class="glyphicon glyphicon-off" aria-hidden="true" style="padding-right: 5%"></span> Logout
									
				</a>
				
			</label>
						    
				
		</div>
        
    </div>

    </body>
    