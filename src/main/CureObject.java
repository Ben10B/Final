package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CureObject extends JFrame{
	
	private final int WIDTH = 150, HEIGHT = WIDTH+100;
	private CureListener victim;
	private JPanel panel;
	private JButton purifyButton, cB, uB, rB, eB;
	private int count = 0;
	private String spellCure = "";
	private String[] effected = {"Help me!", "I'm poisoned!", "Hurry up!"};
	private Random r = new Random();
	
	public CureObject(){
		this.setTitle("Cure");
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
		
		JLabel label = new JLabel();
		label.setText(effected[r.nextInt(3)]);
		this.add(label, BorderLayout.SOUTH);
		
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
			rB = new JButton("R");
			rB.setActionCommand("r");
			rB.addMouseListener(new ColorChange(rB));
			rB.addActionListener(new Concatenator());
			panel.add(rB);
			
			uB = new JButton("U");
			uB.setActionCommand("u");
			uB.addMouseListener(new ColorChange(uB));
			uB.addActionListener(new Concatenator());
			panel.add(uB);
			
			cB = new JButton("C");
			cB.setActionCommand("C");
			cB.addMouseListener(new ColorChange(cB));
			cB.addActionListener(new Concatenator());
			panel.add(cB);
			
			eB = new JButton("E");
			eB.setActionCommand("e");
			eB.addMouseListener(new ColorChange(eB));
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
	private final class ColorChange extends MouseAdapter {
		private JButton b;
		public ColorChange(JButton b){this.b = b;}
		public void mousePressed(MouseEvent m){
			b.setBackground(Color.cyan);
		}
	}
	
	public void setVictim(CureListener p){
		this.victim = p;
	}
}
