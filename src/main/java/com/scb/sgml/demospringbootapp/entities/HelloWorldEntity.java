package com.scb.sgml.demospringbootapp.entities;

public class HelloWorldEntity {

	private String message;
	
	public HelloWorldEntity(String msg) {
		this.message=msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
