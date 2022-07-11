package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;

import javax.swing.Timer;

import Game.Commands.Implementations.ButtonClickCommand;
import Game.Commands.Implementations.TimerActivatedCommand;

public class CommandListener implements ActionListener {


	
	public Card[] clist;
	
	public GameHandler gh;

	public Timer turnDownTimer;
//	int counter;

	public CommandListener( GameHandler gh) {
//		this.clist = clist;
		this.gh = gh;
//		this.counter = 0;
		this.turnDownTimer = new Timer(1000, this);
		this.turnDownTimer.setRepeats(false);

	}
		
	
	public void ButtonIsClicked(Card C) throws IOException, Exception {
		
		    MyLogger.log(Level.INFO, "------ ButtonIsClicked() CommandListener"); 
		    
		    String C_unique_id=String.valueOf(C.unique_id);
		    
		    
		    MyLogger.log(Level.INFO, "Unique Id of Clicked Button: " +C_unique_id); 
			
//	    	System.out.println( "ButtonIsClicked() CommandListener");
	    
		
			ButtonClickCommand btncommand = new ButtonClickCommand(C.unique_id);
			

			btncommand.execute(this.gh);

	}
	
	public void TimerIsActivated() throws IOException, Exception {
		

		
		MyLogger.log(Level.INFO, "TimerIsActivated() CommandListener" ); 
		
		TimerActivatedCommand timeractived = new TimerActivatedCommand();
		
		timeractived.execute(this.gh);

}
	

	
	public void actionPerformed(ActionEvent e) {

		for (int t = 0; t < 16; t++) {

			if (e.getSource() == this.clist[t]) {
				
				try {
					this.ButtonIsClicked(this.clist[t]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		  }
		
		
		if (e.getSource() == this.turnDownTimer) {
			
			
			
			try {
				this.TimerIsActivated();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}

	}
}
