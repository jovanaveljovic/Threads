package music;

public class Singer {

	private Performance performance;
	private String singerName;
	private Voice voice;
	
	private Synchronized synch;
	private boolean stop;
	
	
	public Singer(Performance performance, String singerName, Voice voice,
			Synchronized synch, boolean stop) {
		super();
		this.performance = performance;
		this.singerName = singerName;
		this.voice = voice;
		this.synch = synch;
		this.stop = stop;
	}

	public Synchronized getSynch() {
		return synch;
	}

	public void setSynch(Synchronized synch) {
		this.synch = synch;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

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
	public synchronized void SingWithDelay(Song song, int noOfRepetitions ){
		long delay = this.performance.getDelay();
		for(int i = 0; i<noOfRepetitions; i+=2){
			if(this.voice == voice.LEAD){
				System.out.println(song.getLyrics().get(i%song.getLyrics().size()));
				try {
					wait(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(this.voice==voice.BACKING){
				System.out.println(song.getLyrics().get(i%song.getLyrics().size()+1));
				try {
					wait(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void run(){
		sing();
	}
	public void sing(){
		Song song = performance.getSong();
		long delay = performance.getDelay();
		
		int i = 0;
		String line = null;
		
		while(!stop){
			if(this.voice==voice.LEAD){
				line = song.pickLine(this.voice, song.getLyrics().size());
				synch.singLeadVoice(line, delay);
			}
			if(this.voice==voice.BACKING){
				line = song.pickLine(this.voice, song.getLyrics().size()+1);
				synch.singBeakingVoice(line, delay);
			}
			i+=2;
			
			
		}
	}
	
}
