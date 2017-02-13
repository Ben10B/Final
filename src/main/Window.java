package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	private JPanel panel;
	public Window(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("In Progress");
		Container c = this.getContentPane();
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setBackground(Color.gray);
		c.add(panel);
		
		this.pack();
	}
}
