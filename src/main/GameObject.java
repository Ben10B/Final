package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;

import main.frames.CureObject;

public class GameObject extends JButton implements TimeListener, CureListener, STATUSListener{
	
	private STATUS state;
	private int invincibility = 180;
	private Virus v;
	private Random r;
	
	public GameObject(Virus virus){
		GameObject me = this;
		this.v = virus;
		state = STATUS.Healthy;
		r = new Random();
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent m) {
				if(state == STATUS.Effected && m.getClickCount() == 1){
					CureObject p = new CureObject();		
					p.setVictim(me);
					p.setVisible(true);
				}
			}
		});
		if(this.getBounds().intersects(this.getBounds())){
			this.setLocation(this.getX()+this.getWidth(), this.getY()+this.getHeight());
		}
	}

	@Override
	public void tick() {
		if(collision()){
			if(state == STATUS.Healthy){
				state = STATUS.Effected;
			}
		}
		if(state == STATUS.Purified){
			invincibility--;
		}
		if(invincibility == 0){
			state = STATUS.Healthy;
			invincibility = 180;
		}
		
	} 
	
	public boolean collision(){
		return (v.getBounds().intersects(this.getBounds())) ? true : false;
	}
	
	public void paint(Graphics g){
		if(state == STATUS.Healthy){
			g.setColor(STATUS.Healthy.getColor());
//			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 40, 40);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}else if(state == STATUS.Effected){
			g.setColor(STATUS.Effected.getColor());
//			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 40, 40);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.black);
			g.drawString("Poisoned", 0, 30);
		}else{
			g.setColor(STATUS.Purified.getColor());
//			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 40, 40);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.black);
			g.drawString("Purified!", 0, 30);
			g.drawString(invincibility+"", 15, 15);
		}
	}

	public void setStatus2Affected(){
		state = STATUS.Effected;
	}
	@Override
	public void cure(int count) {
		if(count >= 3){
			state = STATUS.Purified;
		}
	}
	@Override
	public void cure(String cure) {
		if(cure.equalsIgnoreCase("cure")){
			state = STATUS.Purified;
		}
	}
	@Override
	public STATUS getObjectStatus() {
		return state;
	}
}
