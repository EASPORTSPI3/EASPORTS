package br.com.easports.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.easports.entities.Cargo;


public class CargoDAO extends DAO{

	public List<Cargo> listAll() throws Exception{
		
		String query = "select * from cargo";
		abreConexao();

		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<Cargo> lista = new ArrayList<Cargo>();
		while(rs.next()){
			Cargo cargo = new Cargo();
			
			cargo.setIdCargo(rs.getInt("id_cargo"));
			cargo.setCargo(rs.getString("cargo"));
			lista.add(cargo);
		}
		return lista;
	}	
}
