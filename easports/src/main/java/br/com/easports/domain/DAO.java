package br.com.easports.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection getConnection() {

		Connection conn = null;
		final String caminho = System.getProperty("user.dir");

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:" + caminho + "/src/main/resources/br/com/easports/bd.db");
			System.out.println("dentro");
		} catch (final SQLException e) {
			System.out.println("erro");
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(final String[] args) {

		DAO.getConnection();

	}
}
