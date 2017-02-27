package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class GameObject extends JButton implements TimeListener, PurifyListener{
	
	private boolean notAffected;
	private STATUS state;
	private int x, y;
	Virus v;
	
	public GameObject(){
		GameObject me = this;
		this.x = this.getX();
		this.y = this.getY();
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
		}
	}

	@Override
	public void purify(int count) {
		if(count >= 5){
			state = STATUS.Purified;
		}
	}

	public Rectangle getBounds(){
		return new Rectangle(x, y, this.getWidth(), this.getHeight());
	}
}
