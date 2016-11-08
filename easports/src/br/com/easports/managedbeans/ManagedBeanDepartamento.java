package br.com.easports.managedbeans;

import java.util.List;

import br.com.easports.entities.Departamento;
import br.com.easports.persistence.DepartamentoDAO;

public class ManagedBeanDepartamento {

	private List<Departamento> listagemDepartamentos;

	public List<Departamento> getListagemDepartamentos() {
		
		try{
			
			DepartamentoDAO d = new DepartamentoDAO();
			
			listagemDepartamentos = d.listAll();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemDepartamentos;
	}
}
