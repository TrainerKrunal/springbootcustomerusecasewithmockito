package com.scb.sgml.demospringbootapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scb.sgml.demospringbootapp.entities.HelloWorldEntity;

@RestController
@RequestMapping("/helloworld")
public class HelloController {

	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String sayHello() {
		return "Hello SG-ML";
	}
	
	
	@GetMapping("/welcome")1
	public String welcomeMessage() {
		return "Welcome to SCB";
	}
	
	@GetMapping("/names")
	public List<String> getCandidateNames(){
		List<String> empnames = new ArrayList<>();
		empnames.add("Swee");
		empnames.add("Amir");
		empnames.add("Zam");
		empnames.add("Clement");
		
		return empnames;
	}
	
	@GetMapping("/users/{id}/{name}")
	public String testVariables(@PathVariable int id,@PathVariable String name) {
		String result="Your name is " + name +"Your id is "+id;
		return result;
	}
	
	@GetMapping(path="/hello-world-entity")
	public HelloWorldEntity helloworldentity() {
		
		return new HelloWorldEntity("Hey I am an entity message");
	}
	
}
