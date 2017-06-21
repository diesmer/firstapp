package nl.hu.ipass.application.persistence;

import java.sql.*;

public class SQLConnection {
	private Connection conn = null;
	private String table = "";

	public SQLConnection(String DB_DRIV, String DB_URL, String DB_USER, String DB_PASS) {
		try {
			DB_DRIV = "org.postgresql.Driver";
			Class.forName(DB_DRIV);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			conn.setAutoCommit(true);
			System.out.println("db succesvol geconnect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SQLConnection(Connection conn) {
		this.conn = conn;
	}
	public void save() {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public boolean Update(String query) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(query) == 1 ? true : false;
	}

	public ResultSet Retrieve(String query) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs != null) {
			return rs;
		} else {
			return null;
		}
	}
}