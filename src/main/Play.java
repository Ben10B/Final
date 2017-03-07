package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Play extends JFrame {
	private int counter = 0, time;
	public int objectSize = 0;
	private Level lvl;
	public Timer t;
	private JButton easy, medium, hard;
	private Difficulty choice = Difficulty.Select;
	private String background = "/main/img/Select.png";
	private Sprite bg;
	private JPanel panel;

	public Play() {
		Play me = this;
		this.setTitle("Play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		bg = new Sprite(background);
		Container c = this.getContentPane();

		panel = new JPanel();
		panel.setBackground(Color.darkGray/*decode("#B6AFA9")*/);
		c.add(panel);

		easy = new JButton("Easy");
		easy.setPreferredSize(new Dimension(150, 150));
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				objectSize = 12;
				time = 1200;
				lvl = new Level(me);
				lvl.setBackground(Color.GRAY);
				c.add(lvl);
				t.start();
			}
		});
		panel.add(easy);

		medium = new JButton("Medium");
		medium.setPreferredSize(new Dimension(150, 150));
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				objectSize = 24;
				time = 1550;
				lvl = new Level(me);
				lvl.setBackground(Color.GRAY);
				c.add(lvl);
				t.start();
			}
		});
		panel.add(medium);

		hard = new JButton("Hard");
		hard.setPreferredSize(new Dimension(150, 150));
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				objectSize = 36;
				time = 1800;
				lvl = new Level(me);
				lvl.setBackground(Color.GRAY);
				c.add(lvl);
				t.start();
			}
		});
		panel.add(hard);

		this.pack();
		t = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time--;
				Font fnt = new Font("Sylfaen", 1, 25);
				me.setFont(fnt);
				me.setTitle("Play - Countdown: " + Integer.toString(time));
				me.invalidate();
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// g.drawImage(bg.getImg(), 0, 0, null);
		if (panel.isVisible()) {
			Font fnt = new Font("Freestyle Script", 1, 75);
			g.setFont(fnt);
			g.setColor(Color.cyan);
			g.drawString("Select Difficulty", 500, 500);
		}
	}

	public int getPlayTime() {
		return time;
	}

}
