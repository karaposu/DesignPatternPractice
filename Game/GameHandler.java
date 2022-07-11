package Game;


import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JFrame;
import Game.Commands.Services.ICommand;
import java.util.logging.Level;



public class GameHandler {

	
	public CardsManager cardsManager;
	
	public CommandListener commandListener;
	public GameLogic gamelogic;
	


	public void newGame() {
		


		this.createCardsManager();
		Card[] shuffledcards =  this.cardsManager.createCards();
		this.commandListener = new CommandListener(this);
		
		addCardsToCommandListener(shuffledcards);

		this.drawFrame(shuffledcards);
		
		this.gamelogic = new GameLogic();
		
		this.gamelogic.gh= this;

		

	}
	
	
	public void CardIsClicked(Card x) throws IOException, Exception {
		

		
		 MyLogger.log(Level.INFO, "CardIsClicked() gh" ); 
		 Card a= x;
		 this.gamelogic.CardIsClicked(a);
//		this.gamelogic.CardIsClicked(Card x);

	}
	
	public void TimerIsActivated() throws IOException, Exception {
		
//		 Card a= x;
		 this.gamelogic.TimerEventIsActivated();
//		this.gamelogic.CardIsClicked(Card x);

	}
	
	public Card FindCardByUniqueId(Card[] xx, int uid) throws IOException, Exception {
		
		Card temp = null;
		
		
		
		for (int i = 0; i < 16; i++) {

			if (xx[i].unique_id==uid)
			{
				temp=xx[i];
				
			}
		}
		
		return temp;


	}
	
	/**
	   * Input method for all game commands triggered by front end.
	   * @return void.
	 */
	public void Input(ICommand x) throws IOException, Exception {
		
	
		MyLogger.log(Level.INFO, "input() gh" ); 
		
		System.out.println(   x.getUnique_id());
		
		if (x.getUnique_id() <16  ) {
			
			Card temp =FindCardByUniqueId( this.cardsManager.cards,  x.getUnique_id() );
			
//			System.out.println( temp.unique_id);

			 this.CardIsClicked(temp);
		}
		
		else {

	
			 
			 this.TimerIsActivated();
		}
		
		


	}
	
	/**
	   * Finds game objects related to action
	   * @return void.
	 */

	


	public void addCardtoOpenedCards(Card x) {

		this.cardsManager.listopenedcards.add(x);

	}

	public void createCardsManager() {

		this.cardsManager = new CardsManager();



	}
	
	
	public void addCardsToCommandListener(Card[] cardlist) {
		
		this.commandListener.clist=cardlist;

		for (int i = 0; i < 16; i++) {

			cardlist[i].addActionListener(this.commandListener);
		}



	}

	public void drawFrame(Card[] cardlist) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLayout(new GridLayout(4, 4, 20, 20));
		

		for (int i = 0; i < 16; i++) {

			frame.add(cardlist[i]);
		}

		frame.setVisible(true);

	}

}
