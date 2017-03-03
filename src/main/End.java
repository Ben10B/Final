package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.WinLoseListener.WINLOSE;

public class End extends JFrame{
	private JPanel win, lose;
	private WinLoseScenario scenario;

	public End(){
		this.setTitle("The End");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		scenario = new WinLoseScenario();
		Container c = this.getContentPane();
		
		if(scenario.getScenario() == WINLOSE.Win){
			win = new JPanel();
			win.setBackground(Color.cyan);
			c.add(win);
		}else if(scenario.getScenario() == WINLOSE.Lose){
			lose = new JPanel();
			lose.setBackground(Color.magenta);
			c.add(lose);
		}
		
		
		this.pack();
	}
}
