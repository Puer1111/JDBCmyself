package org.kh.library.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.kh.library.common.JDBCTemplate;

public class JDBCTemplate {
	private static final String Driver_Name = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = " jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "EZZJDBC";
	private static final String PW = "EZZJDBC";
	private static JDBCTemplate instance;
	private static Connection conn;

	public static JDBCTemplate getInstance() {
		if (instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		if (conn == null||conn.isClosed()) {
			Class.forName(Driver_Name);
			conn = DriverManager.getConnection(URL, ID, PW);

		}
		return conn;
	}
}
