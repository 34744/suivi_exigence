package model;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.xml.XMLLayout;

public class GestionLog {
	 

	public static void fermetureApplication(){
		Logger log = Logger.getLogger(GestionLog.class);
		
		log.setAdditivity(false);
	    /*try {
	      FileAppender fa = new FileAppender(new XMLLayout(), "c:/log.txt");
	      fa.setName("FichierLog");
	      log.addAppender(fa);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }*/
	    log.debug("connexion DB");
		
		JOptionPane message = new JOptionPane();
		message.showMessageDialog(null, "Impossibilite de se connecter a la DB","Erreur", JOptionPane.ERROR_MESSAGE);	
		message.disable();
				
		System.exit(0);
	}
	
	public static void lancementApplication(){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    try {
	      FileAppender fa = new FileAppender(new XMLLayout(), "d:/log.txt");
	      fa.setName("FichierLog");
	      log.addAppender(fa);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    log.info("Lancement application");
	}
	public static void applicationLancee(){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.info("Application lancee");

	}
	
	public static  void applicationEchecLancement(){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.fatal("Impossibilite de lancer application - DB non trouvee");
	    log.fatal("Fermeture de l'application");
	}
	
	public static  void connexionDBImpossible(){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.fatal("Erreur de connexion DB");
	    log.fatal("Fermeture de l'application");
	    JOptionPane.showMessageDialog(null, "Impossibilite de se connecter a la base de donnees! Veuillez contacter le RFA.", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
	    System.exit(0);
	}
	
	public static  void connexionDB(){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.info("Connexion DB");
	    
	}
	
	public static  void arriveeMethode(String nomMethode){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.info("Entree methode "+nomMethode);
	    
	}
	public static  void sortieMethode(String nomMethode){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.info("Sortie methode "+nomMethode);
	    
	}
	
	public static void testLibraryOK (String nomLibrary){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.info("Library trouvee "+ nomLibrary);
	}
	public static void testLibraryManquante (String nomLibrary){
		Logger log = Logger.getLogger(GestionLog.class);
		log.setAdditivity(false);
	    log.error("Library manquante: "+ nomLibrary);
	}	
	
}
