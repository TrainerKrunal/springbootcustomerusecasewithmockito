package com.scb.sgml.demospringbootapp.dao;

import java.util.List;

import com.scb.sgml.demospringbootapp.entities.Customer;

public interface ICustomerDAO {

	public String addCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public String updateCustomer(int id,Customer c);
	public String deleteCustomer(int id);
	public List<Customer> getCustomerByAccountType(String accountType);
	
	
	
}
