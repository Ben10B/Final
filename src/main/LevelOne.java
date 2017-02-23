package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class LevelOne extends JPanel{

	public LevelOne(Game game){
		this.setBackground(Color.pink);
		this.setPreferredSize(new Dimension(game.WIDTH, game.HEIGHT));
		this.setVisible(true);
	}
	public void tick(){
		
	}
}
