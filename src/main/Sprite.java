package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Sprite extends JComponent{
	private Image img;
	private String address;
	
	public Sprite(){
		
	}
	public Sprite(String imgAddress){
		setAddress(imgAddress);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		this.address = add;
		img = new ImageIcon(this.getClass().getResource(add)).getImage();
		this.setSize(img.getWidth(null), img.getHeight(null));
	}
	public Image getImg() {
		return img;
	}
}
