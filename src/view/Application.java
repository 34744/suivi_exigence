package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import model.applicationArbre;
import model.applicationModelTableau;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

import controller.ControllerDBConfiguration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Application extends JPanel{

	private JFrame frame;
	private JTable table;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JTextField textFieldApplication;
	private applicationArbre applicationArbre = new applicationArbre();
	/**
	 * Launch the application.
	 */
	
	
	public Application() {
		
		setBackground(new Color(176, 196, 222));
		vectAppli = controller.ControllerDBConfiguration.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		setLayout(null);
		table = new JTable(modelAppli);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(table.getSelectedRow()!=-1){
					remplirApplication(table.getValueAt(table.getSelectedRow(),0).toString());
					System.out.println(table.getValueAt(table.getSelectedRow(),0).toString());
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(new Color(211, 211, 211));
		table.setBounds(10, 56, 153, 476);
		/*frame.getContentPane().*/add(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(10, 1, 794, 41);
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
		textFieldApplication.setForeground(Color.BLACK);
		textFieldApplication.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textFieldApplication.setBackground(new Color(176,196,222));
		textFieldApplication.setBounds(185, 53, 239, 25);
		//textFieldApplication.enable(false);
		add(textFieldApplication);
		textFieldApplication.setColumns(10);
		//frame.setBounds(100, 100, 822, 574);
		
		//frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		tglbtnModifier.addActionListener(list);

	}

	private void remplirApplication(String application){
		
		applicationArbre=ControllerDBConfiguration.getApplicationArbre(application);
		textFieldApplication.setText(applicationArbre.getNomApplication());
	}

	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			
			if(source == btnHome){
				controller.gestionFenetreConfiguration.eraseContainerPaneMainJFrame();
				controller.gestionFenetreConfiguration.accueil();
			}
		}
	}
}
