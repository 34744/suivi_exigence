package model;

public class pointMaj {

	int idPoint;
	String nomPoint;
	String descriptionPoint;
	String solutionPoint;
	int fkMiseAJour;
	int fkOrigine;
	String originePrecision;
	Boolean testFinalise;
	
	public pointMaj() {
		super();
	}

	public pointMaj(int idPoint, String nomPoint, String descriptionPoint,
			String solutionPoint, int fkMiseAJour, int fkOrigine, String originePrecision, 
			 Boolean testFinalise) {
		super();
		this.idPoint = idPoint;
		this.nomPoint = nomPoint;
		this.descriptionPoint = descriptionPoint;
		this.solutionPoint = solutionPoint;
		this.fkMiseAJour = fkMiseAJour;
		this.fkOrigine = fkOrigine;
		this.testFinalise = testFinalise;
		this.originePrecision=originePrecision;
	}

	public int getIdPoint() {
		return idPoint;
	}

	public void setIdPoint(int idPoint) {
		this.idPoint = idPoint;
	}

	public String getNomPoint() {
		return nomPoint;
	}

	public void setNomPoint(String nomPoint) {
		this.nomPoint = nomPoint;
	}

	public String getDescriptionPoint() {
		return descriptionPoint;
	}

	public void setDescriptionPoint(String descriptionPoint) {
		this.descriptionPoint = descriptionPoint;
	}

	public String getSolutionPoint() {
		return solutionPoint;
	}

	public void setSolutionPoint(String solutionPoint) {
		this.solutionPoint = solutionPoint;
	}

	public int getFkMiseAJour() {
		return fkMiseAJour;
	}

	public void setFkMiseAJour(int fkMiseAJour) {
		this.fkMiseAJour = fkMiseAJour;
	}

	public int getFkOrigine() {
		return fkOrigine;
	}

	public void setFkOrigine(int fkOrigine) {
		this.fkOrigine = fkOrigine;
	}

	public Boolean getTestFinalise() {
		return testFinalise;
	}

	public void setTestFinalise(Boolean testFinalise) {
		this.testFinalise = testFinalise;
	}

	public String getOriginePrecision() {
		return originePrecision;
	}

	public void setOriginePrecision(String originePrecision) {
		this.originePrecision = originePrecision;
	}
	
	
}
