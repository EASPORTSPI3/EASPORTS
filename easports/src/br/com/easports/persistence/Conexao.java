package br.com.easports.persistence;

import java.sql.*;

/*
 * Classe para abrir ou fechar a conexão com o banco de dados
 */

public class Conexao {
	
	static Connection conexao;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	// metodo que retorna a conexão
	
	public static Connection abreConexao() throws Exception {
		
		// String para pegar o caminho da pasta raiz do projeto.
		
		String caminho = System.getProperty("user.dir");
		String diretorio = "\\WebContent\\WEB-INF\\lib\\easports.db";
		
		System.out.println(caminho);
		
		//driver de conexão para o SQLite
		
		Class.forName("org.sqlite.JDBC");
		
		// Abrindo a conexão com o banco de dados, que encontra-se na pasta "lib" do projeto
		
		conexao = DriverManager.getConnection("jdbc:sqlite:" + caminho + diretorio);
		
		return conexao;
	}

	//metodo para fechar a conexão
	
	public static void fechaConexao() {
			try {
			conexao.close();
			
			//JOptionPane.showMessageDialog(null, "banco fechado");
			
		} catch (SQLException fecha) {
			
			//JOptionPane.showMessageDialog(null, "Não foi possivel " + "fechar o banco de dados: " + fecha);
			
		}

	}
}

	

