package com.scb.sgml.demospringbootapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.sgml.demospringbootapp.dao.ICustomerDAO;
import com.scb.sgml.demospringbootapp.entities.Customer;
import com.scb.sgml.demospringbootapp.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerDAO customerdao;      //ICustomer obj = new CustomerDAO();
	 
	@Override
	public String addCustomer(Customer c) {
		
	
		String result = customerdao.addCustomer(c);
		//custom function to send OTP on customer mobile number
		//sending an email to customer mentioning its customer ID
		return result;
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list = customerdao.getAllCustomers();
		
		return list;
		
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Customer c = customerdao.getCustomerById(id);
		return c;
	}

	 
	public String updateCustomer(int id, Customer c) {
		
		String result = customerdao.updateCustomer(id, c);
		return result;
	}

	@Override
	public String deleteCustomer(int id) {
		
		String result = customerdao.deleteCustomer(id);
		return result;
	}

	@Override
	public List<Customer> getCustomerByAccountType(String accountType) {
		List<Customer> list = customerdao.getCustomerByAccountType(accountType);
		return list;
	}

}
