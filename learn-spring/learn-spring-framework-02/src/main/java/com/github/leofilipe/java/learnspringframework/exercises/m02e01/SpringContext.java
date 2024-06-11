package com.github.leofilipe.java.learnspringframework.exercises.m02e01;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringContext {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(SpringContext.class)){
			
			Arrays.stream(context.getBeanNamesForType(DataService.class)).forEach(name -> {
				
				DataService serv = (DataService)context.getBean(name);
				
				System.out.println(Arrays.toString(serv.retrieveData()));
				
				//System.out.println("Max value: " + context.getBean(BusinessCalculationService.class).findMax());
				
				BusinessCalculationService bc = context.getBean(BusinessCalculationService.class);
				bc.setDataService(serv);
				
				System.out.println(bc.findMax());
				
				
				
			});
		}
	}
}
