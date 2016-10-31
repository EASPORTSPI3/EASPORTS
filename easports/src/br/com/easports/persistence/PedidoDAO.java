package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Pedido;
import br.com.easports.entities.Produto;
import br.com.easports.util.FormataValor;

public class PedidoDAO extends DAO{
	
	public void insert(Pedido pedido) throws Exception {

		String query = "insert into Pedido(id_cliente, id_produto, quantidade)VALUES(?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, pedido.getIdCliente());
		stmt.setInt(2, pedido.getIdProduto());
		stmt.setInt(3, pedido.getQuantidade());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void update(Pedido pedido) throws Exception {

		String query = "update pedido set id_cliente = ?, id_produto = ?, "
				+ "quantidade = ?, finalizado = ? where id_pedido = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, pedido.getIdCliente());
		stmt.setInt(2, pedido.getIdProduto());
		stmt.setInt(3, pedido.getQuantidade());
		stmt.setBoolean(4, pedido.isFinalizado());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void delete(Integer id_pedido) throws Exception {

		String query = "delete from pedido where id_pedido = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_pedido);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public Pedido findById(Integer id_pedido) throws Exception {

		String query = "select * from pedido where id_pedido = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_pedido);

		rs = stmt.executeQuery();

		Pedido pedido = new Pedido();
		
		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setFinalizado(rs.getBoolean("finalizado"));

		}

		stmt.close();

		fechaConexao();

		return pedido;

	}
	
	public ArrayList<Pedido> pedidosNaoFinalizadosPorCliente(Integer id_cliente) throws Exception{
		
		String query = "select * from pedido where id_cliente = ? and finalizado = 'false'";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);
		
		stmt.setInt(1, id_cliente);
		
		rs = stmt.executeQuery();
		
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		
		FormataValor format = new FormataValor();
		
		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			Pedido pedido = new Pedido();
			
			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));

//			pedido.setIdProduto(rs.getInt("id_produto"));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setFinalizado(rs.getBoolean("finalizado"));

			lista.add(pedido);

		}
		
		stmt.close();
		
		fechaConexao();
		
		return lista;
		
	}
	
	public ArrayList<Pedido> pedidosFinalizadosPorCliente(Integer id_cliente) throws Exception{
		
		String query = "select * from pedido where id_cliente = ? and finalizado = 'true'";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);
		
		stmt.setInt(1, id_cliente);
		
		rs = stmt.executeQuery();
		
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		
		FormataValor format = new FormataValor();
		
		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			Pedido pedido = new Pedido();
			
			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setFinalizado(rs.getBoolean("finalizado"));

			lista.add(pedido);

		}
		
		stmt.close();
		
		fechaConexao();
		
		return lista;
		
	}

	public List<Pedido> listAll() throws Exception {

		String query = "select * from pedido";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		List<Pedido> lista = new ArrayList<Pedido>();
		
		FormataValor format = new FormataValor();
		
		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			Pedido pedido = new Pedido();
			
			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setFinalizado(rs.getBoolean("finalizado"));

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

}
