package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class GameObject extends JButton implements TimeListener, PurifyListener{
	
	private boolean notAffected = false;
	private int x, y;
	
	public GameObject(){
		GameObject me = this;
		this.x = this.getX();
		this.y = this.getY();
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent m) {
				if(notAffected){
					System.out.println("I'm good homie");
				}else{
					Purify p = new Purify();
					p.setVictim(me);
					p.setVisible(true);
				}
			}
		});
	}

	public void paint(Graphics g){
		if(notAffected){
			g.setColor(Color.black);
			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 30, 30);
		}else{
			g.setColor(Color.decode("#00ff00"));
			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 30, 30);
		}
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void purify() {
		// TODO Auto-generated method stub
		
	}

}
