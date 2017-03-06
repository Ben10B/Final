package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Virus extends JButton implements TimeListener, PurifyListener{
	private String still = "/main/img/virus1.png";
	private Sprite virusSprite;
	private int x, y, speedX, speedY, freeze = 120, count = 0;
	private Play play;
	private Level lvl;
	private Random r = new Random();
	
	public Virus(Play p, Level lvl){
		Virus me = this;
		this.play = p;
		this.lvl = lvl;
		virusSprite = new Sprite(still);
		
		if(r.nextInt(9)+1 < 6){
			speedX = 30;
			speedY = speedX;
		}else{
			speedX = -30;
			speedY = speedX;
		}
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent m) {
				PurifyVirus pv = new PurifyVirus(play, lvl);
				pv.setVirus(me);
				pv.setVisible(true);
			}
		});
	}
	
	
	@Override
	public void freeze(int freezeCount) {
		// freezes the virus
		if(freezeCount == 7){
			speedX %= freezeCount;
			speedY %= freezeCount;
		}
		if(freezeCount == 15){
			speedX = 0;
			speedY = 0;
		}
	}
	
	@Override
	public void tick() {
		//x > 0 && y > 0 && x < Game.WIDTH && y < Game.HEIGHT
		if(this.getX() <= 21 || this.getX() >= Game.WIDTH-65) speedX *= -1;
		if(this.getY() <= 21 || this.getY() >= Game.HEIGHT-99) speedY *= -1;
		
		if(speedX == 0){
			freeze--;
			if(freeze == 0){
				speedX = 20;
				speedY = speedX;
				freeze = 120;
			}
		}
		this.setLocation(this.getX() + speedX, this.getY() + speedY);
	}

	@Override
	public void paint(Graphics g){
		//super.paint(g);
		g.drawImage(virusSprite.getImg(), 0, 0, this.getWidth(), this.getHeight(),null);
	}

	@Override
	public int purify() {
		return speedX;
	}

}
