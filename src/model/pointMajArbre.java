package model;

public class pointMajArbre {
	int idPoint;
	String nomPoint;
	String descriptionPoint;
	String solutionPoint;
	int fkMiseAJour;
	int fkOrigine;
	String nomOrigine;
	String originePrecision;
	int fkRisque;
	String nomRisque;
	int nombreTest;
	int nombreTestEffectue;
	Boolean testFinalise;
	
	public pointMajArbre(int idPoint, String nomPoint, String descriptionPoint,
			String solutionPoint, int fkMiseAJour, int fkOrigine,
			String nomOrigine, String originePrecision, int fkTest, int fkRisque, String nomRisque,
			int nombreTest, int nombreTestEffectue, Boolean testFinalise) {
		super();
		this.idPoint = idPoint;
		this.nomPoint = nomPoint;
		this.descriptionPoint = descriptionPoint;
		this.solutionPoint = solutionPoint;
		this.fkMiseAJour = fkMiseAJour;
		this.fkOrigine = fkOrigine;
		this.nomOrigine = nomOrigine;
		this.originePrecision=originePrecision;
		this.fkRisque = fkRisque;
		this.nomRisque = nomRisque;
		this.nombreTest = nombreTest;
		this.nombreTestEffectue = nombreTestEffectue;
		this.testFinalise = testFinalise;
	}

	public pointMajArbre(int idPoint, String nomPoint, String descriptionPoint,
			String solutionPoint, int fkMiseAJour, int fkOrigine, String originePrecision,
			int fkRisque, Boolean testFinalise) {
		super();
		this.idPoint = idPoint;
		this.nomPoint = nomPoint;
		this.descriptionPoint = descriptionPoint;
		this.solutionPoint = solutionPoint;
		this.fkMiseAJour = fkMiseAJour;
		this.fkOrigine = fkOrigine;
		this.originePrecision=originePrecision;
		this.fkRisque = fkRisque;
		this.testFinalise = testFinalise;
	}
	
	
	



	public pointMajArbre() {
		super();
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
	public int getFkRisque() {
		return fkRisque;
	}
	public void setFkRisque(int fkRisque) {
		this.fkRisque = fkRisque;
	}
	public Boolean getTestFinalise() {
		return testFinalise;
	}
	public void setTestFinalise(Boolean testFinalise) {
		this.testFinalise = testFinalise;
	}

	public String getNomOrigine() {
		return nomOrigine;
	}

	public void setNomOrigine(String nomOrigine) {
		this.nomOrigine = nomOrigine;
	}

	public String getNomRisque() {
		return nomRisque;
	}

	public void setNomRisque(String nomRisque) {
		this.nomRisque = nomRisque;
	}

	public int getNombreTest() {
		return nombreTest;
	}

	public void setNombreTest(int nombreTest) {
		this.nombreTest = nombreTest;
	}

	public int getNombreTestEffectue() {
		return nombreTestEffectue;
	}

	public void setNombreTestEffectue(int nombreTestEffectue) {
		this.nombreTestEffectue = nombreTestEffectue;
	}

	public String getOriginePrecision() {
		return originePrecision;
	}

	public void setOriginePrecision(String originePrecision) {
		this.originePrecision = originePrecision;
	}
	
	
}
