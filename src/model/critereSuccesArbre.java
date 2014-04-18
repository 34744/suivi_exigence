package model;

import java.util.Date;

public class critereSuccesArbre {

	private int idCritere;
	private String nomCritere;
	private Date dateDebutCritere;
	private Date dateFinCritere;
	private String numCritere;
	private int codeCritere;
	private Date dateDebutCSRecord;
	private Date dateFinCSRecord;
	private int fkAppli;
	private int fkFonct;
	private int fkSFonct;
	private int fkExigence;
	private String nomAppli;
	private String nomFonct;
	private String nomSFonct;
	private String nomExigence;
	
	public critereSuccesArbre() {
		super();
	}

	public critereSuccesArbre(int idCritere, String nomCritere,
			Date dateDebutCritere, Date dateFinCritere, String numCritere,
			int codeCritere, Date dateDebutCSRecord, Date dateFinCSRecord,
			int fkAppli, int fkFonct, int fkSFonct, int fkExigence,
			String nomAppli, String nomFonct, String nomSFonct,
			String nomExigence) {
		super();
		this.idCritere = idCritere;
		this.nomCritere = nomCritere;
		this.dateDebutCritere = dateDebutCritere;
		this.dateFinCritere = dateFinCritere;
		this.numCritere = numCritere;
		this.codeCritere = codeCritere;
		this.dateDebutCSRecord = dateDebutCSRecord;
		this.dateFinCSRecord = dateFinCSRecord;
		this.fkAppli = fkAppli;
		this.fkFonct = fkFonct;
		this.fkSFonct = fkSFonct;
		this.fkExigence = fkExigence;
		this.nomAppli = nomAppli;
		this.nomFonct = nomFonct;
		this.nomSFonct = nomSFonct;
		this.nomExigence = nomExigence;
	}

	public int getIdCritere() {
		return idCritere;
	}

	public void setIdCritere(int idCritere) {
		this.idCritere = idCritere;
	}

	public String getNomCritere() {
		return nomCritere;
	}

	public void setNomCritere(String nomCritere) {
		this.nomCritere = nomCritere;
	}

	public Date getDateDebutCritere() {
		return dateDebutCritere;
	}

	public void setDateDebutCritere(Date dateDebutCritere) {
		this.dateDebutCritere = dateDebutCritere;
	}

	public Date getDateFinCritere() {
		return dateFinCritere;
	}

	public void setDateFinCritere(Date dateFinCritere) {
		this.dateFinCritere = dateFinCritere;
	}

	public String getNumCritere() {
		return numCritere;
	}

	public void setNumCritere(String numCritere) {
		this.numCritere = numCritere;
	}

	public int getCodeCritere() {
		return codeCritere;
	}

	public void setCodeCritere(int codeCritere) {
		this.codeCritere = codeCritere;
	}

	public Date getDateDebutCSRecord() {
		return dateDebutCSRecord;
	}

	public void setDateDebutCSRecord(Date dateDebutCSRecord) {
		this.dateDebutCSRecord = dateDebutCSRecord;
	}

	public Date getDateFinCSRecord() {
		return dateFinCSRecord;
	}

	public void setDateFinCSRecord(Date dateFinCSRecord) {
		this.dateFinCSRecord = dateFinCSRecord;
	}

	public int getFkAppli() {
		return fkAppli;
	}

	public void setFkAppli(int fkAppli) {
		this.fkAppli = fkAppli;
	}

	public int getFkFonct() {
		return fkFonct;
	}

	public void setFkFonct(int fkFonct) {
		this.fkFonct = fkFonct;
	}

	public int getFkSFonct() {
		return fkSFonct;
	}

	public void setFkSFonct(int fkSFonct) {
		this.fkSFonct = fkSFonct;
	}

	public int getFkExigence() {
		return fkExigence;
	}

	public void setFkExigence(int fkExigence) {
		this.fkExigence = fkExigence;
	}

	public String getNomAppli() {
		return nomAppli;
	}

	public void setNomAppli(String nomAppli) {
		this.nomAppli = nomAppli;
	}

	public String getNomFonct() {
		return nomFonct;
	}

	public void setNomFonct(String nomFonct) {
		this.nomFonct = nomFonct;
	}

	public String getNomSFonct() {
		return nomSFonct;
	}

	public void setNomSFonct(String nomSFonct) {
		this.nomSFonct = nomSFonct;
	}

	public String getNomExigence() {
		return nomExigence;
	}

	public void setNomExigence(String nomExigence) {
		this.nomExigence = nomExigence;
	}
	
	
}
