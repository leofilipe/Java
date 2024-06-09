package com.github.leofilipe.java.learnspringframework.game;

public class MarioGame implements GamingConsole{

	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Crouch");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("Go forward");
	}
}
