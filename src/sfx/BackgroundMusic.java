package sfx;

public class BackgroundMusic implements MusicListener{
	
	public BackgroundMusic(){
		
	}

	@Override
	public void playMusic() {
		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();
	}

	@Override
	public void stopMusic() {
		AudioPlayer.getMusic("music").stop();
	}
}
