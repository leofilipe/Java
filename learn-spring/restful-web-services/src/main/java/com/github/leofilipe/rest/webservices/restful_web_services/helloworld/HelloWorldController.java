package com.github.leofilipe.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

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
	
	@GetMapping(path="/hello-world-international")
	//@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String helloWorldInternational() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", 
				//variables to be replaced in the message
				null, 
				"Default Message", 
				locale);
		
		//return "Hello World";
	}
}
