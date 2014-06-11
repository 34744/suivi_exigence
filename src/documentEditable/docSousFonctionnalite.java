package documentEditable;

import java.awt.Color;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import controller.controllerDBExigenceFonctionnelle;
import controller.controllerDBSousFonctionnalite;

public class docSousFonctionnalite {
	public static void docSousFonctionnalite(String nomSousFonctionnalite) { 
	Vector<model.exigenceFonctionnelleArbre> vectExigenceFonctionnelle = new Vector<model.exigenceFonctionnelleArbre>();
	    
	  
	  model.sousFonctionnaliteArbre sousFonctionnaliteArbre = controllerDBSousFonctionnalite.getSousFonctionnaliteArbre(nomSousFonctionnalite);
	  model.sousFonctionnaliteArbre sousFonctionnaliteVersion = controllerDBSousFonctionnalite.getSousFonctionnaliteArbreVersion(Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct()));
	  vectExigenceFonctionnelle = controller.controllerDBExigenceFonctionnelle.getExigenceFonctionnelleVecteurArbre((Integer.parseInt(sousFonctionnaliteArbre.getCodeSFonct())));
	  
	 String StrVersionDate = sousFonctionnaliteArbre.getDateDebutSFRecord().toString();
	 
	 
	 	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
	 	
		String dateVersion;
		dateVersion = sdf.format(sousFonctionnaliteArbre.getDateDebutSFRecord());
	
	  Document document = new Document(PageSize.A4);
	    try {
	      PdfWriter.getInstance(document, new FileOutputStream("c:/test.pdf"));
	      //Phrase page = new Phrase ( "Imprimé le "+sToday);
	     // Phrase page1 = new Phrase ( "Page"+ String.valueOf(document.getPageNumber()));
	    //  HeaderFooter footer = new HeaderFooter(page, false);
	     //document.setFooter(footer);
	      document.open();
	      
	      
	      Font titreFont = FontFactory.getFont("arial", BaseFont.WINANSI);
	      
	      titreFont.setStyle(Font.BOLD);
	      titreFont.setSize(16.0f);
	      
	      
	      Table titre = new Table (1,1);
	      titre.setAutoFillEmptyCells(true);
	      titre.setPadding(3);
	      
	      Cell contenuTitre = new Cell ();
	      contenuTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      contenuTitre.setVerticalAlignment(Element.ALIGN_CENTER);
	      contenuTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      contenuTitre.addElement(new Paragraph("Description d'une sous-fonctionnalité",titreFont));
	      contenuTitre.addElement(new Phrase ("SF"+ sousFonctionnaliteArbre.getNumSFonct()+ ": "+ sousFonctionnaliteArbre.getNomSFonct()+"\n"));
	      contenuTitre.addElement(new Phrase ("Version : "+sousFonctionnaliteVersion.getVersionSFonct() + " du " + dateVersion));
	      titre.addCell(contenuTitre);
	       
	      Font sousTitreFont = FontFactory.getFont("arial", BaseFont.WINANSI);
	      
	      sousTitreFont.setStyle(Font.ITALIC);
	      sousTitreFont.setStyle(Font.UNDERLINE);
	      sousTitreFont.setSize(12.0f);

	     Font textFont = FontFactory.getFont("arial",BaseFont.WINANSI);
	     
	     Paragraph niveauTitre = new Paragraph("Niveaux précédents:",sousTitreFont);
	     niveauTitre.setSpacingBefore(20f);
	     
	     Table tableau = new Table (2,3);
	     tableau.setWidths(new int[]{20,50});
	     tableau.setPadding(3);
	     tableau.addCell("Application:");
	     tableau.addCell(sousFonctionnaliteArbre.getNomAppli());
	     tableau.addCell("Fonctionnalité:");
	     tableau.addCell(sousFonctionnaliteArbre.getNomFonct());
	     

	      Paragraph exigenceTitre = new Paragraph("Exigences fonctionnelles:",sousTitreFont);
	      exigenceTitre.setSpacingBefore(20f);
	      
	      document.add(titre);
	      document.add(niveauTitre);
	      document.add(tableau);
	      
	      document.add(exigenceTitre);
	      
	      
	      if(vectExigenceFonctionnelle.size()==0){
	    	  Paragraph sansCS = new Paragraph("Aucune exigence n'a été définie.",textFont);
		      
		      document.add(sansCS);
	      }
	      else{
	      Table exigence = new Table(3,vectExigenceFonctionnelle.size());
	      exigence.setPadding(2);
	      exigence.setWidths(new int[]{6,55,15});
	      Cell numExigenceTitre = new Cell("N°");
	      numExigenceTitre.setHeader(true);
	      numExigenceTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      numExigenceTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      
	      
	      Cell nomExigenceTitre = new Cell("Définition exigence");
	      nomExigenceTitre.setHeader(true);
	      nomExigenceTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      nomExigenceTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      
	      Cell dateExigenceTitre = new Cell("Date d'effet");
	      dateExigenceTitre.setHeader(true);
	      dateExigenceTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      dateExigenceTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      
	      exigence.addCell(numExigenceTitre);
	      exigence.addCell(nomExigenceTitre);
	      exigence.addCell(dateExigenceTitre);
	      
	      for (int i=0; i<vectExigenceFonctionnelle.size();i++){
			  Cell numExigence = new Cell(vectExigenceFonctionnelle.elementAt(i).getNumExi());
	    	  numExigence.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  numExigence.setVerticalAlignment(Element.ALIGN_CENTER);
			  exigence.addCell(numExigence);
			  
			  Cell nomExigence = new Cell(vectExigenceFonctionnelle.elementAt(i).getNomExigence());
	    	  nomExigence.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	    	  nomExigence.setVerticalAlignment(Element.ALIGN_CENTER);
	    	  exigence.addCell(nomExigence);
	    	  
	    	  String dateExigenceTab;
	  		  dateExigenceTab = sdf.format(vectExigenceFonctionnelle.elementAt(i).getDateDebutEFRecord());
	    	  
	    	  Cell dateExigence = new Cell(dateExigenceTab);
	    	  dateExigence.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	    	  dateExigence.setVerticalAlignment(Element.ALIGN_CENTER);
	    	  exigence.addCell(dateExigence);
		  	}
	      document.add(exigence);
	      }
	      
	      
	     
	      //document.add(footer);

	    } catch (DocumentException de) {
	      de.printStackTrace();
	    } catch (IOException ioe) {
	      ioe.printStackTrace();
	    }

	    document.close();
	    
	    try { 
	    	Desktop.getDesktop().browse(new URI("file:///C:/test.pdf")); 
	    	} catch (IOException e) { 
	    	System.err.println("Impossible de trouver ce fichier."); 
	    	} catch (URISyntaxException e) { 
	    	System.err.println("L'URL fournie est incorrecte."); 
	    	} 



}
}
