package com.kh.jdbc.day04.pstmt.employee.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jdbc.day04.pstmt.common.JDBCTemplate;
import com.kh.jdbc.day04.pstmt.employee.model.vo.Employee;

public class EmployeeDao {
private Properties prop;
private final String FileName = "resource/query.properties";	
public EmployeeDao() {
	try {
		prop = new Properties();
		Reader reader = new FileReader(FileName);
		prop.load(reader);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
//	private final String Driver_name = "oracle.jdbc.driver.OracleDriver";
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private final String ID = "EZZJDBC";
//	private final String PW = "EZZJDBC";

	public List<Employee> selectList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		List<Employee> eList = null;
		String query = prop.getProperty("selectList");
		try {
//			conn = new JDBCTemplate().getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			eList = new ArrayList<Employee>();
			while (rset.next()) {
				Employee emp = rsetToEmployee(rset);
				eList.add(emp);
			}
			// rsetEmployee 메소드 생성
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return eList;
	}

	private Employee rsetToEmployee(ResultSet rset) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpId(rset.getString("emp_id"));
		emp.setEmpName(rset.getString("emp_name"));
		emp.setEmpNo(rset.getString("emp_no"));
		emp.setEmail(rset.getString("email"));
		emp.setPhone(rset.getString("phone"));
		emp.setDeptCode(rset.getString("dept_code"));
		emp.setJobCode(rset.getString("job_code"));
		emp.setSallevel(rset.getString("sal_level"));
		emp.setSalary(rset.getInt("salary"));
		emp.setBonus(rset.getDouble("Bonus"));
		emp.setManagerId(rset.getString("manager_ID"));
		emp.setHireDate(rset.getDate("hire_date"));
		emp.setEntDate(rset.getDate("ent_date"));
		emp.setEntyn(rset.getString("ent_yn"));

		return emp;
	}

//
//	public List<Employee> SelectList(Connection conn) {
//
//		return null;
//	}

	public int insertEmployee(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("insertEmployee");
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, emp.getEmpId());
		pstmt.setString(2, emp.getEmpName());
		pstmt.setString(3, emp.getEmpNo());
		pstmt.setString(4, emp.getJobCode());
		pstmt.setString(5, emp.getSallevel());
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

	public int deleteEmployee(Connection conn, String empId) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteEmployee");
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, empId);
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

	public Employee selectOneByid(Connection conn, String empId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Employee result = null;
		String query = "select * from employee where emp_id = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, empId);
		rset = pstmt.executeQuery();
		if (rset.next()) {
			result = rsetToEmployee(rset);
		}
		pstmt.close();
		rset.close();

		return result;
	}

	public int updateEmployee(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("updateEmployee");
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, emp.getEmail());
		pstmt.setString(2, emp.getPhone());
		pstmt.setString(3, emp.getDeptCode());
		pstmt.setInt(4, emp.getSalary());
		pstmt.setDouble(5, emp.getBonus());
		pstmt.setString(6, emp.getManagerId());
		pstmt.setString(7, emp.getEmpId());
		result = pstmt.executeUpdate();
		pstmt.close();
	
		return result;
	}

}
