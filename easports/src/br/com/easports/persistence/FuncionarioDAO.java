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

}
