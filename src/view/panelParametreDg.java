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
import model.applicationModelTableau;
import model.directionGenerale;
import model.directionGeneraleArbre;
import model.directionGeneraleModelTableau;

public class panelParametreDg extends JPanel implements ActionListener{
	JPanel ongletDG = new JPanel();
	JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JButton btnNewDG = new JButton("Ajouter");
	private JButton btnAjouterDG = new JButton("Valider");
	private JTable tableDG;
	private Vector<model.directionGeneraleArbre> vectDg = new Vector<model.directionGeneraleArbre>();
	private directionGeneraleModelTableau modelDG;
	public directionGenerale directionGenerale = new directionGenerale();
	private final JButton btnModifierDG = new JButton("Valider");
	private JTextField textFieldModifDG;
	private JTextField textFieldAjoutDG;
	private JCheckBox chckbxArchiverModifDG = new JCheckBox("");
	private JCheckBox chckbxArchiverAjtDG = new JCheckBox("");
	public JPanel panelAjouterDG = new JPanel();
	private final JButton btnAffModifierDG = new JButton("Modifier");
	private int idDGSelec;
	private final JLabel lblActifModifDG = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjtDG = new JLabel("Archiv\u00E9e");
	private boolean ajout;
	
	public panelParametreDg() {

		ongletDG.setLayout(null);
		ongletDG.setVisible(true);
		vectDg = controller.ControllerDBConfiguration.getDirectionGeneraleArbre();
		modelDG = new directionGeneraleModelTableau(vectDg);
		tableDG = new JTable(modelDG);
		tableDG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableDG.getSelectedRow()!=-1){
					remplirDG(tableDG.getValueAt(tableDG.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableDG.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDG.setColumnSelectionAllowed(true);
		tableDG.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableDG.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableDG.setForeground(Color.WHITE);
		tableDG.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableDG.setBackground(new Color(211, 211, 211));
		tableDG.setBounds(10, 40, 130, 200);
		tableDG.setAutoCreateRowSorter(true);
		tableDG.getRowSorter().toggleSortOrder(0);
		tableDG.setAutoCreateRowSorter(false);
		
		ongletDG.setPreferredSize(new Dimension(599, 400));
		JScrollPane scrollPaneDG = new JScrollPane(tableDG);
		scrollPaneDG.setVisible(true);
		scrollPaneDG.setBounds(10, 40, 185, 219);
		ongletDG.add(scrollPaneDG);
		
		//pane.addTab("Applications", ongletAppli);
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(302, 83, 200, 128);
		ongletDG.add(panelModifier);
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
		
		textFieldModifDG = new JTextField();
		textFieldModifDG.setBounds(10, 63, 118, 20);
		panelModifier.add(textFieldModifDG);
		textFieldModifDG.setColumns(10);
		btnModifierDG.setBounds(56, 94, 89, 23);
		panelModifier.add(btnModifierDG);
		
		JLabel lblNomApplicationModif = new JLabel("Nom de la DG");
		lblNomApplicationModif.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationModif.setBounds(10, 44, 89, 14);
		panelModifier.add(lblNomApplicationModif);
		
		chckbxArchiverModifDG.setBounds(152, 60, 23, 23);
		panelModifier.add(chckbxArchiverModifDG);
		lblActifModifDG.setForeground(SystemColor.inactiveCaption);
		lblActifModifDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModifDG.setBounds(137, 44, 53, 14);
		
		panelModifier.add(lblActifModifDG);
		
		
		panelAjouterDG.setLayout(null);
		panelAjouterDG.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouterDG.setBounds(302, 83, 200, 128);
		ongletDG.add(panelAjouterDG);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(75, 11, 55, 17);
		panelAjouterDG.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(43, 28, 118, 8);
		panelAjouterDG.add(separator_1);
		
		textFieldAjoutDG = new JTextField();
		textFieldAjoutDG.setBounds(10, 63, 118, 20);
		
		panelAjouterDG.add(textFieldAjoutDG);
		textFieldAjoutDG.setColumns(10);
		
		
		btnAjouterDG.setBounds(58, 94, 89, 23);
		panelAjouterDG.add(btnAjouterDG);
		
		chckbxArchiverAjtDG.setBounds(156, 63, 23, 23);
		panelAjouterDG.add(chckbxArchiverAjtDG);
		
		JLabel lblNomApplicationAjt = new JLabel("Nom de l'application");
		lblNomApplicationAjt.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjt.setBounds(10, 47, 118, 14);
		panelAjouterDG.add(lblNomApplicationAjt);
		lblActifAjtDG.setForeground(SystemColor.inactiveCaption);
		lblActifAjtDG.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjtDG.setBounds(138, 47, 53, 14);
		
		panelAjouterDG.add(lblActifAjtDG);
		
		
		btnNewDG.setBounds(31, 274, 89, 23);
		ongletDG.add(btnNewDG);
		btnAffModifierDG.setBounds(31, 274, 89, 23);
		
		ongletDG.add(btnAffModifierDG);
		
		if(ajout == false){
			panelAjouterDG.setVisible(false);
			panelModifier.setVisible(true);
			btnAffModifierDG.setVisible(false);
			btnNewDG.setVisible(true);
		}
		else
		{
			panelAjouterDG.setVisible(true);
			panelModifier.setVisible(false);
			btnAffModifierDG.setVisible(true);
			btnNewDG.setVisible(false);
		}
		
		MyButtonListener list= new MyButtonListener();
		btnNewDG.addActionListener(list);
		btnAjouterDG.addActionListener(list);
		btnAffModifierDG.addActionListener(list);
		btnModifierDG.addActionListener(list);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			if(source == btnNewDG){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDGAjout(true);
				
			}
			
			if(source == btnAffModifierDG){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDGModif(false);
				
			}
			
			if(source == btnModifierDG){
				
				if(textFieldModifDG.getText()!= null && textFieldModifDG.getText().length()>0 ){
					directionGenerale.setNomDirection(textFieldModifDG.getText());
					directionGenerale.setIdDirection(idDGSelec);
					
					if(chckbxArchiverModifDG.isSelected()){
						directionGenerale.setVisibiliteDG("Archivée");
					}
					else
					{
						directionGenerale.setVisibiliteDG("");
					}					
					controller.ControllerDBConfiguration.ModifDg(directionGenerale);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationDGModif(false);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldModifDG.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldModifDG.requestFocus();
				}
			}
			
			if(source == btnAjouterDG){
				if(textFieldAjoutDG.getText()!= null && textFieldAjoutDG.getText().length()>0 ){
					directionGenerale.setNomDirectionGenerale(textFieldAjoutDG.getText());
					directionGenerale.setIdDirectionGenerale(idDGSelec);
					
					if(chckbxArchiverAjtDG.isSelected()){
						directionGenerale.setVisibiliteDG("Archivée");
					}
					else
					{
						directionGenerale.setVisibiliteDG("");
					}					
					controller.addDataConfiguration.addDirectionGenerale(directionGenerale);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationDGModif(true);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldAjoutDG.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldAjoutDG.requestFocus();
			
				}
				
			}
			
		}
}
		private void remplirDG(String directionGenerale	){
			
			directionGeneraleArbre directionGeneraleArbre = ControllerDBConfiguration.getDirectionGeneraleArbre(directionGenerale);
			textFieldModifDG.setText(directionGeneraleArbre.getNomDirectionGenerale());
			
			if(directionGeneraleArbre.getVisibiliteDg().equals("Archivée")){
				chckbxArchiverModifDG.setSelected(true);
				
			}
			else
			{

				chckbxArchiverModifDG.setSelected(false);
				
			}
			
			idDGSelec=directionGeneraleArbre.getIdDirectionGenerale();
			
		}
}


