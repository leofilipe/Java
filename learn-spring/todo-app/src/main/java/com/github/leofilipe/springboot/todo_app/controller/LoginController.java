package com.github.leofilipe.springboot.todo_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.leofilipe.springboot.todo_app.service.AuthenticationService;

@Controller
@SessionAttributes("name")
public class LoginController {

	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET // limita o acesso ao metodo get (ex.:barra de endereço)
																// exige a definição do q fazer com a requisicao POST,
																// se desejavel
	)
	/*
	 * public String gotoLoginPage(@RequestParam String name, ModelMap model) {
	 * 
	 * model.put("name", name);
	 * 
	 * logger.debug("Request param is {}", name);//for debug level; logger.info for
	 * info level
	 * 
	 * return "login"; }
	 */

	public String gotoLoginPage() {

		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}

		model.put("errorMessage", "Invalid Credentials! Please try again!");
		return "login";
	}

}
