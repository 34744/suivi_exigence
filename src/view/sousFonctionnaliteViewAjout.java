package view;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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
import model.ouvrirTree;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.addDataFonctionnalite;
import controller.addDataSousFonctionnalite;
import controller.controllerDBFonctionnalite;
import controller.controllerDBSousFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;

import view.Parametres.MyButtonListener;

import javax.swing.JPanel;

public class sousFonctionnaliteViewAjout extends JPanel implements ActionListener {
	private JFrame frame;
	private JTable table;
	private JTree tree;
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
	int idFonctionnalite, idAppli;
	String nomAppli, nomFonctionnalite;
	private fonctionnalite fonctionnalite = new fonctionnalite();
	private model.sousFonctionnalite sousFonctionnalite = new model.sousFonctionnalite();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumSFonct;
	private JTextField textFieldNomSFonctionnalite;
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the panel.
	 */
public sousFonctionnaliteViewAjout(int idFonctionnalite, String nomAppli, int idAppli, String nomFonctionnalite) {
	System.out.println(nomAppli+"appli");
		this.idFonctionnalite=idFonctionnalite;
		this.nomAppli=nomAppli;
		this.idAppli=idAppli;
		this.nomFonctionnalite=nomFonctionnalite;
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
		panel.setBounds(282, 203, 495, 204);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNomFonctionnalite = new JLabel("Nom de la sous fonctionnalit\u00E9");
		lblNomFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomFonctionnalite.setBounds(10, 58, 233, 26);
		panel.add(lblNomFonctionnalite);
		
		JLabel lblNumFonctionnalite = new JLabel("Num\u00E9ro de la sous fonctionnalit\u00E9");
		lblNumFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumFonctionnalite.setBounds(10, 21, 233, 26);
		panel.add(lblNumFonctionnalite);
		
		JLabel lblDateDebut = new JLabel("Date Debut");
		lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateDebut.setBounds(10, 99, 85, 26);
		panel.add(lblDateDebut);
		
		textFieldNumSFonct = new JTextField();
		textFieldNumSFonct.setBounds(253, 23, 100, 26);
		panel.add(textFieldNumSFonct);
		textFieldNumSFonct.setColumns(10);
		
		textFieldNomSFonctionnalite = new JTextField();
		textFieldNomSFonctionnalite.setColumns(10);
		textFieldNomSFonctionnalite.setBounds(253, 60, 230, 26);
		panel.add(textFieldNomSFonctionnalite);
		

		calendrierDebut.setBounds(108, 99, 110, 26);
		calendrierDebut.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierDebut);

		calendrierFin.setBounds(316, 99, 110, 26);
		calendrierFin.setDateFormatString("dd/MM/yyyy");
		panel.add(calendrierFin);
		
		JLabel lblDateFin = new JLabel("Date Fin");
		lblDateFin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFin.setBounds(241, 99, 65, 26);
		panel.add(lblDateFin);		
		lblErreur.setBounds(10, 173, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);

		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.setBounds(572, 512, 89, 31);
		add(btnValider);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(399, 512, 89, 31);
		add(btnAnnuler);
		
		buildTree();
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		btnValider.addActionListener(list);
		btnAnnuler.addActionListener(list);


	}
	
	private void buildTree(){
		System.out.println("NOM apllication"+nomAppli);
		vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idFonctionnalite);
		vectSFonctionnalite = controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre(idFonctionnalite);
		vectAppli=ControllerDBConfiguration.getApplicationArbre();
		String fonctionnalite, sFonctionnalite, exiFonct;
		int i=0;
		System.out.println(idFonctionnalite+"idFonct" + "taille vect"+vectSFonctionnalite.size());
		if(vectSFonctionnalite.size()>0){
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectSFonctionnalite.elementAt(i).getNomAppli()); 
		
			while (i<vectSFonctionnalite.size())
			{
				fonctionnalite=vectSFonctionnalite.elementAt(i).getNomFonct();
				DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectSFonctionnalite.elementAt(i).getNomFonct());
				
				while(i<vectSFonctionnalite.size()&& fonctionnalite.equals(vectSFonctionnalite.elementAt(i).getNomFonct()))
				{
					sFonctionnalite=vectSFonctionnalite.elementAt(i).getNomSFonct();
					DefaultMutableTreeNode rep2 = new DefaultMutableTreeNode(vectSFonctionnalite.elementAt(i).getNomSFonct());
				i++;
				rep1.add(rep2);
				}
				i++;
				racine.add(rep1);
			}
		
		JTree tree = new JTree(racine);
		tree.setBounds(21, 112, 250, 433);	
		tree.enable(false);
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(21, 112, 250, 433);
		this.add(JSP);
		int row = 0; 
	    while (row < tree.getRowCount()) { 
	      tree.expandRow(row); 
	      row++; 
	    } 
	
		}
		else{
			DefaultMutableTreeNode rep = new DefaultMutableTreeNode(nomFonctionnalite); 
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
			racine.add(rep);
		JTree tree = new JTree(racine);
		tree.setBounds(21, 112, 250, 433);	
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(21, 112, 250, 433);
		this.add(JSP);
	
		}
		
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
			controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
			controller.gestionFenetreFonctionnalite.modifFonctionnalite(idFonctionnalite, idAppli, nomAppli);
				
			}
			
			if(source == btnValider){
				if(textFieldNumSFonct.getText()!=null && textFieldNumSFonct.getText().length()>0){
					sousFonctionnalite.setNumSFonct(textFieldNumSFonct.getText());
					
					if(textFieldNomSFonctionnalite.getText()!= null && textFieldNomSFonctionnalite.getText().length()>0 ){
						sousFonctionnalite.setNomSFonct(textFieldNomSFonctionnalite.getText());
						sousFonctionnalite.setFkFonct(idFonctionnalite);	
					
							if(calendrierDebut.getDate()!=null){
								Date debut=calendrierDebut.getDate();
								String dateDebut = dateFormat.format(debut);
								sousFonctionnalite.setDateDebutSFonct(dateDebut);
								sousFonctionnalite.setDateDebutSFRecord(dateDebut);
					
								Date fin=calendrierFin.getDate();
								String dateFin="";
									if(calendrierFin.getDate()!=null){
										dateFin=dateFormat.format(fin);
										sousFonctionnalite.setDateFinSFonct(dateFin);
										sousFonctionnalite.setDateFinSFRecord(dateFin);
									}
									else{
										sousFonctionnalite.setDateFinSFonct("20991231");
										sousFonctionnalite.setDateFinSFRecord("2099-12-31");
									}
									addDataSousFonctionnalite.addNewSousFonctionnalite(sousFonctionnalite);
									model.recupererIdSousFonctionnalite.recupererIdSF(sousFonctionnalite);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreSousFonctionnalite.modifSousFonctionnalite(sousFonctionnalite.getFkFonct(), sousFonctionnalite.getCodeSFonct(), sousFonctionnalite.getNomSFonct());	
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
						textFieldNomSFonctionnalite.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNomSFonctionnalite.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumSFonct.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumSFonct.requestFocus();					
				}
			}
		}				
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
