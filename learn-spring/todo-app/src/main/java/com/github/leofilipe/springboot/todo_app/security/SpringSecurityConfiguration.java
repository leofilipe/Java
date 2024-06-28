package com.github.leofilipe.springboot.todo_app.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	// look for LDAP

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		//lambda function that receives a string as input and 
		//returns a string as output
		Function<String, String> passwordEncoder =
				input -> passwordEncoder().encode(input);
		UserDetails details = User.builder().passwordEncoder(passwordEncoder)
				//User.withDefaultPasswordEncoder()
				.username("leo").password("123456")
				.roles("USER", "ADMIN").build();
		
		return new InMemoryUserDetailsManager(details);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
