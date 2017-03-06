package main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class ColorChange extends MouseAdapter {
	private JButton b, g;
	
	public ColorChange(JButton b, JButton g){
		this.b = b;
		this.g = g;
	}
	public void mousePressed(MouseEvent m){
		if(b != null){
			b.setBackground(Color.cyan);
		}
	}
	public void mouseEntered(MouseEvent m){
		if(g != null){			
			g.setBackground(Color.green);
		}
	}
	public void mouseExited(MouseEvent m){
		if(b != null){
			b.setBackground(Color.cyan);
		}
	}
}
