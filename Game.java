package Game;
import java.util.logging.Level;


//import Game.MyLogger;

public class Game {
	
	private static GameHandler gh;
	
	
	  
	
	
	public  GameHandler getInstance() {
		// make an instance of the main game class
		
		
		
		GameHandler temp = null;
		
		if (gh==null) {
			

			gh = new GameHandler();
//			return this.gh;
			temp= gh;
			
			MyLogger.log(Level.INFO, "------ New GH created"); 
		
			}
		return temp;
	}

	public static void main(String[] argv) {


		String projectPath= System.getProperty("user.dir");
		System.out.println(projectPath);
		
		Game  game= new Game();
		game.getInstance().newGame();
	
	}
	
	
	}
