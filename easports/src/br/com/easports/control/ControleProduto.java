package br.com.easports.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.easports.entities.Categoria;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Produto;
import br.com.easports.persistence.CategoriaDAO;
import br.com.easports.persistence.FornecedorDAO;
import br.com.easports.persistence.ProdutoDAO;

// Servlet respons�vel por coletar as informa��es da p�gina web e consultar no 
// banco de dados, via request - response

@WebServlet("/ControleProduto")
@MultipartConfig() //habilitando o servlet a receber um upload
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleProduto() {
		super();
	}

	// m�todo respons�vel por coletar as informa��es dos bot�es submit, nas
	// p�ginas JSP (Java Server Pages)

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Vari�vel respons�vel por coletar a a��o trazida pelo formul�rio e executar o
		// m�todo espec�fico para seu tratamento

		String acao = request.getParameter("acao");

		// if/else respons�vel por comparar a a��o trazida atrav�s do formul�rio com as 
		// op��es poss�veis de serem executadas pela p�gina. Ex: cadastrar produto, consultar
		// estoque, consultar produtos etc...

		if (acao != null) {

			// Se o valor da a��o recebida pelo formul�rio for "cadastrar",
			// execute o bloco abaixo:

			if (acao.equalsIgnoreCase("cadastrar")) {

				try {

					// Instanciando um novo Estoque para receber os par�metros passados pelo usu�rio
					// atrav�s da JSP

					Produto produto = new Produto();

					ProdutoDAO produtoDao = new ProdutoDAO();

					produto.setNome(request.getParameter("nome"));
					produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
					produto.setValorVenda(Double.parseDouble(request.getParameter("valorVenda").replaceAll(",", ".")));
					produto.setValorCusto(Double.parseDouble(request.getParameter("valorCusto").replaceAll(",", ".")));
					produto.setCodigo(request.getParameter("codigo"));

					// Coletando cada par�metro da p�gina atrav�s do "name" do formul�rio, utilizando
					// o request.getParameter() e atribuindo � entidade Estoque atrav�s dos setters

					// GUID - Global Unique Identifier (gera n�meros rand�micos)

					UUID guid = UUID.randomUUID();

					produto.setImagem(guid.toString() + ".jpg");

					// upload...
					// resgatar o campo imagem (file)

					Part imagem = request.getPart("imagem"); // arquivo

					// definir o local onde o arquivo ser� salvo

					//String pasta = getServletContext().getRealPath("/img/produtos");
					
					String pasta = System.getProperty("user.home") + "\\workspace\\EASPORTS\\easports\\WebContent\\img";
	
					FileOutputStream stream = new FileOutputStream(pasta + "/" + produto.getImagem());

					InputStream input = imagem.getInputStream(); // lendo o arquivo

					byte[] buffer = new byte[1024];

					while (input.read(buffer) > 0) {

						stream.write(buffer);

					}

					stream.close();

					Categoria categoria = new Categoria();

					CategoriaDAO categoriaDao = new CategoriaDAO();

					categoria = categoriaDao.findById(Integer.parseInt(request.getParameter("categoria")));

					Fornecedor fornecedor = new Fornecedor();

					FornecedorDAO fornecedorDao = new FornecedorDAO();

					fornecedor = fornecedorDao.findById(Integer.parseInt(request.getParameter("fornecedor")));
					
					produtoDao.insert(produto, fornecedor.getIdFornecedor(), categoria.getIdCategoria());
					
					request.setAttribute("mensagem", "Produto " + produto.getNome() + " cadastrado com sucesso.");

				} catch (Exception e) {

					// Caso o m�todo caia no catch, retorne para a p�gina a mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma p�gina de cadastro de clientes

					request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

				}

			}
			
			else if(acao.equalsIgnoreCase("pesquisar")){
				
				try {
					
					String busca = request.getParameter("pesquisa");
					
					ProdutoDAO produtoDao = new ProdutoDAO();
					
					List<Produto> lista = produtoDao.findByName(busca);
					
					request.setAttribute("lista", lista);
					
				} catch (Exception e) {
					
					// Caso o m�todo caia no catch, retorne para a p�gina a mensagem de erro

					request.setAttribute("mensagem", e.getMessage());
					
				} finally {

					// Redirecionando novamente para a mesma p�gina de cadastro de clientes

					request.getRequestDispatcher("resultadosProduto.jsp").forward(request, response);

				}
				
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

}
