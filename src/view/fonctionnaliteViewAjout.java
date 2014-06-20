package view;

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

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.ControllerDBConfiguration;
import controller.addDataFonctionnalite;
import controller.controllerDBFonctionnalite;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;

import view.Parametres.MyButtonListener;

public class fonctionnaliteViewAjout extends JPanel implements ActionListener{

	private JFrame frame;
	private JTable table;
	private JTree tree;
	private Vector<model.fonctionnaliteArbre> vectFonctionnalite = new Vector<model.fonctionnaliteArbre>();
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private fonctionnaliteModelTableau modelFonctionnalite;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnAnnuler = new JButton("Annuler");
	private JButton btnValider = new JButton("Valider");
	private JTextField textFieldApplication;
	int idAppli;
	String nomAppli;
	private fonctionnalite fonctionnalite = new fonctionnalite();
	private JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant ou corriger le contenu!");
	private JTextField textFieldNumFonct;
	private JTextField textFieldNomFonctionnalite;
	private JDateChooser calendrierDebut= new JDateChooser();
	private JDateChooser calendrierFin= new JDateChooser();
	private JTextArea textArea = new JTextArea();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the panel.
	 */
	public fonctionnaliteViewAjout(int idAppli, String nomAppli) {
		this.idAppli=idAppli;
		this.nomAppli=nomAppli;
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
		
		textFieldApplication = new JTextField();
		textFieldApplication.setBounds(21, 75, 250, 26);
		textFieldApplication.setForeground(Color.BLACK);
		textFieldApplication.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textFieldApplication.setBackground(new Color(176,196,222));
		//textFieldApplication.enable(false);
		add(textFieldApplication);
		textFieldApplication.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(295, 120, 468, 381);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNomFonctionnalite = new JLabel("Nom de la fonctionnalit\u00E9");
		lblNomFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomFonctionnalite.setBounds(10, 58, 186, 26);
		panel.add(lblNomFonctionnalite);
		
		JLabel lblNumFonctionnalite = new JLabel("Num\u00E9ro de la fonctionnalit\u00E9");
		lblNumFonctionnalite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumFonctionnalite.setBounds(10, 21, 208, 26);
		panel.add(lblNumFonctionnalite);
		
		JLabel lblDateDebut = new JLabel("Date Debut");
		lblDateDebut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateDebut.setBounds(10, 99, 85, 26);
		panel.add(lblDateDebut);
		
		JLabel lblDescription = new JLabel("Description de la fonctionnalit\u00E9");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDescription.setBounds(10, 157, 248, 26);
		panel.add(lblDescription);
		
		textFieldNumFonct = new JTextField();
		textFieldNumFonct.setBounds(228, 23, 100, 26);
		panel.add(textFieldNumFonct);
		textFieldNumFonct.setColumns(10);
		
		textFieldNomFonctionnalite = new JTextField();
		textFieldNomFonctionnalite.setColumns(10);
		textFieldNomFonctionnalite.setBounds(228, 60, 230, 26);
		panel.add(textFieldNomFonctionnalite);
		
		textArea.setBounds(10, 187, 448, 149);
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setLineWrap(true);
		JScrollPane JSPtextArea = new JScrollPane(textArea);
		JSPtextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSPtextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSPtextArea.setBounds(10, 187, 448, 149);
		
		panel.add(JSPtextArea);
		

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
		lblErreur.setBounds(10, 356, 416, 14);
		panel.add(lblErreur);
		lblErreur.setVisible(false);
		

		lblErreur.setForeground(Color.RED);

		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnValider.setBounds(594, 512, 89, 31);
		add(btnValider);
		

		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnnuler.setBounds(415, 512, 89, 31);
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


	}
	
	private void buildTree(){
		
		vectFonctionnalite = controllerDBFonctionnalite.getFonctionnaliteVecteurArbre(idAppli);
		vectAppli=ControllerDBConfiguration.getApplicationArbre();
		String fonctionnalite, sFonctionnalite, exiFonct;
		int i=0;
		if(vectFonctionnalite.size()>0){
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(vectFonctionnalite.elementAt(i).getNomApplication()); 
		
			while (i<vectFonctionnalite.size())
			{
				fonctionnalite=vectFonctionnalite.elementAt(i).getNomFonctionnalite();
				DefaultMutableTreeNode rep1 = new DefaultMutableTreeNode(vectFonctionnalite.elementAt(i).getNomFonctionnalite());
				i++;
				racine.add(rep1);
			}
		
		JTree tree = new JTree(racine);
		tree.setBounds(21, 112, 250, 433);	
		JScrollPane JSP = new JScrollPane(tree);
		JSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JSP.setBounds(21, 112, 250, 433);
		this.add(JSP);
	
		}
		else{
			DefaultMutableTreeNode racine = new DefaultMutableTreeNode(nomAppli); 
			
		
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
			controller.gestionFenetreFonctionnalite.fonctionnalite();
				
			}
			
			if(source == btnValider){
				if(textFieldNumFonct.getText()!=null && textFieldNumFonct.getText().length()>0){
					fonctionnalite.setNumFonct(textFieldNumFonct.getText());
					
					if(textFieldNomFonctionnalite.getText()!= null && textFieldNomFonctionnalite.getText().length()>0 ){
						fonctionnalite.setNomFonctionnalite(textFieldNomFonctionnalite.getText());
						fonctionnalite.setFkAppli(idAppli);	
					
						if(textArea.getText()!=null && textArea.getText().length()>0){
							fonctionnalite.setDescriptionFonctionnalite(textArea.getText());
					
					
							if(calendrierDebut.getDate()!=null){
								Date debut=calendrierDebut.getDate();
								String dateDebut = dateFormat.format(debut);
								fonctionnalite.setDateDebutFonct(dateDebut);
					
					
								Date fin=calendrierFin.getDate();
								String dateFin="";
									if(calendrierFin.getDate()!=null){
										dateFin=dateFormat.format(fin);
										fonctionnalite.setDateFinFonct(dateFin);
									}
									else{
										fonctionnalite.setDateFinFonct("20991231");
									}
									addDataFonctionnalite.addFonctionnalite(fonctionnalite);
									controller.gestionFenetreFonctionnalite.eraseContainerPaneMainJFrame();
									controller.gestionFenetreFonctionnalite.modifFonctionnalite(fonctionnalite.getNomFonctionnalite(), fonctionnalite.getFkAppli(), nomAppli);	
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
							textArea.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
							textArea.requestFocus();
						}
					}
					else
					{
						lblErreur.setVisible(true);
						textFieldNomFonctionnalite.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
						textFieldNomFonctionnalite.requestFocus();
					}
				}
				else
				{
					lblErreur.setVisible(true);
					textFieldNumFonct.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldNumFonct.requestFocus();					
				}
			}
		}				
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	
