package model;

import java.util.Date;

public class exigenceFonctionnelleArbre {

	private int idExigence;
	private String nomExigence;
	private String descriptionExigence;
	private String raisonExigence;
	private int prioriteExigence;
	private Date dateDebutExi;
	private Date dateFinExi;
	private String numExi;
	private String codeExigence;
	private Date dateDebutEFRecord;
	private Date dateFinEFRecord;
	private int fkSFonct;
	private int fkFonct;
	private int fkAppli;
	private String nomFonct;
	private String nomAppli;
	private String nomSFonct;
	
	public exigenceFonctionnelleArbre() {
		super();
	}

	public exigenceFonctionnelleArbre(int idExigence, String nomExigence,
			String descriptionExigence, String raisonExigence,
			int prioriteExigence, Date dateDebutExi, Date dateFinExi,
			String numExi, String codeExigence, Date dateDebutEFRecord,
			Date dateFinEFRecord, int fkSFonct, int fkFonct, int fkAppli,
			String nomFonct, String nomAppli, String nomSFonct) {
		super();
		this.idExigence = idExigence;
		this.nomExigence = nomExigence;
		this.descriptionExigence = descriptionExigence;
		this.raisonExigence = raisonExigence;
		this.prioriteExigence = prioriteExigence;
		this.dateDebutExi = dateDebutExi;
		this.dateFinExi = dateFinExi;
		this.numExi = numExi;
		this.codeExigence = codeExigence;
		this.dateDebutEFRecord = dateDebutEFRecord;
		this.dateFinEFRecord = dateFinEFRecord;
		this.fkSFonct = fkSFonct;
		this.fkFonct = fkFonct;
		this.fkAppli = fkAppli;
		this.nomFonct = nomFonct;
		this.nomAppli = nomAppli;
		this.nomSFonct = nomSFonct;
	}

	public int getIdExigence() {
		return idExigence;
	}

	public void setIdExigence(int idExigence) {
		this.idExigence = idExigence;
	}

	public String getNomExigence() {
		return nomExigence;
	}

	public void setNomExigence(String nomExigence) {
		this.nomExigence = nomExigence;
	}

	public String getDescriptionExigence() {
		return descriptionExigence;
	}

	public void setDescriptionExigence(String descriptionExigence) {
		this.descriptionExigence = descriptionExigence;
	}

	public String getRaisonExigence() {
		return raisonExigence;
	}

	public void setRaisonExigence(String raisonExigence) {
		this.raisonExigence = raisonExigence;
	}

	public int getPrioriteExigence() {
		return prioriteExigence;
	}

	public void setPrioriteExigence(int prioriteExigence) {
		this.prioriteExigence = prioriteExigence;
	}


	public Date getDateDebutExi() {
		return dateDebutExi;
	}

	public Date getDateFinExi() {
		return dateFinExi;
	}

	public String getNumExi() {
		return numExi;
	}

	public void setNumExi(String numExi) {
		this.numExi = numExi;
	}

	public String getCodeExigence() {
		return codeExigence;
	}

	public void setCodeExigence(String codeExigence) {
		this.codeExigence = codeExigence;
	}

	public Date getDateDebutEFRecord() {
		return dateDebutEFRecord;
	}

	public void setDateDebutEFRecord(Date dateDebutEFRecord) {
		this.dateDebutEFRecord = dateDebutEFRecord;
	}

	public Date getDateFinEFRecord() {
		return dateFinEFRecord;
	}

	public void setDateFinEFRecord(Date dateFinEFRecord) {
		this.dateFinEFRecord = dateFinEFRecord;
	}

	public void setDateDebutExi(Date dateDebutExi) {
		this.dateDebutExi = dateDebutExi;
	}

	public void setDateFinExi(Date dateFinExi) {
		this.dateFinExi = dateFinExi;
	}

	public int getFkSFonct() {
		return fkSFonct;
	}

	public void setFkSFonct(int fkSFonct) {
		this.fkSFonct = fkSFonct;
	}

	public int getFkFonct() {
		return fkFonct;
	}

	public void setFkFonct(int fkFonct) {
		this.fkFonct = fkFonct;
	}

	public int getFkAppli() {
		return fkAppli;
	}

	public void setFkAppli(int fkAppli) {
		this.fkAppli = fkAppli;
	}

	public String getNomFonct() {
		return nomFonct;
	}

	public void setNomFonct(String nomFonct) {
		this.nomFonct = nomFonct;
	}

	public String getNomAppli() {
		return nomAppli;
	}

	public void setNomAppli(String nomAppli) {
		this.nomAppli = nomAppli;
	}

	public String getNomSFonct() {
		return nomSFonct;
	}

	public void setNomSFonct(String nomSFonct) {
		this.nomSFonct = nomSFonct;
	}
	
	
}
