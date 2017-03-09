package main;

import main.frames.CureObject;
import main.frames.Game;
import main.frames.Play;
import sfx.BackgroundMusic;

public class Window{

	public static void main(String[] args){
		//CureObject g = new CureObject();
		Play g = new Play(null);
		//Game g = new Game();
		g.setVisible(true);
		BackgroundMusic bm = new BackgroundMusic();
		//bm.playMusic();
	}

}
