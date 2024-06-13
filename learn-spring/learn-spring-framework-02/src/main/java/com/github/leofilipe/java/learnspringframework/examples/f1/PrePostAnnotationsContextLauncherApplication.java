package com.github.leofilipe.java.learnspringframework.examples.f1;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("Cleanup");
	}
	
}

@Component
class SomeDependency{

	public void getReady() {
		System.out.println("Some logic using SomeDependecy");
		
	}
	
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {


	
	public static void main(String[] args) {

		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.DEBUG);

		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
