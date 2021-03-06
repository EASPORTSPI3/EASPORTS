package br.com.easports.persistence;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Endereco;

public class EnderecoDAO extends DAO {

	public void delete(final Integer id_endereco) throws Exception {

		final String query = "delete from endereco where id_endereco = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_endereco);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public Endereco findById(final Integer id_endereco) throws Exception {

		final String query = "select * from Endereco where id_endereco = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_endereco);

		rs = stmt.executeQuery();

		final Endereco endereco = new Endereco();

		while (rs.next()) {
			endereco.setId_endereco(id_endereco);
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setNumero(rs.getInt("numero"));
			endereco.setCep(rs.getString("cep"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));
			endereco.setPais(rs.getString("pais"));

		}

		stmt.close();

		fechaConexao();

		return endereco;

	}

	public void insert(final Endereco endereco) throws Exception {

		final String query = "insert into endereco(logradouro, numero, cep, bairro, cidade, " + "estado, pais)VALUES(?,?,?,?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, endereco.getLogradouro());
		stmt.setInt(2, endereco.getNumero());
		stmt.setString(3, endereco.getCep());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setString(7, endereco.getPais());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public int insertReturnID(final Endereco endereco) throws Exception {

		int idEndereco = 0;

		final String query = "insert into endereco(logradouro, numero, cep, bairro, cidade, " + "estado, pais)VALUES(?,?,?,?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, endereco.getLogradouro());
		stmt.setInt(2, endereco.getNumero());
		stmt.setString(3, endereco.getCep());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setString(7, endereco.getPais());

		stmt.execute();

		rs = stmt.getGeneratedKeys();

		while (rs.next()) {

			idEndereco = rs.getInt(1);

		}

		stmt.close();

		fechaConexao();

		return idEndereco;

	}

	public List<Endereco> listAll() throws Exception {

		final String query = "select * from endereco";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		final List<Endereco> lista = new ArrayList<Endereco>();

		while (rs.next()) {

			final Endereco endereco = new Endereco();

			endereco.setId_endereco(rs.getInt("id_endereco"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setNumero(rs.getInt("numero"));
			endereco.setCep(rs.getString("cep"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));
			endereco.setPais(rs.getString("pais"));

			lista.add(endereco);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public void update(final Endereco endereco) throws Exception {

		abreConexao();

		final String query = "update endereco set logradouro = ?, numero = ?, cep = ?, " + "bairro = ?, cidade = ?, estado = ?, pais = ? where id_endereco = ?";

		stmt = con.prepareStatement(query);

		stmt.setString(1, endereco.getLogradouro());
		stmt.setInt(2, endereco.getNumero());
		stmt.setString(3, endereco.getCep());
		stmt.setString(4, endereco.getBairro());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setString(7, endereco.getPais());
		stmt.setInt(8, endereco.getId_endereco());
		stmt.execute();

		stmt.close();

		fechaConexao();

	}

}
