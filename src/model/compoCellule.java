package model;

import java.sql.Date;

public class compoCellule {

	private int idCellule, idUtilisateur;
	String dateDebutCellule;
	private String dateFinCellule;
	private String numUlis;
	public compoCellule (){
		super();
		
	}
	
	public compoCellule (String numUlis){
		super();
		this.numUlis=numUlis;
	}
	
	public compoCellule (int idCellule, int idUtilisateur, String dateDebutCellule, String dateFinCellule){
		super();
		
		this.idCellule=idCellule;
		this.idUtilisateur=idUtilisateur;
		this.dateDebutCellule=dateDebutCellule;
		this.dateFinCellule=dateFinCellule;
				
	}

	public int getFkCellule() {
		return idCellule;
	}

	public void setFkCellule(int fkCellule) {
		this.idCellule = fkCellule;
	}

	public int getFkUtilisateur() {
		return idUtilisateur;
	}

	public void setFkUtilisateur(int fkUtilisateur) {
		this.idUtilisateur = fkUtilisateur;
	}

	public String getDateDebutCellule() {
		return dateDebutCellule;
	}

	public void setDateDebutCellule(String dateDebut) {
		this.dateDebutCellule = dateDebut;
	}

	public String getDateFinCellule() {
		return dateFinCellule;
	}

	public void setDateFinCellule(String dateFin) {
		this.dateFinCellule = dateFin;
	}
	
	
}
