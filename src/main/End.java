package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End extends JFrame implements WinLoseListener{
	private JPanel endPanel;
	private String background = "/main/img/End.png";
	private Sprite bg;
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
		Container c = this.getContentPane();
		
		endPanel = new JPanel();
		c.add(endPanel);
		
		restartButton = new JButton("Play Again");
		restartButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				dispose();
				Play play = new Play();
				play.setVisible(true);
			}
		});
		
		menuButton = new JButton("Return to Menu");
		menuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				dispose();
				Game newGame = new Game();
				newGame.setVisible(true);
			}
		});
		
		quitButton = new JButton("Quit");
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
			System.out.println("Win");
		}else{
			this.scenario = wl;
			System.out.println("Lose");
		}
	}
	
	public WINLOSE getScenario(){
		return scenario;
	}
	@Override
	public void paint(Graphics g){
		g.drawImage(bg.getImg(), 0, 0, this.getWidth(), this.getHeight(), null);
		g.setColor(Color.cyan);
		g.drawString("Game Over: You "+scenario+"!", 480, 120);
	}
}
