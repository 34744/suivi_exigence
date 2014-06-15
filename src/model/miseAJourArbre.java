package model;

import java.util.Date;

public class miseAJourArbre {
	int idMiseAJour;
	String numMAJ;
	Date dateProposition;
	Date dateValidation;
	Date dateNotification; 
	String numCallBmc;
	Date dateMiseProd;
	int fkApplication;
	String nomApplication;
	
	public miseAJourArbre(int idMiseAJour, String numMAJ, Date dateProposition,
			Date dateValidation, Date dateNotification, String numCallBmc,
			Date dateMiseProd, int fkApplication, String nomApplication) {
		super();
		this.idMiseAJour = idMiseAJour;
		this.numMAJ = numMAJ;
		this.dateProposition = dateProposition;
		this.dateValidation = dateValidation;
		this.dateNotification = dateNotification;
		this.numCallBmc = numCallBmc;
		this.dateMiseProd = dateMiseProd;
		this.fkApplication = fkApplication;
		this.nomApplication=nomApplication;
	}

	public miseAJourArbre() {
		super();
	}

	public int getIdMiseAJour() {
		return idMiseAJour;
	}

	public void setIdMiseAJour(int idMiseAJour) {
		this.idMiseAJour = idMiseAJour;
	}

	public String getNumMAJ() {
		return numMAJ;
	}

	public void setNumMAJ(String numMAJ) {
		this.numMAJ = numMAJ;
	}

	public Date getDateProposition() {
		return dateProposition;
	}

	public void setDateProposition(Date dateProposition) {
		this.dateProposition = dateProposition;
	}

	public Date getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}

	public Date getDateNotification() {
		return dateNotification;
	}

	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}

	public String getNumCallBmc() {
		return numCallBmc;
	}

	public void setNumCallBmc(String numCallBmc) {
		this.numCallBmc = numCallBmc;
	}

	public Date getDateMiseProd() {
		return dateMiseProd;
	}

	public void setDateMiseProd(Date dateMiseProd) {
		this.dateMiseProd = dateMiseProd;
	}

	public int getFkApplication() {
		return fkApplication;
	}

	public void setFkApplication(int fkApplication) {
		this.fkApplication = fkApplication;
	}

	public String getNomApplication() {
		return nomApplication;
	}

	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}
	
}
