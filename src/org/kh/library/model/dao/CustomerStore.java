package org.kh.library.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.kh.library.model.vo.Customer;

public class CustomerStore implements CustomerStoreI{

	@Override
	public ArrayList<Customer> selectAllCustomer(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectNameSearch(String CName, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectIdSearch(String CId, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCustomer(Customer customer, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(String CId, Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
