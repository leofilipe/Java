package com.github.leofilipe.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public Person getFirstVerionOfPerson() {
		
		return new PersonV1("Leo Carvalho");
	}
	
	@GetMapping("/v2/person")
	public Person getSecondtVerionOfPerson() {
		
		return new PersonV2(new Name("Leo", "Carvalho"));
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public Person getFirstVerionOfPersonRequestParameter() {
		
		return new PersonV1("Leo Carvalho");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public Person getSecondtVerionOfPersonRequestParameter() {
		
		return new PersonV2(new Name("Leo", "Carvalho"));
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public Person getFirstVerionOfPersonRequestHeader() {
		
		return new PersonV1("Leo Carvalho");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public Person getSecondVerionOfPersonRequestHeader() {
		
		return new PersonV2(new Name("Leo", "Carvalho"));
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public Person getFirstVerionOfPersonAcceptHeader() {
		
		return new PersonV1("Leo Carvalho");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public Person getSecondVerionOfPersonAcceptHeader() {
		
		return new PersonV2(new Name("Leo", "Carvalho"));
	}

}
