package org.kh.library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kh.library.common.JDBCTemplate;
import org.kh.library.model.dao.CustomerStore;
import org.kh.library.model.vo.Customer;

public class CustomerService implements CustomerServiceI{
CustomerStore cStore;
public CustomerService() {
	cStore = new CustomerStore();
}
	@Override
	public ArrayList<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectNameSearch(String CName) {
		Connection conn = null;
		Customer result = null;
		try {
			conn = JDBCTemplate.getConnection();
			result = cStore.selectNameSearch(CName, conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectIdSearch(String CId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(String CId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
