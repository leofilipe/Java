package com.github.leofilipe.java.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

public static void main(String[] args) {
		
		//1: Launch string context
	
		//try with resources
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfig.class)){
			//2: configura what spring should manage: @Configuration
			
			//3: retrieve beans managed by string
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2"));
			
			System.out.println(context.getBean("person3"));
			
			System.out.println(context.getBean(Address.class));
			
			System.out.println(context.getBean("person4"));
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
	}
}
