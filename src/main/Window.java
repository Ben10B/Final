package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Window{

	public static void main(String[] args){
		//Play g = new Play();
		Game g = new Game();
		g.setTitle("Menu");
		g.setVisible(true);
	}

}
