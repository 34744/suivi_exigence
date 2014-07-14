import javax.mail.internet.*;
import javax.mail.*;

import javax.mail.*;
import javax.mail.event.*;
import javax.mail.internet.*;
import javax.mail.search.*;
import java.util.*;
import javax.activation.*;
import com.sun.mail.smtp.SMTPTransport;

import java.util.*;

/**
 * Classe permettant d'envoyer un mail.
 */
public class testMail {
 private final static String MAILER_VERSION = "Java";
   public static boolean envoyerMailSMTP(String serveur, boolean debug) {
         boolean result = false;
         try {
                  Properties prop = System.getProperties();
                  prop.put("mail.smtp.host", serveur);
                  Session session = Session.getDefaultInstance(prop,null);
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("cedric.deceuleneer@spw.wallonie.be"));
                  InternetAddress[] internetAddresses = new InternetAddress[1];
                  internetAddresses[0] = new InternetAddress("cedric.deceuleneer@spw.wallonie.be");
                  message.setRecipients(Message.RecipientType.TO,internetAddresses);
                  message.setSubject("Test");
                  message.setText("test mail");
                  message.setHeader("X-Mailer", MAILER_VERSION);
                  message.setSentDate(new Date());
                  session.setDebug(debug);
                  Transport.send(message);
                  result = true;
         } catch (AddressException e) {
                  e.printStackTrace();
         } catch (MessagingException e) {
                  e.printStackTrace();
         }
         return result;
   }
   public static void main(String[] args) {
       testMail.envoyerMailSMTP("mailrelayappl.intra.wallonie.be",true);
 }

} 