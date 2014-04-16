package model;

public class prioriteArbre {
	int idPriorite;
	String nomPriorite;
	
	public prioriteArbre(int idPriorite, String nomPriorite) {
		super();
		this.idPriorite = idPriorite;
		this.nomPriorite = nomPriorite;
	}
	
	public prioriteArbre() {
		super();
	}

	public int getIdPriorite() {
		return idPriorite;
	}
	public void setIdPriorite(int idPriorite) {
		this.idPriorite = idPriorite;
	}
	public String getNomPriorite() {
		return nomPriorite;
	}
	public void setNomPriorite(String nomPriorite) {
		this.nomPriorite = nomPriorite;
	}
	
	
}