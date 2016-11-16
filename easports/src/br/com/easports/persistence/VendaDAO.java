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

	public int insertreturnID(Venda venda) throws Exception {

		int idVenda = 0;
		String query = "insert into Pedido(data_venda, id_funcionario, finalizado)VALUES(?,?,?)";
		abreConexao();

		stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

		stmt.setString(1, ConverteData.dateToString(venda.getDataVenda()));
		stmt.setInt(2, venda.getFuncionario().getIdFuncionario());
		stmt.setBoolean(3, venda.isFinalizado());

		stmt.execute();

		rs = stmt.getGeneratedKeys();

		stmt.close();

		fechaConexao();

		while (rs.next()) {

			idVenda = rs.getInt(1);
		}		
		return idVenda;
	}
}
