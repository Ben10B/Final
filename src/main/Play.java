package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Play extends JFrame{

	public Play(){
		this.setTitle("Play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1040, 840));
		this.setMaximumSize(new Dimension(1040, 840));
		this.setMinimumSize(new Dimension(1040, 840));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		System.out.println("I'm in Play JPanel");
		
	}
	@Override
	public void paint(Graphics g){
		g.setColor(Color.cyan);
		g.drawString("Play", 200, 200);
	}
}
