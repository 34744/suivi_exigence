package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class mainJFrame extends JFrame {

	private static JPanel contentPane;
	private Container cont;

	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public mainJFrame() {
		/*frame = new JFrame();*/
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		cont=this.getContentPane();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder (5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		cont.add(contentPane);
		//contentPane.setBackground(Color.BLUE);
		//this.add(cont);
		
		view.accueil acc = new view.accueil();
		contentPane.add(acc);
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void setContainerPanel (Component arg0){
		contentPane.add(arg0);
	}
	
	public static void eraseContainerPanel(){
		try{
			contentPane.remove(contentPane.getComponent(0));
			refreshPanelPrincipal();
		}catch (ArrayIndexOutOfBoundsException error){
			JOptionPane.showMessageDialog(null, error, "Erreur ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void refreshPanelPrincipal() {
		// TODO Auto-generated method stub
		contentPane.repaint();
		contentPane.setVisible(false);
		contentPane.setVisible(true);
	}

}
