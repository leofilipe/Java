package com.github.leofilipe.springboot.todo_app.tryout.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("leo");
		
		boolean isValidPassword = password.equals("123456");
		
		return isValidUsername && isValidPassword;
	}
}
