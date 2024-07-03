package com.github.leofilipe.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="hello-world/path-variable/{name}")
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s", name));
	}
}
