package model;

import java.util.Date;

public class fonctionnalite {
	
	private int idFonctionnalite;
	private String nomFonctionnalite;
	private String descriptionFonctionnalite;
	private String dateDebutFonct;
	private String dateFinFonct;
	private String numFonct;
	private int fkAppli;
	
	public fonctionnalite (int idFonctionnalite, String nomFonctionnalite, String descriptionFonctionnalite, String dateDebutFonct, String dateFinFonct, String numFonct, int fkAppli){
		super();
		this.idFonctionnalite=idFonctionnalite;
		this.nomFonctionnalite=nomFonctionnalite;
		this.descriptionFonctionnalite=descriptionFonctionnalite;
		this.dateDebutFonct=dateDebutFonct;
		this.dateFinFonct=dateFinFonct;
		this.numFonct=numFonct;
		this.fkAppli=fkAppli;
	}

	public void setDateDebutFonct(String dateDebutFonct) {
		this.dateDebutFonct = dateDebutFonct;
	}

	public void setDateFinFonct(String dateFinFonct) {
		this.dateFinFonct = dateFinFonct;
	}

	public fonctionnalite() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getNumFonct() {
		return numFonct;
	}

	public void setNumFonct(String numFonct) {
		this.numFonct = numFonct;
	}

	public int getFkAppli() {
		return fkAppli;
	}

	public void setFkAppli(int fkAppli) {
		this.fkAppli = fkAppli;
	}

	public int getIdFonctionnalite() {
		return idFonctionnalite;
	}

	public void setIdFonctionnalite(int idFonctionnalite) {
		this.idFonctionnalite = idFonctionnalite;
	}

	public String getNomFonctionnalite() {
		return nomFonctionnalite;
	}

	public void setNomFonctionnalite(String nomFonctionnalite) {
		this.nomFonctionnalite = nomFonctionnalite;
	}

	public String getDescriptionFonctionnalite() {
		return descriptionFonctionnalite;
	}

	public void setDescriptionFonctionnalite(String descriptionFonctionnalite) {
		this.descriptionFonctionnalite = descriptionFonctionnalite;
	}

	public String getDateDebutFonct() {
		return dateDebutFonct;
	}

	public String getDateFinFonct() {
		return dateFinFonct;
	}

	
}
