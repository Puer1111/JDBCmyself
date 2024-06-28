package com.kh.jdbc.day01.basic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCRun {

	public static void main(String[] args) throws ClassNotFoundException  {
		/*JDBC 코딩 절차
		 * 1. 드라이버 등록 (jar)
		 * 2. DBMS 연결 생성 (ID : KH , PWD : KH)
		 * 3. Statement 객체 생성 (워크시트 , 쿼리문 실행 준비)
		 * 4. SQL전송 ( ctrl + enter)
		 * 5. 결과받기(result set)
		 * 6. 자원해제
		 */
		
		//1. 드라이버 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		//2.DBMS 연결 생성
		try {
			Connection conn = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
		//3. Statement 객체 생성
			Statement stmt = conn.createStatement();
//			String query = "select * from employee";
			String query = "select * from department";
		//4.SQL 전송 , 5. 결과 받기
			ResultSet rset = stmt.executeQuery(query);
			//후처리 - 결과값 복사 붙여넣기 
			while(rset.next()) { // 다음 값이 있는 지 체크
//				System.out.println("직원명: "+ rset.getString("EMP_NAME")); // 컬렴 명 오타없이 적기
				System.out.println("부서명: "+ rset.getString("dept_title")); // 컬렴 명 오타없이 적기
				
			}
		//6. 자원 해제
			rset.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
