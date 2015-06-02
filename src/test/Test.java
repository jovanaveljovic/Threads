package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import music.Performance;
import music.Singer;
import music.Song;
import music.Voice;

public class Test {

	public static final Scanner IN  = new Scanner(System.in);
	
	private Song love;
	List<String> lyrics;
	Singer bbk;
	Singer bono;
	Performance performance;
	
	
	private void initialization(){
		lyrics = new ArrayList<String>();
		lyrics.add("When love comes to town,I'm gonna jump that train");
		lyrics.add("When love comes to town I'm gonna catch that flame");
		lyrics.add("Maybe I was wrong to ever let you down");
		lyrics.add("But I did what I did before love came to town");
		
		love = new Song("When love comes to town", lyrics);
		
		performance = new Performance(love, 1000);
		
		bbk = new Singer(performance, "B.B. King", Voice.LEAD);
		bono = new Singer(performance, "Bono", Voice.BACKING);
		
		
	}
	
	public void testPickLine(){
		initialization();
		System.out.println(love.pickLine(Voice.ALL, 2));
		System.out.println();
		System.out.println(love.pickLine(Voice.LEAD, 1));
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
}
