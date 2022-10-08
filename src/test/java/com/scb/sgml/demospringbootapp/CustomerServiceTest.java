package com.scb.sgml.demospringbootapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.sgml.demospringbootapp.dao.Impl.CustomerDAO;
import com.scb.sgml.demospringbootapp.entities.Customer;
import com.scb.sgml.demospringbootapp.service.impl.CustomerService;

public class CustomerServiceTest {

	@Mock // component I want to mock
	private CustomerDAO customerDAO;

	@InjectMocks // this is the component where the mocked component is injected
	private CustomerService customerService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	

	Customer c1=new Customer(1001,"Krunal","a@a.com",9988776654l,"current");
	Customer c2=new Customer(1002, "Alex", "alex@gmail.com", 9988776654l, "Current");
	Customer c3=new Customer(1003, "Mike", "mike@gmail.com", 9988776653l, "Savings");
	
	@Test
	public void getAllCustomers_success() {
		//Mock
		List<Customer> customers=new ArrayList<>(Arrays.asList(c1,c2,c3));

		Mockito.when(customerDAO.getAllCustomers()).thenReturn(customers);    // It is my MOCK method to check what getAllCustomers() returns
		
		//When
		List<Customer> customersReturned=customerService.getAllCustomers();   // Calling actual method of customerservice.getAllCustomers();


		//Then
		Assertions.assertNotNull(customersReturned);
		Assertions.assertEquals(customersReturned.size(), 3);
		Assertions.assertEquals(customersReturned.get(1).getEmail(), "alex@gmail.com");


	}
	
	@Test
	public void getCustomerById_success() {
		//Mock
		Customer customer=c3;
													//1003						//c3
		Mockito.when(customerDAO.getCustomerById(customer.getId())).thenReturn(customer);
		//When

		Customer customerReturned=customerService.getCustomerById(1003);

		//Then

		Assertions.assertNotNull(customerReturned);
		//Assertions.assertEquals(customerReturned.getAccountCreationDate(), LocalDate.parse("2020-12-12"));
		Assertions.assertEquals(customerReturned.getAccountType(), "Savings");
		Assertions.assertEquals(customerReturned.getName(), "Mike");



	}
	@Test
	public void addCustomer_success() {
		//Mock
		Customer customer=c1;

		Mockito.when(customerDAO.addCustomer(customer)).thenReturn("SUCCESS");
		//When 

		String message=customerService.addCustomer(customer);

		//Then
		Assertions.assertNotNull(message);
		Assertions.assertEquals(message, "SUCCESS");



	}

	@Test
	public void updateCustomer_success() {
//		Mock
		Customer customer=c1;

		Mockito.when(customerDAO.updateCustomer(1001,customer)).thenReturn("SUCCESS");
//		When 

		String message=customerService.updateCustomer(1001,customer);

//		Then
		Assertions.assertNotNull(message);
		Assertions.assertEquals(message, "SUCCESS");



	}

	@Test
	public void deleteCustomer_success() {
			//Mock

		Mockito.when(customerDAO.deleteCustomer(1003)).thenReturn("SUCCESS");
			//When 

		String message=customerService.deleteCustomer(1003);

			//Then
		Assertions.assertNotNull(message);
		Assertions.assertEquals(message, "SUCCESS");



	}


	
}
