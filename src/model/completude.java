package model;

import java.io.File;

public class completude {
	public static void test(){
		File calendar = new File("jcalendar-1.4.zip"); 
		File calendar2 = new File("jcalendar-1.4.jar"); 
		if( calendar.exists() && calendar2.exists()) {
			GestionLog.testLibraryOK(calendar.toString());
		}
		else
			GestionLog.testLibraryManquante(calendar.toString());
	
	File ilf = new File("ilf-gpl-1.6.1.jar.zip"); 
	if( ilf.exists()) {
		GestionLog.testLibraryOK(ilf.toString());
	}
	else
		GestionLog.testLibraryManquante(ilf.toString());
	
	File mysql = new File("mysql-connector-java-5.1.27-bin.jar"); 
	if( mysql.exists()) {
		GestionLog.testLibraryOK(mysql.toString());
	}
	else
		GestionLog.testLibraryManquante(mysql.toString());
	
	File bcpkix = new File("bcpkix-jdk15on-150.zip"); 
	if( bcpkix.exists()) {
		GestionLog.testLibraryOK(bcpkix.toString());
	}
	else
		GestionLog.testLibraryManquante(bcpkix.toString());
	
	File bcprov = new File("bcprov-jdk15on-150.jar"); 
	if( bcprov.exists()) {
		GestionLog.testLibraryOK(bcprov.toString());
	}
	else
		GestionLog.testLibraryManquante(bcprov.toString());
	
	File bcprovDebug = new File("bcprov-debug-jdk15on-150.jar"); 
	if( bcprovDebug.exists()) {
		GestionLog.testLibraryOK(bcprovDebug.toString());
	}
	else
		GestionLog.testLibraryManquante(bcprovDebug.toString());
	
	File iText = new File("itext-2.1.3.jar"); 
	if( iText.exists()) {
		GestionLog.testLibraryOK(iText.toString());
	}
	else
		GestionLog.testLibraryManquante(iText.toString());
	
	File mail = new File("mail.jar"); 
	if( mail.exists()) {
		GestionLog.testLibraryOK(mail.toString());
	}
	else
		GestionLog.testLibraryManquante(mail.toString());
	
	File log = new File("log4j-1.2.17.jar"); 
	if( log.exists()) {
		GestionLog.testLibraryOK(log.toString());
	}
	else
		GestionLog.testLibraryManquante(log.toString());
	
	File pop = new File("pop3-1.4.6.jar"); 
	if( pop.exists()) {
		GestionLog.testLibraryOK(pop.toString());
	}
	else
		GestionLog.testLibraryManquante(pop.toString());
	
	}


}
