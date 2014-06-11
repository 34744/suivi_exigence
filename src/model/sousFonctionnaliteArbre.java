package model;

import java.util.Date;

public class sousFonctionnaliteArbre {
	private int idSousFonct;
	private String nomSFonct;
	private Date dateDebutSFonct;
	private Date dateFinSFonct;
	private String numSFonct;
	private String codeSFonct;
	private Date dateDebutSFRecord;
	private Date dateFinSFRecord;
	private int fkFonct;
	private int fkAppli;
	private String nomFonct;
	private String nomAppli;
	private int versionSFonct; 
	
	public int getVersionSFonct() {
		return versionSFonct;
	}

	public void setVersionSFonct(int versionSFonct) {
		this.versionSFonct = versionSFonct;
	}

	public sousFonctionnaliteArbre() {
		super();
	}

	public sousFonctionnaliteArbre(int idSousFonct, String nomSFonct,
			Date dateDebutSFonct, Date dateFinSFonct, String numSFonct,
			String codeSFonct, Date dateDebutSFRecord, Date dateFinSFRecord,
			int fkFonct, int fkAppli, String nomFonct, String nomAppli) {
		super();
		this.idSousFonct = idSousFonct;
		this.nomSFonct = nomSFonct;
		this.dateDebutSFonct = dateDebutSFonct;
		this.dateFinSFonct = dateFinSFonct;
		this.numSFonct = numSFonct;
		this.codeSFonct = codeSFonct;
		this.dateDebutSFRecord = dateDebutSFRecord;
		this.dateFinSFRecord = dateFinSFRecord;
		this.fkFonct = fkFonct;
		this.fkAppli = fkAppli;
		this.nomFonct = nomFonct;
		this.nomAppli = nomAppli;
	}

	public int getIdSousFonct() {
		return idSousFonct;
	}

	public void setIdSousFonct(int idSousFonct) {
		this.idSousFonct = idSousFonct;
	}

	public String getNomSFonct() {
		return nomSFonct;
	}

	public void setNomSFonct(String nomSFonct) {
		this.nomSFonct = nomSFonct;
	}

	public Date getDateDebutSFonct() {
		return dateDebutSFonct;
	}

	public void setDateDebutSFonct(Date dateDebutSFonct) {
		this.dateDebutSFonct = dateDebutSFonct;
	}

	public Date getDateFinSFonct() {
		return dateFinSFonct;
	}

	public void setDateFinSFonct(Date dateFinSFonct) {
		this.dateFinSFonct = dateFinSFonct;
	}

	public String getNumSFonct() {
		return numSFonct;
	}

	public void setNumSFonct(String numSFonct) {
		this.numSFonct = numSFonct;
	}

	public String getCodeSFonct() {
		return codeSFonct;
	}

	public void setCodeSFonct(String codeSFonct) {
		this.codeSFonct = codeSFonct;
	}

	public Date getDateDebutSFRecord() {
		return dateDebutSFRecord;
	}

	public void setDateDebutSFRecord(Date dateDebutSFRecord) {
		this.dateDebutSFRecord = dateDebutSFRecord;
	}

	public Date getDateFinSFRecord() {
		return dateFinSFRecord;
	}

	public void setDateFinSFRecord(Date dateFinSFRecord) {
		this.dateFinSFRecord = dateFinSFRecord;
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
	
	
}
	
	
	