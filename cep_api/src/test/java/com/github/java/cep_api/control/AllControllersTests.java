package com.github.java.cep_api.control;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ 
	com.github.java.cep_api.control.jackson.AddressControllerTest.class,
	com.github.java.cep_api.control.gson.AddressControllerTest.class,
	com.github.java.cep_api.control.jackson.AddressControllerTest.class,
	com.github.java.cep_api.control.gson.AddressControllerTest.class
	})
public class AllControllersTests {

}
