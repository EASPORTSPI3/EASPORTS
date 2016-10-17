package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Categoria;
import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Endereco;
import br.com.easports.entities.Fornecedor;
import br.com.easports.entities.Produto;
import br.com.easports.util.ConverteData;

public class FornecedorDAO extends DAO{
	
	public void insert(Fornecedor fornecedor, int idEndereco) throws Exception {

		String query = "insert into Fornecedor(nome, telefone, cnpj, razao_social, id_endereco)values(?,?,?,?,?)";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2, fornecedor.getTelefone());
		stmt.setString(3, fornecedor.getCnpj());
		stmt.setString(4, fornecedor.getRazaoSocial());
		stmt.setInt(5, idEndereco);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void update(Fornecedor fornecedor) throws Exception {

		String query = "update fornecedor set nome = ?, telefone = ?, cnpj = ?, razao_social = ?, id_endereco = ? where id_fornecedor = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2, fornecedor.getTelefone());
		stmt.setString(3, fornecedor.getCnpj());
		stmt.setString(3, fornecedor.getRazaoSocial());
		stmt.setInt(5, fornecedor.getEndereco().getId_endereco());
		stmt.setInt(6, fornecedor.getIdFornecedor());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public void delete(Integer id_fornecedor) throws Exception {

		String query = "delete from fornecedor where id_fornecedor = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_fornecedor);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public Fornecedor findById(Integer id_fornecedor) throws Exception {

		String query = "select * from fornecedor where id_fornecedor = ?";

		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_fornecedor);

		rs = stmt.executeQuery();

		Fornecedor fornecedor = new Fornecedor();
		
		Endereco endereco = new Endereco();
		
		fornecedor.setEndereco(endereco);

		while (rs.next()) {

			fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setRazaoSocial(rs.getString("razao_social"));
			fornecedor.getEndereco().setId_endereco(rs.getInt("id_endereco"));

		}
		
		stmt.close();
		
		fechaConexao();

		return fornecedor;

	}
	
	public Fornecedor findByCnpj(String cnpj) throws Exception {

		String query = "select * from fornecedor where cnpj = ?";

		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setString(1, cnpj);

		rs = stmt.executeQuery();

		Fornecedor fornecedor = new Fornecedor();
		
		Endereco endereco = new Endereco();
		
		fornecedor.setEndereco(endereco);

		while (rs.next()) {

			fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setRazaoSocial(rs.getString("razao_social"));
			fornecedor.getEndereco().setId_endereco(rs.getInt("id_endereco"));

		}
		
		stmt.close();
		
		fechaConexao();

		return fornecedor;

	}
	
	public Fornecedor findByName(String nome) throws Exception {

		String query = "select * from fornecedor where nome like ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setString(1, nome);

		rs = stmt.executeQuery();

		Fornecedor fornecedor = new Fornecedor();

		while (rs.next()) {

			fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setRazaoSocial(rs.getString("razao_social"));
			fornecedor.getEndereco().setId_endereco(rs.getInt("id_endereco"));

		}

		stmt.close();

		fechaConexao();

		return fornecedor;

	}

	public List<Fornecedor> listAll() throws Exception{
		
		String query = "select * from fornecedor";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);
		
		rs = stmt.executeQuery();
		
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		while(rs.next()){
			
			Fornecedor fornecedor = new Fornecedor();
			
			Endereco endereco = new Endereco();
			
			fornecedor.setEndereco(endereco);
			
			fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setRazaoSocial(rs.getString("razao_social"));
			fornecedor.getEndereco().setId_endereco(rs.getInt("id_endereco"));
			
			lista.add(fornecedor);
			
		}
		
		stmt.close();
		
		fechaConexao();
		
		return lista;
		
	}

}
