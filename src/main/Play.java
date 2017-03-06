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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class Play extends JFrame{
	private int counter = 1;
	private int time = 1200;
	private JPanel panel;
	private JLabel label;
	private Level lvl1;
	public Timer t;
	
	public Play(){
		Play me = this;
		this.setTitle("Play");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		
		if(counter == 1){
			lvl1 = new Level(this);
			lvl1.setBackground(Color.GRAY);
			c.add(lvl1);
		}
		this.pack();
		t = new Timer(100, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time--;
				Font fnt = new Font("Sylfaen", 1, 25);
				me.setFont(fnt);
				me.setTitle("Play - Countdown: "+Integer.toString(time));
				me.invalidate();
			}
		});
		t.start();
	}
	
	public int getPlayTime(){
		return time;
	}
}
