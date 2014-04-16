package model;

public class sousFonctionnalite {

	private int idSousFonct;
	private String nomSFonct;
	private String dateDebutSFonct;
	private String dateFinSFonct;
	private String numSFonct;
	private int codeSFonct;
	private String dateDebutSFRecord;
	private String dateFinSFRecord;
	
	public int getCodeSFonct() {
		return codeSFonct;
	}

	public void setCodeSFonct(int i) {
		this.codeSFonct = i;
	}

	public String getDateDebutSFRecord() {
		return dateDebutSFRecord;
	}

	public void setDateDebutSFRecord(String dateDebutSFRecord) {
		this.dateDebutSFRecord = dateDebutSFRecord;
	}

	public String getDateFinSFRecord() {
		return dateFinSFRecord;
	}

	public void setDateFinSFRecord(String dateFinSFRecord) {
		this.dateFinSFRecord = dateFinSFRecord;
	}

	public sousFonctionnalite(int idSousFonct, String nomSFonct,
			String dateDebutSFonct, String dateFinSFonct, String numSFonct,
			int codeSFonct, String dateDebutSFRecord,
			String dateFinSFRecord, int fkFonct) {
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
	}
	private int fkFonct;
		
	public sousFonctionnalite() {
		super();
	}
	
	public sousFonctionnalite(int idSousFonct, String nomSFonct,
			String dateDebutSFonct, String dateFinSFonct, String numSFonct,
			int fkFonct) {
		super();
		this.idSousFonct = idSousFonct;
		this.nomSFonct = nomSFonct;		
		this.dateDebutSFonct = dateDebutSFonct;
		this.dateFinSFonct = dateFinSFonct;
		this.numSFonct = numSFonct;

		this.fkFonct = fkFonct;
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
	public String getDateDebutSFonct() {
		return dateDebutSFonct;
	}
	public void setDateDebutSFonct(String dateDebutSFonct) {
		this.dateDebutSFonct = dateDebutSFonct;
	}
	public String getDateFinSFonct() {
		return dateFinSFonct;
	}
	public void setDateFinSFonct(String dateFinSFonct) {
		this.dateFinSFonct = dateFinSFonct;
	}
	public String getNumSFonct() {
		return numSFonct;
	}
	public void setNumSFonct(String numSFonct) {
		this.numSFonct = numSFonct;
	}
	public int getFkFonct() {
		return fkFonct;
	}
	public void setFkFonct(int fkFonct) {
		this.fkFonct = fkFonct;
	}
	
	
}
