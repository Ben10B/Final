package main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Virus extends JButton implements TimeListener, PurifyListener{
	private String still = "/main/img/virus1.png";
	private Sprite virusSprite;
	private int x, y, speedX, speedY, freeze = 180, count = 0;
	

	private JFrame frame;
	
	public Virus(){
		Virus me = this;
		speedX = 20;
		speedY = speedX;
		virusSprite = new Sprite(still);
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent m) {
				PurifyVirus pv = new PurifyVirus();
				pv.setVirus(me);
				pv.setVisible(true);
			}
		});
		
	}
	
	
	@Override
	public void purify(int freezeCount) {
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
		if(this.getX() <= 0 || this.getX() >= Game.WIDTH-40) speedX *= -1;
		if(this.getY() <= 0 || this.getY() >= Game.HEIGHT-80) speedY *= -1;
		
		if(speedX == 0){
			freeze--;
			if(freeze == 0){
				speedX = 10;
				speedY = speedX;
			}
		}
		this.setLocation(this.getX() + speedX, this.getY() + speedY);
	}

	@Override
	public void paint(Graphics g){
		g.drawImage(virusSprite.getImg(), 0, 0, this.getWidth(), this.getHeight(),null);
	}
}
