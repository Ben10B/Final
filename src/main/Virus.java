package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Virus extends JComponent implements TimeListener{
	private int x, y, speedX, speedY;
	
	public Virus(){
		speedX = 20;
		speedY = speedX;
	}
	
	@Override
	public void tick() {

		if(this.getX() <= 0 || this.getX() >= Game.WIDTH-30) speedX *= -1;
		if(this.getY() <= 0 || this.getY() >= Game.HEIGHT-70) speedY *= -1;
		
		
		this.setLocation(this.getX() + speedX, this.getY() + speedY);
	}

	@Override
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.drawString("Actor"+speedX+"", 0, 15);
	}
}
