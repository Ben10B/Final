package main;

public interface WinLoseListener {
	public enum WINLOSE{
		Win, Lose
	}
	void WinLose(WINLOSE wl);
}
