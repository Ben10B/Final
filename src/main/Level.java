package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private int size = 24, cured/*, time = 1200*/;
	private ArrayList<STATUSListener> gameObjects;
	private Play play;
	//private JLabel timeLabel;
	private String background = "/main/img/playbg.png";
	private Sprite bg = new Sprite(background);
	
 	public Level(Play p){
		Level me = this;
		timeListeners = new ArrayList<>();
		gameObjects = new ArrayList<>();
		this.setLayout(null);
		this.play = p;
		r = new Random();
		
//		timeLabel = new JLabel();
//		timeLabel.setForeground(Color.BLUE);
//		timeLabel.setBounds(100, 10, 210, 50);
//		this.add(timeLabel);
		
		
		Virus v = new Virus(play, me);
		boolean isWithinBounds = false;
		while(!isWithinBounds){
			int x = r.nextInt(Game.WIDTH-100)+1;
			int y = r.nextInt(Game.HEIGHT-100)+1;
			if(x > 35 && y > 35 && x < Game.WIDTH-10 && y < Game.HEIGHT-10){
				v.setBounds(x, y, 35, 35);
				timeListeners.add(v);
				this.add(v);
				isWithinBounds = true;
			}else{
				isWithinBounds = false;
			}
		}
		
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
			}
		}
		
		t = new Timer(100, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				//time countdown
//				play.time--;
//				Font fnt = new Font("Sylfaen", 1, 25);
//				timeLabel.setFont(fnt);
//				timeLabel.setText("Countdown: "+Integer.toString(play.time));
//				timeLabel.invalidate();
				//all tick methods
				for(TimeListener tickee : timeListeners){
					tickee.tick();
				}repaint();
				//if all objects are cured, user wins
				int curedObjects = 0;
				for(STATUSListener gameO : gameObjects){
					if(gameO.getObjectStatus() == STATUS.Healthy 
							|| gameO.getObjectStatus() == STATUS.Purified){
						curedObjects += 1;
					}cured = curedObjects;
				}
				
				End wlScenario = new End(play);
				if(play.getPlayTime() == 0 && cured != gameObjects.size()){
					wlScenario.WinLose(WINLOSE.Lose);
					wlScenario.setVisible(true);
					t.stop();
					play.dispose();
				}else if(play.getPlayTime() == 0 && cured == gameObjects.size()){
					wlScenario.WinLose(WINLOSE.Win);
					wlScenario.setVisible(true);
					t.stop();
					play.dispose();
				}else if(cured == 0){
					wlScenario.WinLose(WINLOSE.Lose);
					wlScenario.setVisible(true);
					t.stop();
					play.dispose();
				}
			}
		});
		t.start();
	}
	public boolean areAllObjectsCured() {
		return (cured == gameObjects.size()) ? true : false;
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bg.getImg(), 0, 0, null);
	}
}
