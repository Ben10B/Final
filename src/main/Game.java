package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame{
	public static final int WIDTH = 1040, HEIGHT = WIDTH-200;
	private JButton playButton, helpButton, quitButton;
	
	public Game(){
		Game me = this;
		Play lvl = new Play();
		lvl.setDefaultCloseOperation(EXIT_ON_CLOSE);
		lvl.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		lvl.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		lvl.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		lvl.setLocationRelativeTo(null);
		lvl.setResizable(false);
		lvl.setVisible(true);
//		Container c = this.getContentPane();
//		JPanel panel1 = new JPanel();
//		panel1.setBackground(Color.cyan);
//		panel1.setPreferredSize(new Dimension(WIDTH, HEIGHT-600));
//		c.add(panel1, BorderLayout.NORTH);
//		
//		
//		JPanel panel2 = new JPanel();
//		panel2.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//		panel2.setBackground(Color.darkGray);
//		
//		playButton = new JButton("Play");
//		playButton.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg) {
//				Play lvl = new Play();
//				lvl.setDefaultCloseOperation(EXIT_ON_CLOSE);
//				lvl.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//				lvl.setMaximumSize(new Dimension(WIDTH, HEIGHT));
//				lvl.setMinimumSize(new Dimension(WIDTH, HEIGHT));
//				lvl.setLocationRelativeTo(null);
//				lvl.setResizable(false);
//				lvl.setVisible(true);
//				me.dispose();
//			}
//		});
//		helpButton = new JButton("Help");
//		helpButton.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg) {
//				System.out.println("Help");
//			}
//		});
//		quitButton = new JButton("Quit");
//		quitButton.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent arg) {
//				System.out.println("Quit");
//				System.exit(0);
//			}
//		});
//		panel2.add(playButton);
//		panel2.add(helpButton);
//		panel2.add(quitButton);
//		c.add(panel2, BorderLayout.CENTER);
	}
}
