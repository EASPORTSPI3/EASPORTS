package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Pedido;
import br.com.easports.entities.Produto;
import br.com.easports.entities.Venda;
import br.com.easports.util.FormataValor;

public class PedidoDAO extends DAO {

	public void insert(Pedido pedido) throws Exception {

		String query = "insert into Pedido(id_cliente, id_produto, quantidade)VALUES(?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, pedido.getCliente().getIdCliente());
		stmt.setInt(2, pedido.getProduto().getIdProduto());
		stmt.setInt(3, pedido.getQuantidade());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void update(Pedido pedido) throws Exception {

		String query = "update pedido set id_cliente = ?, id_produto = ?, " + "quantidade = ? where id_pedido = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, pedido.getCliente().getIdCliente());
		stmt.setInt(2, pedido.getProduto().getIdProduto());
		stmt.setInt(3, pedido.getQuantidade());
		stmt.setInt(4, pedido.getIdPedido());

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
			FormataValor format = new FormataValor();

			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			if (rs.getBoolean("finalizado")) {

				pedido.setIdVenda(rs.getInt("id_vendas"));
				pedido.setStatus("Finalizado");

			} else {

				pedido.setStatus("Pendente");

			}

		}

		stmt.close();

		fechaConexao();

		return pedido;

	}
	
	public ArrayList<Pedido> findByIdVenda(Integer idVenda) throws Exception {

		String query = "select * from pedido where id_vendas = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idVenda);

		rs = stmt.executeQuery();

		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		
		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			FormataValor format = new FormataValor();
			
			Pedido pedido = new Pedido();

			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			pedido.setIdVenda(rs.getInt("id_vendas"));
			pedido.setStatus("Finalizado");
			
			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosPorCliente(Integer idCliente) throws Exception {

		String query = "select * from pedido where id_cliente = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idCliente);

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
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			Integer idVendas = rs.getInt("id_vendas");

			if (idVendas > 0) {

				pedido.setStatus("Finalizado");

			} else {

				pedido.setStatus("Pendente");

			}

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosFinalizados() throws Exception {

		String query = "select * from pedido where id_vendas is not null";

		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		ArrayList<Pedido> lista = new ArrayList<Pedido>();

		FormataValor format = new FormataValor();

		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			VendaDAO vendaDao = new VendaDAO();

			Pedido pedido = new Pedido();

			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));

			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));
			pedido.setVenda(vendaDao.findById(rs.getInt("id_vendas")));

			pedido.setStatus("Finalizado");

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosNaoFinalizados() throws Exception {

		String query = "select * from pedido where id_vendas is null";

		abreConexao();

		stmt = con.prepareStatement(query);

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
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			pedido.setStatus("Pendente");

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosNaoFinalizadosPorCliente(Integer id_cliente) throws Exception {

		String query = "select * from pedido where id_cliente = ? and id_vendas is null";

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

			// pedido.setIdProduto(rs.getInt("id_produto"));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			pedido.setStatus("Pendente");

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosFinalizadosPorCliente(Integer id_cliente) throws Exception {

		String query = "select * from pedido where id_cliente = ? and id_vendas is not null";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_cliente);

		rs = stmt.executeQuery();

		ArrayList<Pedido> lista = new ArrayList<Pedido>();

		FormataValor format = new FormataValor();

		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			VendaDAO vendaDao = new VendaDAO();

			Pedido pedido = new Pedido();
			Venda venda = new Venda();
			venda = vendaDao.findById(rs.getInt("id_vendas"));

			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setIdVenda(rs.getInt("id_vendas"));
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));
			pedido.setStatus("Finalizado");

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosFiltro(Integer idCliente, Boolean finalizado)
			throws Exception {

		String query;

		ArrayList<Pedido> lista = new ArrayList<Pedido>();

		if (finalizado) {

			query = "select * from pedido where id_cliente = ? and id_vendas is not null";

			abreConexao();

			stmt = con.prepareStatement(query);

			stmt.setInt(1, idCliente);

			rs = stmt.executeQuery();

			FormataValor format = new FormataValor();

			while (rs.next()) {

				ClientePFDAO clientePfDao = new ClientePFDAO();
				ProdutoDAO produtoDao = new ProdutoDAO();
				VendaDAO vendaDao = new VendaDAO();

				Pedido pedido = new Pedido();

				pedido.setIdPedido(rs.getInt("id_pedido"));
				pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));

				pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
				pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
				pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
				pedido.setQuantidade(rs.getInt("quantidade"));
				pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
				pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));
				pedido.setStatus("Finalizado");
				pedido.setVenda(vendaDao.findById(rs.getInt("id_vendas")));

			}

		} else {

			query = "select * from pedido where id_cliente = ? and id_vendas is null";

			abreConexao();

			stmt = con.prepareStatement(query);

			stmt.setInt(1, idCliente);

			rs = stmt.executeQuery();

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
				pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
				pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));
				pedido.setStatus("Pendente");

				lista.add(pedido);

			}

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public ArrayList<Pedido> pedidosPorStatus(Integer status) throws Exception {

		String query = "select * from pedido where finalizado = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		String statusString;

		if (status == 1) {

			statusString = "'true'";

		} else {

			statusString = "'false'";

		}

		stmt.setString(1, statusString);

		rs = stmt.executeQuery();

		ArrayList<Pedido> lista = new ArrayList<Pedido>();

		FormataValor format = new FormataValor();

		while (rs.next()) {

			ClientePFDAO clientePfDao = new ClientePFDAO();
			ProdutoDAO produtoDao = new ProdutoDAO();
			VendaDAO vendaDao = new VendaDAO();

			Pedido pedido = new Pedido();

			pedido.setIdPedido(rs.getInt("id_pedido"));
			pedido.setCliente(clientePfDao.findById(rs.getInt("id_cliente")));
			pedido.setProduto(produtoDao.findById(rs.getInt("id_produto")));
			pedido.getProduto().setValorCustoFormatado(format.valorFormatado(pedido.getProduto().getValorCusto()));
			pedido.getProduto().setValorVendaFormatado(format.valorFormatado(pedido.getProduto().getValorVenda()));
			pedido.setQuantidade(rs.getInt("quantidade"));
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			if (status == 1) {

				pedido.setVenda(vendaDao.findById(rs.getInt("id_vendas")));

				pedido.setStatus("Finalizado");

			} else {

				pedido.setStatus("Pendente");

			}

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

	public void finalizaPedidos(Integer idCliente, Integer idVenda) throws Exception {

		String query = "update pedido set id_vendas = ?, finalizado = 'true' where id_cliente = ? and finalizado = 'false'";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idVenda);
		stmt.setInt(2, idCliente);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public List<Pedido> listAll() throws Exception {

		String query = "select * from pedido order by id_cliente asc";

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
			pedido.setValorTotal(pedido.getQuantidade() * pedido.getProduto().getValorVenda());
			pedido.setValorTotalFormatado(format.valorFormatado(pedido.getValorTotal()));

			Integer idVendas = rs.getInt("id_vendas");

			if (idVendas > 0) {

				pedido.setIdVenda(rs.getInt("id_vendas"));

				pedido.setStatus("Finalizado");

			} else {

				pedido.setStatus("Pendente");

			}

			lista.add(pedido);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

}
