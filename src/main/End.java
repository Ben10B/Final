package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class End extends JFrame{
	private JPanel win;

	public End(){
		this.setTitle("The End");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		
		win = new JPanel();
		win.setBackground(Color.cyan);
		c.add(win);
		
		this.pack();
	}
}
