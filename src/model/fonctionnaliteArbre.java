package model;

import java.util.Date;

public class fonctionnaliteArbre {
	
	private int idFonctionnalite;
	private String nomFonctionnalite;
	private String descriptionFonctionnalite;
	private Date dateDebutFonct;
	private Date dateFinFonct;
	private String numFonct;
	private int fkAppli;
	private String nomApplication;
	
	public fonctionnaliteArbre(){
		super();
	}
	
	public fonctionnaliteArbre (int idFonctionnalite, String nomFonctionnalite, String descriptionFonctionnalite, Date dateDebutFonct, Date dateFinFonct, String numFonct, int fkAppli, String nomApplication){
		super();
		this.idFonctionnalite=idFonctionnalite;
		this.nomFonctionnalite=nomFonctionnalite;
		this.descriptionFonctionnalite=descriptionFonctionnalite;
		this.dateDebutFonct=dateDebutFonct;
		this.dateFinFonct=dateFinFonct;
		this.numFonct=numFonct;
		this.fkAppli=fkAppli;
		this.nomApplication=nomApplication;
	}

	public String getNomApplication() {
		return nomApplication;
	}

	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
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

	public Date getDateDebutFonct() {
		return dateDebutFonct;
	}

	public void setDateDebutFonct(Date dateDebutFonct) {
		this.dateDebutFonct = dateDebutFonct;
	}

	public Date getDateFinFonct() {
		return dateFinFonct;
	}

	public void setDateFinFonct(Date dateFinFonct) {
		this.dateFinFonct = dateFinFonct;
	}
}
