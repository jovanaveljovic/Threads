package music;

public class Synchronized {

	private boolean leadVoiceFlag;
	
	public synchronized void singLeadVoice(String line, long delay){
		
		while(!leadVoiceFlag){
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		singOneLine( line,  delay);		
		
	}
	
	
	public synchronized void singBeakingVoice(String line, long delay){
		
		while(leadVoiceFlag){
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		singOneLine( line,  delay);		
		
	}
	public Synchronized(boolean leadVoiceFlag) {
		super();
		this.leadVoiceFlag = leadVoiceFlag;
	}


	public void singOneLine(String line, long delay){
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(line);
		leadVoiceFlag=!leadVoiceFlag;
		notifyAll();
		
	}
}
