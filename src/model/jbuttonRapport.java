package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

import com.lowagie.text.FontFactory;

public class jbuttonRapport extends JButton {

	    private static final long serialVersionUID = 9032198251140247116L;
	    String text;
	    public jbuttonRapport(String s) {
	        super(s);
	        text = s;
	        setBorderPainted(true);
	        setContentAreaFilled(false);
	        setFocusable(false);
	        setFont(new Font("Arial",Font.ITALIC,18));
	        setForeground(Color.WHITE);
	        
	    }
	    @Override
	    public void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        if (getModel().isPressed()) {
	            g.setColor(g.getColor());
	            g2.fillRect(3, 3, getWidth() - 6, getHeight() - 6);
	        }
	        super.paintComponent(g);
	        
	            g2.setColor(Color.WHITE);
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setStroke(new BasicStroke(1.2f));
	        g2.draw(new RoundRectangle2D.Double(1, 1, (getWidth() - 3),
	                (getHeight() - 3), 12, 8));
	        g2.setStroke(new BasicStroke(1.5f));
	        g2.drawLine(4, getHeight() - 3, getWidth() - 4, getHeight() - 3);
	        g2.dispose();
	    }
}
