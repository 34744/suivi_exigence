package view;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import model.fonctionnalite;
import model.fonctionnaliteModelTableau;
import model.majDataCritereSucces;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.ControllerDBCritereSucces;
import controller.addDataCritereSucces;
import controller.addDataFonctionnalite;
import controller.addDataSousFonctionnalite;
import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBFonctionnalite;
import controller.controllerDBSousFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import view.Parametres.MyButtonListener;

import javax.swing.JPanel;

public class critereSuccesView extends JPanel implements ActionListener {
	private JFrame frame;
	private JTable table;
	private JTree tree;
	private Vector<model.critereSuccesArbre> vectCritereSucces = new Vector<model.critereSuccesArbre>();
	private Vector<model.exigenceFonctionnelleArbre> vectExigenceFonctionnelle = new Vector<model.exigenceFonctionnelleArbre>();
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private Vector<model.sousFonctionnaliteArbre> vectSFonctionnalite = new Vector<model.sousFonctionnaliteArbre>();
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAnnuler = new JButton("Annuler");
	private JButton btnValider = new JButton("Valider");
	int idFonctionnalite, codeExigence, codeCritere, idRecordCritere;
	String nomAppli, nomCritere;
	private fonctionnalite fonctionnalite = new fonctionnalite();
	private model.sousFonctionnalite sousFonctionnalite = new model.sousFonctionnalite();
	private model.critereSucces critereSucces = new model.critereSucces();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumCritere;
	private JTextArea textAreaNomCritere;
	private JButton btnCritereSuccesAjouter = new JButton("");
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final JButton btnCreer = new JButton("Cr\u00E9er");
	/**
	 * Create the panel.
	 */
	public critereSuccesView(int idFonctionnalite, String nomAppli, int codeExigence, String nomCSpassee) {
		this.idFonctionnalite=idFonctionnalite;
		this.nomAppli=nomAppli;
		this.codeExigence=codeExigence;
		this.nomCritere=nomCSpassee;
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		buildTree();
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(269, 117, 480, 340);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNomFonctionnalite = new JLabel("Nom du crit\u00E8re");
		lblNomFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomFonctionnalite.setBounds(10, 58, 132, 26);
		panel.add(lblNomFonctionnalite);
		
		JLabel lblNumCritere = new JLabel("Num\u00E9ro du crit\u00E8re");
		lblNumCritere.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumCritere.setBounds(10, 21, 233, 26);
		panel.add(lblNumCritere);
		
		JLabel lblDateDebut = new JLabel("Date Debut");
		lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateDebut.setBounds(10, 278, 85, 26);
		panel.add(lblDateDebut);
		
		textFieldNumCritere = new JTextField();
		textFieldNumCritere.setBounds(150, 23, 52, 26);
		panel.add(textFieldNumCritere);
		textFieldNumCritere.setColumns(10);
		
		textAreaNomCritere = new JTextArea();
		textAreaNomCritere.setLineWrap(true);
		textAreaNomCritere.setColumns(10);
		textAreaNomCritere.setBounds(140, 60, 331, 65);
		panel.add(textAreaNomCritere);
		
		JScrollPane scrollPaneDesc = new JScrollPane(textAreaNomCritere);
		scrollPaneDesc.setBounds(140, 60, 331, 164);
		panel.add(scrollPaneDesc);

		calendrierDebut.setBounds(108, 278, 110, 26);
		calendrierDebut.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierDebut);

		calendrierFin.setBounds(316, 278, 110, 26);
		calendrierFin.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierFin);
		
		JLabel lblDateFin = new JLabel("Date Fin");
		lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFin.setBounds(241, 278, 65, 26);
		panel.add(lblDateFin);		
		lblErreur.setBounds(10, 315, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);

		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.setBounds(572, 512, 89, 31);
		add(btnValider);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(399, 512, 89, 31);
		add(btnAnnuler);
		
		btnCritereSuccesAjouter.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
		btnCritereSuccesAjouter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCritereSuccesAjouter.setBounds(759, 232, 22, 23);
		add(btnCritereSuccesAjouter);
		
		btnCreer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreer.setBounds(572, 512, 89, 31);
		btnCreer.setVisible(false);
		add(btnCreer);
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnValider.addActionListener(list);
		btnAnnuler.addActionListener(list);
		btnCritereSuccesAjouter.addActionListener(list);
		btnCreer.addActionListener(list);
		remplirCritereSucces(nomCritere);
	}
	
	private void buildTree(){
		
		vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
		vectSFonctionnalite = controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
		vectAppli=ControllerDBConfiguration.getApplicationArbre();
		vectExigenceFonctionnelle=controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre(codeExigence);
		vectCritereSucces = ControllerDBCritereSucces.getCritereSuccesVecteurArbre(codeExigence);
		System.out.println(vectCritereSucces.size());
		String fonctionnalite, sFonctionnalite, exiFonct;
		int i=0;

		if(vectCritereSucces.size()>0){
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectCritereSucces.elementAt(i).getNomAppli()); 
		
			while (i<vectCritereSucces.size())
			{
				fonctionnalite=vectCritereSucces.elementAt(i).getNomFonct();
				DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectCritereSucces.elementAt(i).getNomFonct());
				
				while(i<vectCritereSucces.size()&&fonctionnalite.equals(vectCritereSucces.elementAt(i).getNomFonct()))
				{
					sFonctionnalite=vectCritereSucces.elementAt(i).getNomSFonct();
					DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(vectCritereSucces.elementAt(i).getNomSFonct());
						System.out.println(sFonctionnalite);
						while(i<vectCritereSucces.size()&& sFonctionnalite.equals(vectCritereSucces.elementAt(i).getNomSFonct())
																&& fonctionnalite.equals(vectCritereSucces.elementAt(i).getNomFonct()))
						{
							exiFonct=vectCritereSucces.elementAt(i).getNomExigence();
							DefaultMutableTreeNode rep3 = new DefaultMutableTreeNode(vectCritereSucces.elementAt(i).getNomExigence());
							while(i<vectCritereSucces.size()&& exiFonct.equals(vectCritereSucces.elementAt(i).getNomExigence())
																&& sFonctionnalite.equals(vectCritereSucces.elementAt(i).getNomSFonct())
																&& fonctionnalite.equals(vectCritereSucces.elementAt(i).getNomFonct()))
							{
								//exiFonct=vectCritereSucces.elementAt(i).getNomExigence();
								DefaultMutableTreeNode rep4 = new DefaultMutableTreeNode(vectCritereSucces.elementAt(i).getNumCritere()+"."+vectCritereSucces.elementAt(i).getNomCritere());
  
								i++;
								rep3.add(rep4);
}
							
							i++;
							rep2.add(rep3);
						}
				i++;
				rep1.add(rep2);
				}
				i++;
				racine.add(rep1);
			}
			tree = new JTree(racine);
			tree.setBounds(21, 53, 250, 495);	
			  int row = 0; 
			    while (row < tree.getRowCount()) { 
			      tree.expandRow(row); 
			      row++; 
			    } 
		
		tree.setBounds(11, 50, 250, 433);	
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(11, 50, 250, 433);
		this.add(JSP);
	
		}
		else{
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
			
		
		JTree tree = new JTree(racine);
		tree.setBounds(11, 50, 250, 433);	
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(11, 50, 250, 433);
		this.add(JSP);
	
		}
	
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent event) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				if(node.isLeaf()){
				remplirCritereSucces(tree.getLastSelectedPathComponent().toString());
				}
			}

					});
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
			
			if(source== btnAnnuler){
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreFonctionnalite.fonctionnalite();
				
			}
			
			if(source==btnCritereSuccesAjouter){
				textFieldNumCritere.setText("");
				textAreaNomCritere.setText("");
				calendrierDebut.setDate(null);
				calendrierFin.setDate(null);
				btnCreer.setVisible(true);
				btnValider.setVisible(false);
			}
			
			if(source==btnCreer){
				if(textFieldNumCritere.getText()!=null && textFieldNumCritere.getText().length()>0){
					critereSucces.setNumCritere(textFieldNumCritere.getText());
					
					if(textAreaNomCritere.getText()!= null && textAreaNomCritere.getText().length()>0 ){
						critereSucces.setNomCritere(textAreaNomCritere.getText());
						critereSucces.setFkExigence(codeExigence);
					
							if(calendrierDebut.getDate()!=null){
								Date debut=calendrierDebut.getDate();
								String dateDebut = dateFormat.format(debut);
								critereSucces.setDateDebutCritere(dateDebut);
								critereSucces.setDateDebutCSRecord(dateDebut);
					
								Date fin=calendrierFin.getDate();
								String dateFin="";
									if(calendrierFin.getDate()!=null){
										dateFin=dateFormat.format(fin);
										critereSucces.setDateFinCritere(dateFin);
										critereSucces.setDateFinCSRecord(dateFin);
									}
									else{
										critereSucces.setDateFinCritere("20991231");
										critereSucces.setDateFinCSRecord("2099-12-31");
									}
									
									
									controller.addDataCritereSucces.addNewCritereSucces(critereSucces);
									model.recupererIdCritereSucces.recupererIdCritereSucces(critereSucces);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreCritereSucces.modifCritereSucces(idFonctionnalite, nomAppli, codeExigence, critereSucces.getNomCritere().toString());
									
									
									/*addDataCritereSucces.addNewCritereSucces(critereSucces);
									model.recupererIdSousFonctionnalite.recupererIdSF(sousFonctionnalite);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(sousFonctionnalite.getFkFonct(), sousFonctionnalite.getCodeSFonct(), sousFonctionnalite.getNomSFonct());*/	
							}
							else
							{
								lblErreur.setVisible(true);
								calendrierDebut.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								calendrierDebut.requestFocus();
							}
						}
						
					else
					{
						lblErreur.setVisible(true);
						textAreaNomCritere.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textAreaNomCritere.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumCritere.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumCritere.requestFocus();					
				}
			}
						
		
			
			if(source == btnValider){
				if(textFieldNumCritere.getText()!=null && textFieldNumCritere.getText().length()>0){
					critereSucces.setNumCritere(textFieldNumCritere.getText());
					
					if(textAreaNomCritere.getText()!= null && textAreaNomCritere.getText().length()>0 ){
						critereSucces.setNomCritere(textAreaNomCritere.getText());
						critereSucces.setFkExigence(codeExigence);
						critereSucces.setCodeCritere(codeCritere);
						critereSucces.setIdCritere(idRecordCritere);
					
							if(calendrierDebut.getDate()!=null){
								Date debut=calendrierDebut.getDate();
								String dateDebut = dateFormat.format(debut);
								critereSucces.setDateDebutCritere(dateDebut);
								critereSucces.setDateDebutCSRecord(dateDebut);
					
								Date fin=calendrierFin.getDate();
								String dateFin="";
									if(calendrierFin.getDate()!=null){
										dateFin=dateFormat.format(fin);
										critereSucces.setDateFinCritere(dateFin);
										critereSucces.setDateFinCSRecord(dateFin);
									}
									else{
										critereSucces.setDateFinCritere("20991231");
										critereSucces.setDateFinCSRecord("2099-12-31");
									}
									
									majDataCritereSucces.majCritere(critereSucces);
									controller.addDataCritereSucces.addNewCritereSucces(critereSucces);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreCritereSucces.modifCritereSucces(idFonctionnalite, nomAppli, codeExigence, critereSucces.getNomCritere().toString());
									
									
									/*addDataCritereSucces.addNewCritereSucces(critereSucces);
									model.recupererIdSousFonctionnalite.recupererIdSF(sousFonctionnalite);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(sousFonctionnalite.getFkFonct(), sousFonctionnalite.getCodeSFonct(), sousFonctionnalite.getNomSFonct());*/	
							}
							else
							{
								lblErreur.setVisible(true);
								calendrierDebut.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
								calendrierDebut.requestFocus();
							}
						}
						
					else
					{
						lblErreur.setVisible(true);
						textAreaNomCritere.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textAreaNomCritere.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumCritere.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumCritere.requestFocus();					
				}
			}
		}				
	}
	
	private void remplirCritereSucces(String nomCritereSucces){
		SimpleDateFormat formater99 = null;
		formater99 =new SimpleDateFormat ("yyyy-MM-dd");
		Date dateFinale=null;
		try {
			dateFinale = formater99.parse("2099-12-31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		nomCritere=nomCritereSucces;
		model.critereSuccesArbre critereSuccesArbre =controller.ControllerDBCritereSucces.getCritereSuccesArbre(nomCritere);
		textFieldNumCritere.setText(critereSuccesArbre.getNumCritere());
		textAreaNomCritere.setText(critereSuccesArbre.getNomCritere());
		codeExigence=critereSuccesArbre.getFkExigence();
		codeCritere=critereSuccesArbre.getCodeCritere();
		idRecordCritere=critereSuccesArbre.getIdCritere();
		calendrierDebut.setDate(critereSuccesArbre.getDateDebutCritere());
		
		if(critereSuccesArbre.getDateFinCritere().compareTo(dateFinale)==0){
			calendrierFin.setDate(null);
		}
		else{
			calendrierFin.setDate(critereSuccesArbre.getDateFinCritere());
		}
		btnCreer.setVisible(false);
		btnValider.setVisible(true);
		
		
	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
