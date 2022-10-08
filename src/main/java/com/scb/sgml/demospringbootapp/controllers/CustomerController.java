package com.scb.sgml.demospringbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.sgml.demospringbootapp.config.APISuccessPayload;
import com.scb.sgml.demospringbootapp.entities.Customer;
import com.scb.sgml.demospringbootapp.service.ICustomerService;

@RestController
@RequestMapping("/mycust")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	ICustomerService customerservice;
	
	
	@GetMapping("/customers")
	public ResponseEntity<APISuccessPayload> getAllCustomers() {
		
		List<Customer> list = customerservice.getAllCustomers();
		APISuccessPayload payload = new APISuccessPayload();
		payload.setBody(list);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage("Customers found");
		
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.OK);
		return response;
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<APISuccessPayload> addCustomer(@RequestBody Customer c){
		String result = customerservice.addCustomer(c);
		
		APISuccessPayload payload = APISuccessPayload.build(result, result, HttpStatus.CREATED);
		
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.CREATED);
		return response;
	}
	
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<APISuccessPayload> getCustomerById(@PathVariable int id){
		Customer c = customerservice.getCustomerById(id);
		APISuccessPayload payload = APISuccessPayload.build(c, "Customer Found", HttpStatus.OK);
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<APISuccessPayload> updateCustomer(@PathVariable int id,@RequestBody Customer c){
		
		String result = customerservice.updateCustomer(id, c);
		APISuccessPayload payload = new APISuccessPayload();
		payload.setBody(result);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage(result);
		
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<APISuccessPayload> deleteCustomer(@PathVariable int id){
		String result = customerservice.deleteCustomer(id);
		
		APISuccessPayload payload = new APISuccessPayload();
		payload.setBody(result);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage(result);
		
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/customers/account/{accountType}")
	public ResponseEntity<APISuccessPayload> getCustomerByAccountType(@PathVariable String accountType){
		
		List<Customer> list = customerservice.getCustomerByAccountType(accountType);
		APISuccessPayload payload = new APISuccessPayload();
		payload.setBody(list);
		payload.setStatus(200);
		payload.setHttpStatus(String.valueOf(HttpStatus.OK));
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage("Customers found");
		
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
}



















