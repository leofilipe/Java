package com.github.leofilipe.java.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.leofilipe.java.learnspringframework.game")
public class GameAppLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GameAppLauncherApplication.class)) {

			context.getBean(GamingConsole.class).up(); // 03 Gaming Consoles, still needs fixing
			context.getBean(GameRunner.class).run();

			/*
			 * Arrays.stream(context.getBeanNamesForType(GamingConsole.class)).forEach(name
			 * -> {
			 * 
			 * name = name.substring(0, 1).toUpperCase() + name.substring(1);
			 * 
			 * context.getBean(GameRunner.class).setGamingConsole((GamingConsole)Class.
			 * forName("com.github.leofilipe.java.learnspringframework.game." + name)); try
			 * { System.out.println(Class.forName(
			 * "com.github.leofilipe.java.learnspringframework.game." + name)); } catch
			 * (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 * 
			 * });
			 */

		}
	}
}
