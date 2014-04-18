package model;

public class critereSucces {

	private int idCritere;
	private String nomCritere;
	private String dateDebutCritere;
	private String dateFinCritere;
	private String numCritere;
	private int codeCritere;
	private String dateDebutCSRecord;
	private String dateFinCSRecord;
	private int fkExigence;
	
	public critereSucces() {
		super();
	}

	public critereSucces(int idCritere, String nomCritere,
			String dateDebutCritere, String dateFinCritere, String numCritere,
			int codeCritere, String dateDebutCSRecord, String dateFinCSRecord,
			int fkExigence) {
		super();
		this.idCritere = idCritere;
		this.nomCritere = nomCritere;
		this.dateDebutCritere = dateDebutCritere;
		this.dateFinCritere = dateFinCritere;
		this.numCritere = numCritere;
		this.codeCritere = codeCritere;
		this.dateDebutCSRecord = dateDebutCSRecord;
		this.dateFinCSRecord = dateFinCSRecord;
		this.fkExigence = fkExigence;
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

	public String getDateDebutCritere() {
		return dateDebutCritere;
	}

	public void setDateDebutCritere(String dateDebutCritere) {
		this.dateDebutCritere = dateDebutCritere;
	}

	public String getDateFinCritere() {
		return dateFinCritere;
	}

	public void setDateFinCritere(String dateFinCritere) {
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

	public String getDateDebutCSRecord() {
		return dateDebutCSRecord;
	}

	public void setDateDebutCSRecord(String dateDebutCSRecord) {
		this.dateDebutCSRecord = dateDebutCSRecord;
	}

	public String getDateFinCSRecord() {
		return dateFinCSRecord;
	}

	public void setDateFinCSRecord(String dateFinCSRecord) {
		this.dateFinCSRecord = dateFinCSRecord;
	}

	public int getFkExigence() {
		return fkExigence;
	}

	public void setFkExigence(int fkExigence) {
		this.fkExigence = fkExigence;
	}
	
}
