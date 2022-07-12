



package Game;

import java.util.ArrayList;
import java.util.logging.Level;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


import Game.Actions.Services.IAction;
public class GameLogic {
	

	public GameHandler gh;
	
	
	public void GetAction(IAction x)  {
		
				
		
		
		

	}
	
	

	
	
	public void CardIsClicked(Card card) throws IOException, Exception {
		
	

	
	MyLogger.log(Level.INFO, "! gl cardsclicked" ); 
	
	if (card.locked==true) {
		
		MyLogger.log(Level.INFO, "! card is locked" ); 

		
	}
	else {
		
	  if (this.gh.cardsManager.listopenedcards.size() == 0) {
		
		MyLogger.log(Level.INFO, "First card is opened" ); 
		this.gh.addCardtoOpenedCards(card);
		card.SetFrontIcon();

	  }

	 else if (gh.cardsManager.listopenedcards.size() == 1) {
		 
		 
		
		 MyLogger.log(Level.INFO, "Second card is opened" ); 
		 
	    
		this.gh.addCardtoOpenedCards(card);
		card.SetFrontIcon();
		

		
		if ( gh.cardsManager.detectMatch()==true) {
			
			
			 
			 MyLogger.log(Level.INFO, "A match is detected" ); 
			
			this.playMusic();
			gh.cardsManager.lockCards();
			this.gh.cardsManager.listopenedcards.clear();
		}
		else {
			

			 
			MyLogger.log(Level.INFO, "gh.clicklistener.turnDownTimer.start()" ); 
			 
			gh.commandListener.turnDownTimer.start();
			
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

		

		String soundFileName = "match_detected.wav";   
		
		String projectPath= System.getProperty("user.dir");

		
		String soundFilePath= projectPath + "/files/" + soundFileName;
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();

			
		}
	
	
	
	
	

}




