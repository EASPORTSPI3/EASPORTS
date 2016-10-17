
	<style>
		.well { background-image: url("/aula13_projeto/arearestrita/img/test.jpg");border-width: 1px;border-color: black; }
	</style>
    
    <!-- MENU DO SISTEMA -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid"style="background-color: #d7ecce">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/aula13_projeto/arearestrita/index.jsp" style="background-color: #d7ecce">Página inicial</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color: #d7ecce">Autores <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/aula13_projeto/arearestrita/cadastroAutor.jsp">Cadastrar Autores</a></li>
                            <li><a href="/aula13_projeto/arearestrita/consultaAutor.jsp">Consultar Autores</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color: #d7ecce">Editoras <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/aula13_projeto/arearestrita/cadastroEditora.jsp">Cadastrar Editoras</a></li>
                            <li><a href="/aula13_projeto/arearestrita/consultaEditora.jsp">Consultar Editoras</a></li>
                        </ul>
                    </li>
		    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color: #d7ecce">Livros <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/aula13_projeto/arearestrita/cadastroLivro.jsp">Cadastrar Livros</a></li>
                            <li><a href="/aula13_projeto/arearestrita/consultaLivro.jsp">Consultar Livros</a></li>
                        </ul>
                    </li>
                </ul>
                
                <form id="logout" name="logout" method="post" action="/aula13_projeto/ControleCliente?cmd=logout" style="margin-left: 930px">
				  
					
					    
					
					    <strong>Usuário: </strong>${usuariologado.nome}
					<input type="submit" class="btn btn-sm" value="Logout" style="background-color: #ffc1c1; width: 85px; font-size: 14; font: bold;text-align: right; margin-left: 20px"/>
					<span class="glyphicon glyphicon-off" style="margin-left: -80; margin-top: 10px"></span>
	
				</form>
            </div>

        </div>
    </nav>

    <!-- TOPO DO SISTEMA -->
    
    <div class="well text-center" style="margin-top: 50px;">
        <h2 style="color: #727272;">Biblioteca Virtual VirtLibrary</h2>
    </div>
    
    </body>
    