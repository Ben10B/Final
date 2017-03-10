package main;

import main.frames.Game;
import main.frames.Play;
import sfx.BackgroundMusic;

public class Window{

	public static void main(String[] args){
		Game g = new Game();
		g.setVisible(true);
		BackgroundMusic bm = new BackgroundMusic();
		bm.playMusic();
	}

}
