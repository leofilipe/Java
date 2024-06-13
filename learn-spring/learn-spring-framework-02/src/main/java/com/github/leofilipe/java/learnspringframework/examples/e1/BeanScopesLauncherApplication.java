package com.github.leofilipe.java.learnspringframework.examples.e1;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.leofilipe.java.learnspringframework.game.GameRunner;
import com.github.leofilipe.java.learnspringframework.game.GamingConsole;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@Component
class NormalClass{
	
}

@Component @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {


	
	public static void main(String[] args) {
		
		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.DEBUG);
		
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
			

			
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));

			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
	
		}
	}
}
