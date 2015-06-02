package music;

import java.util.Iterator;
import java.util.List;

public class Song {

	
	String title;
	private List<String> lyrics;
	

	public Song(String title, List<String> lyrics) {
		super();
		this.title = title;
		this.lyrics = lyrics;
	}
	
	
	public Song() {
		super();
		
	}
	
	public String pickLine(Voice voice, int lineNumber){
		
		if(voice ==Voice.ALL){
			return allLines();
		}
		if(voice == Voice.LEAD || voice == Voice.BACKING){
			return this.lyrics.get(lineNumber);
		}
		
		return null;
	}

	public String allLines(){
		StringBuffer lyrics = new StringBuffer();
		for (Iterator iterator = this.lyrics.iterator(); iterator.hasNext();) {
			lyrics  = lyrics.append((String) iterator.next()+'\n');
			
		}
		return lyrics.toString();
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<String> getLyrics() {
		return lyrics;
	}


	public void setLyrics(List<String> lyrics) {
		this.lyrics = lyrics;
	}
	
	
	
}
