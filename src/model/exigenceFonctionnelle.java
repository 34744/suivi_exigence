package model;

public class exigenceFonctionnelle {

	private int idExigence;
	private String nomExigence;
	private String descriptionExigence;
	private String raisonExigence;
	private int prioriteExigence;
	private String dateDebutExi;
	private String dateFinExi;
	private String numExi;
	private int codeExigence;
	private String dateDebutEFRecord;
	private String dateFinEFRecord;
	private int fkSFonct;
	
	public exigenceFonctionnelle() {
		super();
	}

	public exigenceFonctionnelle(int codeExigence) {
		super();
		this.codeExigence=codeExigence;
	}
	
	public exigenceFonctionnelle(int idExigence, String nomExigence,
			String descriptionExigence, String raisonExigence,
			int prioriteExigence, String dateDebutExi, String dateFinExi,
			String numExi, int codeExigence, String dateDebutEFRecord,
			String dateFinEFRecord, int fkSFonct) {
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

	public String getDateDebutExi() {
		return dateDebutExi;
	}

	public void setDateDebutExi(String dateDebutExi) {
		this.dateDebutExi = dateDebutExi;
	}

	public String getDateFinExi() {
		return dateFinExi;
	}

	public void setDateFinExi(String dateFinExi) {
		this.dateFinExi = dateFinExi;
	}

	public String getNumExi() {
		return numExi;
	}

	public void setNumExi(String numExi) {
		this.numExi = numExi;
	}

	public int getCodeExigence() {
		return codeExigence;
	}

	public void setCodeExigence(int codeExigence) {
		this.codeExigence = codeExigence;
	}

	public String getDateDebutEFRecord() {
		return dateDebutEFRecord;
	}

	public void setDateDebutEFRecord(String dateDebutEFRecord) {
		this.dateDebutEFRecord = dateDebutEFRecord;
	}

	public String getDateFinEFRecord() {
		return dateFinEFRecord;
	}

	public void setDateFinEFRecord(String dateFinEFRecord) {
		this.dateFinEFRecord = dateFinEFRecord;
	}

	public int getFkSFonct() {
		return fkSFonct;
	}

	public void setFkSFonct(int fkSFonct) {
		this.fkSFonct = fkSFonct;
	}
	
	
	
}
