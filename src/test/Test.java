package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import music.Song;
import music.Voice;

public class Test {

	public static final Scanner IN  = new Scanner(System.in);
	
	private Song love;
	List<String> lyrics;
	
	
	private void initialization(){
		lyrics = new ArrayList<String>();
		lyrics.add("When love comes to town,I'm gonna jump that train");
		lyrics.add("When love comes to town I'm gonna catch that flame");
		lyrics.add("Maybe I was wrong to ever let you down");
		lyrics.add("But I did what I did before love came to town");
		
		love = new Song("When love comes to town", lyrics);
		
		
	}
	
	public void testPickLine(){
		initialization();
		System.out.println(love.pickLine(Voice.ALL, 2));
		System.out.println();
		System.out.println(love.pickLine(Voice.LEAD, 1));
	}
	
}
