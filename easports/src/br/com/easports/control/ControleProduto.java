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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.plaf.synth.SynthSliderUI;

import br.com.easports.entities.Categoria;
import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Funcionario;
import br.com.easports.entities.Pedido;
import br.com.easports.entities.Produto;
import br.com.easports.entities.Venda;
import br.com.easports.persistence.CategoriaDAO;
import br.com.easports.persistence.ClientePFDAO;
import br.com.easports.persistence.FornecedorDAO;
import br.com.easports.persistence.PedidoDAO;
import br.com.easports.persistence.ProdutoDAO;
import br.com.easports.persistence.VendaDAO;
import br.com.easports.util.ConverteData;
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

					//Notebook Diego -> System.getProperty("user.home") + "\\Desktop\\PI\\easports\\EASPORTS\\easports\\WebContent\\img";
					
					//String pasta = System.getProperty("user.home") + "\\Desktop\\PI\\easports\\EASPORTS\\easports\\WebContent\\img";
					
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
					
					FormataValor format = new FormataValor();
					
					Double valorTotalCompra = 0.0;
					
					for(Pedido pedido : lista){
						
						Produto produto = new Produto();

						produto = pedido.getProduto();
						
						pedido.setValorTotalFormatado(format.valorFormatado(pedido.getQuantidade() * produto.getValorVenda()));
						
						valorTotalCompra += pedido.getQuantidade() * produto.getValorVenda();
						
					}
					
					String valorTotalFormatado = format.valorFormatado(valorTotalCompra);
					
					if(lista != null){
						
						request.setAttribute("lista", lista);
						
						request.setAttribute("cpf", cpf);
						
						request.setAttribute("valorTotal", valorTotalFormatado);
						
					}else{
						
						request.setAttribute("mensagem", "Nenhum registro encontrado.");
						
					}
					
				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes
					
					request.getRequestDispatcher("consultaPedido.jsp").forward(request, response);

				}

			}
			
			else if (acao.equalsIgnoreCase("visualizarPedido")) {

				try {
					
					Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));

					PedidoDAO pedidoDao = new PedidoDAO();
					
					Pedido pedido = new Pedido();
					
					pedido = pedidoDao.findById(idPedido);
					
					request.setAttribute("pedido", pedido);
					
				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro
					
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes
					
					request.getRequestDispatcher("edicaoPedido.jsp").forward(request, response);

				}
			}
			
			else if (acao.equalsIgnoreCase("editarPedido")) {

				try {
					
					Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));

					Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
					
					Integer novaQuantidade = Integer.parseInt(request.getParameter("quantidade"));
					
					PedidoDAO pedidoDao = new PedidoDAO();
					
					Pedido pedido = new Pedido();
					
					pedido = pedidoDao.findById(idPedido);
					
					pedidoDao = new PedidoDAO();
					
					Produto produto = new Produto();
					
					ProdutoDAO produtoDao = new ProdutoDAO();
					
					produto = produtoDao.findById(idProduto);
					
					Integer diferenca = 0;
					
					if(novaQuantidade >= pedido.getQuantidade()){
						
						diferenca = novaQuantidade - pedido.getQuantidade();
						
						if(produto.getQuantidade() >= diferenca){
							
							produto.setQuantidade(produto.getQuantidade() - diferenca);
							
							pedido.setQuantidade(novaQuantidade);
							
							produtoDao = new ProdutoDAO();
							
							pedidoDao = new PedidoDAO();
							
							pedidoDao.update(pedido);
							
							produtoDao.update(produto);
							
							request.setAttribute("pedido", pedido);
							
							request.setAttribute("produto", produto);
							
							request.setAttribute("mensagem", "Pedido nº " + pedido.getIdPedido() + " atualizado com sucesso.");
							
						}
						else{
							
							request.setAttribute("pedido", pedido);
							
							request.setAttribute("mensagem", "Quantidade indisponível.");
							
						}
						
					}else{
						
						diferenca = pedido.getQuantidade() - novaQuantidade;
						
						produto.setQuantidade(produto.getQuantidade() + diferenca);
						
						pedido.setQuantidade(novaQuantidade);
						
						produtoDao = new ProdutoDAO();
						
						pedidoDao = new PedidoDAO();
						
						pedidoDao.update(pedido);
						
						produtoDao.update(produto);
						
						request.setAttribute("pedido", pedido);
						
						request.setAttribute("produto", produto);
						
						request.setAttribute("mensagem", "Pedido nº " + pedido.getIdPedido() + " atualizado com sucesso.");
						
					}
					
				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro
					
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes
					
					request.getRequestDispatcher("edicaoPedido.jsp").forward(request, response);

				}
			}
			
			else if (acao.equalsIgnoreCase("excluirPedido")) {

				try {
					
					Integer idPedido = Integer.parseInt(request.getParameter("idPedido"));
					Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
					
					PedidoDAO pedidoDao = new PedidoDAO();
				
					Pedido pedidoRealizado = new Pedido();
					
					pedidoRealizado = pedidoDao.findById(idPedido);
					
					Integer quantidade = pedidoRealizado.getQuantidade();
					Produto produto = new Produto();
					
					ProdutoDAO produtoDao = new ProdutoDAO();
					Integer idProduto = pedidoRealizado.getProduto().getIdProduto();
					
					produto = produtoDao.findById(idProduto);
					
					produto.setQuantidade(produto.getQuantidade() + quantidade);
					produtoDao = new ProdutoDAO();
					produtoDao.update(produto);
					pedidoDao = new PedidoDAO();
					pedidoDao.delete(idPedido);
					
					pedidoDao = new PedidoDAO();

					ArrayList<Pedido> listaPedidos = pedidoDao.pedidosNaoFinalizadosPorCliente(idCliente);
					
					FormataValor format = new FormataValor();
					
					Double valorTotal = 0.0;
					
					for(Pedido pedido : listaPedidos){
						
						valorTotal += pedido.getProduto().getValorVenda() * pedido.getQuantidade();
						
						pedido.setValorTotalFormatado(format.valorFormatado(pedido.getProduto().getValorVenda() * pedido.getQuantidade()));
						
					}
					
					String valorTotalFormatado = format.valorFormatado(valorTotal);
					
					request.setAttribute("mensagem", "Pedido ID: " + idPedido + ", excluído com sucesso.");
					
					request.setAttribute("lista", listaPedidos);
					
					request.setAttribute("valorTotal", valorTotalFormatado);
					
				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("consultaPedido.jsp").forward(request, response);

				}
			}
			
			else if (acao.equalsIgnoreCase("finalizarPedidos")) {

				try {
					
					//estancioando uma nova venda
					Venda venda = new Venda();
					
					//pegando o usuario logado na sessão
					
					HttpSession session = request.getSession();
					
					Funcionario funcionadoLogado = (Funcionario) session.getAttribute("usuarioLogado");
					
					Integer idFuncionario = funcionadoLogado.getIdFuncionario();
					
					venda.setDataVenda(ConverteData.getDataAtual());
					
					VendaDAO vendaDao = new VendaDAO();
					
					int idVenda = vendaDao.insertreturnID(venda,idFuncionario);
					
					String cpf = request.getParameter("cpf");
					
					ClientePFDAO clientePfDao = new ClientePFDAO();
					
					ClientePF clientePf = new ClientePF();
					
					clientePf = clientePfDao.findByCpf(cpf);
					
					PedidoDAO pedidoDao = new PedidoDAO();
					
					pedidoDao.finalizaPedidos(clientePf.getIdCliente(), idVenda);
					
					request.setAttribute("mensagem", "Pedidos finalizados com sucesso");
					
				} catch (Exception e) {
					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("consultaPedido.jsp").forward(request, response);

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
