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
		
		Virus a = new Virus();
		a.setBounds(Game.WIDTH/2, Game.HEIGHT/2, 25, 25);
		timeListeners.add(a);
		this.add(a);
		
		
		GameObject go = new GameObject(a);
		go.setBounds(200, 210, 51, 51);
		timeListeners.add(go);
		this.add(go);
		
		GameObject go2 = new GameObject(a);
		go2.setBounds(400, 210, 51, 51);
		timeListeners.add(go2);
		this.add(go2);
		
		GameObject go3 = new GameObject(a);
		go3.setBounds(600, 210, 51, 51);
		timeListeners.add(go3);
		this.add(go3);
		
		
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
