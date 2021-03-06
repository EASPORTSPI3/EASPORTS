package br.com.easports.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.easports.entities.Funcionario;
import br.com.easports.entities.Venda;
import br.com.easports.util.ConverteData;

public class VendaDAO extends DAO {

	public void insert(Venda venda) throws Exception {
		String query = "insert into Pedido(data_venda, id_funcionario)VALUES(?,?)";
		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, ConverteData.dateToString(venda.getDataVenda()));
		stmt.setInt(2, venda.getFuncionario().getIdFuncionario());

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

	public Venda findById(Integer idVenda) throws Exception {

		String query = "select * from vendas where id_vendas = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idVenda);

		rs = stmt.executeQuery();

		Venda venda = null;

		while (rs.next()) {

			FuncionarioDAO funcionarioDao = new FuncionarioDAO();

			venda = new Venda();

			venda.setIdVenda(rs.getInt("id_vendas"));
			venda.setFuncionario(funcionarioDao.findById(rs.getInt("id_funcionario")));
			venda.setDataVenda(ConverteData.stringToDate(rs.getString("data_venda")));

		}

		stmt.close();

		fechaConexao();

		return venda;
	}

	public List<Venda> listAll() throws Exception {

		List<Venda> list = new ArrayList<Venda>();
		String query = "select * from vendas";
		abreConexao();

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();
		Venda venda = null;

		while (rs.next()) {

			FuncionarioDAO funcionarioDao = new FuncionarioDAO();

			venda = new Venda();

			venda.setIdVenda(rs.getInt("id_vendas"));
			venda.setFuncionario(funcionarioDao.findById(rs.getInt("id_funcionario")));
			venda.setDataVenda(ConverteData.stringToDate(rs.getString("data_venda")));
			venda.setDataVendaFormatado(rs.getString("data_venda"));
			list.add(venda);
		}

		stmt.close();

		fechaConexao();

		return list;
	}

	public List<Venda> vendaPorPeriodo(Integer idFuncionario, Date dataInicio, Date dataFinal) throws Exception {

		List<Venda> list = new ArrayList<Venda>();
		String query = "select * from vendas where data_venda between ? and ? and id_funcionario = ?";
		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, ConverteData.dateToString(dataInicio));
		stmt.setString(2, ConverteData.dateToString(dataFinal));
		stmt.setInt(3, idFuncionario);

		rs = stmt.executeQuery();
		Venda venda = null;

		while (rs.next()) {

			FuncionarioDAO funcionarioDao = new FuncionarioDAO();

			venda = new Venda();

			venda.setIdVenda(rs.getInt("id_vendas"));
			venda.setFuncionario(funcionarioDao.findById(rs.getInt("id_funcionario")));
			venda.setDataVenda(ConverteData.stringToDate(rs.getString("data_venda")));
			venda.setDataVendaFormatado(rs.getString("data_venda"));
			list.add(venda);
		}

		stmt.close();

		fechaConexao();

		return list;
	}
}
