package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Departamento;

public class DepartamentoDAO extends DAO{
	
	public List<Departamento> listAll() throws Exception{
		
		String query = "select * from departamento";
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
}
