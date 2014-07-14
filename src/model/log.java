package model;

import org.apache.log4j.Logger;

public class log {
	private static Logger logger = Logger.getLogger(log.class);
	  
	  public static void main(String[] args) {
	    logger.debug("msg de debogage");
	    logger.info("msg d'information");
	    logger.warn("msg d'avertissement");
	    logger.error("msg d'erreur");
	    logger.fatal("msg d'erreur fatale");   
	  }

}
