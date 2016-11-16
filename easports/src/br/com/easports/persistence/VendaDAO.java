package br.com.easports.persistence;

import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.easports.entities.Venda;
import br.com.easports.util.ConverteData;

public class VendaDAO extends DAO {

	public void insert(Venda venda) throws Exception {
		String query = "insert into Pedido(data_venda, id_funcionario, finalizado)VALUES(?,?,?)";
		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, ConverteData.dateToString(venda.getDataVenda()));
		stmt.setInt(2, venda.getFuncionario().getIdFuncionario());
		stmt.setBoolean(3, venda.isFinalizado());
		stmt.execute();

		stmt.close();

		fechaConexao();
	}

	public int insertreturnID(Venda venda, Integer idFuncionario) throws Exception {

		int idVenda = 0;
		String query = "insert into Vendas(data_venda, id_funcionario)VALUES(?,?)";
		abreConexao();

		stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

		stmt.setString(1, ConverteData.dateToString(venda.getDataVenda()));
		stmt.setInt(2, idFuncionario);

		stmt.execute();

		rs = stmt.getGeneratedKeys();
		while (rs.next()) {

			idVenda = rs.getInt(1);
		}		
		stmt.close();

		fechaConexao();
		return idVenda;
	}
	
	public void finalizaPedidos(Integer idVenda) throws Exception {

		String query = "update venda set finalizado = 'true' where id_cliente = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idVenda);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

}
