package com.github.leofilipe.java.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address) {};

record Address(String firstLine, String city) {};


@Configuration
public class HelloWorldConfig {

	@Bean
	public String name() {
		return "Leo";
	}
	
	@Bean
	public int age() {
		return 39;
	}
	
	@Bean
	@Primary //makes this one the primary bean for Person type
	public Person person() {
		return new Person("Leo", 15, new Address("Minha rua", "Minha cidade"));
	}
	
	@Bean(name = "person2")
	public Person person2methodCall() {
		
		return new Person(name(), age(), address());
	}
	
	@Bean(name = "person3")	//parameters must have the same name as its beans
	public Person person3Parameters(String name, int age, Address address2) {
		
		return new Person(name, age + 1, address2); //+1 just to show a different output
	}
	
	@Bean(name = "person4")	//parameters must have the same name as its beans
	public Person person4Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address) {
		
		return new Person(name, age + 1, address); //+1 just to show a different output
	}
	
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("R. rua, n. 1, Bairro", "Porto Alegre - RS");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3Qualifier") //may be used as an option to @Primary
	public Address address3() {
		return new Address("R. rua, n. 1, Bairro", "Porto Alegre - RS");
	}
}
