package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controller.ControllerDBConfiguration;
import model.application;
import model.applicationArbre;
import model.applicationModelTableau;

public class panelParametreAppli extends JPanel implements ActionListener {

	JPanel ongletAppli = new JPanel();
	JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JButton btnNewAppli = new JButton("Ajouter");
	private JButton btnAjouterAppli = new JButton("Valider");
	private JTable tableAppli;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	public application appli = new application();
	private final JButton btnModifier = new JButton("Valider");
	private JTextField textFieldModifAppli;
	private JTextField textFieldAjoutAppli;
	private JCheckBox chckbxArchiverModif = new JCheckBox("");
	private JCheckBox chckbxArchiverAjt = new JCheckBox("");
	public JPanel panelAjouter = new JPanel();
	private final JButton btnAffModifierAppli = new JButton("Modifier");
	private int idAppliSelec;
	private JPanel panelModifierUtilisateur = new JPanel();
	private final JLabel lblActifModif = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjt = new JLabel("Archiv\u00E9e");
	private boolean ajout;
	
	public panelParametreAppli() {



		ongletAppli.setLayout(null);
		
		vectAppli = controller.ControllerDBConfiguration.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		tableAppli = new JTable(modelAppli);
		tableAppli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableAppli.getSelectedRow()!=-1){
					remplirApplication(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableAppli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAppli.setColumnSelectionAllowed(true);
		tableAppli.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableAppli.setForeground(Color.WHITE);
		tableAppli.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableAppli.setBackground(new Color(211, 211, 211));
		tableAppli.setBounds(10, 40, 130, 200);
		tableAppli.setAutoCreateRowSorter(true);
		tableAppli.getRowSorter().toggleSortOrder(0);
		tableAppli.setAutoCreateRowSorter(false);
		
		ongletAppli.setPreferredSize(new Dimension(300, 80));
		JScrollPane scrollPaneAppli = new JScrollPane(tableAppli);
		scrollPaneAppli.setVisible(true);
		scrollPaneAppli.setBounds(10, 40, 156, 219);
		ongletAppli.add(scrollPaneAppli);
		
		//pane.addTab("Applications", ongletAppli);
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelModifier);
		panelModifier.setLayout(null);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setBounds(72, 11, 55, 17);
		lblModifier.setForeground(SystemColor.inactiveCaption);
		lblModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifier.add(lblModifier);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.text);
		separator.setForeground(SystemColor.menu);
		separator.setBounds(40, 25, 118, 8);
		panelModifier.add(separator);
		
		textFieldModifAppli = new JTextField();
		textFieldModifAppli.setBounds(10, 63, 118, 20);
		panelModifier.add(textFieldModifAppli);
		textFieldModifAppli.setColumns(10);
		btnModifier.setBounds(56, 94, 89, 23);
		panelModifier.add(btnModifier);
		
		JLabel lblNomApplicationModif = new JLabel("Nom de l'application");
		lblNomApplicationModif.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationModif.setBounds(10, 44, 118, 14);
		panelModifier.add(lblNomApplicationModif);
		
		chckbxArchiverModif.setBounds(152, 60, 23, 23);
		panelModifier.add(chckbxArchiverModif);
		lblActifModif.setForeground(SystemColor.inactiveCaption);
		lblActifModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModif.setBounds(137, 44, 53, 14);
		
		panelModifier.add(lblActifModif);
		
		
		panelAjouter.setLayout(null);
		panelAjouter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouter.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelAjouter);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(75, 11, 55, 17);
		panelAjouter.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(43, 28, 118, 8);
		panelAjouter.add(separator_1);
		
		textFieldAjoutAppli = new JTextField();
		textFieldAjoutAppli.setBounds(10, 63, 118, 20);
		
		panelAjouter.add(textFieldAjoutAppli);
		textFieldAjoutAppli.setColumns(10);
		
		
		btnAjouterAppli.setBounds(58, 94, 89, 23);
		panelAjouter.add(btnAjouterAppli);
		
		chckbxArchiverAjt.setBounds(156, 63, 23, 23);
		panelAjouter.add(chckbxArchiverAjt);
		
		JLabel lblNomApplicationAjt = new JLabel("Nom de l'application");
		lblNomApplicationAjt.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjt.setBounds(10, 47, 118, 14);
		panelAjouter.add(lblNomApplicationAjt);
		lblActifAjt.setForeground(SystemColor.inactiveCaption);
		lblActifAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjt.setBounds(138, 47, 53, 14);
		
		panelAjouter.add(lblActifAjt);
		
		
		btnNewAppli.setBounds(31, 274, 89, 23);
		ongletAppli.add(btnNewAppli);
		btnAffModifierAppli.setBounds(31, 274, 89, 23);
		
		ongletAppli.add(btnAffModifierAppli);
		
		if(ajout == false){
			panelAjouter.setVisible(false);
			panelModifier.setVisible(true);
			btnAffModifierAppli.setVisible(false);
			btnNewAppli.setVisible(true);
		}
		else
		{
			panelAjouter.setVisible(true);
			panelModifier.setVisible(false);
			btnAffModifierAppli.setVisible(true);
			btnNewAppli.setVisible(false);
		}
		
		MyButtonListener list= new MyButtonListener();
		btnNewAppli.addActionListener(list);
		btnAjouterAppli.addActionListener(list);
		btnAffModifierAppli.addActionListener(list);
		btnModifier.addActionListener(list);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
if(source == btnNewAppli){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationAppliAjout(true);
				
			}
			
			if(source == btnAffModifierAppli){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationAppliModif(false);
				
			}
			
			if(source == btnModifier){
				
				if(textFieldModifAppli.getText()!= null && textFieldModifAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldModifAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverModif.isSelected()){
						appli.setVisibiliteApplication("Archivée");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.ControllerDBConfiguration.ModifApplication(appli);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationAppliModif(false);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldModifAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldModifAppli.requestFocus();
				}
			}
			
			if(source == btnAjouterAppli){
				if(textFieldAjoutAppli.getText()!= null && textFieldAjoutAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldAjoutAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverAjt.isSelected()){
						appli.setVisibiliteApplication("Archivée");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.addDataConfiguration.addApplication(appli);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationAppliModif(true);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldAjoutAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldAjoutAppli.requestFocus();
			
				}
				
			}
			
		}
}
		private void remplirApplication(String application){
			
			applicationArbre applicationArbre = ControllerDBConfiguration.getApplicationArbre(application);
			textFieldModifAppli.setText(applicationArbre.getNomApplication());
			
			if(applicationArbre.getVisibiliteApplication().equals("Archivée")){
				chckbxArchiverModif.setSelected(true);
				
			}
			else
			{

				chckbxArchiverModif.setSelected(false);
				
			}
			
			idAppliSelec=applicationArbre.getIdApplication();
			
		}
}