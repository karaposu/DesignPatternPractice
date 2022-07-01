package Game;

import java.util.ArrayList;
//import javax.swing.Timer;
public class GameLogic {
	

	
	public GameHandler gh;

//	public Timer turnDownTimer;


	
//	public void GameLogic() {
//
//
//	}
	
	
	public void CardIsClicked(Card card) {

	  if (this.gh.cardsManager.listopenedcards.size() == 0) {
		this.gh.addCardtoOpenedCards(card);
		card.SetFrontIcon();

	  }

	 else if (gh.cardsManager.listopenedcards.size() == 1) {
		this.gh.addCardtoOpenedCards(card);
		card.SetFrontIcon();
		gh.clicklistener.turnDownTimer.start();

	 }
			
		
		
		
	}
	
	public void TimerEventIsActivated() {

		

	ArrayList<Card> ocards = this.gh.cardsManager.listopenedcards;
	ocards.get(0).SetBackIcon();
	ocards.get(1).SetBackIcon();
	this.gh.cardsManager.listopenedcards.clear();


		
	}

}




