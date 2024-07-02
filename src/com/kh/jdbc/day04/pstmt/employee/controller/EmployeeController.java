package com.kh.jdbc.day04.pstmt.employee.controller;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.day04.pstmt.employee.model.dao.EmployeeDao;
import com.kh.jdbc.day04.pstmt.employee.model.service.EmployeeService;
import com.kh.jdbc.day04.pstmt.employee.model.vo.Employee;

public class EmployeeController {
//	private EmployeeDao eDao;
	private EmployeeService eService;

	public EmployeeController() {
//		eDao = new EmployeeDao();
		eService = new EmployeeService();
	}

	public List<Employee> printAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> eList = eService.SelectList();

		return eList;

	}

	public int insertEmployee(Employee emp) {
		int result = eService.insertEmployee(emp);
		return result;
	}

	public int deleteEmployee(String empId) {
		int result = eService.deleteEmployee(empId);
		
		return result;
	}

	public Employee selectOneById(String empId) {
		Employee emp = eService.selectOneById(empId);
			return emp;
	}

	public int updateEmployee(Employee emp) {
		int result = eService.updateEmployee(emp);
		return result;
	}

}
