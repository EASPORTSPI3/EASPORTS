package br.com.easports.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		final String caminho = System.getProperty("user.dir");
	
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:" + caminho + "/src/main/resources/br/com/easports/bd/easportsBd.db");
			System.out.println("dentro");
		} catch (final SQLException e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void incluir() {
		
		//alteracao  bill
		
		
		
		PreparedStatement stmt= null;
		Connection conn = null;
		
		String sql = "INSERT INTO TB_PESSOA (ID_PESSOA) VALUES (?)";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "1");
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
System.out.println("erro ao incluir");		}
		
	}
	

	
	
	
	public static void main(final String[] args) {
		
		incluir();
		

	}
}
