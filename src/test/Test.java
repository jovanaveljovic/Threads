package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import music.Performance;
import music.Singer;
import music.Song;
import music.Synchronized;
import music.Voice;

public class Test {

	public static final Scanner IN  = new Scanner(System.in);
	
	private Song love;
	private List<String> lyrics;
	private Singer bbk;
	private Singer bono;
	private Performance performance;
	private Synchronized synch;
	private boolean stop;
	
	
	
	private void initialization(){
		lyrics = new ArrayList<String>();
		lyrics.add("When love comes to town,I'm gonna jump that train");
		lyrics.add("When love comes to town I'm gonna catch that flame");
		lyrics.add("Maybe I was wrong to ever let you down");
		lyrics.add("But I did what I did before love came to town");
		
		love = new Song("When love comes to town", lyrics);
		
		performance = new Performance(love, 1000);
		
		synch = new Synchronized(true);
		stop=false;
		
		//bbk = new Singer(performance, "B.B. King", Voice.LEAD, synch, stop);
		//bono = new Singer(performance, "Bono", Voice.BACKING, synch, stop);
		
		
	}
	
	public void testPickLine(){
		initialization();
		System.out.println(love.pickLine(Voice.ALL, 2));
		System.out.println();
		System.out.println(love.pickLine(Voice.LEAD, 2));
		System.out.println();
		System.out.println(love.pickLine(Voice.LEAD, 3));
	}
	
	public void testSing(){
		initialization();
		bbk.sing(love, 8);
		System.out.println();
		bono.sing(love, 8);
	}
	
	public void testSingWithDelay(){
		initialization();
		bbk.SingWithDelay(love, 8);
		System.out.println();
		bono.SingWithDelay(love, 8);
	}
	
	public void testSingwithTimer(){
		Timer timer = new Timer();
		ShoutTimerTast shout = new ShoutTimerTast(timer);
		timer.schedule(shout, 2500);
		
		initialization();
		bbk.SingWithDelay(love, 8);
	}
	
	public void testSingWithThreads(){
		initialization();
		bbk.start();
		bono.start();
		
		IN.nextLine();
		bbk.setStop(true);
		bono.setStop(true);
	}
}
