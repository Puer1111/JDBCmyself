package org.kh.library.controller;

import org.kh.library.model.service.CustomerService;
import org.kh.library.model.vo.Customer;

public class CustomerController implements CustomerControllerI {
	CustomerService cService;

	public CustomerController() {
		cService = new CustomerService();
	}

	@Override
	public void selectAllCustomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer selectNameSearch(String CName) {
		Customer cust = cService.selectNameSearch(CName);
		return cust;
	}

	@Override
	public void selectIdSearch(String CId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(String CId) {
		// TODO Auto-generated method stub

	}

}
