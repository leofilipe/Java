package com.github.leofilipe.java.learnspringframework.exercises.m02e01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class BusinessCalculationService {
	
	private DataService dataService;

	@Autowired
	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}



	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}
