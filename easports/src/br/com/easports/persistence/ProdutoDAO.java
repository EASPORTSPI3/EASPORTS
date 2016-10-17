package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Categoria;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Produto;

public class ProdutoDAO extends DAO {

	public void insert(Produto produto, int idFornecedor, int idCategoria) throws Exception {

		String query = "insert into Produto(nome, imagem, codigo, valor_venda, valor_custo, "
				+ "id_fornecedor, id_categoria, quantidade)VALUES(?,?,?,?,?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getImagem());
		stmt.setString(3, produto.getCodigo());
		stmt.setDouble(4, produto.getValorVenda());
		stmt.setDouble(5, produto.getValorCusto());
		stmt.setInt(6, idFornecedor);
		stmt.setInt(7, idCategoria);
		stmt.setInt(8, produto.getQuantidade());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void update(Produto produto) throws Exception {

		String query = "update produto set nome = ?, imagem = ?, codigo = ?, "
				+ "valor_venda = ?, valor_custo = ?, id_fornecedor = ?, id_categoria = ?, quantidade = ? where id_produto = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getImagem());
		stmt.setString(3, produto.getCodigo());
		stmt.setDouble(4, produto.getValorVenda());
		stmt.setDouble(5, produto.getValorCusto());
		stmt.setInt(6, produto.getFornecedor().getIdFornecedor());
		stmt.setString(7, produto.getCategoria().toString());
		stmt.setInt(8, produto.getQuantidade());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void delete(Integer id_produto) throws Exception {

		String query = "delete from produto where id_produto = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_produto);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public Produto findById(Integer id_produto) throws Exception {

		String query = "select * from produto where id_produto = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_produto);

		rs = stmt.executeQuery();

		Produto produto = new Produto();

		Fornecedor fornecedor = new Fornecedor();

		Categoria categoria = new Categoria();

		produto.setFornecedor(fornecedor);
		produto.setCategoria(categoria);

		while (rs.next()) {

			produto.setNome(rs.getString("nome"));
			produto.setImagem(rs.getString("imagem"));
			produto.setCodigo(rs.getString("codigo"));
			produto.setValorVenda(rs.getDouble("valor_venda"));
			produto.setValorCusto(rs.getDouble("valor_custo"));
			produto.getCategoria().setIdCategoria(rs.getInt("id_categoria"));
			produto.getFornecedor().setIdFornecedor(rs.getInt("id_fornecedor"));
			produto.setQuantidade(rs.getInt("quantidade"));

		}

		stmt.close();

		fechaConexao();

		return produto;

	}

	public Produto findByCodigo(String codigo) throws Exception {

		String query = "select * from produto where codigo = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, codigo);

		rs = stmt.executeQuery();

		Produto produto = new Produto();

		Fornecedor fornecedor = new Fornecedor();

		Categoria categoria = new Categoria();

		produto.setFornecedor(fornecedor);
		produto.setCategoria(categoria);

		while (rs.next()) {

			produto.setIdProduto(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
			produto.setImagem(rs.getString("imagem"));
			produto.setCodigo(rs.getString("codigo"));
			produto.setValorVenda(rs.getDouble("valor_venda"));
			produto.setValorCusto(rs.getDouble("valor_custo"));
			produto.getCategoria().setIdCategoria(rs.getInt("id_categoria"));
			produto.getFornecedor().setIdFornecedor(rs.getInt("id_fornecedor"));
			produto.setQuantidade(rs.getInt("quantidade"));

		}

		stmt.close();

		fechaConexao();

		return produto;

	}

	public List<Produto> findByName(String nome) throws Exception {

		String query = "select * from produto where nome like '%"+nome+"%'";

		abreConexao();

		stmt = con.prepareStatement(query);

		//stmt.setString(1, "'%" + nome.toLowerCase() + "%'");

		rs = stmt.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		System.out.println("criou a lista");
		
		while (rs.next()) {

			System.out.println("entrou no rs.next");
			
			Produto produto = new Produto();

			Categoria categoria = new Categoria();
			Fornecedor fornecedor = new Fornecedor();

			CategoriaDAO categoriaDao = new CategoriaDAO();
			FornecedorDAO fornecedorDao = new FornecedorDAO();

			categoria = categoriaDao.findById(rs.getInt("id_categoria"));
			fornecedor = fornecedorDao.findById(rs.getInt("id_fornecedor"));

			produto.setCategoria(categoria);
			produto.setFornecedor(fornecedor);

			produto.setIdProduto(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
			produto.setImagem(rs.getString("imagem"));
			produto.setCodigo(rs.getString("codigo"));
			produto.setValorVenda(rs.getDouble("valor_venda"));
			produto.setValorCusto(rs.getDouble("valor_custo"));
			produto.setQuantidade(rs.getInt("quantidade"));

			lista.add(produto);
			
			System.out.println(produto.getNome());

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public List<Produto> listAll() throws Exception {

		String query = "select * from produto";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		List<Produto> lista = new ArrayList<Produto>();

		while (rs.next()) {

			Produto produto = new Produto();

			Categoria categoria = new Categoria();
			Fornecedor fornecedor = new Fornecedor();

			CategoriaDAO categoriaDao = new CategoriaDAO();
			FornecedorDAO fornecedorDao = new FornecedorDAO();

			categoria = categoriaDao.findById(rs.getInt("id_categoria"));
			fornecedor = fornecedorDao.findById(rs.getInt("id_fornecedor"));

			produto.setCategoria(categoria);
			produto.setFornecedor(fornecedor);

			produto.setIdProduto(rs.getInt("id_produto"));
			produto.setNome(rs.getString("nome"));
			produto.setImagem(rs.getString("imagem"));
			produto.setCodigo(rs.getString("codigo"));
			produto.setValorVenda(rs.getDouble("valor_venda"));
			produto.setValorCusto(rs.getDouble("valor_custo"));
			produto.setQuantidade(rs.getInt("quantidade"));

			lista.add(produto);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

}
