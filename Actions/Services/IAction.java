package Game.Actions.Services;
import Game.GameHandler;

public interface IAction {
	
//	public void IAction() ;
	
	
  
	
	
	int id = 0;
	String type = null;

	public void evaluateAction( GameHandler gh);

}
