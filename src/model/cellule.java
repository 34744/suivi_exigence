package model;

public class cellule {

	private int idCellule;
	private String nomCellule;
	
	public cellule(){
		super();
	}
	
	public cellule(int idCellule, String nomCellule){
		super();
		this.idCellule=idCellule;
		this.nomCellule=nomCellule;
	}

	public int getIdCellule() {
		return idCellule;
	}

	public void setIdCellule(int idCellule) {
		this.idCellule = idCellule;
	}

	public String getNomCellule() {
		return nomCellule;
	}

	public void setNomCellule(String nomCellule) {
		this.nomCellule = nomCellule;
	}
	
}
