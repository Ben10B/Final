package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CureObject extends JFrame{
	
	private final int WIDTH = 150, HEIGHT = WIDTH+100;
	private CureListener victim;
	private JPanel panel;
	private JTextArea text;
	private JButton purifyButton, cB, uB, rB, eB;
	private int count = 0;
	private String spellCure = "";
	private Random r = new Random();
	
	public CureObject(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		
		panel = new JPanel();
		panel.setBackground(Color.green);
		c.add(panel);
		
		int action = r.nextInt(2);
		if(action == 0){
			purifyButton = new JButton("Cure!");
			purifyButton.setBackground(Color.cyan);
			purifyButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg) {
					count++;
					victim.cure(count);
					if(count == 3){
						dispose();
					}
				}
			});
			//Once clicked, the button will be appear at a random coordinate... supposedly.
			purifyButton.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent m) {
					purifyButton.setLocation((int)(Math.random() * 150), (int)(Math.random() * 100));
				}
			});
			panel.add(purifyButton);
		}else{
			cB = new JButton("C");
			cB.setActionCommand("C");
			cB.addActionListener(new Concatenator());
			panel.add(cB);
			
			uB = new JButton("U");
			uB.setActionCommand("u");
			uB.addActionListener(new Concatenator());
			panel.add(uB);
			
			rB = new JButton("R");
			rB.setActionCommand("r");
			rB.addActionListener(new Concatenator());
			panel.add(rB);
			
			eB = new JButton("E");
			eB.setActionCommand("e");
			eB.addActionListener(new Concatenator());
			panel.add(eB);
		}
		this.pack();
	}
	
	private final class Concatenator implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent action) {
			spellCure += action.getActionCommand();
			victim.cure(spellCure);
			if(spellCure.length() == 4){
				dispose();
			}	
		}
	}
	
	public void setVictim(CureListener p){
		this.victim = p;
	}
}
