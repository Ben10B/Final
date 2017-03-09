package main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;

import main.frames.Game;
import main.frames.Play;
import main.frames.PurifyVirus;

public class Virus extends JButton implements TimeListener, PurifyListener{
	private String still = "/main/img/virus1.png";
	private Sprite virusSprite;
	private int speedX, speedY, freeze = 120, stuckInBounds;
	private Play play;
	private Random r = new Random();
	
	public Virus(Play p, Level lvl){
		Virus me = this;
		this.play = p;
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
		if(this.getX() <= 21 || this.getX() >= Game.WIDTH-65) speedX *= -1;
		if(this.getY() <= 21 || this.getY() >= Game.HEIGHT-90) speedY *= -1;
		
		if(speedX == 0){
			freeze--;
			if(freeze == 0){
				speedX = 30;
				speedY = speedX;
				freeze = 120;
			}
		}
		
		if(speedX != 0 && this.getX() <= 21){
			stuckInBounds++;
			if(stuckInBounds == 10){
				this.setLocation(Game.WIDTH/2, Game.HEIGHT/2);
			}
		}else if(speedY != 0 && this.getY() <= 21){
			stuckInBounds++;
			if(stuckInBounds == 10){
				this.setLocation(Game.WIDTH/2, Game.HEIGHT/2);
			}
		}
		if(speedX != 0 && this.getY() >= Game.WIDTH-100){
			stuckInBounds++;
			if(stuckInBounds == 10){
				this.setLocation(Game.WIDTH/2, Game.HEIGHT/2);
			}
		}else if(speedY != 0 && this.getY() >= Game.HEIGHT-100){
			stuckInBounds++;
			if(stuckInBounds == 10){
				this.setLocation(Game.WIDTH/2, Game.HEIGHT/2);
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
