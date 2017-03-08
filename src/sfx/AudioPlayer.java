package sfx;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer{
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	private AudioPlayer() {

	}

	public static void load(){
		
		try {
			musicMap.put("music", new Music("res/Martin_Garrix.ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void loop(){
		if(musicMap != null)
			((Music) musicMap).loop();
	}
	
	public static void play(){
		if(musicMap != null)
			((Music) musicMap).play();
	}
	
	public void stop(){
		if(musicMap != null)
			((Music) musicMap).stop();
	}
	
	public static Music getMusic(String key){
		return musicMap.get(key);
	}
}