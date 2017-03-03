package main;

public class WinLoseScenario implements WinLoseListener{
	private WINLOSE scenario;
	@Override
	public void WinLose(WINLOSE wl) {
		
		if(wl == WINLOSE.Win){
			this.scenario = wl;
			//System.out.println("Win");
		}else{
			this.scenario = wl;
			//System.out.println("Lose");
		}
	}
	
	public WINLOSE getScenario(){
		return scenario;
	}
}
