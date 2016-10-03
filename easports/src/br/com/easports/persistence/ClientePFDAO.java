package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

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

	public void delete(Integer id_endereco) throws Exception {

		String query = "delete from endereco where id_endereco = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_endereco);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public Endereco findById(Integer id_endereco) throws Exception {

		String query = "select from Endereco where id_endereco = ?";

		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_endereco);

		rs = stmt.executeQuery();

		Endereco endereco = null;

		while (rs.next()) {

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

	public List<Endereco> listAll() throws Exception{
		
		String query = "select * from endereco";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);
		
		rs = stmt.executeQuery();
		
		List<Endereco> lista = new ArrayList<Endereco>();
		
		while(rs.next()){
			
			Endereco endereco = new Endereco();
			
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

}
