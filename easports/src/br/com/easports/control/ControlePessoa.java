package br.com.easports.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Endereco;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Pedido;
import br.com.easports.entities.PessoaFisica;
import br.com.easports.entities.Produto;
import br.com.easports.persistence.ClientePFDAO;
import br.com.easports.persistence.EnderecoDAO;
import br.com.easports.persistence.FornecedorDAO;
import br.com.easports.persistence.PedidoDAO;
import br.com.easports.persistence.ProdutoDAO;
import br.com.easports.util.ConverteData;
import br.com.easports.util.FormataValor;

// Servlet responsável por coletar as informações da página web e consultar no 
// banco de dados, via request - response

@WebServlet("/ControlePessoa")
public class ControlePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlePessoa() {
		super();
	}

	// método responsável por coletar as informações dos botões submit, nas
	// páginas JSP (Java Server Pages)

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Variável responsável por coletar a ação trazida pelo formulário e
		// executar o
		// método específico para seu tratamento

		String acao = request.getParameter("acao");

		// if/else responsável por comparar a ação trazida através do formulário
		// com as opções possíveis
		// de serem executadas pela página. Ex: cadastrar pessoa física,
		// consultar fornecedores,
		// cadastrar produtos etc...

		if (acao != null) {

			// Se o valor da ação recebida pelo formulário for "cadastrarpf",
			// execute o bloco abaixo:

			if (acao.equalsIgnoreCase("cadastrarpf")) {

				try {

					// Instanciando um novo Endereço para receber os parâmetros
					// passados pelo usuário
					// através da JSP

					Endereco endereco = new Endereco();

					// Coletando cada parâmetro da página através do "name" do
					// formulário, utilizando
					// o request.getParameter() e atribuindo à entidade Endereco
					// através dos setters

					endereco.setLogradouro(request.getParameter("logradouro"));
					endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
					endereco.setCep(request.getParameter("cep"));
					endereco.setBairro(request.getParameter("bairro"));
					endereco.setCidade(request.getParameter("cidade"));
					endereco.setEstado(request.getParameter("estado"));
					endereco.setPais(request.getParameter("pais"));

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Endereços no banco

					EnderecoDAO enderecoDao = new EnderecoDAO();

					// Utilizando o método que recebe como parâmetro um objeto
					// endereço, grava o
					// mesmo no banco e retorna seu id, criado automaticamente
					// pelo próprio SQL

					int idEndereço = enderecoDao.insertReturnID(endereco);

					// Instanciando um novo ClientePF para receber os parâmetros
					// passados pelo usuário
					// através da JSP

					ClientePF clientePf = new ClientePF();

					// Coletando cada parâmetro da página através do "name" do
					// formulário, utilizando
					// o request.getParameter() e atribuindo à entidade
					// ClientePF através dos setters

					clientePf.setNome(request.getParameter("nome"));
					clientePf.setTelefone(request.getParameter("telefone"));
					clientePf.setCpf(request.getParameter("cpf"));
					clientePf.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
					clientePf.setEndereco(endereco);

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Clientes no banco

					ClientePFDAO clientePfDao = new ClientePFDAO();

					// Utilizando o método responsável por receber como
					// parâmetro um ClientePF e um id de
					// Endereço, gravar o Cliente no banco e atribuir a ele este
					// Endereço, através da coluna
					// id_endereco, localizada na tabela cliente_pf

					clientePfDao.insert(clientePf, idEndereço);

					// retornando para a página, através do método
					// request.setAttribute(), uma mensagem de
					// sucesso após o cadastro do cliente

					request.setAttribute("mensagem", "Cliente " + clientePf.getNome() + " cadastrado com sucesso");

				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a
					// mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro
					// de clientes

					request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);

				}

			}

			// Se o valor da ação recebida pelo formulário for "consultarpf",
			// execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("consultarpf")) {

				try {

					// Coletando da página o parâmetro "cpf", através do "name"
					// do formulário, utilizando
					// o método request.getParameter()

					String cpf = request.getParameter("cpf");

					// Instanciando um novo ClientePF

					ClientePF cliente = new ClientePF();

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Clientes no banco

					ClientePFDAO clientePfDao = new ClientePFDAO();

					// Utilizando o método que recebe como parâmetro um número
					// de cpf e retorna os dados
					// do cliente a qual ele pertence

					cliente = clientePfDao.findByCpf(cpf);

					// Retornando para a página JSP o objeto cliente e
					// atribuindo a ele o nome "cliente"

					if (cliente.getIdCliente() == null) {
						request.setAttribute("mensagem", "Cliente não encontrado.");
					} else {
						request.setAttribute("cliente", cliente);
					}

				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a
					// mensagem de erro

					request.setAttribute("mensagem", e);

				} finally {

					// Redirecionando novamente para a mesma página de consulta
					// de clientes

					request.getRequestDispatcher("consultaCliente.jsp").forward(request, response);

				}

			}

			// Se o valor da ação recebida pelo formulário for
			// "cadastrarFornecedor", execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("cadastrarFornecedor")) {

				try {

					// Coletando cada parâmetro da página através do "name" do
					// formulário, utilizando
					// o request.getParameter() e atribuindo às variáveis

					String nome = request.getParameter("nome");
					String razaoSocial = request.getParameter("razaoSocial");
					String telefone = request.getParameter("telefone");
					String cnpj = request.getParameter("cnpj");
					String logradouro = request.getParameter("logradouro");
					Integer numero = Integer.parseInt(request.getParameter("numero"));
					String cep = request.getParameter("cep");
					String bairro = request.getParameter("bairro");
					String cidade = request.getParameter("cidade");
					String estado = request.getParameter("estado");
					String pais = request.getParameter("pais");

					// Instanciando um novo Endereco

					Endereco endereco = new Endereco();

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Enderecos no banco

					EnderecoDAO enderecoDao = new EnderecoDAO();

					// Utilizando os Setters da classe Endereco para passar
					// valores aos seus atributos

					endereco.setLogradouro(logradouro);
					endereco.setNumero(numero);
					endereco.setCep(cep);
					endereco.setBairro(bairro);
					endereco.setCidade(cidade);
					endereco.setEstado(estado);
					endereco.setPais(pais);

					// Utilizando o método que recebe como parâmetro um objeto
					// endereço, grava o
					// mesmo no banco e retorna seu id, criado automaticamente
					// pelo próprio SQL

					int idEndereco = enderecoDao.insertReturnID(endereco);

					// Instanciando um novo Fornecedor

					Fornecedor fornecedor = new Fornecedor();

					// Utilizando os Setters da classe Fornecedor para passar
					// valores aos seus atributos

					fornecedor.setNome(nome);
					fornecedor.setTelefone(telefone);
					fornecedor.setCnpj(cnpj);
					fornecedor.setRazaoSocial(razaoSocial);

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Fornecedores no banco

					FornecedorDAO fornecedorDao = new FornecedorDAO();

					// Utilizando o método responsável por receber como
					// parâmetro um Fornecedor e um id de
					// Endereço, gravar o Fornecedor no banco e atribuir a ele
					// este Endereço, através da coluna
					// id_endereco, localizada na tabela fornecedor

					fornecedorDao.insert(fornecedor, idEndereco);

					// retornando para a página, através do método
					// request.setAttribute(), uma mensagem de
					// sucesso após o cadastro do fornecedor

					request.setAttribute("mensagem", "Fornecedor " + fornecedor.getNome() + " cadastrado com sucesso.");

				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a
					// mensagem de erro

					request.setAttribute("mensagem", "Erro: " + e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro
					// de fornecedores

					request.getRequestDispatcher("cadastroFornecedor.jsp").forward(request, response);

				}

			}

			// Se o valor da ação recebida pelo formulário for
			// "consultarFornecedor", execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("consultarFornecedor")) {

				try {

					// Coletando da página o parâmetro "cnpj", através do "name"
					// do formulário, utilizando
					// o método request.getParameter()

					String cnpj = request.getParameter("cnpj");

					// Instanciando um novo Fornecedor

					Fornecedor fornecedor = new Fornecedor();

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Fornecedores no banco

					FornecedorDAO fornecedorDao = new FornecedorDAO();

					// Utilizando o método que recebe como parâmetro um número
					// de cnpj e retorna os dados
					// do fornecedor a qual ele pertence

					fornecedor = fornecedorDao.findByCnpj(cnpj);

					// Instanciando um novo Endereco

					Endereco endereco = new Endereco();

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Endereços no banco

					EnderecoDAO enderecoDao = new EnderecoDAO();

					// Utilizando o método que recebe como parâmetro o id de um
					// Endereco e retorna os dados
					// do mesmo gravados no banco. Para isso, utilizamos o
					// getEndereco do fornecedor para encontrar
					// seu endereço e, por fim, o método getId do endereço, para
					// encontrar seu id

					endereco = enderecoDao.findById(fornecedor.getEndereco().getId_endereco());

					// Atribuindo o endereço encontrado ao fornecedor

					fornecedor.setEndereco(endereco);

					// Retornando para a página JSP o objeto fornecedor e
					// atribuindo a ele o nome "fornecedor"

					request.setAttribute("fornecedor", fornecedor);

				} catch (Exception e) {

					// Caso o método caia no catch, retorne para a página a
					// mensagem de erro

					request.setAttribute("mensagem", "Fornecedor não encontrado.");

				} finally {

					// Redirecionando novamente para a mesma página de consulta
					// de fornecedores

					request.getRequestDispatcher("consultaFornecedor.jsp").forward(request, response);

				}

			} else if (acao.equalsIgnoreCase("cadastrarfuncionario")) {

				try {
					// Instanciando um novo Endereço para receber os parâmetros
					// passados pelo usuário
					// através da JSP

					Endereco endereco = new Endereco(); 

					// Coletando cada parâmetro da página através do "name" do
					// formulário, utilizando
					// o request.getParameter() e atribuindo à entidade Endereco
					// através dos setters

					endereco.setLogradouro(request.getParameter("logradouro"));
					endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
					endereco.setCep(request.getParameter("cep"));
					endereco.setBairro(request.getParameter("bairro"));
					endereco.setCidade(request.getParameter("cidade"));
					endereco.setEstado(request.getParameter("estado"));
					endereco.setPais(request.getParameter("pais"));

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Endereços no banco

					EnderecoDAO enderecoDao = new EnderecoDAO();

					// Utilizando o método que recebe como parâmetro um objeto
					// endereço, grava o
					// mesmo no banco e retorna seu id, criado automaticamente
					// pelo próprio SQL

					int idEndereço = enderecoDao.insertReturnID(endereco);

					String nome = request.getParameter("nome");
					String telefone = request.getParameter("telefone");
					String cpf = request.getParameter("cpf");
					String dataNasc = request.getParameter("datanasc");
					String departamento = request.getParameter("departamento");
					String cargo = request.getParameter("cargo");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
