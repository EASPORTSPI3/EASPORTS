package br.com.easports.persistence;

import br.com.easports.entities.Unidade;

public class UnidadeDAO extends Conexao{
	
	public void adicionarUnidade(Unidade unidade) {
		try {
			conexao = abreConexao();
			
			String sql = "INSERT INTO UNIDADE(nome, endereco, telefone)VALUES(?,?,?)";

			pstmt.setString(1, unidade.getNome());
			pstmt.setString(2, unidade.getEndereço());
			pstmt.setString(3, unidade.getTelefone());
			
			pstmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
