package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel{
	private Timer t;
	private ArrayList<TimeListener> timeListeners;
	private ArrayList<GameObject> go;
	private Random r;
	private int size = 6;
	private ArrayList<STATUSListener> gameObjects;
	private PurifyListener virus;
	private Play play;
	
	public Level(Play p){
		Level me = this;
		timeListeners = new ArrayList<>();
		gameObjects = new ArrayList<>();
		this.setLayout(null);
		this.play = p;
		r = new Random();
		
		
		Virus v = new Virus(play);
		v.setBounds(Game.WIDTH/2, Game.HEIGHT/2, 35, 35);
		this.virus = v;
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
				//if(i == 4) go.get(i).setStatus2Affected();
				
				this.add(go.get(i));
				timeListeners.add(go.get(i));
				gameObjects.add(go.get(i));
				i++;
			}else{
				
			}
		}
		
		t = new Timer(100, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				for(TimeListener tickee : timeListeners){
					tickee.tick();
				}repaint();
				//if all objects are cured, user wins
				int curedObjects = 0;
				for(STATUSListener gameO : gameObjects){
					if(gameO.getObjectStatus() == STATUS.Healthy 
							|| gameO.getObjectStatus() == STATUS.Purified && virus.purify() == 0){
						curedObjects += 1;
					}else if(gameO.getObjectStatus() == STATUS.Affected && virus.purify() == 0){
						curedObjects -= 1;
					}
				}
				if(curedObjects == gameObjects.size() && virus.purify() == 0){
					t.stop();
				}
			}
		});
		
		t.start();
	}
	
}
