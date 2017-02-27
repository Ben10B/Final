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

public class Purify extends JFrame{
	
	private final int WIDTH = 150, HEIGHT = WIDTH+100;
	private PurifyListener victim;
	private JPanel panel;
	private JTextArea text;
	private JButton purifyButton;
	private int count = 0;
	
	public Purify(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.pink);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		
		panel = new JPanel();
		panel.setBackground(Color.pink);
		c.add(panel);
		
		purifyButton = new JButton("Purify!");
		purifyButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg) {
				count++;
				System.out.println(count);
				victim.purify(count);
			}
		});
		//Once clicked, the button will be appear at a random coordinate... supposedly.
//		purifyButton.addMouseListener(new MouseAdapter(){
//			public void mouseClicked(MouseEvent m) {
//				purifyButton.setLocation((int)Math.random() * 10, (int)Math.random() * 10);
//			}
//		});
		
		panel.add(purifyButton);
	}
	
	public void setVictim(PurifyListener p){
		this.victim = p;
	}
}
