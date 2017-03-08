package sfx;

public class BackgroundMusic implements MusicListener{
	
	public BackgroundMusic(){
		
	}

	@Override
	public void playMusic() {
		AudioPlayer.load();
		AudioPlayer.getMusic("music").play();
	}

	@Override
	public void stopMusic() {
		AudioPlayer.getMusic("music").stop();
	}
}
