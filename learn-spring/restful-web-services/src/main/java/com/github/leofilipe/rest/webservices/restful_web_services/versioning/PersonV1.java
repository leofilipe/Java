package com.github.leofilipe.rest.webservices.restful_web_services.versioning;

public class PersonV1 extends Person {

	private String name;

	public PersonV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}
	
	
}
