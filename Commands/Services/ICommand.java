package Game.Commands.Services;

import java.io.IOException;

import Game.GameHandler;

public interface ICommand  {
	

	
	public static  int unique_id =0;

	public void execute( GameHandler gh) throws IOException, Exception;
	
	public int getUnique_id();
	
	public void setUnique_id(int a);

}
