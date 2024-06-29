package com.github.leofilipe.springboot.todo_app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.leofilipe.springboot.todo_app.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {

		model.put("name", this.getLoggedUsername());
		return "welcome";
	}

	private String getLoggedUsername() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return auth.getName();
	}
	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public String
	 * gotoWelcomePage(@RequestParam String name, @RequestParam String password,
	 * ModelMap model) {
	 * 
	 * if (authenticationService.authenticate(name, password)) { model.put("name",
	 * name); model.put("password", password); return "welcome"; }
	 * 
	 * model.put("errorMessage", "Invalid Credentials! Please try again!"); return
	 * "login"; }
	 */
}
