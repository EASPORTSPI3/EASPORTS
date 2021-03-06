package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Categoria;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Produto;

public class CategoriaDAO extends DAO{

	
	public Categoria findById(Integer id_categoria) throws Exception {

		String query = "select * from categoria where id_categoria = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_categoria);

		rs = stmt.executeQuery();

		Categoria categoria = new Categoria();

		while (rs.next()) {

			categoria.setIdCategoria(rs.getInt("id_categoria"));
			categoria.setNome(rs.getString("categoria"));

		}

		stmt.close();

		fechaConexao();

		return categoria;

	}
	
	public Categoria findByName(String nome) throws Exception {

		String query = "select * from categoria where categoria like ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, nome);

		rs = stmt.executeQuery();

		Categoria categoria = new Categoria();

		while (rs.next()) {

			categoria.setIdCategoria(rs.getInt("id_categoria"));
			categoria.setNome(rs.getString("categoria"));

		}

		stmt.close();

		fechaConexao();

		return categoria;

	}
	
	public List<Categoria> listAll() throws Exception {

		String query = "select * from categoria order by categoria";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

			List<Categoria> lista = new ArrayList<Categoria>();

		while (rs.next()) {

			Categoria categoria = new Categoria();

			categoria.setIdCategoria(rs.getInt("id_categoria"));
			categoria.setNome(rs.getString("categoria"));

			lista.add(categoria);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}
	
}
