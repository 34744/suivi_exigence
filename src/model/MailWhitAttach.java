package model;


	import javax.mail.*;
	import javax.mail.event.*;
	import javax.mail.internet.*;
	import javax.mail.search.*;
	import java.util.*;
	import javax.activation.*;
	 
	/**
	 * <p>Titre : envoi d' e-mail </p>
	 * <p>Description : utilisation du protocole smtp</p>
	 * <p>Copyright : Copyright (c) 2005</p>
	 * <p>Société : emi</p>
	 * @author mabroumi mouhcine
	 * @version 1.0
	 */
	 
	public class MailWhitAttach {
	  private final static String MAILER_VERSION = "Java";
	 
	  public MailWhitAttach() {
	  }
	 
	  public static boolean envoyerMailSMTP(String serveur,String mailto,String subject,String texte,String piece, boolean debug) {
	    boolean result = false;
	    try {
	      Properties prop = System.getProperties();
	      prop.put("mail.smtp.host", serveur);
	      Session session = Session.getDefaultInstance(prop, null);
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("cedric_deceuleneer@hotmail.com"));
	      InternetAddress[] internetAddresses = new InternetAddress[1];
	      internetAddresses[0] = new InternetAddress(mailto);
	      message.setRecipients(Message.RecipientType.TO, internetAddresses);
	      message.setSubject(subject);
	      message.setText("test de code");
	 
	      message.setSentDate(new Date());
	      // Première partie du message
	      BodyPart messageBodyPart = new MimeBodyPart();
	 
	// Contenu du message
	      messageBodyPart.setText(texte);
	 
	//Ajout de la première partie du message dans un objet Multipart
	      Multipart multipart = new MimeMultipart();
	      multipart.addBodyPart(messageBodyPart);
	 
	// Partie de la pièce jointe
	      messageBodyPart = new MimeBodyPart();
	      //piece est le path obtenu avec JFileChooser dans une autre classe
	      DataSource source = new FileDataSource(piece);
	      messageBodyPart.setDataHandler(new DataHandler(source));
	      messageBodyPart.setFileName("piece jointe");
	//Ajout de la partie pièce jointe
	      multipart.addBodyPart(messageBodyPart);
	 
	      message.setContent(multipart);
	 
	      session.setDebug(debug);
	      Transport.send(message);
	      System.out.println("message envoyé avec succés");
	      result = true;
	    }
	    catch (AddressException e) {
	      e.printStackTrace();
	    }
	    catch (MessagingException e) {
	      e.printStackTrace();
	    }
	    return result;
	  }
	  public static void main(String[] args) { 
		         
		 MailWhitAttach.envoyerMailSMTP("mailrelayappl.intra.wallonie.be","cedric_deceuleneer@hotmail.com","test","test","C:\\Documents and Settings\\34744\\Bureau\\temporaire\\MVC.doc",true); 
		    
		  } 

	}

