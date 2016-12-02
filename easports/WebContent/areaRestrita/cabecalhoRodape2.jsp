
    <!-- MENU DO SISTEMA -->
    
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid"style="background-color: #7f7f7f">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            
                <ul class="nav navbar-nav">
                
                    <li><a href="/easports/areaRestrita/index.jsp" style="background-color: #7f7f7f; 
                    	   color: #ffffff;"><b>Página inicial</b></a></li>
                    
                    <li class="dropdown">
                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Cadastrar</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li id="cliente"> <a href="/easports/areaRestrita/cadastroCliente.jsp">Cliente</a></li>
                            <li id="fornecedor"><a href="/easports/areaRestrita/cadastroFornecedor.jsp">Fornecedor</a></li>
                            <li id="funcionario"><a href="/easports/areaRestrita/cadastroFuncionario.jsp">Funcionário</a></li>
                            <li id="produto"><a href="/easports/areaRestrita/cadastroProduto.jsp">Produto</a></li>
                        </ul>
                    </li>
                    
                    <li class="dropdown">
                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Consultar</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/easports/areaRestrita/consultaCliente.jsp">Cliente</a></li>
                            <li><a href="/easports/areaRestrita/consultaFornecedor.jsp">Fornecedor</a></li>
                            <li><a href="/easports/areaRestrita/consultaFuncionario.jsp">Funcionário</a></li>
                            <li><a href="/easports/areaRestrita/consultaProduto.jsp">Produto</a></li>
                            <li><a href="/easports/areaRestrita/consultaPedido.jsp">Pedidos</a></li>
                        </ul>
                    </li>
                    
		    		<li class="dropdown" id="relatorio">
		    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Relatórios</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/easports/areaRestrita/relatorioClientes.jsp">Clientes Cadastrados</a></li>
                            <li><a href="/easports/areaRestrita/relatorioPedidos.jsp">Pedidos Realizados</a></li>
                        	<li><a href="/easports/areaRestrita/relatorioEstoque.jsp">Estoque da Loja</a></li>
                            
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
			
			<label style="color: green; font-size: 18px; padding-right: 100px">${usuarioLogado.nome} : 
					<label style="color: green; font-size: 18px; padding-right: 100px" id="perfil";>vendedor</label>
			
				<a href="/easports/ControlePessoa?acao=logout" class="btn btn-sm" 
				   style="background-color: #fbfecf; font-size: 14; color: black;border-color: black">									
				   <span class="glyphicon glyphicon-off" aria-hidden="true" style="padding-right: 5%"></span> Logout
									
				</a>		
						
			</label>	    
		</div>
    </div>
    <script type="text/javascript" src="/easports/js/filtro.js"></script>
  </body>
    