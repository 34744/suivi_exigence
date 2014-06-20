package model;

public class origineArbre {
	int idOrigine;
	String nomOrigine;
	
	public origineArbre(int idOrigine, String nomOrigine) {
		super();
		this.idOrigine = idOrigine;
		this.nomOrigine = nomOrigine;
	}

	public int getIdOrigine() {
		return idOrigine;
	}

	public void setIdOrigine(int idOrigine) {
		this.idOrigine = idOrigine;
	}

	public String getNomOrigine() {
		return nomOrigine;
	}

	public void setNomOrigine(String nomOrigine) {
		this.nomOrigine = nomOrigine;
	}

	public origineArbre() {
		super();
	}
	
}
