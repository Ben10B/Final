package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class GameObject extends JButton implements TimeListener{
	
	private boolean isAffected = false;
	private int x, y;
	
	public GameObject(){
		this.x = this.getX();
		this.y = this.getY();
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent m) {
				System.out.println("Clicked");
				
			}
		});
	}

	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 30, 30);

	}

	@Override
	public void tick() {
		
		
	}

}
