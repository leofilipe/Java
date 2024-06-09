package com.github.leofilipe.java.learnspringframework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.leofilipe.java.learnspringframework.game.GameRunner;
import com.github.leofilipe.java.learnspringframework.game.GamingConsole;

public class App03GameSpringBeans {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			
			//sempre executa o ultimo bean do array, ja que o estado de GamingConsole game foi atualizado ao final
			//da coleta do array. Para funcionar corretamente, seria preciso passar game como parametro para
			//o bean GameRunner
			//Arrays.stream(context.getBeanNamesForType(GamingConsole.class)).forEach(name -> {
			//	context.getBean(name);
			//	context.getBean(GameRunner.class).run();
			//});
			
			//context.getBean("super_contra");
			//context.getBean(GameRunner.class).run();
			
			context.getBean("mario");
			context.getBean(GameRunner.class).run();
			
			context.getBean("pacman");
			context.getBean(GameRunner.class).run();
			
		}
	}
}
