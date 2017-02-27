package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Help extends JFrame{

	public Help(){
		this.setTitle("Help");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1040, 840));
		this.setMaximumSize(new Dimension(1040, 840));
		this.setMinimumSize(new Dimension(1040, 840));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		System.out.println("I'm in Help JFrame");
		
	}
	@Override
	public void paint(Graphics g){
		g.setColor(Color.cyan);
		g.drawString("Help", 200, 200);
	}
}
