package com.scb.sgml.demospringbootapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.scb.sgml.demospringbootapp.entities.Calculator;

public class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	public void setUp() {
		System.out.println("Before all tests start--> Initiating Calculator Object ...");
		calculator=new Calculator();

	}

	@Test
	public void demoTest() {
		assertTrue(true);
	}

	@Test
	public void testAddition() {
		int expected=20;
		int actual=calculator.add(10, 10);

		assertEquals(expected, actual);

	}
	@Test
	public void testSubtraction() {
		int expected=10;
		int actual=calculator.subtract(30, 20);

		assertEquals(expected, actual);
	}

	@AfterEach
	public void cleanUp() {
		System.out.println("After all tests end --> Destroying calculator object..");
		calculator=null;
	}
}
