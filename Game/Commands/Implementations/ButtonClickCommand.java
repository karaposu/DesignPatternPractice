package Game.Commands.Implementations;

import java.io.IOException;

import Game.GameHandler;


import Game.Commands.Services.*;

public class ButtonClickCommand implements ICommand{
	
	
	public static int unique_id =0;
	
	String type = null;
	
	public ButtonClickCommand(int unique_id) {
		
		this.setUnique_id(unique_id);

	}

	@Override
	public void execute(GameHandler gh) throws IOException, Exception {
		
		gh.Input(this);
		
	}
	
	@Override
	public int getUnique_id() {
		return this.unique_id;
	}

	@Override
	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}
	



}
