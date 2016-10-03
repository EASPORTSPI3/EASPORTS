package br.com.easports.persistence;

import java.sql.*;

public class DAO {

	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String DATABASE = "jdbc:sqlite:";
	private static final String URL = System.getProperty("user.dir");;
	private static final String DIRETORIO = "\\WebContent\\WEB-INF\\lib\\easports.db";

	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;

	protected void abreConexao() throws Exception {

		Class.forName(DRIVER);

		if (con == null) {

			con = DriverManager.getConnection(DATABASE + URL + DIRETORIO);
			
		}
	}

	protected void fechaConexao() throws Exception {

		if (con != null) {

			con.close();

		}

	}
}
