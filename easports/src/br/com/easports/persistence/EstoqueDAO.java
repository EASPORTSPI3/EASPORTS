package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Categoria;
import br.com.easports.entities.Estoque;
import br.com.easports.entities.Produto;

public class EstoqueDAO extends DAO{

	public void insert(Estoque estoque) throws Exception {

		String query = "insert into estoque(id_prod, nome_prod, "
				+ "id_categoria, quantidade)values(?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, estoque.getProduto().getIdProduto());
		stmt.setString(2, estoque.getProduto().getNome());
		stmt.setInt(3, estoque.getCategoria().getIdCategoria());
		stmt.setInt(4, estoque.getQuantidade());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void update(Estoque estoque) throws Exception {

		String query = "update estoque set id_prod = ?, nome_prod = ?, id_categoria = ?, "
				+ "quantidade = ? where id_estoque = ?";

		stmt = con.prepareStatement(query);

		abreConexao();

		stmt.setInt(1, estoque.getProduto().getIdProduto());
		stmt.setString(2, estoque.getProduto().getNome());
		stmt.setInt(3, estoque.getCategoria().getIdCategoria());
		stmt.setInt(4, estoque.getQuantidade());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void delete(Integer id_estoque) throws Exception {

		String query = "delete from estoque where id_estoque = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_estoque);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public Estoque findById(Integer id_estoque) throws Exception {

		String query = "select * from Estoque where id_estoque = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_estoque);

		rs = stmt.executeQuery();

		Estoque estoque = new Estoque();
		
		Produto produto = new Produto();
		
		Categoria categoria = new Categoria();
		
		estoque.setProduto(produto);
		
		estoque.setCategoria(categoria);

		while (rs.next()) {

			estoque.getProduto().setIdProduto(rs.getInt("id_prod"));
			estoque.getProduto().setNome(rs.getString("nome_prod"));
			estoque.getCategoria().setIdCategoria(rs.getInt("id_categoria"));
			estoque.setQuantidade(rs.getInt("quantidade"));

		}

		stmt.close();

		fechaConexao();

		return estoque;

	}

	public List<Estoque> listAll() throws Exception {

		String query = "select * from estoque";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		List<Estoque> lista = new ArrayList<Estoque>();

		while (rs.next()) {

			Estoque estoque = new Estoque();

			estoque.setIdEstoque(rs.getInt("id_estoque"));
			estoque.getProduto().setIdProduto(rs.getInt("id_prod"));
			estoque.getProduto().setNome(rs.getString("nome_prod"));
			estoque.getCategoria().setIdCategoria(rs.getInt("id_categoria"));
			estoque.setQuantidade(rs.getInt("quantidade"));

			lista.add(estoque);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}
	
}
