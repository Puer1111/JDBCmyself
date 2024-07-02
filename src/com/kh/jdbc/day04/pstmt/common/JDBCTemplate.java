package com.kh.jdbc.day04.pstmt.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCTemplate {
//	private static final String Driver_name = "oracle.jdbc.driver.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static final String ID = "EZZJDBC";
//	private static final String PW = "EZZJDBC";
	private static Properties prop;
	private static Connection conn;
	private static String File_Name = "resource/dev.properties";
//	private static String DriverName;
//	private static String URL;
//	private static String ID;
//	private static String PW;
//	
//	
//	public JDBCTemplate() {
//		prop= new Properties();
//		try {
////			prop.load(new FileReader("resources/dev.properties"));
////			DriverName = prop.getProperty("Driver_Name");
////			URL = prop.getProperty("URL");
////			
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//	
public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
	prop = new Properties();
	Reader reader = new FileReader(File_Name);
	prop.load(reader);
	String DriverName = prop.getProperty("DriverName");
	String URL = prop.getProperty("URL");
	String ID = prop.getProperty("ID");
	String PW = prop.getProperty("PW");
	
	
	if(conn==null|| conn.isClosed()) {
		Class.forName(DriverName);
		conn = DriverManager.getConnection(URL, ID, PW);
	}	
	return conn;
}

}
