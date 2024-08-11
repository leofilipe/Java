package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

	// >>disabling csrf
	// >>statless rest api

	@Bean // FilterChain
	public SecurityFilterChain filterChaint(HttpSecurity http) throws Exception {

		// spring security authenticates all requests, we want to use basic
		// authentication
		// 1. authenticates all requests. This will ensure that only authenticated
		// requests can access the system's pages
		http.authorizeHttpRequests(auth -> 
			auth
			.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.anyRequest().authenticated());

		// 2. enables basic authentication (no sessions). This will provide a pop-signin
		// for providing login and password on access attempts
		http.httpBasic(Customizer.withDefaults());

		// 3. enables stateless CSRF for the REST API
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		//4. disable CSRF
		http.csrf(csrf->csrf.disable());
		return http.build(); // if the method just returns the buildm then its is the same as disabling the
								// authentication
		
		//alternatively, it could have been written as:
		/*	return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
		 * 						.httpBasic(Customizer.withDefaults())
		 * 						.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		 * 						.csrf().disable().build();
		 * */
	}
}
