package com.github.leofilipe.springboot.todo_app.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// look for LDAP

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails details = createNewUser("leo", "123456");
		UserDetails details2 = createNewUser("cris", "123456");

		return new InMemoryUserDetailsManager(details, details2);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		http.formLogin(Customizer.withDefaults());

		http.csrf(csrf -> csrf.disable());
		http.headers(header -> header.frameOptions(frameOptions -> frameOptions.disable()));

		return http.build();
	}

	private UserDetails createNewUser(String username, String password) {

		// lambda function that receives a string as input and
		// returns a string as output
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails details = User.builder().passwordEncoder(passwordEncoder)
				// User.withDefaultPasswordEncoder()
				.username(username).password(password).roles("USER", "ADMIN").build();
		return details;
	}

}
