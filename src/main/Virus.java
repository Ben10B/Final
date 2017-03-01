package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Virus extends JButton implements TimeListener, PurifyListener{
	private String still = "/main/img/virus1.png";
	private Sprite virusSprite;
	private int x, y, speedX, speedY, freeze, count = 0;
	
	public Virus(){
		speedX = 10;
		speedY = speedX;
		virusSprite = new Sprite(still);
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent m) {
				System.out.println(count++);
			}
		});
		
		if(count == 100){
			
		}
	}
	public void setPurityWindow(){
		
	}
	@Override
	public void purify(int count) {
		// freezes the virus
		
	}
	
	@Override
	public void tick() {

		if(this.getX() <= 0 || this.getX() >= Game.WIDTH-40) speedX *= -1;
		if(this.getY() <= 0 || this.getY() >= Game.HEIGHT-80) speedY *= -1;
		
		
		this.setLocation(this.getX() + speedX, this.getY() + speedY);
	}

	@Override
	public void paint(Graphics g){
//		g.setColor(Color.red);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		g.setColor(Color.black);
//		g.drawString("Virus", 0, 15);
//		g.drawString(count+"", 15, 30);
		g.drawImage(virusSprite.getImg(), 0, 0, this.getWidth(), this.getHeight(),null);
	}
	
}
