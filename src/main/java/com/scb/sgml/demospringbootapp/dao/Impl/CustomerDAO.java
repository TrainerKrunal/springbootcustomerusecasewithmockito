package com.scb.sgml.demospringbootapp.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.scb.sgml.demospringbootapp.dao.ICustomerDAO;
import com.scb.sgml.demospringbootapp.entities.Customer;
import com.scb.sgml.demospringbootapp.util.Status;

@Repository
public class CustomerDAO implements ICustomerDAO{

	@Autowired
	JdbcTemplate template;    //using autowired we are implementing DI

	 
	public String addCustomer(Customer c) {
		
		try {
			String query = "insert into customer (name,email,phone,accounttype) values (?,?,?,?)";
			int rowInserted = template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.getAccountType());
			
			if(rowInserted==1) {
				return Status.SUCCESS;
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer was not created");
			}
		}
		catch(Exception e) {
			if (e instanceof ResponseStatusException) {
				throw e;
			}
			else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
	}

	 
	public List<Customer> getAllCustomers() {
		try {
			String query = "select id,name,email,phone,accounttype  from customer" ;
			RowMapper<Customer> rowmapper = new CustomerRowMapper();
			List<Customer> list = template.query(query, rowmapper);
			if(list.size() == 0) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customer Found");
			}
			else {
				return list;
			}
		}
		catch(Exception e) {
			if (e instanceof ResponseStatusException) {
				throw e;
			}
			else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
	}

	 
	public Customer getCustomerById(int id) {
		try {
			String query = "select id,name,email,phone,accounttype from customer where id=?";
			RowMapper<Customer> rowmapper = new CustomerRowMapper();
			Customer c = template.queryForObject(query, rowmapper,id);
			return c;
		}
		catch(DataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customer Found");
		}
		catch(Exception e) {
			  if( e instanceof ResponseStatusException ) {
					throw e;
				}
				else {
					throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
				}
		  }
	}

 
	public String updateCustomer(int id, Customer c) {
		try {
			String query = "update customer set name=?,email=?,phone=?,accounttype=? where id=?";
			int rowUpdated = template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.getAccountType(),id);
			if(rowUpdated == 1) {
				return Status.SUCCESS;
			}
			else
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with id ["+id+"] was not found" );
			}
		}
		catch(Exception e) {
			if (e instanceof ResponseStatusException) {
				throw e;
			}
			else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
		
	}

	 
	public String deleteCustomer(int id) {
		try {
			String query = "delete from customer where id =?";
			int rowDeleted = template.update(query,id);
			
			if(rowDeleted==1) {
				return Status.SUCCESS;
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with id ["+id+"] was not deleted");
			}
		}
		catch(Exception e) {
			if (e instanceof ResponseStatusException) {
				throw e;
			}
			else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
		}
	}

	 
	public List<Customer> getCustomerByAccountType(String accountType) {
		try {
			String query = "select id,name,email,phone,accounttype from customer where accounttype=?";
			RowMapper<Customer> rowmapper = new CustomerRowMapper();
			List<Customer> list = template.query(query, rowmapper,accountType);
			if (list.size() == 0) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customers found");
			}
			else {
				return list;
			}	
			
		}
		catch(Exception e) {
			if( e instanceof ResponseStatusException ) {
				throw e;
			}
			else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
			}
			
		
		}
	}

}
