package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	private boolean running = false;
	private Thread thread;
	private Menu menu;
	
	private STATE gameState = STATE.Menu;
	
	public Game(){
		menu = new Menu(this);
	
		if(gameState == STATE.Game){
			new Window(WIDTH, HEIGHT, "Game In Progress", this);
			
		}else if(gameState == STATE.Menu){
			new Window(WIDTH, HEIGHT, "Menu", this, menu);
		}
	}

	public static final int WIDTH = 1040, HEIGHT = WIDTH-200;
	public static void main(String[] args) {
		new Game();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
				updates = 0;
			}
		}
		
	}
	private void render() {}
	private void tick() {}
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
}
