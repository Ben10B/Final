package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Game extends JFrame{
	public static final int WIDTH = 1040, HEIGHT = WIDTH-200;
	private JButton playButton, helpButton, quitButton;
	
	public Game(){
		Game me = this;
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.cyan);
		panel1.setPreferredSize(new Dimension(WIDTH, HEIGHT-600));
		c.add(panel1, BorderLayout.NORTH);
		
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel2.setBackground(Color.darkGray);
		
		playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Play lvl = new Play();
				lvl.setVisible(true);
				me.dispose();
			}
		});
		helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Help help = new Help(me);
				help.setVisible(true);
				me.setVisible(false);
			}
		});
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.exit(0);
			}
		});
		panel2.add(playButton);
		panel2.add(helpButton);
		panel2.add(quitButton);
		c.add(panel2, BorderLayout.CENTER);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Font fnt = new Font("Sylfaen", 1, 50);
		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawString("VIRUS PURIFICATION", 50, 150);
	}
}
