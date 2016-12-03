<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnc"%>

  <html>
  <body>
    <!-- MENU DO SISTEMA -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid"style="background-color: #7f7f7f">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            
                <ul class="nav navbar-nav">
                
                    <li><a href="/easports/areaRestrita/index.jsp" style="background-color: #7f7f7f; 
                    	   color: #ffffff;"><b>Página inicial</b></a></li>
                    
                    <li class="dropdown" id="menuCadastrar">
                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Cadastrar</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        <c:if test="${usuarioLogado.cargo.cargo=='Gerente'}">
                            <li id="cadastrarCliente"> <a href="/easports/areaRestrita/cadastroCliente.jsp">Cliente</a></li>
                            <li id="cadastrarFornecedor"><a href="/easports/areaRestrita/cadastroFornecedor.jsp">Fornecedor</a></li>
                            <li id="cadastrarFuncionario"><a href="/easports/areaRestrita/cadastroFuncionario.jsp">Funcionário</a></li>
                            <li id="cadastrarProduto"><a href="/easports/areaRestrita/cadastroProduto.jsp">Produto</a></li>
                        </c:if>
                        <c:if test="${usuarioLogado.cargo.cargo=='Vendedor'}">
                            <li id="cadastrarCliente"> <a href="/easports/areaRestrita/cadastroCliente.jsp">Cliente</a></li>
                        </c:if>
                        <c:if test="${usuarioLogado.cargo.cargo=='Gerente de Produtos'}">
                            <li id="cadastrarProduto"><a href="/easports/areaRestrita/cadastroProduto.jsp">Produto</a></li>
                        </c:if>                                                
                        
                        </ul>
                    </li>
                    
                    <li class="dropdown" id="menuConsultar">                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Consultar</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        <c:if test="${usuarioLogado.cargo.cargo=='Gerente'}">
                            <li id="consultarCliente"><a href="/easports/areaRestrita/consultaCliente.jsp">Cliente</a></li>
                            <li id="consultarFornecedor"><a href="/easports/areaRestrita/consultaFornecedor.jsp">Fornecedor</a></li>
                            <li id="consultarFuncionario"><a href="/easports/areaRestrita/consultaFuncionario.jsp">Funcionário</a></li>
                            <li id="consultarProduto"><a href="/easports/areaRestrita/consultaProduto.jsp">Produto</a></li>
                            <li id="consultarPedido"><a href="/easports/areaRestrita/consultaPedido.jsp">Pedidos</a></li>
                            </c:if>
                        <c:if test="${usuarioLogado.cargo.cargo=='Vendedor'}">
                            <li id="consultarCliente"><a href="/easports/areaRestrita/consultaCliente.jsp">Cliente</a></li>
                            <li id="consultarProduto"><a href="/easports/areaRestrita/consultaProduto.jsp">Produto</a></li>
                            <li id="consultarPedido"><a href="/easports/areaRestrita/consultaPedido.jsp">Pedidos</a></li>
                        </c:if>  
                        <c:if test="${usuarioLogado.cargo.cargo=='Gerente de Produtos'}">
                            <li id="consultarFornecedor"><a href="/easports/areaRestrita/consultaFornecedor.jsp">Fornecedor</a></li>
                            <li id="consultarProduto"><a href="/easports/areaRestrita/consultaProduto.jsp">Produto</a></li>
                        </c:if>                            
                                                      
                        </ul>
                    </li>
                    <c:if test="${usuarioLogado.cargo.cargo=='Gerente'}">
		    		<li class="dropdown" id="menuRelatorio">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Relatórios</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li id="relatorioCliente"><a href="/easports/areaRestrita/relatorioClientes.jsp">Clientes Cadastrados</a></li>
                            <li id="relatorioPedido"><a href="/easports/areaRestrita/relatorioPedidos.jsp">Pedidos Realizados</a></li>
                        	<li id="relatorioEstoque"><a href="/easports/areaRestrita/relatorioEstoque.jsp">Estoque da Loja</a></li>
                        </ul>
                    </li>
                 </c:if>
                 
                    <c:if test="${usuarioLogado.cargo.cargo=='Gerente de Produtos'}">
		    		<li class="dropdown" id="menuRelatorio">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
                           aria-haspopup="true" aria-expanded="false" style="background-color: #7f7f7f; 
                           color: #ffffff"><b>Relatórios</b> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        	<li id="relatorioEstoque"><a href="/easports/areaRestrita/relatorioEstoque.jsp">Estoque da Loja</a></li>
                        </ul>
                    </li>
                 </c:if>                 
                 
                </ul>                
            </div>
        </div>

    </nav>
    
    <!-- TOPO DO SISTEMA -->
    
    <div class="well text-center" style="margin-top: 40px;width: 100%;height: 65px">
        
		<div style="padding-left: 50%">
		
			<strong>Logado como: </strong>
			
			<label style="color: green; font-size: 18px">${usuarioLogado.nome}</label><strong> | Perfil: </strong><label style="color: olive; font-size: 18px" id="perfil">${usuarioLogado.cargo.cargo}</label>
			<label>
				<a href="/easports/ControlePessoa?acao=logout" class="btn btn-sm" 
				   style="background-color: #fbfecf; font-size: 14; color: black;border-color: black">									
				   <span class="glyphicon glyphicon-off" aria-hidden="true" style="padding-right: 5%"></span> Logout
									
				</a>		
						
			</label>	    
		</div>
    </div>
    <script type="text/javascript" src="/easports/js/filtro.js"></script>
  </body>
  </html>
    