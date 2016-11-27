package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Cargo;
import br.com.easports.entities.Departamento;

public class DepartamentoDAO extends DAO{
	
	public List<Departamento> listAll() throws Exception{
		
		String query = "select * from departamento order by departamento";
		abreConexao();

		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<Departamento> lista = new ArrayList<Departamento>();
		while(rs.next()){
			Departamento departamento = new Departamento();
			
			departamento.setIdDepartamento(rs.getInt("id_departamento"));
			departamento.setDepartamento(rs.getString("departamento"));
			lista.add(departamento);
		}
		return lista;
	}
	
	public Departamento findById(Integer id_departamento) throws Exception {

		String query = "select * from departamento where id_departamento = ?";

		abreConexao();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, id_departamento);

		rs = stmt.executeQuery();

		Departamento departamento = new Departamento();

		while (rs.next()) {

			departamento.setIdDepartamento(rs.getInt("id_departamento"));
			departamento.setDepartamento(rs.getString("departamento"));

		}

		stmt.close();

		fechaConexao();

		return departamento;

	}
	
}
