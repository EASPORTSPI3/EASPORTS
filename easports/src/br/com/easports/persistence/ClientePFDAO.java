package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.ClientePF;
import br.com.easports.util.ConverteData;

public class ClientePFDAO extends DAO {

	public void delete(final Integer id_cliente) throws Exception {

		final String query = "delete from cliente_pf where id_cliente_pf = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_cliente);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ClientePF findByCpf(final String cpf) throws Exception {

		final String query = "select * from cliente_pf where cpf = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, cpf);

		rs = stmt.executeQuery();

		final ClientePF cliente = new ClientePF();

		while (rs.next()) {

			final EnderecoDAO enderecoDAO = new EnderecoDAO();

			cliente.setIdCliente(rs.getInt("id_cliente_pf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setDataNasc(ConverteData.stringToDate(rs.getString("data_nascimento")));
			cliente.setEndereco(enderecoDAO.findById(rs.getInt("id_endereco")));

		}

		stmt.close();

		fechaConexao();

		return cliente;

	}

	public ClientePF findById(final Integer id_cliente) throws Exception {

		final String query = "select * from cliente_pf where id_cliente_pf = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_cliente);

		rs = stmt.executeQuery();

		ClientePF cliente = null;

		while (rs.next()) {

			cliente = new ClientePF();

			final EnderecoDAO enderecoDAO = new EnderecoDAO();

			cliente.setIdCliente(rs.getInt("id_cliente_pf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setDataNasc(ConverteData.stringToDate(rs.getString("data_nascimento")));
			cliente.setEndereco(enderecoDAO.findById(rs.getInt("id_endereco")));

		}

		stmt.close();

		fechaConexao();

		return cliente;

	}

	public void insert(final ClientePF cliente, final int idEndereco) throws Exception {

		final String query = "insert into Cliente_PF(nome, telefone, cpf, data_nascimento, id_endereco)VALUES(?,?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.setString(3, cliente.getCpf());
		stmt.setString(4, ConverteData.dateToString(cliente.getDataNasc()));
		stmt.setInt(5, idEndereco);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public List<ClientePF> listAll() throws Exception {

		final String query = "select * from cliente_pf";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		final List<ClientePF> lista = new ArrayList<ClientePF>();

		while (rs.next()) {

			final ClientePF cliente = new ClientePF();

			final EnderecoDAO enderecoDAO = new EnderecoDAO();

			cliente.setIdCliente(rs.getInt("id_cliente_pf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setDataNasc(ConverteData.stringToDate(rs.getString("data_nascimento")));
			cliente.setEndereco(enderecoDAO.findById(rs.getInt("id_endereco")));

			lista.add(cliente);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public void update(final ClientePF cliente) throws Exception {

		final String query = "update Cliente_PF set nome = ?, telefone = ?, cpf = ?, data_nascimento = ? where id_cliente_pf = ?";

		con = null;
		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.setString(3, cliente.getCpf());
		stmt.setString(4, ConverteData.dateToString(cliente.getDataNasc()));
		stmt.setObject(5, cliente.getIdCliente());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

}
