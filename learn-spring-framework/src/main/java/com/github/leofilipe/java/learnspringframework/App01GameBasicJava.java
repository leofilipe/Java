
package com.github.leofilipe.java.learnspringframework;

import com.github.leofilipe.java.learnspringframework.game.GameRunner;
import com.github.leofilipe.java.learnspringframework.game.MarioGame;
import com.github.leofilipe.java.learnspringframework.game.PacmanGame;
import com.github.leofilipe.java.learnspringframework.game.SuperContraGame;

public class App01GameBasicJava {

	public static void main(String[] args) {
		
		var game = new PacmanGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
		
	}
}