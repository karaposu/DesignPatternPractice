package Game;


import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class GameHandler {

	
//	private Container mainContentPane;			// frame that holds card field and turn counter
	public CardsManager cardsManager;
	
	public Clicklistener clicklistener;
	public GameLogic gamelogic;

	public void newGame() {

		this.createCardsManager();

		ImageIcon[] icons = this.cardsManager.loadimages();

		Card[] cards = this.cardsManager.createCards(icons);

		Card[] shuffledcards = this.cardsManager.shuffleCards(cards);

		this.clicklistener = new Clicklistener(shuffledcards, this);

		this.drawFrame(cards);
		
		this.gamelogic = new GameLogic();
		
		this.gamelogic.gh= this;

		

	}

	public void addCardtoOpenedCards(Card x) {

		this.cardsManager.listopenedcards.add(x);

	}

	public void createCardsManager() {

		this.cardsManager = new CardsManager();

//		this.cardsManager = cardsManager;

	}

	public void drawFrame(Card[] cardlist) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLayout(new GridLayout(4, 4, 20, 20));

		for (int i = 0; i < 16; i++) {

			cardlist[i].addActionListener(this.clicklistener);
			ImageIcon imagicon = cardlist[i].backImage;

			cardlist[i].setIcon(imagicon);

			cardlist[i].setVisible(true);
			cardlist[i].setOpaque(false);
			frame.add(cardlist[i]);
		}

		frame.setVisible(true);

	}

}
