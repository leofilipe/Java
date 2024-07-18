package com.github.leofilipe.rest.webservices.restful_web_services.versioning;

public class PersonV2 extends Person {

	
	private Name name;

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
	
	
	
}
