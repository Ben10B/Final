package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Help extends JFrame{
	private JButton backButton;
	private String still = "/main/img/virus1.png";
	private Sprite virusSprite;

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
		panel.setBackground(Color.cyan);
		
		backButton = new JButton("< Go back to Menu");
		backButton.addMouseListener(new ColorChange(null, backButton, null));
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.setVisible(true);
				me.setVisible(false);
			}
		});
		panel.add(backButton);
		c.add(panel, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.darkGray);
		c.add(panel2);

		virusSprite = new Sprite(still);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Font fnt = new Font("Arial", 1, 20);
		g.setFont(fnt);
		g.setColor(Color.cyan);
		g.drawString("• Control the game with your mouse/keypad/stylus.  • Don't forget to check the time above in the TITLE!", 25, 110);
		g.drawString("• To win, purify the Virus.", 25, 150);
		g.drawString("• First, the objects need to be in HEALTHY or CURED condition;", 25, 190);
		g.setColor(Color.black);
		g.fillRect(360, 200, 35, 35);
		g.setColor(Color.cyan);
		g.fillRect(475, 200, 35, 35);
		g.drawString("• not in the POISONED condition.", 25, 250);
		g.setColor(Color.green);
		g.fillRect(170, 260, 35, 35);
		g.setColor(Color.cyan);
		g.drawString("• To cure objects, a window will appear after clicking on it, then complete the action.", 25, 320);
		g.drawString("• Once cured, the objects are immune to the Virus for a limited time.", 25, 360);
		g.drawString("• To purify the Virus, first freeze it in it's tracks.", 25, 400);
		g.drawString("• Clicking on the Virus will open a window with 2 options: FREEZE & PURIFY.", 25, 440);
		g.drawString("• Click the FREEZE button 15 times to halt the virus in order to cure the remaining poisoned objects.", 25, 480);
		g.drawString("• Once the objects are cured and the Virus is stunned, time for VIRUS PURIFICATION!", 25, 520);
		
		g.drawImage(virusSprite.getImg(), 300, 610, null);
		Font fnt2 = new Font("Times New Roman", 1, 30);
		g.setFont(fnt2);
		g.drawString("< This is the Virus :(", 400, 640);
		g.drawString("< Purify It Please :)", 470, 680);
		
		Font fnt3 = new Font("Times New Roman", 1, 25);
		g.setFont(fnt3);
		g.setColor(Color.white);
		g.drawString("Copyright ©2017 by 2Ways", 10, 830);
	}
}
