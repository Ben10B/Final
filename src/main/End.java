package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class End extends JFrame implements WinLoseListener{
	private JPanel endPanel;
	private String background = "/main/img/End.png", backgroundL = "/main/img/EndL.png";
	private Sprite bg, bgL;
	private JButton restartButton, menuButton, quitButton;

	public End(Play play){
		this.setTitle("The End");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		bg = new Sprite(background);
		bgL = new Sprite(backgroundL);
		Container c = this.getContentPane();
		
		endPanel = new JPanel();
		c.add(endPanel);
		
		restartButton = new JButton("Play Again");
		restartButton.addMouseListener(new ColorChange(null, restartButton, restartButton));
		restartButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Play play = new Play();
				play.setVisible(true);
				dispose();
			}
		});
		
		menuButton = new JButton("Return to Menu");
		menuButton.addMouseListener(new ColorChange(null, menuButton, menuButton));
		menuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Game newGame = new Game();
				newGame.setVisible(true);
				dispose();
			}
		});
		
		quitButton = new JButton("Quit");
		quitButton.addMouseListener(new ColorChange(null, quitButton, quitButton));
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				System.exit(0);
			}
		});
		
		endPanel.add(restartButton);
		endPanel.add(menuButton);
		endPanel.add(quitButton);
		
		this.pack();
	}

	private WINLOSE scenario;
	@Override
	public void WinLose(WINLOSE wl) {
		
		if(wl == WINLOSE.Win){
			this.scenario = wl;
		}else{
			this.scenario = wl;
		}
	}
	
	public WINLOSE getScenario(){
		return scenario;
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		if(scenario == WINLOSE.Win){
			g.drawImage(bg.getImg(), 0, 0, this.getWidth(), this.getHeight(), null);
			g.setColor(Color.cyan);
		}else{
			g.drawImage(bgL.getImg(), 0, 0, this.getWidth(), this.getHeight(), null);
			g.setColor(Color.green);
		}
		Font fnt = new Font("Arial", 1, 50);
		g.setFont(fnt);
		g.drawString("^", 415, 130);
		g.drawString("^", 525, 130);
		g.drawString("^", 615, 130);
		g.drawString("Game Over: You "+scenario+"!", 260, 180);
	}
}
