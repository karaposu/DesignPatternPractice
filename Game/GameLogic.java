package Game;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
public class GameLogic {
	

	public GameHandler gh;

	
	
	public void CardIsClicked(Card card) throws IOException, Exception {
		
	if (card.locked==true) {
		
	}
	else {

	  if (this.gh.cardsManager.listopenedcards.size() == 0) {
		this.gh.addCardtoOpenedCards(card);
		card.SetFrontIcon();

	  }

	 else if (gh.cardsManager.listopenedcards.size() == 1) {
		 
	    
		this.gh.addCardtoOpenedCards(card);
		card.SetFrontIcon();
		

		
		if ( gh.cardsManager.detectMatch()==true) {
			
			this.playMusic();
			gh.cardsManager.lockCards();
			this.gh.cardsManager.listopenedcards.clear();
		}
		else {
			gh.clicklistener.turnDownTimer.start();
			
		}
		
		
		
	 }

   }
	  
		
	}
	
	public void TimerEventIsActivated() {

		

	ArrayList<Card> ocards = this.gh.cardsManager.listopenedcards;
	ocards.get(0).SetBackIcon();
	ocards.get(1).SetBackIcon();
	this.gh.cardsManager.listopenedcards.clear();


		
	}
	
	
	public void playMusic() throws Exception, IOException {

		

		String soundName = "match_detected.wav";    
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();


			
		}
	
	
	
	
	

}




