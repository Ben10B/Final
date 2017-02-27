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
	ArrayList<GameObject> go;
	private int size = 12;
	
	public Level(){
		timeListeners = new ArrayList<>();
		this.setLayout(null);
		
		Virus v = new Virus();
		v.setBounds(Game.WIDTH/2, Game.HEIGHT/2, 25, 25);
		timeListeners.add(v);
		this.add(v);
		
		go = new ArrayList<>();
		for(int i = 0; i < size; i++){
			int x = (int)(Math.random()*Game.WIDTH);
			int y = (int)(Math.random()*Game.HEIGHT);
			go.add(new GameObject(v));
			go.get(i).setBounds(x, y, 51, 51);
			
			this.add(go.get(i));
			timeListeners.add(go.get(i));
		}
//		GameObject go = new GameObject(a);
//		go.setBounds(200, 210, 51, 51);
//		timeListeners.add(go);
//		this.add(go);
		
		
		
		
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
