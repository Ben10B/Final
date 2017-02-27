package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class GameObject extends JButton implements TimeListener, PurifyListener{
	
	private STATUS state;
	private int x, y, invincibility = 180;
	private Virus v;
	
	public GameObject(Virus virus){
		GameObject me = this;
		this.x = this.getX();
		this.y = this.getY();
		this.v = virus;
		state = STATUS.Healthy;
		
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent m) {
				if(state == STATUS.Healthy){
					System.out.println(state+": I'm good homie");
				}else if(state == STATUS.Affected){
					System.out.println(state+": Help me!");
					Purify p = new Purify();
					p.setVictim(me);
					p.setVisible(true);
				}else{
					System.out.println(state);
				}
			}
		});
	}

	@Override
	public void tick() {
		if(collision()){
			if(state == STATUS.Healthy){
				state = STATUS.Affected;
			}
		}
		if(state == STATUS.Purified){
			invincibility--;
		}
		if(invincibility == 0){
			state = STATUS.Healthy;
		}
	} 
	
	public boolean collision(){
		return (v.getBounds().intersects(this.getBounds())) ? true : false;
	}
	
	public void paint(Graphics g){
		if(state == STATUS.Healthy){
			g.setColor(Color.black);
			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 40, 40);
		}else if(state == STATUS.Affected){
			g.setColor(Color.decode("#00ff00"));
			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 40, 40);
			g.setColor(Color.black);
			g.drawString("Poisoned", 0, 30);
		}else{
			g.setColor(Color.black);
			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 40, 40);
			g.setColor(Color.white);
			g.drawString("Purified!", 0, 30);
			g.drawString(invincibility+"", 15, 15);
		}
		
	}

	@Override
	public void purify(int count) {
		if(count >= 5){
			state = STATUS.Purified;
		}
	}
}
