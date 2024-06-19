package com.github.leofilipe.java.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

	@Autowired
	private CurrenceServiceConfiguration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrenceServiceConfiguration retrieveCurrenceServiceConfiguration(){
		
		return this.configuration;
	}
}
