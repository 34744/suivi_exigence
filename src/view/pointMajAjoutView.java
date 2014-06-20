package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import model.exigenceFonctionnelle;
import model.fonctionnalite;
import model.fonctionnaliteModelTableau;
import model.miseAJourArbre;
import model.origine;
import model.origineArbre;
import model.pointMaj;
import model.pointMajArbre;
import model.priorite;













import com.toedter.calendar.JDateChooser;

import controller.ControllerDBConfiguration;
import controller.addDataExigenceFonctionnelle;
import controller.addDataPointMaj;
import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBFonctionnalite;
import controller.controllerDBMiseAJour;
import controller.controllerDBPointMaj;
import controller.controllerDBSousFonctionnalite;

public class pointMajAjoutView extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame frame; //initialisation
	private JTable table;
	private JTree tree;
	private Vector<pointMajArbre> vectPointMaj = new Vector <model.pointMajArbre>();
	private Vector<miseAJourArbre>vectMaj =new Vector<model.miseAJourArbre>();
	private Vector<origineArbre> vectOrigine = new Vector<model.origineArbre>();
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAnnuler = new JButton("Annuler");
	private JButton btnValider = new JButton("Valider");
	private JComboBox comboBoxOrigine = new JComboBox();
	int idSousFonctionnalite, idAppli, idFonctionnalite;
	String nomSousFonctionnalite, nomAppli, nomFonctionnalite;
	private pointMaj pointMaj = new pointMaj();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNomPoint;
	private JTextField textFieldOrigine;
	private JTextArea description = new JTextArea();
	private JTextArea raison = new JTextArea();
	private JTextArea solution;
	private JPanel panel = new JPanel();
	private JLabel lblOrigine = new JLabel("Origine");
	private JLabel lblNomPoint = new JLabel("Nom du point");
	private JLabel lblDescription = new JLabel("Description");
	private JLabel lblSolution = new JLabel("Solution");
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private int idMaj;
	/**
	 * Create the panel.
	 */
	public pointMajAjoutView(int idMAJ)  {
		 idMaj=idMAJ;

		setBackground(new Color(46,139,87));
		setLayout(null);
		buildTree(idMaj);
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 1, 794, 41);
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		/*frame.getContentPane().*/add(toolBar);
		

		btnHome.setIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		btnHome.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		toolBar.add(btnHome);
		btnSoftware.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		

		btnSoftware.setIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		toolBar.add(btnSoftware);
		btnUpdate.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		

		btnUpdate.setIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		toolBar.add(btnUpdate);
		btnRapports.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		

		btnRapports.setIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		toolBar.add(btnRapports);
		btnConfig.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		

		btnConfig.setIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		toolBar.add(btnConfig);
		
		JToggleButton tglbtnModifier = new JToggleButton("Modifier");
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		
		tglbtnModifier.setToolTipText("Modifier");
		
		if(tglbtnModifier.isSelected()==false)
		{
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		System.out.println("test");
		}
		
		else
		{
			tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiableG41.png")));
			
		}
		toolBar.add(tglbtnModifier);
		

		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(282, 45, 495, 463);
		add(panel);
		panel.setLayout(null);
		

		lblOrigine.setBounds(10, 58, 65, 26);
		lblOrigine.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblOrigine);
		
		
		lblNomPoint.setBounds(10, 21, 100, 26);
		lblNomPoint.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNomPoint);
		
		textFieldNomPoint = new JTextField();
		textFieldNomPoint.setBounds(120, 23, 347, 26);
		panel.add(textFieldNomPoint);
		textFieldNomPoint.setColumns(10);
		
		textFieldOrigine = new JTextField();
		textFieldOrigine.setBounds(246, 60, 221, 26);
		textFieldOrigine.setColumns(10);
		panel.add(textFieldOrigine);
		lblErreur.setBounds(10, 442, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);
		
		description = new JTextArea();
		description.setLineWrap(true);
		JScrollPane scrollPaneDesc = new JScrollPane(description);
		scrollPaneDesc.setBounds(10, 126, 442, 129);
		panel.add(scrollPaneDesc);
		

		comboBoxOrigine.setBounds(120, 60, 116, 26);
		remplirOrigine();
		panel.add(comboBoxOrigine);
		

		lblDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDescription.setBounds(10, 95, 100, 20);
		panel.add(lblDescription);

		lblSolution.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSolution.setBounds(10, 266, 100, 20);
		panel.add(lblSolution);
		
		solution = new JTextArea();
		solution.setLineWrap(true);
		
		JScrollPane scrollPaneRaison = new JScrollPane(solution);
		scrollPaneRaison.setBounds(10, 297, 442, 143);
		panel.add(scrollPaneRaison);

		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.setBounds(573, 516, 89, 31);
		add(btnValider);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(399, 516, 89, 31);
		add(btnAnnuler);
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnValider.addActionListener(list);
		btnAnnuler.addActionListener(list);
		
		buildTree(idMaj);

		
	}
	
	private void buildTree(int idMaj){
		int idMAJ=idMaj;
		int i=0;
		vectPointMaj = controllerDBPointMaj.getPointMajVecteurArbre(idMAJ);
		model.miseAJourArbre miseajour=controllerDBMiseAJour.getMiseAJourArbre(idMAJ);
		
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(miseajour.getNomApplication());
		DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(miseajour.getNumMAJ());

		if(vectPointMaj.size()>0){
		
			while (i<vectPointMaj.size()&& idMAJ==(vectPointMaj.elementAt(i).getFkMiseAJour()))
			{	
				DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(vectPointMaj.elementAt(i).getNomPoint());
				rep1.add(rep2);
				i++;
			}
		}
		racine.add(rep1);
		tree = new JTree(racine);
		tree.setBounds(5, 53, 200, 453);
		tree.enable(false);
		int row = 0; 
	    
		while (row < tree.getRowCount()) { 
	      tree.expandRow(row); 
	      row++; 
	    } 
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(5, 53, 250, 453);
		this.add(JSP);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(node.isLeaf()){

			}
		}});
	
	}
	private class MyButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			
			if(source == btnHome){
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.accueil();
			}
			if (source == btnSoftware){
				System.out.println("appli");
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.fonctionnalite();
			}
			
			if (source == btnRapports){
				System.out.println("appli");
				controller.gestionFenetreRapport.eraseContainerPaneMainJFrame();
				controller.gestionFenetreRapport.configRapport("choix");
			}
			
			if(source == btnConfig){
				System.out.println("config test");
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.configurationAppliModif(false, 0);

			}
			if(source==btnUpdate){
				controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
				controller.gestionFenetreMAJ.miseAJour();;
			}
			
			if(source== btnAnnuler){
				controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
				controller.gestionFenetreMAJ.majModif(idMaj);
			
			}
			
		if(source == btnValider){
				if(textFieldNomPoint.getText()!=null && textFieldNomPoint.getText().length()>0){
					pointMaj.setNomPoint(textFieldNomPoint.getText());
					pointMaj.setNomPoint(pointMaj.getNomPoint().replaceAll("'", "''"));
					if(description.getText()!= null && description.getText().length()>0 ){
						
						pointMaj.setDescriptionPoint(description.getText());	
						pointMaj.setDescriptionPoint(pointMaj.getDescriptionPoint().replaceAll("'", "''"));
							if(comboBoxOrigine.getSelectedIndex()!=0){
								origineArbre origineArbre= controllerDBPointMaj.getOrigineArbre(comboBoxOrigine.getSelectedItem().toString());
								pointMaj.setFkOrigine(origineArbre.getIdOrigine());	
								pointMaj.setFkMiseAJour(idMaj);
								pointMaj.setSolutionPoint(solution.getText());
								pointMaj.setSolutionPoint(pointMaj.getSolutionPoint().replaceAll("'","''"));
								pointMaj.setOriginePrecision(textFieldOrigine.getText());
								pointMaj.setTestFinalise(0);		
											addDataPointMaj.addNewPoint(pointMaj);
											controller.gestionFenetreMAJ.eraseContainerPaneMainJFrame();
											controller.gestionFenetreMAJ.majModif(idMaj);
										}
										else
										{
											lblErreur.setVisible(true);
											comboBoxOrigine.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
											comboBoxOrigine.requestFocus();
										}
									}
									else
									{
										lblErreur.setVisible(true);
										description.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
										description.requestFocus();
									}								
									}
							else
							{
								lblErreur.setVisible(true);
								textFieldNomPoint.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								textFieldNomPoint.requestFocus();
							}								
						}
	}
		
}
	@SuppressWarnings("unchecked")
	private void remplirOrigine(){
		comboBoxOrigine.removeAllItems();
		vectOrigine = controllerDBPointMaj.getOrigineVecteurArbre();
		comboBoxOrigine.addItem("--Sélectionnez Direction--");
		for(int i=0; i<vectOrigine.size();i++){
			comboBoxOrigine.addItem(vectOrigine.elementAt(i).getNomOrigine());
		}
		
	}
}


