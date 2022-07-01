package Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton {
	
	ImageIcon frontImage;
	ImageIcon backImage;
	boolean locked = false;
	int id;
	boolean activeIcon = false;
	boolean matched = false;

	public Card(int num, ImageIcon on, ImageIcon arka) {

		this.frontImage = on;
		this.backImage = arka;
		this.id = num;
//		boolean faceUp = false; 

	}

	public boolean WhichSideIsOn() {

		return this.activeIcon;

	}

	public void LockTheCard() {

		this.locked = true;

	}

	public void SetFrontIcon() {

		this.setIcon(this.frontImage);
		this.activeIcon = true;

	}

	public void SetBackIcon() {

		this.setIcon(this.backImage);
		this.activeIcon = false;

	}

}
