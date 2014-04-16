package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import controller.ControllerDBConfiguration;
import controller.addDataConfiguration;
import model.cellule;
import model.celluleArbre;
import model.compoCelluleArbre;
import model.utilisateur;
import model.utilisateurArbre;

public class compoCelluleJFrame extends JFrame implements ActionListener{
	
	private JFrame frame = new JFrame();
	private JPanel contentPane;
	private JComboBox comboBoxCellule;
	private JTextField textField;
	private JButton btnValider = new JButton("Valider");
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	private utilisateur user=new utilisateur();
	private model.compoCellule compoCellule = new model.compoCellule();
	private JTable table;
	private int numRow;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//private Vector<model.celluleArbre> vectCelluleArbre = new Vector<model.celluleArbre>();
	
	
	private String numUlis;
		
	
	public compoCelluleJFrame(String numUlis, JTable table, int numRow) {
		this.numUlis=numUlis;
		this.table=table;
		this.numRow=numRow;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 122);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//frame.add(contentPane);
		comboBoxCellule = new JComboBox();
		comboBoxCellule.setBounds(10, 11, 130, 20);
		contentPane.add(comboBoxCellule);
		
		
		utilisateurArbre utilisateurArbre=ControllerDBConfiguration.getUtilisateurArbre(numUlis);
		int idUtilisateur=utilisateurArbre.getIdUtilisateur();
		
		Vector<model.cellule> vectCellule = new Vector<model.cellule>();
		vectCellule = controller.ControllerDBConfiguration.getCelluleNonUtilisee(idUtilisateur);
		//vectCellule = controller.ControllerDB.getCellule();
		comboBoxCellule.addItem("--Sélectionnez Direction--");
		for(int i=0; i<vectCellule.size();i++){
			comboBoxCellule.addItem(vectCellule.elementAt(i).getNomCellule());
			System.out.println(vectCellule.elementAt(i).getNomCellule());
		}
		

		btnValider.setBounds(160, 54, 89, 23);
		contentPane.add(btnValider);
		
		calendrierDebut.setBounds(150, 11, 110, 20);
		calendrierDebut.setDateFormatString("dd/MM/yyyy");
		getContentPane().add(calendrierDebut);
		
		Date d1=new Date();
		calendrierDebut.setDate(d1);
		
		calendrierFin.setBounds(280, 11, 110, 20);
		calendrierFin.setDateFormatString("dd/MM/yyyy");
		getContentPane().add(calendrierFin);
		
		Date d2=new Date();
		calendrierDebut.setDate(d2);
		
		MyButtonListener list = new MyButtonListener();
		btnValider.addActionListener(list);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void conversion(){
		
	}
	
	private class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			
			if(source == btnValider){
				String nomCellule = comboBoxCellule.getSelectedItem().toString();
				cellule celluleArbre = ControllerDBConfiguration.getCelluleSele(nomCellule);
				utilisateurArbre utilisateurArbre=ControllerDBConfiguration.getUtilisateurArbre(numUlis);
				int idCellule= celluleArbre.getIdCellule();
				int idUtilisateur=utilisateurArbre.getIdUtilisateur();
				Date debut=calendrierDebut.getDate();
				String dateDebut = dateFormat.format(debut);
				
				
				
				Date fin=calendrierFin.getDate();
				String dateFin="";
				if(fin!= null){
				dateFin = dateFormat.format(fin);
				}
				
				
				
				compoCellule.setFkCellule(idCellule);
				compoCellule.setFkUtilisateur(idUtilisateur);
				compoCellule.setDateDebutCellule(dateDebut);
				if(calendrierFin.getDate()!=null){
				compoCellule.setDateFinCellule(dateFin);
				}
				else{
					compoCellule.setDateFinCellule("20991231");
				}
				controller.addDataConfiguration.addCompoCellule(compoCellule);
				mainJFrame.eraseContainerPanel();
				controller.gestionFenetreConfiguration.configurationUtilisateur(true, numRow);
				hide();
				
				
			}
		}
		
	}
	
}
