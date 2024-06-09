package com.github.leofilipe.java.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github.leofilipe.java.learnspringframework.game.GameRunner;
import com.github.leofilipe.java.learnspringframework.game.GamingConsole;
import com.github.leofilipe.java.learnspringframework.game.MarioGame;
import com.github.leofilipe.java.learnspringframework.game.PacmanGame;
import com.github.leofilipe.java.learnspringframework.game.SuperContraGame;

@Configuration
public class GamingConfiguration {

	private GamingConsole game;
	
	@Bean(name = "pacman")
	@Primary
	public GamingConsole pacman_game() {
		return this.game = new PacmanGame();
	}
	
	@Bean(name = "mario")
	public GamingConsole mario_game() {
		return this.game = new MarioGame();
	}
	
	/*@Bean(name = "super_contra")
	public GamingConsole super_contra_game() {
		return this.game = new SuperContraGame();
	}*/
	
	@Bean
	public GameRunner run() {
		
		/*if(this.game != null) {
			return new GameRunner(this.game);
			gameRunner.run();
		}else {
			System.out.println("No game set for running at the console....");
		}*/
		
		return this.game != null? new GameRunner(this.game) : null;		
	}
		
}
