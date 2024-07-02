package com.kh.jdbc.day04.pstmt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCTemplate_OLD {
	private static final String Driver_name = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "EZZJDBC";
	private static final String PW = "EZZJDBC";

	private static Connection conn;
	
	
public static Connection getConnection() throws SQLException, ClassNotFoundException {
	if(conn==null|| conn.isClosed()) {
		Class.forName(Driver_name);
		conn = DriverManager.getConnection(URL, ID, PW);
	}	
	return conn;
}

}
