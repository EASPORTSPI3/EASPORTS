package br.com.easports.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Pedido;
import br.com.easports.entities.Produto;
import br.com.easports.persistence.CategoriaDAO;
import br.com.easports.persistence.ClientePFDAO;
import br.com.easports.persistence.FornecedorDAO;
import br.com.easports.persistence.PedidoDAO;
import br.com.easports.persistence.ProdutoDAO;
import br.com.easports.util.FormataValor;

// Servlet responsável por coletar as informações da página web e consultar no 
// banco de dados, via request - response

@WebServlet("/ControleProduto")
@MultipartConfig() // habilitando o servlet a receber um upload
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleProduto() {
		super();
	}

	// método responsável por coletar as informações dos botões submit, nas
	// páginas JSP (Java Server Pages)

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Variável responsável por coletar a ação trazida pelo formulário e executar o
		// método específico para seu tratamento

		String acao = request.getParameter("acao");

		// if/else responsável por comparar a ação trazida através do formulário com as
		// opções possíveis de serem executadas pela página. Ex: cadastrar produto, consultar
		// estoque, consultar produtos etc...

		if (acao != null) {

			// Se o valor da ação recebida pelo formulário for "cadastrar", execute o bloco abaixo:

			if (acao.equalsIgnoreCase("cadastrar")) {

				try {
					
					// Instanciando um novo Estoque para receber os parâmetros passados pelo usuário
					// através da JSP

					Produto produto = new Produto();

					ProdutoDAO produtoDao = new ProdutoDAO();

					produto.setNome(request.getParameter("nome"));
					produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
					produto.setValorVenda(Double.parseDouble(request.getParameter("valorVenda").replaceAll(",", ".")));
					produto.setValorCusto(Double.parseDouble(request.getParameter("valorCusto").replaceAll(",", ".")));
					produto.setCodigo(request.getParameter("codigo"));

					// Coletando cada parâmetro da página através do "name" do formulário, utilizando o 
					// request.getParameter() e atribuindo à entidade Estoque através dos setters

					// GUID - Global Unique Identifier (gera números randômicos)

					UUID guid = UUID.randomUUID();

					produto.setImagem(guid.toString() + ".jpg");

					// upload...
					// resgatar o campo imagem (file)

					Part imagem = request.getPart("imagem"); // arquivo

					// definir o local onde o arquivo será salvo

					// String pasta = getServletContext().getRealPath("/img/produtos");

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

					request.setAttribute("mensagem", "Produto " + produto.getNome() + " cadastrado com sucesso");

				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("pesquisar")) {

				try {
					
					String busca = request.getParameter("pesquisa");

					ProdutoDAO produtoDao = new ProdutoDAO();

					List<Produto> lista = produtoDao.findByName(busca);
					
					request.setAttribute("lista", lista);

				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("resultadosProduto.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("detalhesProduto")) {

				try {
					
					Integer idProduto = Integer.parseInt(request.getParameter("id"));

					ProdutoDAO produtoDao = new ProdutoDAO();

					Produto produto = produtoDao.findById(idProduto);

					FormataValor format = new FormataValor();
					
					request.setAttribute("produto", produto);


				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem", "Erro: " + e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("detalhesProduto.jsp").forward(request, response);

				}

			}
			
			else if (acao.equalsIgnoreCase("adicionarProduto")) {

				try {
					
					Integer idProduto = Integer.parseInt(request.getParameter("id"));

					ProdutoDAO produtoDao = new ProdutoDAO();

					Produto produto = produtoDao.findById(idProduto);

					FormataValor format = new FormataValor();
					
					request.setAttribute("produto", produto);


				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem", "Erro: " + e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("realizarPedido.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("realizarPedido")) {

				try {
					
					Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
					
					Integer quantidadePedida = Integer.parseInt(request.getParameter("quantidade"));
					
					Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
					
					Produto produto = new Produto();
					
					ProdutoDAO produtoDao = new ProdutoDAO();
					
					ClientePFDAO clientePfDao = new ClientePFDAO();
					
					produto = produtoDao.findById(idProduto);
					
					Integer quantidadeDisponivel = produto.getQuantidade();
					
					Pedido pedido = new Pedido();
					
					pedido.setCliente(clientePfDao.findById(idCliente));
					pedido.setProduto(produto);
					pedido.setQuantidade(quantidadePedida);
					
					if(quantidadeDisponivel >= quantidadePedida){
						
						PedidoDAO pedidoDao = new PedidoDAO();
						
						pedidoDao.insert(pedido);
						
						produto.setQuantidade(quantidadeDisponivel - quantidadePedida);
						
						ProdutoDAO produtoDao2 = new ProdutoDAO();
						
						produtoDao2.update(produto);
						
						System.out.println(produto.getQuantidade());
						
						request.setAttribute("mensagem", "Pedido realizado com sucesso.");
						
						request.setAttribute("produto", produto);
						
						request.setAttribute("pedido", pedido);
						
					}
					else{
						
						request.setAttribute("mensagem", "Quantidade indisponível em estoque.");
						
						request.setAttribute("produto", produto);
						
						request.setAttribute("pedido", pedido);
						
					}
					
					
					
				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro
					System.out.println("erro "+e);
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("pedidoRealizado.jsp").forward(request, response);

				}

			}
			
			else if (acao.equalsIgnoreCase("consultarPedidos")) {

				try {
					
					String cpf = request.getParameter("cpf");
					
					ClientePF clientePf = new ClientePF();
					
					ClientePFDAO clientePfDao = new ClientePFDAO();
					
					PedidoDAO pedidoDao = new PedidoDAO();
					
					ProdutoDAO produtoDao = new ProdutoDAO();
					
					clientePf = clientePfDao.findByCpf(cpf);
					
					ArrayList<Pedido> lista = pedidoDao.pedidosNaoFinalizadosPorCliente(clientePf.getIdCliente());
					
					Double valorTotal = 0.0;
					
					for(Pedido pedido : lista){
						
						Produto produto = new Produto();

						produto = produtoDao.findById(pedido.getProduto().getIdProduto());
						produto = pedido.getProduto();
						
						valorTotal += pedido.getQuantidade() * produto.getValorVenda();
						
					}
					
					FormataValor format = new FormataValor();
					
					String valorTotalFormatado = format.valorFormatado(valorTotal);
					
					if(lista != null){
						
						request.setAttribute("lista", lista);
						
						request.setAttribute("valorTotal", valorTotalFormatado);
						
					}
					else{
						
						request.setAttribute("mensagem", "Nenhum registro encontrado.");
						
					}
					
				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro
					System.out.println(""+e);
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes
					
					request.getRequestDispatcher("listagemPedido.jsp").forward(request, response);

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
