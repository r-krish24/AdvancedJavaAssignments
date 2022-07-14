package logging;

import org.apache.log4j.Logger;

//Priority Levels
/*
 * SEVERE (highest)
 * WARNING
 * INFO
 * CONFIG
 */
public class Main {
	
	public static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String args[])
	{
		//logger.setLevel(Level.SEVERE);
		logger.info("This is Info Log");
		logger.debug("This is Debug Log");
		logger.warn("This is Error Log");
		logger.error("THis is Error Log");
		
	}
}
