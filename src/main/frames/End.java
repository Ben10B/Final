package main.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.ColorChange;
import main.Sprite;
import main.WinLoseListener;
import main.WinLoseListener.WINLOSE;
import sfx.BackgroundMusic;

public class End extends JFrame implements WinLoseListener{
	private String background = "/main/img/End.png", backgroundL = "/main/img/EndL.png";
	private Sprite bg, bgL;
	private JButton restartButton, menuButton, quitButton;
	private BackgroundMusic bm;
	private Font fnt = new Font("Freestyle Script", 1, 32);
	
	public End(Play play){
		this.setTitle("The End");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		Container c = this.getContentPane();
		bm = new BackgroundMusic();
		
		JPanel endPanel = new JPanel();
		endPanel.setBackground(Color.darkGray);
		
		restartButton = new JButton("Play Again");
		restartButton.setFont(fnt);
		restartButton.addMouseListener(new ColorChange(null, restartButton, restartButton));
		restartButton.setPreferredSize(new Dimension(150, 70));
		restartButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Game newGame = new Game();
				Play play = new Play(newGame);
				play.setVisible(true);
				dispose();
			}
		});
		
		menuButton = new JButton("Menu");
		menuButton.setFont(fnt);
		menuButton.addMouseListener(new ColorChange(null, menuButton, menuButton));
		menuButton.setPreferredSize(new Dimension(150, 70));
		menuButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Game newGame = new Game();
				newGame.setVisible(true);
				dispose();
			}
		});
		
		quitButton = new JButton("Quit");
		quitButton.setFont(fnt);
		quitButton.addMouseListener(new ColorChange(null, quitButton, quitButton));
		quitButton.setPreferredSize(new Dimension(150, 70));
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				bm.stopMusic();
				System.exit(0);
			}
		});
		
		endPanel.add(restartButton);
		endPanel.add(menuButton);
		endPanel.add(quitButton);
		c.add(endPanel);
		
		bg = new Sprite(background);
		bgL = new Sprite(backgroundL);
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
			g.setColor(Color.decode("#666666"));
			g.fillRect(80, 133, 880, 175);
			g.drawImage(bg.getImg(), 0, 0, null);
			g.setColor(Color.cyan);
		}else{
			g.setColor(Color.decode("#666666"));
			g.fillRect(80, 133, 880, 175);
			g.drawImage(bgL.getImg(), 0, 0, null);
			g.setColor(Color.green);
		}
		Font fnt = new Font("Arial", 1, 50);
		g.setFont(fnt);
		g.drawString("Game Over: You "+scenario+"!", 260, 230);
	}
}
