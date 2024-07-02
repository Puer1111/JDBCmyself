package com.kh.jdbc.day04.pstmt.employee.model.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.jdbc.day04.pstmt.common.JDBCTemplate;
import com.kh.jdbc.day04.pstmt.employee.model.dao.EmployeeDao;
import com.kh.jdbc.day04.pstmt.employee.model.vo.Employee;

public class EmployeeService {
//	private JDBCTemplate jdbcTemplate;
	private EmployeeDao eDao;

	public EmployeeService() {
//		jdbcTemplate = new JDBCTemplate();
		eDao = new EmployeeDao();
	}

	public List<Employee> SelectList() {
		Connection conn = null;
		List<Employee> eList = null;
		try {
			conn = JDBCTemplate.getConnection();
			eList = eDao.selectList(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return eList;
	}

	public int insertEmployee(Employee emp) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = eDao.insertEmployee(conn, emp);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}

	public int deleteEmployee(String empId) {
		Connection conn = null;
		int result = 0;

		try {
			conn = JDBCTemplate.getConnection();
			result = eDao.deleteEmployee(conn, empId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Employee selectOneById(String empId) {
		Connection conn = null;
		Employee result = null;
		try {
			conn = JDBCTemplate.getConnection();
			result = eDao.selectOneByid(conn, empId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateEmployee(Employee emp) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = eDao.updateEmployee(conn, emp);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
