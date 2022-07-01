package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


public class Clicklistener implements ActionListener
{
	
		public Card[] clist;
	
	    public GameHandler gh;
	    
	    public Timer turnDownTimer ;
	    int counter ;


	public  Clicklistener(Card[] clist, GameHandler gh)
  {
		this.clist = clist;
		this.gh = gh;
		this.counter = 0;
		this.turnDownTimer = new Timer(1000, this);
		this.turnDownTimer.setRepeats(false);

  }
	




  public void actionPerformed(ActionEvent e)
  {
  	
	 
	for(int t = 0; t < 16; t++ )
		{  
		  
		if (e.getSource() ==  this.clist[t]) {
			Object activeSource = e.getSource();
			
			if(gh.cardsManager.listopenedcards.size()==0)
			  {
				 this.gh.addCardtoOpenedCards(this.clist[t]);
	  			 this.clist[t].SetFrontIcon();
				
			  }
			
			else if(gh.cardsManager.listopenedcards.size()==1)
			  {
				this.gh.addCardtoOpenedCards(this.clist[t]);
	  			this.clist[t].SetFrontIcon();
				this.turnDownTimer.start();
			  }
				
				
		 }
		}
	 if (e.getSource()== this.turnDownTimer)
		{
		    System.out.println("---------timer");
			Object activeSource = e.getSource();
			ArrayList<Card>  ocards = this.gh.cardsManager.listopenedcards;
  			ocards.get(0).SetBackIcon();
	  		ocards.get(1).SetBackIcon();
	  		this.gh.cardsManager.listopenedcards.clear();
		}
	  


  	
  
	 }


  }


//if (e.getSource() ==  this.clist[t])
//{	
// 
//	System.out.println("click detected");
//	 
//	 
//	 if(gh.cardsManager.listopenedcards.size()!=2)
//	  {
//		 gh.addCardtoOpenedCards(this.clist[t]);
//		 
//		 if (this.clist[t].WhichSideIsOn() == false)
//  	  {
//  		  
//  		  this.clist[t].SetFrontIcon();
//  		 
//  	  }
//  	  else
//  	  {
//  		  this.clist[t].SetBackIcon();
//  		  
//  	  }
//		 
//
//	  }
//	 
//	 
//	 else {
//		  this.turnDownTimer.start();
//		  this.turnDownTimer.setRepeats(false);
//		  
//		  gh.cardsManager.listopenedcards.clear();
//		 
//	 }
// 

