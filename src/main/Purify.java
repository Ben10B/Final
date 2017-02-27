package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Purify extends JFrame{
	
	private final int WIDTH = 250, HEIGHT = WIDTH+100;
	private PurifyListener victim;
	
	public Purify(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	}
	
	public void setVictim(PurifyListener p){
		this.victim = p;
	}
}
