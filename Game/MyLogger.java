package Game;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
	static Logger logger;
    public Handler fileHandler;
    Formatter plainText;
    
    private MyLogger() throws  IOException {
        //instance the logger
    	logger = Logger.getLogger(MyLogger.class.getName());
//        Logger LOGGER = Logger.getLogger(GameHandler.class.getName());
        //instance the filehandler
        fileHandler = new FileHandler("MemoryGame_logs.txt",true);
        //instance formatter, set formatting, and handler
        plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);

    }
    private static Logger getLogger(){
        if(logger == null){
        	
        	System.out.println( "logger == null");
            try {
                new MyLogger();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logger;
    }
    public static void log(Level level, String msg){
    	
      Logger logg=  getLogger();
      logg.log(level, msg);
      System.out.println(msg);
    }

}
