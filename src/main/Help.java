package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Help extends JFrame{
	private JButton backButton;

	public Help(Game game){
		Help me = this;
		this.setTitle("Help");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1040, 840));
		this.setMaximumSize(new Dimension(1040, 840));
		this.setMinimumSize(new Dimension(1040, 840));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		Container c = this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		
		backButton = new JButton("<- Go back to Menu");
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.setVisible(true);
				me.setVisible(false);
			}
		});
		panel.add(backButton);
		c.add(panel);
	}
//	@Override
//	public void paint(Graphics g){
//		g.setColor(Color.cyan);
//		g.drawString("Help", 200, 200);
//	}
}
