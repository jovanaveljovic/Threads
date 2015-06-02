package test;

import java.util.Timer;
import java.util.TimerTask;

public class ShoutTimerTast extends TimerTask {

	
	private Timer timer;
	
	public void run() {
		System.out.println();
		System.out.println("Yeah");
		System.out.println();
		
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public ShoutTimerTast(Timer timer) {
		super();
		this.timer = timer;
	}
	

	public ShoutTimerTast() {
		super();
		
		
	}
	
	

}
