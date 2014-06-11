package documentEditable;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import model.exigenceFonctionnelle;
import model.exigenceFonctionnelleModelTableau;

import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;

import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPage;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfPageLabels;
import com.lowagie.text.pdf.PdfPages;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfBorderDictionary;

import controller.ControllerDBCritereSucces;
import controller.controllerDBExigenceFonctionnelle;
public class docExigenceFonctionnelleDetaille {

  public static void docExigenceFonctionnelleDetaille(String nomExigence) {
	  
	  
	  Vector<model.critereSuccesArbre> vectCritereSucces = new Vector<model.critereSuccesArbre>();
	    
	  
	  model.exigenceFonctionnelleArbre exigenceFonctionnelleArbre = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbrePdf(nomExigence);
	  model.exigenceFonctionnelleArbre exigenceVersion = controllerDBExigenceFonctionnelle.getExgienceFonctionnelleArbreVersion(Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence()));
	  vectCritereSucces = controller.ControllerDBCritereSucces.getCritereSuccesVecteurArbre(Integer.parseInt(exigenceFonctionnelleArbre.getCodeExigence()));
	  System.out.println(exigenceFonctionnelleArbre.getIdExigence());
	 String StrVersionDate = exigenceFonctionnelleArbre.getDateDebutEFRecord().toString();
	 
	 
	 	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
	 	
		String dateVersion;
		dateVersion = sdf.format(exigenceFonctionnelleArbre.getDateDebutEFRecord());
	
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
	      contenuTitre.addElement(new Paragraph("Description d'une exigence fonctionnelle",titreFont));
	      contenuTitre.addElement(new Phrase ("EF"+ exigenceFonctionnelleArbre.getNumExi()+ ": "+ exigenceFonctionnelleArbre.getNomExigence()+"\n"));
	      contenuTitre.addElement(new Phrase ("Version : "+exigenceVersion.getVersionExigence() + " du " + dateVersion));
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
	     tableau.addCell(exigenceFonctionnelleArbre.getNomAppli());
	     tableau.addCell("Fonctionnalité:");
	     tableau.addCell(exigenceFonctionnelleArbre.getNomFonct());
	     tableau.addCell("Sous-Fonctionnalité:");
	     tableau.addCell(exigenceFonctionnelleArbre.getNomSFonct());
	     
	     Paragraph descriptionTitre = new Paragraph("Description:",sousTitreFont);
	      descriptionTitre.setSpacingBefore(20f);
	      
	      Paragraph description = new Paragraph(exigenceFonctionnelleArbre.getDescriptionExigence(),textFont);
	      description.setAlignment(Element.ALIGN_JUSTIFIED);
	      description.setIndentationRight(20f);
	      
	      Paragraph raisonTitre = new Paragraph("Raison:",sousTitreFont);
	      raisonTitre.setSpacingBefore(20f);
	      
	      Paragraph raison = new Paragraph(exigenceFonctionnelleArbre.getRaisonExigence(),textFont);
	      raison.setAlignment(Element.ALIGN_JUSTIFIED);
	      raison.setIndentationRight(20f);

	      Paragraph critereTitre = new Paragraph("Critère de succès:",sousTitreFont);
	      critereTitre.setSpacingBefore(20f);
	      
	      document.add(titre);
	      document.add(niveauTitre);
	      document.add(tableau);
	      document.add(descriptionTitre);
	      document.add(description);
	      document.add(raisonTitre);
	      document.add(raison);
	      document.add(critereTitre);
	      
	      
	      if(vectCritereSucces.size()==0){
	    	  Paragraph sansCS = new Paragraph("Aucun critère de succès n'a été défini.",textFont);
		      description.setAlignment(Element.ALIGN_JUSTIFIED);
		      description.setIndentationRight(20f);
		      document.add(sansCS);
	      }
	      else{
	      Table critere = new Table(3,vectCritereSucces.size());
	      critere.setPadding(2);
	      critere.setWidths(new int[]{4,55,15});
	      Cell numCritereTitre = new Cell("N°");
	      numCritereTitre.setHeader(true);
	      numCritereTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      numCritereTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      
	      
	      Cell nomCritereTitre = new Cell("Définition critère");
	      nomCritereTitre.setHeader(true);
	      nomCritereTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      nomCritereTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      
	      Cell dateCritereTitre = new Cell("Date effet");
	      dateCritereTitre.setHeader(true);
	      dateCritereTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
	      dateCritereTitre.setBackgroundColor(Color.LIGHT_GRAY);
	      
	      critere.addCell(numCritereTitre);
	      critere.addCell(nomCritereTitre);
	      critere.addCell(dateCritereTitre);
	      
	      for (int i=0; i<vectCritereSucces.size();i++){
			  Cell numCritere = new Cell(vectCritereSucces.elementAt(i).getNumCritere());
	    	  numCritere.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	  numCritere.setVerticalAlignment(Element.ALIGN_CENTER);
			  critere.addCell(numCritere);
			  
			  Cell nomCritere = new Cell(vectCritereSucces.elementAt(i).getNomCritere());
	    	  nomCritere.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	    	  nomCritere.setVerticalAlignment(Element.ALIGN_CENTER);
	    	  critere.addCell(nomCritere);
	    	  
	    	  String dateCritereTab;
	  		  dateCritereTab = sdf.format(vectCritereSucces.elementAt(i).getDateDebutCSRecord());
	    	  
	    	  Cell dateCritere = new Cell(dateCritereTab);
	    	  dateCritere.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	    	  dateCritere.setVerticalAlignment(Element.ALIGN_CENTER);
	    	  critere.addCell(dateCritere);
		  	}
	      document.add(critere);
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