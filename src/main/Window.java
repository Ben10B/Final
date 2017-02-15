package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	
	public Window(int width, int height, String title, Game game){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(title);
		
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.add(game);
		game.start();
	}
	public Window(int width, int height, String title, Game game, JPanel panel){
		this.getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(title);
		
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.add(panel);
		this.add(game);
		game.start();
	}
}
