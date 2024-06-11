package com.github.leofilipe.java.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class BusinessClass{
	
	//field injection
	//@Autowired
	Dependency1 dep01;
	
	//field injection
	//@Autowired
	Dependency2 dep02;
	
	@Autowired
	public BusinessClass(Dependency1 dep01, Dependency2 dep02) {
		super();
		this.dep01 = dep01;
		this.dep02 = dep02;
		System.out.println("Constructor injection BusinessClass");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Using " + dep01 + " and " + dep02;
	}

//	@Autowired
//	public void setDep01(Dependency1 dep01) {
//		System.out.println("Setter injection dep 01");
//		this.dep01 = dep01;
//	}
//
//	@Autowired
//	public void setDep02(Dependency2 dep02) {
//		System.out.println("Setter injection dep 02");
//		this.dep02 = dep02;
//	}
	
	
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan// ("com.github.leofilipe.java.learnspringframework.game")//the lacking of a
// package auto scans current one
public class DepInjectionLauncherApplication {


	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	
			System.out.println(context.getBean(BusinessClass.class));
		}
	}
}
