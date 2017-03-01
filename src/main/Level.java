package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel{
	Timer t;
	ArrayList<TimeListener> timeListeners;
	ArrayList<GameObject> go;
	Random r;
	private int size = 24;
	
	public Level(){
		timeListeners = new ArrayList<>();
		this.setLayout(null);
		r = new Random();
		
		
		Virus v = new Virus();
		v.setBounds(Game.WIDTH/2, Game.HEIGHT/2, 35, 35);
		timeListeners.add(v);
		this.add(v);
		
		go = new ArrayList<>();
		int i = 0;
		while(i < size){
			int x = r.nextInt(Game.WIDTH-60);
			int y = r.nextInt(Game.HEIGHT-100);
			go.add(new GameObject(v));
			if(x > 0 || y > 0 || x < Game.WIDTH || y < Game.HEIGHT){
				go.get(i).setBounds(x, y, 51, 51);	
				this.add(go.get(i));
				timeListeners.add(go.get(i));
				i++;
			}else{
				
			}
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
