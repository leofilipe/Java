package com.github.leofilipe.java.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.leofilipe.java.learnspringframework.game.GameRunner;
import com.github.leofilipe.java.learnspringframework.game.PacmanGame;

@Configuration
@ComponentScan("com.github.leofilipe.java.learnspringframework.game")
public class GameAppLauncherApplication {


	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GameAppLauncherApplication.class)){
			
			context.getBean(PacmanGame.class).up(); //03 Gaming Consoles, still needs fixing
			context.getBean(GameRunner.class).run();
	
		}
	}
}
