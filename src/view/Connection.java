package view;
import javax.swing.*;
import javax.swing.plaf.multi.MultiButtonUI;

import controller.ControllerDBConfiguration;
import controller.gestionFenetreConfiguration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.*;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
public class Connection extends JDialog {        
	// VARIABLES        
	private JLabel labID, labPass;        
	JTextField textID;        
	private JPasswordField pass;        
	private JButton butOK, btnAnnuler;        
	private JPanel pan;        
	private acces user = new acces();        
	// CONSTRUCTEUR        
	public Connection() { 
		try 
	    {
	      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
	     
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		                           
		this.setTitle("Fenêtre de connection");                
		this.setModal(true);                
		this.setResizable(false);                
		this.setBounds(0, 0, 350, 200);    
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);                
		pan = new JPanel();                
		pan.setBackground(new Color(103,113,121));
		pan.setBounds(350, 200, 150, 150);                
		pan.setLayout(null);                
		
		labID = new JLabel("Identifiants: ");                
		labID.setBounds(50, 50, 100, 24);                
		
		labPass = new JLabel("Mot de passe: ");                
		labPass.setBounds(50, 75, 100, 24);                
		
		textID = new JTextField();                
		textID.setBounds(150, 50, 100, 24);                
		
		pass = new JPasswordField();                
		pass.setBounds(150, 75, 100, 24);    
		
		
		butOK = new JButton("OK");                
		butOK.setBounds(71, 124, 75, 24);                
		
		pan.add(labID);                
		pan.add(labPass);                
		pan.add(textID);                
		pan.add(pass);                
		pan.add(butOK);                
		
		getContentPane().add(pan);                
		
		btnAnnuler = new JButton("Annuler");                
		btnAnnuler.setBounds(161, 125, 89, 23);                
		pan.add(btnAnnuler);                
		
		MyButtonListener list = new MyButtonListener();                
		butOK.addActionListener(list);                
		btnAnnuler.addActionListener(list); 
		pass.addKeyListener(list);
		this.setVisible(true);  
		controller.ControllerDBConfiguration.connectionDB();     
		}        
	
	
	private class MyButtonListener implements ActionListener, KeyListener {               
	
		public void keyPressed(KeyEvent e) {
			/* Cette méthode est appelée quand l'utilisateur appuie sur une touche.
			Il est conseillé de ne pas utiliser getKeyChar() mais getKeyCode(), car les touches spéciales comme F1 ou Echap ne disposent pas d'un équivalent en Unicode, et donc ne peuvent être représentées en char. */
		       
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (verifConnection() == true){                                        
					hide(); 
					view.mainJFrame main = new view.mainJFrame(); 
				}
			}
					                            
		}

		
		public void actionPerformed(ActionEvent e) {                        
			Object source = e.getSource();                        
			if (source == butOK) {                                
				if (verifConnection() == true){                                        
					hide(); 
					view.mainJFrame main = new view.mainJFrame();                                    
					                            
					//dispose();
					}
				}
			if (source == btnAnnuler) {
				clotApplication();
				}
			}


		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		}
	private boolean verifConnection(){
	
		if (textID.getText() != null && pass.getText() != null){
			String nom = textID.getText();
			user = ControllerDBConfiguration.getUser(nom);
			if (user.getUlis() != null){
				
				System.out.println("mdp"+user.getMdp() + "pass"+getEncodedPassword(pass.getText()));
				if (user.getMdp().equals(getEncodedPassword(pass.getText()))){
					
					return true;
					}
				else{
					JOptionPane.showMessageDialog(null,"Mot de passe incorrect", "Mot de passe incorrect",JOptionPane.ERROR_MESSAGE);
					return false;
					}
				}
			else{
				JOptionPane.showMessageDialog(null,"Utilisateur inconnu", "Utilisateur inconnu",JOptionPane.ERROR_MESSAGE);
				return false;
				}
			}
		else{
			JOptionPane.showMessageDialog(null,"Veuillez remplir les champs", "Champs non remplis",JOptionPane.ERROR_MESSAGE);
			return false;
			}
		
		}
	
	public void clotApplication() {
		if (model.AccesDB.getConnection() != null)
			controller.ControllerDBConfiguration.fermetureDB();
		System.exit(0);
		}
	
			
		
/**
 * Fonction de hash SHA1
 * @param String toConvert
 */
	 
	public String getEncodedPassword(String key) 
	    { 
	 
	     byte[] uniqueKey = key.getBytes(); 
	     byte[] hash = null; 
	 
	     try 
		 { 
	        hash = MessageDigest.getInstance("SHA-1").digest(uniqueKey); //MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
	 
	     } 
	     catch (NoSuchAlgorithmException e) { 
	        throw new Error("no MD5 support in this VM"); 
	     }
	     catch (Exception e) {
	        e.printStackTrace();
	     }
	 
	     StringBuffer hashString = new StringBuffer(); 
	     for ( int i = 0; i < hash.length; ++i ) { 
	        String hex = Integer.toHexString(hash[i]); 
	        if ( hex.length() == 1 ) { 
	         hashString.append('0'); 
	         hashString.append(hex.charAt(hex.length()-1)); 
	        } else { 
	         hashString.append(hex.substring(hex.length()-2)); 
	        } 
	     } 
	     return hashString.toString(); 
	    }


}	

