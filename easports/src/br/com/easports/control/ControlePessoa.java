package br.com.easports.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Endereco;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Funcionario;
import br.com.easports.persistence.ClientePFDAO;
import br.com.easports.persistence.EnderecoDAO;
import br.com.easports.persistence.FornecedorDAO;
import br.com.easports.persistence.FuncionarioDAO;
import br.com.easports.util.ConverteData;
import br.com.easports.util.WebServiceCep;

// Servlet respons�vel por coletar as informa��es da p�gina web e consultar no
// banco de dados, via request - response

@WebServlet("/ControlePessoa")
public class ControlePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;

	public ControlePessoa() {
		super();
	}

	// m�todo respons�vel por coletar as informa��es dos bot�es submit, nas
	// p�ginas JSP (Java Server Pages)

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		// Vari�vel respons�vel por coletar a a��o trazida pelo formul�rio e
		// executar o
		// m�todo espec�fico para seu tratamento

		final String acao = request.getParameter("acao");

		// if/else respons�vel por comparar a a��o trazida atrav�s do formul�rio
		// com as op��es poss�veis
		// de serem executadas pela p�gina. Ex: cadastrar pessoa f�sica,
		// consultar fornecedores,
		// cadastrar produtos etc...

		if (acao != null) {

			// Se o valor da a��o recebida pelo formul�rio for "cadastrarpf",
			// execute o bloco abaixo:

			if (acao.equalsIgnoreCase("cadastrarpf")) {

				try {

					ClientePFDAO clientePfDao = new ClientePFDAO();

					final ClientePF clientePF = clientePfDao.findByCpf(request.getParameter("cpf"));

					if (clientePF.getNome() == null || clientePF.getNome() == "") {

						// Instanciando um novo Endere�o para receber os par�metros
						// passados pelo usu�rio
						// atrav�s da JSP
						final Endereco endereco = new Endereco();

						// Coletando cada par�metro da p�gina atrav�s do "name" do
						// formul�rio, utilizando
						// o request.getParameter() e atribuindo � entidade Endereco
						// atrav�s dos setters

						endereco.setLogradouro(request.getParameter("logradouro"));
						endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
						endereco.setCep(request.getParameter("cep"));
						endereco.setBairro(request.getParameter("bairro"));
						endereco.setCidade(request.getParameter("cidade"));
						endereco.setEstado(request.getParameter("estado"));
						endereco.setPais(request.getParameter("pais"));

						// Instanciando a classe respons�vel por gravar, alterar e
						// excluir Endere�os no banco

						final EnderecoDAO enderecoDao = new EnderecoDAO();

						// Utilizando o m�todo que recebe como par�metro um objeto
						// endere�o, grava o
						// mesmo no banco e retorna seu id, criado automaticamente
						// pelo pr�prio SQL

						final int idEndereco = enderecoDao.insertReturnID(endereco);

						// Instanciando um novo ClientePF para receber os par�metros
						// passados pelo usu�rio
						// atrav�s da JSP

						final ClientePF clientePf = new ClientePF();

						// Coletando cada par�metro da p�gina atrav�s do "name" do
						// formul�rio, utilizando
						// o request.getParameter() e atribuindo � entidade
						// ClientePF atrav�s dos setters

						clientePf.setNome(request.getParameter("nome"));
						clientePf.setTelefone(request.getParameter("telefone"));
						clientePf.setCpf(request.getParameter("cpf"));
						clientePf.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
						clientePf.setEndereco(endereco);

						// Instanciando a classe respons�vel por gravar, alterar e
						// excluir Clientes no banco

						clientePfDao = new ClientePFDAO();

						// Utilizando o m�todo respons�vel por receber como
						// par�metro um ClientePF e um id de
						// Endere�o, gravar o Cliente no banco e atribuir a ele este
						// Endere�o, atrav�s da coluna
						// id_endereco, localizada na tabela cliente_pf

						clientePfDao.insert(clientePf, idEndereco);

						// retornando para a p�gina, atrav�s do m�todo
						// request.setAttribute(), uma mensagem de
						// sucesso ap�s o cadastro do cliente

						request.setAttribute("mensagem", "Cliente " + clientePf.getNome() + " cadastrado com sucesso");

					} else {
						request.setAttribute("mensagem2", "CPF *" + request.getParameter("cpf") + "* j� cadastrado em nosso sistema");
					}
				} catch (final Exception e) {

					// Caso o m�todo caia no catch, retorne para a p�gina a
					// mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma p�gina de cadastro
					// de clientes

					request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);

				}

			}

			// Se o valor da a��o recebida pelo formul�rio for "consultarpf",
			// execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("consultarpf")) {

				try {

					// Coletando da p�gina o par�metro "cpf", atrav�s do "name"
					// do formul�rio, utilizando
					// o m�todo request.getParameter()

					final String cpf = request.getParameter("cpf");

					// Instanciando um novo ClientePF

					ClientePF cliente = new ClientePF();

					// Instanciando a classe respons�vel por gravar, alterar e
					// excluir Clientes no banco

					final ClientePFDAO clientePfDao = new ClientePFDAO();

					// Utilizando o m�todo que recebe como par�metro um n�mero
					// de cpf e retorna os dados
					// do cliente a qual ele pertence

					cliente = clientePfDao.findByCpf(cpf);

					// Retornando para a p�gina JSP o objeto cliente e
					// atribuindo a ele o nome "cliente"

					if (cliente.getIdCliente() == null) {
						request.setAttribute("mensagem", "Cliente n�o encontrado.");
					} else {
						request.setAttribute("cliente", cliente);
					}

				} catch (final Exception e) {

					// Caso o m�todo caia no catch, retorne para a p�gina a
					// mensagem de erro

					request.setAttribute("mensagem", e);

				} finally {

					// Redirecionando novamente para a mesma p�gina de consulta
					// de clientes

					request.getRequestDispatcher("consultaCliente.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("consultarFuncionario")) {

				try {

					final String cpf = request.getParameter("cpf");

					Funcionario funcionario = null;

					final FuncionarioDAO funcionarioDao = new FuncionarioDAO();

					funcionario = funcionarioDao.findByCpf(cpf);

					if (funcionario == null) {
						request.setAttribute("mensagem", "Funcion�rio n�o encontrado.");
					} else {
						request.setAttribute("funcionario", funcionario);
					}

				} catch (final Exception e) {

					request.setAttribute("mensagem", e);

				} finally {

					request.getRequestDispatcher("consultaFuncionario.jsp").forward(request, response);

				}

			}

			// Se o valor da a��o recebida pelo formul�rio for
			// "cadastrarFornecedor", execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("cadastrarFornecedor")) {

				try {

					final FornecedorDAO fornecedorDAO = new FornecedorDAO();
					Fornecedor fornecedor = fornecedorDAO.findByCnpj(request.getParameter("cnpj"));

					if (fornecedor.getNome() == null || fornecedor.getNome() == "") {

						// Coletando cada par�metro da p�gina atrav�s do "name" do
						// formul�rio, utilizando
						// o request.getParameter() e atribuindo �s vari�veis

						final String nome = request.getParameter("nome");
						final String razaoSocial = request.getParameter("razaoSocial");
						final String telefone = request.getParameter("telefone");
						final String cnpj = request.getParameter("cnpj");
						final String logradouro = request.getParameter("logradouro");
						final Integer numero = Integer.parseInt(request.getParameter("numero"));
						final String cep = request.getParameter("cep");
						final String bairro = request.getParameter("bairro");
						final String cidade = request.getParameter("cidade");
						final String estado = request.getParameter("estado");
						final String pais = request.getParameter("pais");

						// Instanciando um novo Endereco

						final Endereco endereco = new Endereco();

						// Instanciando a classe respons�vel por gravar, alterar e
						// excluir Enderecos no banco

						final EnderecoDAO enderecoDao = new EnderecoDAO();

						// Utilizando os Setters da classe Endereco para passar
						// valores aos seus atributos

						endereco.setLogradouro(logradouro);
						endereco.setNumero(numero);
						endereco.setCep(cep);
						endereco.setBairro(bairro);
						endereco.setCidade(cidade);
						endereco.setEstado(estado);
						endereco.setPais(pais);

						// Utilizando o m�todo que recebe como par�metro um objeto
						// endere�o, grava o
						// mesmo no banco e retorna seu id, criado automaticamente
						// pelo pr�prio SQL

						final int idEndereco = enderecoDao.insertReturnID(endereco);

						// Instanciando um novo Fornecedor

						fornecedor = new Fornecedor();

						// Utilizando os Setters da classe Fornecedor para passar
						// valores aos seus atributos

						fornecedor.setNome(nome);
						fornecedor.setTelefone(telefone);
						fornecedor.setCnpj(cnpj);
						fornecedor.setRazaoSocial(razaoSocial);

						// Instanciando a classe respons�vel por gravar, alterar e
						// excluir Fornecedores no banco

						final FornecedorDAO fornecedorDao = new FornecedorDAO();

						// Utilizando o m�todo respons�vel por receber como
						// par�metro um Fornecedor e um id de
						// Endere�o, gravar o Fornecedor no banco e atribuir a ele
						// este Endere�o, atrav�s da coluna
						// id_endereco, localizada na tabela fornecedor

						fornecedorDao.insert(fornecedor, idEndereco);

						// retornando para a p�gina, atrav�s do m�todo
						// request.setAttribute(), uma mensagem de
						// sucesso ap�s o cadastro do fornecedor

						request.setAttribute("mensagem", "Fornecedor " + fornecedor.getNome() + " cadastrado com sucesso.");
					} else {
						request.setAttribute("mensagem2", "CNPJ *" + request.getParameter("cnpj") + "* j� cadastrado em nosso sistema");
					}
				} catch (final Exception e) {

					// Caso o m�todo caia no catch, retorne para a p�gina a
					// mensagem de erro

					request.setAttribute("mensagem", "Erro: " + e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma p�gina de cadastro
					// de fornecedores

					request.getRequestDispatcher("cadastroFornecedor.jsp").forward(request, response);

				}

			}

			// Se o valor da a��o recebida pelo formul�rio for
			// "consultarFornecedor", execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("consultarFornecedor")) {

				try {

					// Coletando da p�gina o par�metro "cnpj", atrav�s do "name"
					// do formul�rio, utilizando
					// o m�todo request.getParameter()

					final String cnpj = request.getParameter("cnpj");

					// Instanciando um novo Fornecedor

					Fornecedor fornecedor = new Fornecedor();

					// Instanciando a classe respons�vel por gravar, alterar e
					// excluir Fornecedores no banco

					final FornecedorDAO fornecedorDao = new FornecedorDAO();

					// Utilizando o m�todo que recebe como par�metro um n�mero
					// de cnpj e retorna os dados
					// do fornecedor a qual ele pertence

					fornecedor = fornecedorDao.findByCnpj(cnpj);

					// Instanciando um novo Endereco

					Endereco endereco = new Endereco();

					// Instanciando a classe respons�vel por gravar, alterar e
					// excluir Endere�os no banco

					final EnderecoDAO enderecoDao = new EnderecoDAO();

					// Utilizando o m�todo que recebe como par�metro o id de um
					// Endereco e retorna os dados
					// do mesmo gravados no banco. Para isso, utilizamos o
					// getEndereco do fornecedor para encontrar
					// seu endere�o e, por fim, o m�todo getId do endere�o, para
					// encontrar seu id

					endereco = enderecoDao.findById(fornecedor.getEndereco().getId_endereco());

					// Atribuindo o endere�o encontrado ao fornecedor

					fornecedor.setEndereco(endereco);

					// Retornando para a p�gina JSP o objeto fornecedor e
					// atribuindo a ele o nome "fornecedor"

					request.setAttribute("fornecedor", fornecedor);

				} catch (final Exception e) {

					// Caso o m�todo caia no catch, retorne para a p�gina a
					// mensagem de erro

					request.setAttribute("mensagem", "Fornecedor n�o encontrado.");

				} finally {

					// Redirecionando novamente para a mesma p�gina de consulta
					// de fornecedores

					request.getRequestDispatcher("consultaFornecedor.jsp").forward(request, response);

				}

			} else if (acao.equalsIgnoreCase("cadastrarfuncionario")) {

				try {

					final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					Funcionario funcionario = funcionarioDAO.findByCpf(request.getParameter("cpf"));

					if (funcionario.getNome() == null || funcionario.getNome() == "") {
						// Instanciando um novo Endere�o para receber os par�metros
						// passados pelo usu�rio
						// atrav�s da JSP

						final Endereco endereco = new Endereco();

						// Coletando cada par�metro da p�gina atrav�s do "name" do
						// formul�rio, utilizando
						// o request.getParameter() e atribuindo � entidade Endereco
						// atrav�s dos setters

						endereco.setLogradouro(request.getParameter("logradouro"));
						endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
						endereco.setCep(request.getParameter("cep"));
						endereco.setBairro(request.getParameter("bairro"));
						endereco.setCidade(request.getParameter("cidade"));
						endereco.setEstado(request.getParameter("estado"));
						endereco.setPais(request.getParameter("pais"));

						// Instanciando a classe respons�vel por gravar, alterar e
						// excluir Endere�os no banco

						final EnderecoDAO enderecoDao = new EnderecoDAO();

						// Utilizando o m�todo que recebe como par�metro um objeto
						// endere�o, grava o
						// mesmo no banco e retorna seu id, criado automaticamente
						// pelo pr�prio SQL

						final Integer idEndereco = enderecoDao.insertReturnID(endereco);

						final Integer departamento = Integer.parseInt(request.getParameter("departamento"));
						final Integer cargo = Integer.parseInt(request.getParameter("cargo"));

						funcionario = new Funcionario();

						funcionario.setNome(request.getParameter("nome"));
						funcionario.setTelefone(request.getParameter("telefone"));
						funcionario.setCpf(request.getParameter("cpf"));
						funcionario.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
						funcionario.setSenha(request.getParameter("senha"));
						funcionario.setEndereco(endereco);

						final FuncionarioDAO funcionarioDAO2 = new FuncionarioDAO();
						funcionarioDAO2.insert(funcionario, idEndereco, departamento, cargo);

						request.setAttribute("mensagem", "Funcion�rio " + funcionario.getNome() + " cadastrado com sucesso");
					} else {
						request.setAttribute("mensagem2", "CPF *" + request.getParameter("cpf") + "* j� cadastrado em nosso sistema");
					}
				} catch (final Exception e) {
					request.setAttribute("mensagem", e.getMessage());
					e.printStackTrace();
				} finally {
					request.getRequestDispatcher("cadastroFuncionario.jsp").forward(request, response);
				}
			}

			else if (acao.equalsIgnoreCase("autenticar")) {

				String destino = "login.jsp";

				try {

					final String cpf = request.getParameter("cpf");
					final String senha = request.getParameter("senha");

					final FuncionarioDAO funcionarioDao = new FuncionarioDAO();

					final Funcionario funcionario = funcionarioDao.findByLoginSenha(cpf, senha);

					if (funcionario != null) {

						session = request.getSession();

						session.setAttribute("usuarioLogado", funcionario);

						request.setAttribute("usuarioLogado", funcionario);

						destino = "index.jsp";

					} else {

						throw new Exception("Acesso negado, tente novamente.");

					}

				} catch (final Exception e) {

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					request.getRequestDispatcher(destino).forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("logout")) {

				final HttpSession session = request.getSession();

				session.invalidate();

				response.sendRedirect("/easports/login.jsp");

			} else if (acao.equalsIgnoreCase("consultaCep")) {
				final String cep = request.getParameter("cep");
				Endereco endereco = new Endereco();
				endereco = WebServiceCep.buscaCep(cep);

				request.setAttribute("endereco", endereco);
				request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);

				// Se o valor da açao recebida pelo formulario for "editarPessoa",
				// execute o bloco abaixo:

			} else if (acao.equalsIgnoreCase("editarPessoa")) {

				try {

					// Instanciando a classe respons�vel por gravar, alterar e
					// excluir Clientes no banco
					final ClientePFDAO clientePfDao = new ClientePFDAO();

					// Instanciando a classe respons�vel por gravar, alterar e
					// excluir endereços no banco
					final EnderecoDAO enderecoDao = new EnderecoDAO();

					// Recebe o cliente ao ser alterado pelo cpf
					final ClientePF clientePF = clientePfDao.findByCpf(request.getParameter("cpf"));
					final Endereco endereco = clientePF.getEndereco();

					// altera o endereço do cliente
					endereco.setId_endereco(clientePF.getEndereco().getId_endereco());
					endereco.setLogradouro(request.getParameter("logradouro"));
					endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
					endereco.setCep(request.getParameter("cep"));
					endereco.setBairro(request.getParameter("bairro"));
					endereco.setCidade(request.getParameter("cidade"));
					endereco.setEstado(request.getParameter("estado"));
					endereco.setPais(request.getParameter("pais"));

					// altualiza o endereço
					enderecoDao.update(endereco);

					// altera os dados do cliente

					clientePF.setTelefone(request.getParameter("telefone"));
					clientePF.setNome(request.getParameter("nome"));
					clientePF.setEndereco(endereco);
					clientePF.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
					// atualiza o cliente
					clientePfDao.update(clientePF);

					request.setAttribute("mensagem", "Cliente " + clientePF.getNome() + " Alterado com sucesso");

				} catch (final Exception e) {

					// Caso o m�todo caia no catch, retorne para a p�gina a
					// mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma p�gina de cadastro
					// de clientes

					request.getRequestDispatcher("consultaCliente.jsp").forward(request, response);

				}

			}
		}

	}

}
