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

import controller.controllerDBFonctionnalite;
import controller.controllerDBSousFonctionnalite;

public class docFonctionnalite {
	public static void docFonctionnalite(String nomFonctionnalite) { 
		Vector<model.sousFonctionnaliteArbre> vectSousFonctionnalite = new Vector<model.sousFonctionnaliteArbre>();
		    
		  
		  model.fonctionnaliteArbre fonctionnaliteArbre = controllerDBFonctionnalite.getFonctionnaliteArbre(nomFonctionnalite);
		  vectSousFonctionnalite = controller.controllerDBSousFonctionnalite.getSousFonctionnaliteVecteurArbre((Integer.parseInt(fonctionnaliteArbre.getNumFonct())));
		  
		 String StrVersionDate = fonctionnaliteArbre.getDateDebutFonct().toString();
		 
		 
		 	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		 	
			String dateVersion;
			dateVersion = sdf.format(fonctionnaliteArbre.getDateDebutFonct());
		
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
		      contenuTitre.addElement(new Paragraph("Description d'une fonctionnalité",titreFont));
		      contenuTitre.addElement(new Phrase ("F"+ fonctionnaliteArbre.getNumFonct()+ ": "+ fonctionnaliteArbre.getNomFonctionnalite()+"\n"));
		      
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
		     tableau.addCell(fonctionnaliteArbre.getNomApplication());
		         

		      Paragraph exigenceTitre = new Paragraph("Sous-fonctionnalité:",sousTitreFont);
		      exigenceTitre.setSpacingBefore(20f);
		      
		      document.add(titre);
		      document.add(niveauTitre);
		      document.add(tableau);
		      
		      document.add(exigenceTitre);
		      
		      
		      if(vectSousFonctionnalite.size()==0){
		    	  Paragraph sansCS = new Paragraph("Aucune sous-fonctionnalité n'a été définie.",textFont);
			      
			      document.add(sansCS);
		      }
		      else{
		      Table sousFonctionnalite = new Table(3,vectSousFonctionnalite.size());
		      sousFonctionnalite.setPadding(2);
		      sousFonctionnalite.setWidths(new int[]{6,55,15});
		      Cell numSFTitre = new Cell("N°");
		      numSFTitre.setHeader(true);
		      numSFTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
		      numSFTitre.setBackgroundColor(Color.LIGHT_GRAY);
		      
		      
		      Cell nomSFTitre = new Cell("Définition sous-fonctionnalité");
		      nomSFTitre.setHeader(true);
		      nomSFTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
		      nomSFTitre.setBackgroundColor(Color.LIGHT_GRAY);
		      
		      Cell dateSFTitre = new Cell("Date d'effet");
		      dateSFTitre.setHeader(true);
		      dateSFTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
		      dateSFTitre.setBackgroundColor(Color.LIGHT_GRAY);
		      
		      sousFonctionnalite.addCell(numSFTitre);
		      sousFonctionnalite.addCell(nomSFTitre);
		      sousFonctionnalite.addCell(dateSFTitre);
		      
		      for (int i=0; i<vectSousFonctionnalite.size();i++){
				  Cell numSF = new Cell(vectSousFonctionnalite.elementAt(i).getNumSFonct());
		    	  numSF.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	  numSF.setVerticalAlignment(Element.ALIGN_CENTER);
				  sousFonctionnalite.addCell(numSF);
				  
				  Cell nomSF = new Cell(vectSousFonctionnalite.elementAt(i).getNomSFonct());
		    	  nomSF.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		    	  nomSF.setVerticalAlignment(Element.ALIGN_CENTER);
		    	  sousFonctionnalite.addCell(nomSF);
		    	  
		    	  String dateSFTab;
		  		  dateSFTab = sdf.format(vectSousFonctionnalite.elementAt(i).getDateDebutSFRecord());
		    	  
		    	  Cell dateSF = new Cell(dateSFTab);
		    	  dateSF.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		    	  dateSF.setVerticalAlignment(Element.ALIGN_CENTER);
		    	  sousFonctionnalite.addCell(dateSF);
			  	}
		      document.add(sousFonctionnalite);
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
