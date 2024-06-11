package com.github.leofilipe.java.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private GamingConsole game;
	
	public GameRunner(//@Qualifier("SuperContraGameQualifier") 
						GamingConsole game) {

		this.game = game;
	}

	public GameRunner setGamingConsole(GamingConsole game) {
		this.game = game;
		return this;
	}
	public void run() {

		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
		
	}
}
