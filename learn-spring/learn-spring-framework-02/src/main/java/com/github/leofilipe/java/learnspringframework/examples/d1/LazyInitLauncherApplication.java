package com.github.leofilipe.java.learnspringframework.examples.d1;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@Component
class ClassA {

}

@Component @Lazy
class ClassB {

	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("Initialization Class B");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do something");
	}
}

@Configuration
@ComponentScan
public class LazyInitLauncherApplication {

	public static void main(String[] args) {
		
		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.DEBUG);
		
		try (var context = new AnnotationConfigApplicationContext(LazyInitLauncherApplication.class)) {

			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Context initialization completed");
			context.getBean(ClassB.class).doSomething();

		}
	}
}
