package main.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.ColorChange;
import main.Sprite;
import sfx.BackgroundMusic;

public class Game extends JFrame{
	public static final int WIDTH = 1040, HEIGHT = WIDTH-200;
	private JButton playButton, helpButton, quitButton;
	private String background = "/main/img/Start.png";
	private Sprite bg;
	private BackgroundMusic bm;
	private Font fnt = new Font("Freestyle Script", 1, 45);
	
	public Game(){
		Game me = this;
		this.setTitle("Menu");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		bm = new BackgroundMusic();
		//Top panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.cyan);
		panel1.setPreferredSize(new Dimension(WIDTH, HEIGHT-600));
		c.add(panel1, BorderLayout.NORTH);
		
		//Bottom panel
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel2.setBackground(Color.darkGray);
		
		//Bottom panel buttons
		playButton = new JButton("Play");
		playButton.setFont(fnt);
		playButton.addMouseListener(new ColorChange(null, playButton, null));
		playButton.setPreferredSize(new Dimension(150, 50));
		playButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Play lvl = new Play(me);
				lvl.setVisible(true);
				me.dispose();
			}
		});
		
		helpButton = new JButton("Help");
		helpButton.setFont(fnt);
		helpButton.addMouseListener(new ColorChange(null, helpButton, null));
		helpButton.setPreferredSize(new Dimension(150, 50));
		helpButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				Help help = new Help(me);
				help.setVisible(true);
				me.setVisible(false);
			}
		});
		
		quitButton = new JButton("Quit");
		quitButton.setFont(fnt);
		quitButton.addMouseListener(new ColorChange(null, quitButton, null));
		quitButton.setPreferredSize(new Dimension(150, 50));
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				bm.stopMusic();
				System.exit(0);
			}
		});
		
		panel2.add(playButton);
		panel2.add(helpButton);
		panel2.add(quitButton);
		c.add(panel2, BorderLayout.CENTER);
		bg = new Sprite(background);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Font fnt = new Font("Freestyle Script", 1, 75);
		Font fnt2 = new Font("Times New Roman", 1, 25);
		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawString("VIRUS PURIFICATION", 50, 150);
		g.drawImage(bg.getImg(), 0, 0, null);
		g.setFont(fnt2);
		g.setColor(Color.white);
//		g.drawString("By: Benjamin Beckwith", 10, 770);
//		g.drawString("Sponsored By: HeTap", 10, 800);
		g.drawString("Copyright ©2017 by 2Ways", 10, 830);
		g.setColor(Color.black);
		g.drawString("By: Benjamin Beckwith    Sponsored By: HeTap", 15, 280);
	}
}
