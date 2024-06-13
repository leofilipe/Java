package com.github.leofilipe.java.learnspringframework.examples.h1;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.github.leofilipe.java.learnspringframework.game.GameRunner;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Configuration
@ComponentScan
public class XmlConfigurationContextLauncherApplication {


	
	public static void main(String[] args) {

		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.DEBUG);

		try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean(GameRunner.class));

		}
	}
}
