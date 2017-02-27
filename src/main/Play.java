package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class Play extends JFrame{
	private int counter = 1;
	private JPanel panel;
	private JLabel label;
	private Level lvl1;
	
	public Play(){
		this.setTitle("Play");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		System.out.println("I'm in Play JFrame");
		
		if(counter == 1){
			lvl1 = new Level();
			lvl1.setBackground(Color.GRAY);
			c.add(lvl1);
		}
		this.pack();
	}

	public void render(){
		
	}
}
