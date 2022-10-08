package com.scb.sgml.demospringbootapp.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scb.sgml.demospringbootapp.entities.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	
	//select * from customer -----> id,name,email,phone,accounttype
	 @Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getLong("phone"));
		c.setAccountType(rs.getString("accounttype"));
		
		return c;
	}

}
