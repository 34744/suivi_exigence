package view;
import javax.swing.*;
import javax.swing.plaf.multi.MultiButtonUI;
import controller.ControllerDB;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
public class Connection extends JDialog {        
	// VARIABLES        
	private JLabel labID, labPass;        
	JTextField textID;        
	private JPasswordField pass;        
	private JButton butOK, btnAnnuler;        
	private JPanel pan;        
	private utilisateur user = new utilisateur();        
	// CONSTRUCTEUR        
	public Connection() {                                
		controller.ControllerDB.connectionDB();                                
		this.setTitle("Fenêtre de connection");                
		this.setModal(true);                
		this.setResizable(false);                
		this.setBounds(0, 0, 350, 200);                
		this.setLocationRelativeTo(null);                
		pan = new JPanel();                
		pan.setBounds(350, 200, 150, 150);                
		pan.setLayout(null);                
		
		labID = new JLabel("Identifiant: ");                
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
		this.setVisible(true);        
		}        
	
	private class MyButtonListener implements ActionListener {               
		public void actionPerformed(ActionEvent e) {                        
			Object source = e.getSource();                        
			if (source == butOK) {                                
				if (verifConnection() == true){                                        
					new view.MainJFrame();                                        
					hide();                                       
					//dispose();
					}
				}
			if (source == btnAnnuler) {
				clotApplication();
				}
			}
		}
	private boolean verifConnection(){
		if (textID.getText() != null && pass.getText() != null){
			String nom = textID.getText();
			user = ControllerDB.getUser(nom);
			if (user.getNomUser() != null){
				if (user.getMdpUser().equals(pass.getText())){
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
			controller.ControllerDB.fermetureDB();
		System.exit(0);
		}
	 
	}		
		
	
	

