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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import main.ColorChange;
import main.Level;
import main.Sprite;
import sfx.BackgroundMusic;

public class Play extends JFrame {
	private int counter = 0, time, objectSize;
	private Level lvl;
	private Timer t;
	private JButton easy, medium, hard, backButton;
	private String background = "/main/img/Select.png";
	private Sprite bg;
	private JPanel selectPanel;
	private BackgroundMusic bm;
	private Font fnt = new Font("Freestyle Script", 1, 50);

	public Play(Game game) {
		Play me = this;
		this.setTitle("Play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		bm = new BackgroundMusic();
		//Panel for back button
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.darkGray);
		panel1.setPreferredSize(new Dimension(Game.WIDTH, 200));
		backButton = new JButton("< Go back to Menu");
		backButton.addMouseListener(new ColorChange(null, backButton, null));
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.setVisible(true);
				me.setVisible(false);
			}
		});
		
		panel1.add(backButton);
		c.add(panel1, BorderLayout.NORTH);
		//Panel for difficulty selection
		selectPanel = new JPanel();
		selectPanel.setBackground(Color.darkGray);
		
		easy = new JButton("Easy");
		easy.setFont(fnt);
		easy.setPreferredSize(new Dimension(150, 150));
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanel.setVisible(false);
				panel1.setVisible(false);
				objectSize = 12;
				time = 1200;
				lvl = new Level(me);
				lvl.setBackground(Color.GRAY);
				c.add(lvl);
				t.start();
			}
		});
		
		medium = new JButton("Medium");
		medium.setFont(fnt);
		medium.setPreferredSize(new Dimension(150, 150));
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanel.setVisible(false);
				panel1.setVisible(false);
				objectSize = 24;
				time = 1800;
				lvl = new Level(me);
				lvl.setBackground(Color.GRAY);
				c.add(lvl);
				t.start();
			}
		});
		
		hard = new JButton("Hard");
		hard.setFont(fnt);
		hard.setPreferredSize(new Dimension(150, 150));
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanel.setVisible(false);
				panel1.setVisible(false);
				objectSize = 36;
				time = 2400;
				lvl = new Level(me);
				lvl.setBackground(Color.GRAY);
				c.add(lvl);
				t.start();
			}
		});
		
		selectPanel.add(easy);
		selectPanel.add(medium);
		selectPanel.add(hard);
		c.add(selectPanel, BorderLayout.CENTER);
		
		t = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time--;
				Font fnt = new Font("Sylfaen", 1, 25);
				me.setFont(fnt);
				me.setTitle("Play                                                       Time: " + Integer.toString(time));
				me.invalidate();
			}
		});
		
		bg = new Sprite(background); 
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (selectPanel.isVisible()) {
			g.drawImage(bg.getImg(), 0, 0, null);
			Font fnt = new Font("Freestyle Script", 1, 75);
			g.setFont(fnt);
			g.setColor(Color.cyan);
			g.drawString("Select Difficulty", 500, 500);
		}
	}

	public int getPlayTime() {
		return time;
	}
	public int getObjectSize() {
		return objectSize;
	}
}
