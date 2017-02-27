package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel{
	Timer t;
	ArrayList<TimeListener> timeListeners;
	
	public Level(){
		timeListeners = new ArrayList<>();
		this.setLayout(null);
		
		Actor a = new Actor();
		a.setBounds(Game.WIDTH/2, Game.HEIGHT/2, 25, 25);
		timeListeners.add(a);
		this.add(a);
		
		
		GameObject go = new GameObject();
		go.setBounds(200, 210, 31, 31);
		timeListeners.add(go);
		this.add(go);
		
		
		t = new Timer(100, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				
				for(TimeListener tickee : timeListeners){
					tickee.tick();
				}
				repaint();
			}
		});
		
		t.start();
	}
}
