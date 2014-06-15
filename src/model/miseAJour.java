package model;

import java.util.Date;

public class miseAJour {
	int idMiseAJour;
	String numMAJ;
	String dateProposition;
	String dateValidation;
	String dateNotification; 
	String numCallBmc;
	String dateMiseProd;
	int fkApplication;
	
	public miseAJour(int idMiseAJour, String numMAJ, String dateProposition,
			String dateValidation, String dateNotification, String numCallBmc,
			String dateMiseProd, int fkApplication) {
		super();
		this.idMiseAJour = idMiseAJour;
		this.numMAJ = numMAJ;
		this.dateProposition = dateProposition;
		this.dateValidation = dateValidation;
		this.dateNotification = dateNotification;
		this.numCallBmc = numCallBmc;
		this.dateMiseProd = dateMiseProd;
		this.fkApplication = fkApplication;
	}

	public miseAJour() {
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

	
	public String getNumCallBmc() {
		return numCallBmc;
	}

	public void setNumCallBmc(String numCallBmc) {
		this.numCallBmc = numCallBmc;
	}

	public String getDateProposition() {
		return dateProposition;
	}

	public void setDateProposition(String dateProposition) {
		this.dateProposition = dateProposition;
	}

	public String getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(String dateValidation) {
		this.dateValidation = dateValidation;
	}

	public String getDateNotification() {
		return dateNotification;
	}

	public void setDateNotification(String dateNotification) {
		this.dateNotification = dateNotification;
	}

	public String getDateMiseProd() {
		return dateMiseProd;
	}

	public void setDateMiseProd(String dateMiseProd) {
		this.dateMiseProd = dateMiseProd;
	}

	public int getFkApplication() {
		return fkApplication;
	}

	public void setFkApplication(int fkApplication) {
		this.fkApplication = fkApplication;
	}
	

}
