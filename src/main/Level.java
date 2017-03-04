package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.WinLoseListener.WINLOSE;

public class Level extends JPanel{
	public Timer t;
	private ArrayList<TimeListener> timeListeners;
	private ArrayList<GameObject> go;
	private Random r;
	private int size = 24, time = 1800, cured;
	private ArrayList<STATUSListener> gameObjects;
	private PurifyListener virus;
	private Play play;
	private JLabel timeLabel;
	
	public Level(Play p){
		Level me = this;
		timeListeners = new ArrayList<>();
		gameObjects = new ArrayList<>();
		this.setLayout(null);
		this.play = p;
		r = new Random();
		
		timeLabel = new JLabel();
		timeLabel.setForeground(Color.cyan);
		timeLabel.setBounds(10, 10, 100, 50);
		this.add(timeLabel);
		
		Virus v = new Virus(play, me);
		v.setBounds(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), 35, 35);
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
				//poisons the 4th object
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
				//time countdown
				time--;
				timeLabel.setText("Countdown: "+Integer.toString(time));
				timeLabel.invalidate();
				//all tick methods
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
					}cured = curedObjects;
				}
				
				End wlScenario = new End(play);
				if(time == 0 && curedObjects != gameObjects.size()){
					t.stop();
					play.dispose();
					wlScenario.WinLose(WINLOSE.Lose);
					wlScenario.setVisible(true);
				}else if(time == 0 && curedObjects == gameObjects.size()){
					t.stop();
					play.dispose();
					wlScenario.WinLose(WINLOSE.Win);
					wlScenario.setVisible(true);
				}else if(curedObjects == 0){
					t.stop();
					play.dispose();
					wlScenario.WinLose(WINLOSE.Lose);
					wlScenario.setVisible(true);
				}
			}
		});
		t.start();
	}
	public boolean areAllObjectsCured() {
		return (cured == gameObjects.size()) ? true : false;
	}
}
