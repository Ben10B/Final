package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Virus extends JComponent implements TimeListener{
	private int x, y, speedX, speedY;
	
	public Virus(){
		x = this.getX();
		y = this.getY();
		speedX = 10;
		speedY = speedX;
	}
	
	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		if(x <= 0 || x >= Game.WIDTH-25) speedX *= -1;
		if(y <= 0 || y >= Game.HEIGHT-25) speedY *= -1;
		
		
		this.setLocation(x, y);
	}

	@Override
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.drawString("Actor"+speedX+"", 0, 15);
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, this.getWidth(), this.getHeight());
	}
}
