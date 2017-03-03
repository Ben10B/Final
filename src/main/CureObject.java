package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class CureObject extends JFrame{
	
	private final int WIDTH = 150, HEIGHT = WIDTH+100;
	private CureListener victim;
	private JPanel panel;
	private JTextArea text;
	private JButton purifyButton;
	private int count = 0;
	
	public CureObject(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		
		panel = new JPanel();
		panel.setBackground(Color.pink);
		c.add(panel);
		
		purifyButton = new JButton("Cure!");
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
		this.pack();
	}
	
	public void setVictim(CureListener p){
		this.victim = p;
	}
}
