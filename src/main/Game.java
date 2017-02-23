package main;

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

public class Game extends JFrame implements GameStateListener{
	private STATE gameState;
	private JButton playButton, helpButton, quitButton;
	
	public Game(){
		gameState = null;
		Container c = this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setBackground(Color.darkGray);
		
		playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				dispose();
				Play lvl = new Play();
				lvl.setVisible(true);
			}
		});
		helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Help");
			}
		});
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Quit");
				System.exit(0);
			}
		});
		panel.add(playButton);
		panel.add(helpButton);
		panel.add(quitButton);
		c.add(panel);
	}


	public static final int WIDTH = 1040, HEIGHT = WIDTH-200;

	@Override
	public void gameStateListener(STATE state) {
		if(state == STATE.Play){
			gameState = STATE.Play;
		}
	}
}
