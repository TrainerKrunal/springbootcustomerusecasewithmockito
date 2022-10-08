package com.scb.sgml.demospringbootapp.service;

import java.util.List;

import com.scb.sgml.demospringbootapp.entities.Customer;

public interface ICustomerService {

	public String addCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public String updateCustomer(int id,Customer c);
	public String deleteCustomer(int id);
	public List<Customer> getCustomerByAccountType(String accountType);
	
}
