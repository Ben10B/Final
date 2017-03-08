package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import main.WinLoseListener.WINLOSE;
import main.frames.End;
import main.frames.Game;
import main.frames.Play;
import sfx.BackgroundMusic;

public class Window{

	public static void main(String[] args){
		End g = new End(null);
//		Game g = new Game();
		g.setVisible(true);
		BackgroundMusic bm = new BackgroundMusic();
		bm.playMusic();
	}

}
