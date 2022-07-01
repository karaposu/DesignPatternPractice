package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Clicklistener implements ActionListener {

	public Card[] clist;
	
	public GameHandler gh;

	public Timer turnDownTimer;
	int counter;

	public Clicklistener(Card[] clist, GameHandler gh) {
		this.clist = clist;
		this.gh = gh;
		this.counter = 0;
		this.turnDownTimer = new Timer(1000, this);
		this.turnDownTimer.setRepeats(false);

	}
		
	
	public void NotifyGameLogicButtonIsClicked(Card C) {
		
			this.gh.gamelogic.CardIsClicked(C);
		

	}
	
	
	public void NotifyGameLogicTimerIsActivated() {
	
			this.gh.gamelogic.TimerEventIsActivated();
		

	}
	
	public void actionPerformed(ActionEvent e) {

		for (int t = 0; t < 16; t++) {

			if (e.getSource() == this.clist[t]) {
				
				this.NotifyGameLogicButtonIsClicked(this.clist[t]) ;
			}
		  }
		
		
		if (e.getSource() == this.turnDownTimer) {
			
			this.NotifyGameLogicTimerIsActivated() ;
			
			
			
		}

	}
}
