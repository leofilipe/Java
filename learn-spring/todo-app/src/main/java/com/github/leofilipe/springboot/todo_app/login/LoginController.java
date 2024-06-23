package com.github.leofilipe.springboot.todo_app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {	
	@RequestMapping("login")
	/*public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		
		model.put("name", name);
		
		logger.debug("Request param is {}", name);//for debug level; logger.info for info level

		return "login";
	}*/
	
	public String gotoLoginPage() {
		
		return "login";
	}
}
