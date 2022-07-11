package Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Game.Card;
import java.util.ArrayList;
public class CardsManager {

	Card[] cards;

	Card[] openedcards;
	
	ImageIcon[] imageIcons;

	ArrayList<Card> listopenedcards = new ArrayList<Card>(16);

	boolean locked = false;
	
	
	
	public void lockCards() {

		
	 this.listopenedcards.get(0).locked=true;
	 this.listopenedcards.get(1).locked=true;
	 
	
			


	}
	
	
	public boolean detectMatch() {
		
		MyLogger.log(Level.INFO, "------ detectMatch()"); 

		boolean match=false;
		if (this.listopenedcards.size()==2) {
			
			if(	this.listopenedcards.get(0).id==this.listopenedcards.get(1).id ) {
			

			match= true;
			
			}
			else {match= false;}
		}
		return match;


	}

	public Card[] shuffleCards() {
		
		MyLogger.log(Level.INFO, "------ shuffleCards()"); 

		Random RANDOM = new Random();
		
		Card[] array=this.cards;

		for (int i = 0; i < array.length; i++) {

			int nuovaPosizione = RANDOM.nextInt(array.length);
			Card swap = array[nuovaPosizione];

			array[nuovaPosizione] = array[i];
			array[i] = swap;
		}
		this.cards= array;
		
		

		
		
		return array;

	}

	public Card[] createCards() {
		
		MyLogger.log(Level.INFO, "------ createCards()"); 

//		a=this.imageIcons;
		Card[] cards = new Card[16];

		ImageIcon[] Icons = this.loadimages();

		int list_of_ids[] = new int[16];
		for (int i = 0; i < 8; i++) {
			list_of_ids[2 * i] = i;
			list_of_ids[2 * i + 1] = i;
		}

		for (int i = 0; i < list_of_ids.length; i++) {

			int num = list_of_ids[i];

			ImageIcon img_card = Icons[num];

			ImageIcon backIcon = Icons[8];

			Card newCard = new Card(i, num, img_card, backIcon);
			
			newCard.setIcon(backIcon);

			newCard.setVisible(true);
			newCard.setOpaque(false);

//			System.out.println("dsa");
			cards[i] = newCard;

		}
		this.cards=cards;
		
		this.shuffleCards();
		

		
		return this.cards;

	}

	public ImageIcon[] loadimages() {

		ImageIcon imageIcons[] = new ImageIcon[9];
		BufferedImage buffered[] = new BufferedImage[9];

		for (int i = 0; i < 9; i++) {

			String fileName = "/Users/ns/Desktop/WS/Oyun/resimler/futbol/card" + i + ".jpg";

			BufferedImage img = null;

			try {
				img = ImageIO.read(new File(fileName)); // eventually C:\\ImageTest\\pic2.jpg
			} catch (IOException e) {
				e.printStackTrace();
			}

			ImageIcon imageIcon = new ImageIcon(img);
			imageIcons[i] = imageIcon;

		}

		this.imageIcons= imageIcons;
		return imageIcons;

	}

}
