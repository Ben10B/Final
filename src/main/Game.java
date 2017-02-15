package main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
	private boolean running = false;
	private Thread thread;
	public static final int WIDTH = 1040, HEIGHT = WIDTH-200;
	public Game(){
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public static void main(String[] args) {
		new Window(WIDTH, HEIGHT, "In Progress", new Game());
	}
}
