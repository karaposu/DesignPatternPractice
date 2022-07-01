package Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Game.Card;
import java.util.ArrayList;

public class CardsManager {

	Card[] cards;

	Card[] openedcards;

	ArrayList<Card> listopenedcards = new ArrayList<Card>(16);

	boolean locked = false;

	public Card[] shuffleCards(Card[] array) {

		Random RANDOM = new Random();

		for (int i = 0; i < array.length; i++) {

			int nuovaPosizione = RANDOM.nextInt(array.length);
			Card swap = array[nuovaPosizione];

			array[nuovaPosizione] = array[i];
			array[i] = swap;
		}

		return array;

	}

	public Card[] createCards(ImageIcon[] a) {

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

			Card newCard = new Card(num, img_card, backIcon);

//			System.out.println("dsa");
			cards[i] = newCard;

		}

		return cards;

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

		return imageIcons;

	}

}
