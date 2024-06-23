package com.github.leofilipe.springboot.todo_app.hello_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	
	@RequestMapping("")
	@ResponseBody //returns the string as it is
	public String sayHello() {
		return "Hello there! I'm index";
	}
	
	@RequestMapping("hello-jsp")
	public String sayHelloJSP() {
		return "hello"; //reroutes to hello.jsp using the prefix and suffix set at the properties file
	}
}
