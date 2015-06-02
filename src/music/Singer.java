package music;

public class Singer {

	private Performance performance;
	private String singerName;
	private Voice voice;
	
	public Singer() {
		super();
		
	}

	public Singer(Performance performance, String singerName, Voice voice) {
		super();
		this.performance = performance;
		this.singerName = singerName;
		this.voice = voice;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	
	public void sing(Song song, int noOfRepetitions){
		for(int i = 0; i<noOfRepetitions; i+=2){
			if(this.voice == voice.LEAD){
				System.out.println(song.getLyrics().get(i%song.getLyrics().size()));
			}
			if(this.voice==voice.BACKING){
				System.out.println(song.getLyrics().get(i%song.getLyrics().size()+1));
			
			}
		}
		
	}
	
	
	
}
