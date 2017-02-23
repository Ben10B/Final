package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Window{

	public static void main(String[] args){
		Game g = new Game();
		g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		g.setTitle("Menu");
		g.setPreferredSize(new Dimension(1040, 840));
		g.setMaximumSize(new Dimension(1040, 840));
		g.setMinimumSize(new Dimension(1040, 840));
		g.setLocationRelativeTo(null);
		g.setResizable(false);
		g.setVisible(true);
	}

}
