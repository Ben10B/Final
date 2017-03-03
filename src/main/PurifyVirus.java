package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import main.WinLoseListener.WINLOSE;

public class PurifyVirus extends JFrame{
	
	private final int WIDTH = 150, HEIGHT = WIDTH+100;
	private PurifyListener virus;
	private JPanel panel;
	private JTextArea text;
	private JButton freezeButton, finalPurification;
	private int count = 0;
	private Play play;
	
	public PurifyVirus(Play p){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.play = p;
		Container c = this.getContentPane();
		
		panel = new JPanel();
		panel.setBackground(Color.green);
		c.add(panel);
		
		//Freeze Counter Label
		JLabel freezeLabel = new JLabel();
		freezeLabel.setText(""+count);
		this.add(freezeLabel, BorderLayout.SOUTH);
		
		//Freeze Button
		freezeButton = new JButton("Freeze!");
		freezeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				count++;
				freezeLabel.setText(Integer.toString(count));
				freezeLabel.invalidate();
				virus.freeze(count);
				
				if(count == 15){
					dispose();
				}
			}
		});
		freezeButton.setPreferredSize(new Dimension(WIDTH, HEIGHT-180));
		panel.add(freezeButton);
		
		//Kill Button
		finalPurification = new JButton("Purify!");
		finalPurification.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				WinLoseScenario wlScenario = new WinLoseScenario();
				if(virus.purify() == 0){
					wlScenario.WinLose(WINLOSE.Win);
					dispose();
					play.dispose();
					End win = new End();
					win.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
					win.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
					win.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
					win.setLocationRelativeTo(null);
					win.setResizable(false);
					win.setVisible(true);
				}else{
					freezeLabel.setText("Freeze the Virus first!!");
				}
			}
		});
		finalPurification.setPreferredSize(new Dimension(WIDTH, HEIGHT-180));
		panel.add(finalPurification);
		
		this.pack();
	}

	public void setVirus(PurifyListener k){
		this.virus = k;
	}
}
