package model;

public class priorite {

	int idPriorite;
	String nomPriorite;
	
	public priorite(int idPriorite, String nomPriorite) {
		super();
		this.idPriorite = idPriorite;
		this.nomPriorite = nomPriorite;
	}
	
	public priorite() {
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
