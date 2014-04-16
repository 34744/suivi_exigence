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

import view.panelParametreDg.MyButtonListener;
import controller.ControllerDBConfiguration;
import model.directionArbre;
import model.directionGenerale;
import model.directionGeneraleArbre;
import model.directionGeneraleModelTableau;
import model.directionModelTableau;
import javax.swing.JComboBox;

public class panelParametreDirection extends JPanel {

	JPanel ongletDirection = new JPanel();
	
	private JButton btnNewDirection = new JButton("Ajouter");
	private JButton btnAjouterDirection = new JButton("Valider");
	private JTable tableDirection;
	private Vector<model.directionArbre> vectDirectionArbre = new Vector<model.directionArbre>();
	private directionModelTableau modelDirection;
	public model.direction direction = new model.direction();
	private final JButton btnModifierDirection = new JButton("Valider");
	private JTextField textFieldModifDirection;
	private JTextField textFieldAjoutDirection;
	private JComboBox comboBoxDirectionGeneraleDirectionModif = new JComboBox();
	private JComboBox comboBoxDirectionGeneraleDirectionAjout = new JComboBox();
	private JCheckBox chckbxArchiverModifDirection = new JCheckBox("");
	private JCheckBox chckbxArchiverAjtDirection = new JCheckBox("");
	public JPanel panelAjouterDirection = new JPanel();
	private final JButton btnAffModifierDirection = new JButton("Modifier");
	private int idDirectionSelec;
	private final JLabel lblActifModifDirection = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjtDirection = new JLabel("Archiv\u00E9e");
	private boolean ajout;
	private JScrollPane scrollPaneDirection = new JScrollPane();
	
	public panelParametreDirection() {

		ongletDirection.setLayout(null);
		ongletDirection.setVisible(true);
		vectDirectionArbre = controller.ControllerDBConfiguration.getDirectionUtilisateurArbre();
		modelDirection = new directionModelTableau(vectDirectionArbre);
		tableDirection = new JTable(modelDirection);
		tableDirection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableDirection.getSelectedRow()!=-1){
					remplirDirection(tableDirection.getValueAt(tableDirection.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableDirection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDirection.setColumnSelectionAllowed(true);
		tableDirection.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableDirection.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableDirection.setForeground(Color.WHITE);
		tableDirection.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableDirection.setBackground(new Color(211, 211, 211));
		tableDirection.setBounds(10, 40, 130, 200);
		tableDirection.setAutoCreateRowSorter(true);
		tableDirection.getRowSorter().toggleSortOrder(0);
		tableDirection.setAutoCreateRowSorter(false);
		
		ongletDirection.setPreferredSize(new Dimension(599, 400));
		scrollPaneDirection.add(tableDirection);
		scrollPaneDirection.setVisible(true);
		scrollPaneDirection.setBounds(10, 40, 185, 219);
		ongletDirection.add(scrollPaneDirection);
		
		//pane.addTab("Applications", ongletAppli);
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(302, 83, 242, 176);
		ongletDirection.add(panelModifier);
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
		
		textFieldModifDirection = new JTextField();
		textFieldModifDirection.setBounds(10, 63, 118, 20);
		panelModifier.add(textFieldModifDirection);
		textFieldModifDirection.setColumns(10);
		btnModifierDirection.setBounds(86, 129, 89, 23);
		panelModifier.add(btnModifierDirection);
		
		JLabel lblNomDirectionModif = new JLabel("Nom de la Direction");
		lblNomDirectionModif.setForeground(SystemColor.inactiveCaption);
		lblNomDirectionModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomDirectionModif.setBounds(10, 44, 117, 14);
		panelModifier.add(lblNomDirectionModif);
		
		chckbxArchiverModifDirection.setBounds(152, 60, 23, 23);
		panelModifier.add(chckbxArchiverModifDirection);
		lblActifModifDirection.setForeground(SystemColor.inactiveCaption);
		lblActifModifDirection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModifDirection.setBounds(137, 44, 53, 14);
		
		panelModifier.add(lblActifModifDirection);
		

		comboBoxDirectionGeneraleDirectionModif.setBounds(10, 98, 117, 20);
		panelModifier.add(comboBoxDirectionGeneraleDirectionModif);
		
		
		btnNewDirection.setBounds(31, 274, 89, 23);
		ongletDirection.add(btnNewDirection);
		btnAffModifierDirection.setBounds(31, 274, 89, 23);
		
		ongletDirection.add(btnAffModifierDirection);
		panelAjouterDirection.setBounds(302, 83, 242, 176);
		ongletDirection.add(panelAjouterDirection);
		
		
		panelAjouterDirection.setLayout(null);
		panelAjouterDirection.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(75, 11, 55, 17);
		panelAjouterDirection.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(43, 28, 118, 8);
		panelAjouterDirection.add(separator_1);
		
		textFieldAjoutDirection = new JTextField();
		textFieldAjoutDirection.setBounds(10, 63, 118, 20);
		
		panelAjouterDirection.add(textFieldAjoutDirection);
		textFieldAjoutDirection.setColumns(10);
		
		
		btnAjouterDirection.setBounds(88, 125, 89, 23);
		panelAjouterDirection.add(btnAjouterDirection);
		
		chckbxArchiverAjtDirection.setBounds(156, 63, 23, 23);
		panelAjouterDirection.add(chckbxArchiverAjtDirection);
		
		JLabel lblNomApplicationAjt = new JLabel("Nom de la Direction");
		lblNomApplicationAjt.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjt.setBounds(10, 47, 118, 14);
		panelAjouterDirection.add(lblNomApplicationAjt);
		lblActifAjtDirection.setForeground(SystemColor.inactiveCaption);
		lblActifAjtDirection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjtDirection.setBounds(138, 47, 53, 14);
		
		panelAjouterDirection.add(lblActifAjtDirection);
		

		comboBoxDirectionGeneraleDirectionAjout.setBounds(11, 94, 117, 20);
		panelAjouterDirection.add(comboBoxDirectionGeneraleDirectionAjout);

		
		if(ajout == false){
			panelAjouterDirection.setVisible(false);
			panelModifier.setVisible(true);
			btnAffModifierDirection.setVisible(false);
			btnNewDirection.setVisible(true);
		}
		else
		{
			panelAjouterDirection.setVisible(true);
			panelModifier.setVisible(false);
			btnAffModifierDirection.setVisible(true);
			btnNewDirection.setVisible(false);
		}
		
		MyButtonListener list= new MyButtonListener();
		btnNewDirection.addActionListener(list);
		btnAffModifierDirection.addActionListener(list);
		btnModifierDirection.addActionListener(list);
		btnAjouterDirection.addActionListener(list);
		comboBoxDirectionGeneraleDirectionAjout.addActionListener(list);
		comboBoxDirectionGeneraleDirectionModif.addActionListener(list);
		
		remplirDirectionAjoutDirection();
	}
	
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			if(source == btnNewDirection){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDirectionAjout(true,3);
				
			}
			
			if(source == btnAffModifierDirection){
				
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationDirectionModif(false,3);
				
			}
			
			if(source == btnModifierDirection){
				
				if(textFieldModifDirection.getText()!= null && textFieldModifDirection.getText().length()>0 ){
					direction.setNomDirection(textFieldModifDirection.getText());
					direction.setIdDirection(idDirectionSelec);
					
					if(chckbxArchiverModifDirection.isSelected()){
						direction.setVisibiliteDirection("Archivée");
					}
					else
					{
						direction.setVisibiliteDirection("");
					}					
					controller.ControllerDBConfiguration.ModifDirection(direction);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationDirectionModif(false,3);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldModifDirection.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldModifDirection.requestFocus();
				}
			}
			
			if(source == btnAjouterDirection){
				if(textFieldAjoutDirection.getText()!= null && textFieldAjoutDirection.getText().length()>0 ){
					direction.setNomDirection(textFieldAjoutDirection.getText());
					direction.setIdDirection(idDirectionSelec);
					
					if(chckbxArchiverAjtDirection.isSelected()){
						direction.setVisibiliteDirection("Archivée");
					}
					else
					{
						direction.setVisibiliteDirection("");
					}					
					controller.addDataConfiguration.addDirection(direction);
					controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
					controller.gestionFenetreConfiguration.configurationDirectionModif(true,3);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldAjoutDirection.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldAjoutDirection.requestFocus();
			
				}
				
			}
			
		}
}
		private void remplirDirection(String direction	){
			
			directionArbre directionArbre = ControllerDBConfiguration.getDirectionUtilisateurArbre(direction);
			textFieldModifDirection.setText(directionArbre.getNomDirection());
			
			if(directionArbre.getVisibiliteDirection().equals("Archivée")){
				chckbxArchiverModifDirection.setSelected(true);
				
			}
			else
			{

				chckbxArchiverModifDirection.setSelected(false);
				
			}
			
			idDirectionSelec=directionArbre.getIdDirection();
			
		}
		
	private void remplirDirectionAjoutDirection(){
		comboBoxDirectionGeneraleDirectionAjout.removeAllItems();
		vectDirectionArbre = ControllerDBConfiguration.getDirectionUtilisateurArbre();
		comboBoxDirectionGeneraleDirectionAjout.addItem("--Sélectionnez Direction--");
		for(int i=0; i<this.vectDirectionArbre.size();i++){
			comboBoxDirectionGeneraleDirectionAjout.addItem(vectDirectionArbre.elementAt(i).getNomDirection());
		}
	}	
}
