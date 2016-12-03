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
import br.com.easports.util.FormataValor;
import br.com.easports.util.WebServiceCep;

// Servlet responsï¿½vel por coletar as informaï¿½ï¿½es da pï¿½gina web e consultar no
// banco de dados, via request - response

@WebServlet("/ControlePessoa")
public class ControlePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;

	public ControlePessoa() {
		super();
	}

	// mï¿½todo responsï¿½vel por coletar as informaï¿½ï¿½es dos botï¿½es
	// submit, nas
	// pï¿½ginas JSP (Java Server Pages)

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		// Variável responsável por coletar a ação trazida pelo formulário e executar o
		// método específico para seu tratamento

		final String acao = request.getParameter("acao");

		// if/else responsável por comparar a ação trazida através do formulário
		// com as opções possáveis de serem executadas pela página. Ex: cadastrar 
		// pessoa física, consultar fornecedores, cadastrar produtos etc...

		if (acao != null) {

			// Se o valor da ação recebida pelo formulário for "cadastrarpf",
			// execute o bloco abaixo:

			if (acao.equalsIgnoreCase("cadastrarpf")) {

				try {

					ClientePFDAO clientePfDao = new ClientePFDAO();

					final ClientePF clientePF = clientePfDao.findByCpf(request.getParameter("cpf"));

					if (clientePF.getNome() == null || clientePF.getNome() == "") {

						// Instanciando um novo Endereço para receber os parâetros passados pelo usuário
						// através da JSP
						final Endereco endereco = new Endereco();

						// Coletando cada parâmetro da página através do "name" do formulário, 
						// utilizando o request.getParameter() e atribuindo à entidade Endereco
						// através dos setters

						endereco.setLogradouro(request.getParameter("logradouro"));
						endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
						endereco.setCep(request.getParameter("cep"));
						endereco.setBairro(request.getParameter("bairro"));
						endereco.setCidade(request.getParameter("cidade"));
						endereco.setEstado(request.getParameter("estado"));
						endereco.setPais(request.getParameter("pais"));

						// Instanciando a classe responsáel por gravar, alterar e
						// excluir Endereços no banco

						final EnderecoDAO enderecoDao = new EnderecoDAO();

						// Utilizando o método que recebe como parâmetro um objeto 
						// endereço, grava o mesmo no banco e retorna seu id, criado
						// automaticamente pelo próprio SQL

						final int idEndereco = enderecoDao.insertReturnID(endereco);

						// Instanciando um novo ClientePF para receber os
						// parï¿½metros
						// passados pelo usuï¿½rio
						// atravï¿½s da JSP

						final ClientePF clientePf = new ClientePF();

						// Coletando cada parï¿½metro da pï¿½gina atravï¿½s do
						// "name" do
						// formulï¿½rio, utilizando
						// o request.getParameter() e atribuindo ï¿½ entidade
						// ClientePF atravï¿½s dos setters

						clientePf.setNome(request.getParameter("nome"));
						clientePf.setTelefone(request.getParameter("telefone"));
						clientePf.setCpf(request.getParameter("cpf"));
						clientePf.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
						clientePf.setEndereco(endereco);

						// Instanciando a classe responsï¿½vel por gravar,
						// alterar e
						// excluir Clientes no banco

						clientePfDao = new ClientePFDAO();

						// Utilizando o mï¿½todo responsï¿½vel por receber como
						// parï¿½metro um ClientePF e um id de
						// Endereï¿½o, gravar o Cliente no banco e atribuir a
						// ele este
						// Endereï¿½o, atravï¿½s da coluna
						// id_endereco, localizada na tabela cliente_pf

						clientePfDao.insert(clientePf, idEndereco);

						// retornando para a pï¿½gina, atravï¿½s do mï¿½todo
						// request.setAttribute(), uma mensagem de
						// sucesso apï¿½s o cadastro do cliente

						request.setAttribute("mensagem", "Cliente " + clientePf.getNome() + " cadastrado com sucesso");

					} else {
						request.setAttribute("mensagem2",
								"CPF *" + request.getParameter("cpf") + "* já cadastrado no sistema");
					}
				} catch (final Exception e) {

					// Caso o mï¿½todo caia no catch, retorne para a pï¿½gina a
					// mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma pï¿½gina de
					// cadastro
					// de clientes

					request.getRequestDispatcher("/areaRestrita/cadastroCliente.jsp").forward(request, response);

				}

			}

			// Se o valor da aï¿½ï¿½o recebida pelo formulï¿½rio for
			// "consultarpf",
			// execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("consultarpf")) {

				try {

					// Coletando da pï¿½gina o parï¿½metro "cpf", atravï¿½s do
					// "name"
					// do formulï¿½rio, utilizando
					// o mï¿½todo request.getParameter()

					final String cpf = request.getParameter("cpf");

					// Instanciando um novo ClientePF

					ClientePF cliente = new ClientePF();

					// Instanciando a classe responsï¿½vel por gravar, alterar e
					// excluir Clientes no banco

					final ClientePFDAO clientePfDao = new ClientePFDAO();

					// Utilizando o mï¿½todo que recebe como parï¿½metro um
					// nï¿½mero
					// de cpf e retorna os dados
					// do cliente a qual ele pertence

					cliente = clientePfDao.findByCpf(cpf);

					// Retornando para a pï¿½gina JSP o objeto cliente e
					// atribuindo a ele o nome "cliente"

					if (cliente.getIdCliente() == null) {
						request.setAttribute("mensagem", "Cliente não encontrado.");
					} else {
						request.setAttribute("cliente", cliente);
					}

				} catch (final Exception e) {

					// Caso o mï¿½todo caia no catch, retorne para a pï¿½gina a
					// mensagem de erro

					request.setAttribute("mensagem", e);

				} finally {

					// Redirecionando novamente para a mesma pï¿½gina de
					// consulta
					// de clientes

					request.getRequestDispatcher("/areaRestrita/consultaCliente.jsp").forward(request, response);

				}

			}

			if (acao.equalsIgnoreCase("excluirpf")) {

				try {

					Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));

					ClientePFDAO clientePfDao = new ClientePFDAO();

					clientePfDao.delete(idCliente);

					request.setAttribute("mensagem", "Cliente excluído com sucesso.");

				} catch (final Exception e) {

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					request.getRequestDispatcher("/areaRestrita/relatorioClientes.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("consultarFuncionario")) {

				try {

					final String cpf = request.getParameter("cpf");

					Funcionario funcionario = null;

					final FuncionarioDAO funcionarioDao = new FuncionarioDAO();

					funcionario = funcionarioDao.findByCpf(cpf);

					if (funcionario == null) {
						request.setAttribute("mensagem", "Funcionário não encontrado.");
					} else {
						request.setAttribute("funcionario", funcionario);
					}

				} catch (final Exception e) {

					request.setAttribute("mensagem", e);

				} finally {

					request.getRequestDispatcher("/areaRestrita/consultaFuncionario.jsp").forward(request, response);

				}

			}

			// Se o valor da aï¿½ï¿½o recebida pelo formulï¿½rio for
			// "cadastrarFornecedor", execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("cadastrarFornecedor")) {

				try {

					final FornecedorDAO fornecedorDAO = new FornecedorDAO();
					Fornecedor fornecedor = fornecedorDAO.findByCnpj(request.getParameter("cnpj"));

					if (fornecedor.getNome() == null || fornecedor.getNome() == "") {

						// Coletando cada parï¿½metro da pï¿½gina atravï¿½s do
						// "name" do
						// formulï¿½rio, utilizando
						// o request.getParameter() e atribuindo ï¿½s
						// variï¿½veis

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

						// Instanciando a classe responsï¿½vel por gravar,
						// alterar e
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

						// Utilizando o mï¿½todo que recebe como parï¿½metro um
						// objeto
						// endereï¿½o, grava o
						// mesmo no banco e retorna seu id, criado
						// automaticamente
						// pelo prï¿½prio SQL

						final int idEndereco = enderecoDao.insertReturnID(endereco);

						// Instanciando um novo Fornecedor

						fornecedor = new Fornecedor();

						// Utilizando os Setters da classe Fornecedor para
						// passar
						// valores aos seus atributos

						fornecedor.setNome(nome);
						fornecedor.setTelefone(telefone);
						fornecedor.setCnpj(cnpj);
						fornecedor.setRazaoSocial(razaoSocial);

						// Instanciando a classe responsï¿½vel por gravar,
						// alterar e
						// excluir Fornecedores no banco

						final FornecedorDAO fornecedorDao = new FornecedorDAO();

						// Utilizando o mï¿½todo responsï¿½vel por receber como
						// parï¿½metro um Fornecedor e um id de
						// Endereï¿½o, gravar o Fornecedor no banco e atribuir a
						// ele
						// este Endereï¿½o, atravï¿½s da coluna
						// id_endereco, localizada na tabela fornecedor

						fornecedorDao.insert(fornecedor, idEndereco);

						// retornando para a pï¿½gina, atravï¿½s do mï¿½todo
						// request.setAttribute(), uma mensagem de
						// sucesso apï¿½s o cadastro do fornecedor

						request.setAttribute("mensagem",
								"Fornecedor " + fornecedor.getNome() + " cadastrado com sucesso.");
					} else {
						request.setAttribute("mensagem2",
								"CNPJ *" + request.getParameter("cnpj") + "* já cadastrado no sistema");
					}
				} catch (final Exception e) {

					// Caso o mï¿½todo caia no catch, retorne para a pï¿½gina a
					// mensagem de erro

					request.setAttribute("mensagem", "Erro: " + e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma pï¿½gina de
					// cadastro
					// de fornecedores

					request.getRequestDispatcher("/areaRestrita/cadastroFornecedor.jsp").forward(request, response);

				}

			}

			// Se o valor da aï¿½ï¿½o recebida pelo formulï¿½rio for
			// "consultarFornecedor", execute o bloco abaixo:

			else if (acao.equalsIgnoreCase("consultarFornecedor")) {

				try {

					// Coletando da pï¿½gina o parï¿½metro "cnpj", atravï¿½s do
					// "name"
					// do formulï¿½rio, utilizando
					// o mï¿½todo request.getParameter()

					final String cnpj = request.getParameter("cnpj");

					// Instanciando um novo Fornecedor

					Fornecedor fornecedor = new Fornecedor();

					// Instanciando a classe responsï¿½vel por gravar, alterar e
					// excluir Fornecedores no banco

					final FornecedorDAO fornecedorDao = new FornecedorDAO();

					// Utilizando o mï¿½todo que recebe como parï¿½metro um
					// nï¿½mero
					// de cnpj e retorna os dados
					// do fornecedor a qual ele pertence

					fornecedor = fornecedorDao.findByCnpj(cnpj);

					// Instanciando um novo Endereco

					Endereco endereco = new Endereco();

					// Instanciando a classe responsï¿½vel por gravar, alterar e
					// excluir Endereï¿½os no banco

					final EnderecoDAO enderecoDao = new EnderecoDAO();

					// Utilizando o mï¿½todo que recebe como parï¿½metro o id de
					// um
					// Endereco e retorna os dados
					// do mesmo gravados no banco. Para isso, utilizamos o
					// getEndereco do fornecedor para encontrar
					// seu endereï¿½o e, por fim, o mï¿½todo getId do
					// endereï¿½o, para
					// encontrar seu id

					endereco = enderecoDao.findById(fornecedor.getEndereco().getId_endereco());

					// Atribuindo o endereï¿½o encontrado ao fornecedor

					fornecedor.setEndereco(endereco);

					// Retornando para a pï¿½gina JSP o objeto fornecedor e
					// atribuindo a ele o nome "fornecedor"

					request.setAttribute("fornecedor", fornecedor);

				} catch (final Exception e) {

					// Caso o mï¿½todo caia no catch, retorne para a pï¿½gina a
					// mensagem de erro

					request.setAttribute("mensagem", "Fornecedor não encontrado.");

				} finally {

					// Redirecionando novamente para a mesma pï¿½gina de
					// consulta
					// de fornecedores

					request.getRequestDispatcher("/areaRestrita/consultaFornecedor.jsp").forward(request, response);

				}

			} else if (acao.equalsIgnoreCase("cadastrarfuncionario")) {

				try {

					final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					Funcionario funcionario = funcionarioDAO.findByCpf(request.getParameter("cpf"));

					if (funcionario.getNome() == null || funcionario.getNome() == "") {
						// Instanciando um novo Endereï¿½o para receber os
						// parï¿½metros
						// passados pelo usuï¿½rio
						// atravï¿½s da JSP

						final Endereco endereco = new Endereco();

						// Coletando cada parï¿½metro da pï¿½gina atravï¿½s do
						// "name" do
						// formulï¿½rio, utilizando
						// o request.getParameter() e atribuindo ï¿½ entidade
						// Endereco
						// atravï¿½s dos setters

						endereco.setLogradouro(request.getParameter("logradouro"));
						endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
						endereco.setCep(request.getParameter("cep"));
						endereco.setBairro(request.getParameter("bairro"));
						endereco.setCidade(request.getParameter("cidade"));
						endereco.setEstado(request.getParameter("estado"));
						endereco.setPais(request.getParameter("pais"));

						// Instanciando a classe responsï¿½vel por gravar,
						// alterar e
						// excluir Endereï¿½os no banco

						final EnderecoDAO enderecoDao = new EnderecoDAO();

						// Utilizando o método que recebe como parâmetro um
						// objeto
						// endereço, grava o
						// mesmo no banco e retorna seu id, criado
						// automaticamente
						// pelo próprio SQL

						final Integer idEndereco = enderecoDao.insertReturnID(endereco);

						final Integer cargo = Integer.parseInt(request.getParameter("cargo"));

						funcionario = new Funcionario();

						funcionario.setNome(request.getParameter("nome"));
						funcionario.setTelefone(request.getParameter("telefone"));
						funcionario.setCpf(request.getParameter("cpf"));
						funcionario.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
						funcionario.setSenha(request.getParameter("senha"));
						funcionario.setEndereco(endereco);

						final FuncionarioDAO funcionarioDAO2 = new FuncionarioDAO();
						funcionarioDAO2.insert(funcionario, idEndereco, cargo);

						request.setAttribute("mensagem",
								"Funcionário " + funcionario.getNome() + " cadastrado com sucesso");
					} else {
						request.setAttribute("mensagem2",
								"CPF *" + request.getParameter("cpf") + "* já cadastrado no sistema");
					}
				} catch (final Exception e) {
					request.setAttribute("mensagem", e.getMessage());
					e.printStackTrace();
				} finally {
					request.getRequestDispatcher("/areaRestrita/cadastroFuncionario.jsp").forward(request, response);
				}
			}

			else if (acao.equalsIgnoreCase("autenticar")) {

				String destino = "/login.jsp";

				try {

					final String cpf = request.getParameter("cpf");
					final String senha = request.getParameter("senha");

					final FuncionarioDAO funcionarioDao = new FuncionarioDAO();

					final Funcionario funcionario = funcionarioDao.findByLoginSenha(cpf, senha);

					if (funcionario != null) {

						session = request.getSession();

						session.setAttribute("usuarioLogado", funcionario);

						request.setAttribute("usuarioLogado", funcionario);

						destino = "/areaRestrita/index.jsp";

					} else {

						request.setAttribute("mensagem", "Acesso negado, tente novamente.");
						//throw new Exception("Acesso negado, tente novamente.");

						request.getRequestDispatcher(destino);
						
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

			} else if (acao.equalsIgnoreCase("consultaCepCadCli")) {

				final String cep = request.getParameter("cep");
				
				ClientePF clientePf = new ClientePF();

				Endereco endereco = new Endereco();

				endereco = WebServiceCep.buscaCep(cep);

				request.setAttribute("endereco", endereco);

				request.getRequestDispatcher("/areaRestrita/cadastroCliente.jsp").forward(request, response);

			}

			else if (acao.equalsIgnoreCase("consultaCepCadForn")) {

				final String cep = request.getParameter("cep");

				Endereco endereco = new Endereco();

				endereco = WebServiceCep.buscaCep(cep);

				request.setAttribute("endereco", endereco);

				request.getRequestDispatcher("/areaRestrita/cadastroFornecedor.jsp").forward(request, response);

			}

			else if (acao.equalsIgnoreCase("consultaCepCadFunc")) {

				final String cep = request.getParameter("cep");
				
				Endereco endereco = new Endereco();

				endereco = WebServiceCep.buscaCep(cep);

				request.setAttribute("endereco", endereco);

				request.getRequestDispatcher("/areaRestrita/cadastroFuncionario.jsp").forward(request, response);

			}

			else if (acao.equalsIgnoreCase("editarPessoa")) {

				try {

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Clientes no banco
					final ClientePFDAO clientePfDao = new ClientePFDAO();

					// Instanciando a classe responsável por gravar, alterar e
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

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("/areaRestrita/consultaCliente.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("editarFornecedor")) {

				try {

					// Instanciando a classe responsável por gravar, alterar e
					// excluir endereços no banco
					EnderecoDAO enderecoDao = new EnderecoDAO();

					// Instanciando a classe responsável por gravar, alterar e
					// excluir Clientes no banco
					FornecedorDAO fornecedorDao = new FornecedorDAO();

					// Recebe o cliente ao ser alterado pelo cpf
					Fornecedor fornecedor = fornecedorDao.findByCnpj(request.getParameter("cnpj"));

					Endereco endereco = fornecedor.getEndereco();

					// altera o endereço do cliente
					endereco.setId_endereco(fornecedor.getEndereco().getId_endereco());
					endereco.setLogradouro(request.getParameter("logradouro"));
					endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
					endereco.setCep(request.getParameter("cep"));
					endereco.setBairro(request.getParameter("bairro"));
					endereco.setCidade(request.getParameter("cidade"));
					endereco.setEstado(request.getParameter("estado"));
					endereco.setPais(request.getParameter("pais"));

					// atualiza o endereço
					enderecoDao.update(endereco);

					// altera os dados do fornecedor

					fornecedor.setNome(request.getParameter("nome"));
					fornecedor.setRazaoSocial(request.getParameter("razaoSocial"));
					fornecedor.setTelefone(request.getParameter("telefone"));
					fornecedor.setCnpj(request.getParameter("cnpj"));
					fornecedor.setEndereco(endereco);

					// atualiza o fornecedor
					fornecedorDao = new FornecedorDAO();
					
					fornecedorDao.update(fornecedor);

					request.setAttribute("mensagem", "Fornecedor " + fornecedor.getNome() + " Alterado com sucesso");

				} catch (final Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem2", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("/areaRestrita/consultaFornecedor.jsp").forward(request, response);

				}

			}

			else if (acao.equalsIgnoreCase("editarFuncionario")) {

				try {

					// Instanciando a classe responsável por gravar, alterar e excluir Funcionários no banco
					FuncionarioDAO funcionarioDao = new FuncionarioDAO();

					// Instanciando a classe responsável por gravar, alterar e excluir endereços no banco
					EnderecoDAO enderecoDao = new EnderecoDAO();

					// Recebe o Funcionário ao ser alterado pelo cpf
					Funcionario funcionario = funcionarioDao.findByCpf(request.getParameter("cpf"));
					Endereco endereco = funcionario.getEndereco();

					// altera o endereço do Funcionário
					endereco.setId_endereco(funcionario.getEndereco().getId_endereco());
					endereco.setLogradouro(request.getParameter("logradouro"));
					endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
					endereco.setCep(request.getParameter("cep"));
					endereco.setBairro(request.getParameter("bairro"));
					endereco.setCidade(request.getParameter("cidade"));
					endereco.setEstado(request.getParameter("estado"));
					endereco.setPais(request.getParameter("pais"));

					// altualiza o endereço
					enderecoDao.update(endereco);

					// altera os dados do Funcionários

					funcionario.setNome(request.getParameter("nome"));
					funcionario.setTelefone(request.getParameter("telefone"));
					funcionario.setCpf(request.getParameter("cpf"));
					funcionario.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
					funcionario.setEndereco(endereco);
					
					// atualiza o Funcionários
					
					funcionarioDao = new FuncionarioDAO();
					
					funcionarioDao.update(funcionario);

					request.setAttribute("mensagem", "Funcionário " + funcionario.getNome() + " Alterado com sucesso");

				} catch (final Exception e) {

					// Caso o método caia no catch, retorne para a página a mensagem de erro

					request.setAttribute("mensagem", e.getMessage());

				} finally {

					// Redirecionando novamente para a mesma página de cadastro de clientes

					request.getRequestDispatcher("/areaRestrita/consultaFuncionario.jsp").forward(request, response);

				}

			}

		}

	}

}
