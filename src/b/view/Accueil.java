package b.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import java.awt.Color;

public class Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Accueil() {
		try 
	    {
	      UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
	      Accueil frame = new Accueil();
			frame.setVisible(true);
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		setForeground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setVisible(true);
	}

}
