package Game.Commands.Implementations;

import java.io.IOException;

import Game.GameHandler;
import Game.Commands.Services.ICommand;

public class TimerActivatedCommand implements ICommand {

	
	
	
	public static int unique_id =20;
	
	public  TimerActivatedCommand() throws IOException, Exception {
		// TODO Auto-generated method stub
		
		this.setUnique_id(unique_id);
		
	}
	
	@Override
	public void execute(GameHandler gh) throws IOException, Exception {
		// TODO Auto-generated method stub
		
		gh.Input(this);
		
	}
	
	@Override
	public int getUnique_id() {
		return this.unique_id;
	}



	@Override
	public void setUnique_id(int a) {
		// TODO Auto-generated method stub
		
	}

}
