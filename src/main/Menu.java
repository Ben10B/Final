package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel{
	private Game game;
	private JButton playButton, helpButton, quitButton;
	private STATE gameState = STATE.Play;
	
	public Menu(Game game){
		this.game = game;
		
		this.setPreferredSize(new Dimension(game.WIDTH, game.HEIGHT));
		this.setBackground(Color.darkGray);
		
		playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.out.println("Play");
				LevelOne lvl = new LevelOne();
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
				
			}
		});
		this.add(playButton);
		this.add(helpButton);
		this.add(quitButton);
	}

}
