package br.com.easports.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	public static Connection getConnection() {

		Connection conn = null;
		String caminho = System.getProperty("user.dir");

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:" + caminho + "/src/main/resources/br/com/easports/bd.db");
			System.out.println("dentro");
		} catch (SQLException e) {
			System.out.println("erro");
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {

		DAO.getConnection();

	}

}
