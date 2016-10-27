package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import org.sqlite.date.DateFormatUtils;

import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Endereco;
import br.com.easports.util.ConverteData;

public class ClientePFDAO extends DAO{
	
	
	public void insert(ClientePF cliente, int idEndereco) throws Exception {

		String query = "insert into Cliente_PF(nome, telefone, cpf, data_nascimento, id_endereco)VALUES(?,?,?,?,?)";

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

	public void update(ClientePF cliente) throws Exception {

		String query = "update cliente set nome = ?, telefone = ?, cpf = ?, data_nascimento = ?, id_endereco = ? where id_cliente_pf = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.setString(3, cliente.getCpf());
		stmt.setString(4, ConverteData.dateToString(cliente.getDataNasc()));
		stmt.setInt(5, cliente.getEndereco().getId_endereco());
		stmt.setInt(6, cliente.getIdCliente());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void delete(Integer id_cliente) throws Exception {

		String query = "delete from cliente_pf where id_cliente_pf = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_cliente);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ClientePF findById(Integer id_cliente) throws Exception {

		String query = "select * from cliente_pf where id_cliente_pf = ?";

		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_cliente);

		rs = stmt.executeQuery();

		ClientePF cliente = new ClientePF();

		while (rs.next()) {

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			
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
	
	public ClientePF findByCpf(String cpf) throws Exception {

		String query = "select * from cliente_pf where cpf = ?";

		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setString(1, cpf);

		rs = stmt.executeQuery();

		ClientePF cliente = new ClientePF();
		
		while (rs.next()) {

			EnderecoDAO enderecoDAO = new EnderecoDAO();
			
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

	public List<ClientePF> listAll() throws Exception{
		
		String query = "select * from cliente_pf";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);
		
		rs = stmt.executeQuery();
		
		List<ClientePF> lista = new ArrayList<ClientePF>();
		
		while(rs.next()){
			
			ClientePF cliente = new ClientePF();
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			
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

}
