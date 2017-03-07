package main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class ColorChange extends MouseAdapter {
	private JButton pressed, entered, exited;
	
	public ColorChange(JButton p, JButton e, JButton ex){
		this.pressed = p;
		this.entered = e;
		this.exited = ex;
	}
	public void mousePressed(MouseEvent m){
		if(pressed != null){
			pressed.setBackground(Color.cyan);
		}
	}
	public void mouseEntered(MouseEvent m){
		if(entered != null){			
			entered.setBackground(Color.green);
		}
		if(exited != null && entered != null){
			entered.setBackground(Color.green);
		}
	}
	public void mouseExited(MouseEvent m){
		if(exited != null && entered != null){
			exited.setBackground(Color.cyan);
		}
	}
}
