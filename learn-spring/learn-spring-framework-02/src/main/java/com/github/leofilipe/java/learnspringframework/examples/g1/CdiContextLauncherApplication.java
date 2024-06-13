package com.github.leofilipe.java.learnspringframework.examples.g1;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	
	private DataService dataService;

	
	public DataService getDataService() {
		
		return dataService;
	}

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	
}

//@Component
@Named
class DataService{
	
}
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {


	
	public static void main(String[] args) {

		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.DEBUG);

		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}
	}
}
