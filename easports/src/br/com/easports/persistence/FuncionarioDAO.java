package br.com.easports.persistence;

import br.com.easports.entities.Funcionario;
import br.com.easports.util.ConverteData;

public class FuncionarioDAO extends DAO{
	
	public void insert(Funcionario funcionario, int idEndereco, int idDepartamento, int idCargo) throws Exception{
		
		String query = "insert into funcionario(nome, telefone, cpf, data_nasc, id_endereco, senha, id_cargo, id_departamento)values (?,?,?,?,?,?,?,?)";
		abreConexao();
		
		stmt = con.prepareStatement(query);
		
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getTelefone());
		stmt.setString(3, funcionario.getCpf());
		stmt.setString(4, ConverteData.dateToString(funcionario.getDataNasc()));
		stmt.setInt(5, idEndereco);
		stmt.setString(6, funcionario.getSenha());
		stmt.setInt(7, idCargo);
		stmt.setInt(8, idDepartamento);
		
		stmt.execute();

		stmt.close();

		fechaConexao();
	}
	
	public Funcionario findByCpf(String cpf) throws Exception {

		String query = "select * from funcionario where cpf = ?";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setString(1, cpf);

		rs = stmt.executeQuery();

		Funcionario funcionario = null;
		
		while (rs.next()) {

			funcionario = new Funcionario();
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			CargoDAO cargoDao = new CargoDAO();
			DepartamentoDAO departamentoDao = new DepartamentoDAO();
			
			funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setTelefone(rs.getString("telefone"));
			funcionario.setCpf(rs.getString("cpf"));
			funcionario.setDataNasc(ConverteData.stringToDate(rs.getString("data_nasc")));
			funcionario.setEndereco(enderecoDAO.findById(rs.getInt("id_endereco")));
			funcionario.setSenha(rs.getString("senha"));
			funcionario.setCargo(cargoDao.findById(rs.getInt("id_cargo")));
			funcionario.setDepartamento(departamentoDao.findById(rs.getInt("id_departamento")));

		}
		
		stmt.close();
		
		fechaConexao();

		return funcionario;

	}
	
	public Funcionario findByLoginSenha(String cpf, String senha) throws Exception {

		String query = "select * from funcionario where cpf = ? and senha = ?";
		
		abreConexao();
		
		stmt = con.prepareStatement(query);

		stmt.setString(1, cpf);
		stmt.setString(2, senha);

		rs = stmt.executeQuery();

		Funcionario funcionario = null;
		
		while (rs.next()) {

			funcionario = new Funcionario();
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			CargoDAO cargoDao = new CargoDAO();
			DepartamentoDAO departamentoDao = new DepartamentoDAO();
			
			funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setTelefone(rs.getString("telefone"));
			funcionario.setCpf(rs.getString("cpf"));
			funcionario.setDataNasc(ConverteData.stringToDate(rs.getString("data_nasc")));
			funcionario.setEndereco(enderecoDAO.findById(rs.getInt("id_endereco")));
			funcionario.setSenha(rs.getString("senha"));
			funcionario.setCargo(cargoDao.findById(rs.getInt("id_cargo")));
			funcionario.setDepartamento(departamentoDao.findById(rs.getInt("id_departamento")));

		}
		
		stmt.close();
		
		fechaConexao();

		return funcionario;

	}

}
