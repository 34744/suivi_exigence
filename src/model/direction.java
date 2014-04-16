package model;

public class direction {
	private String nomDirection, nomDG, visibiliteDirection;
	private int idDirection, idDG;
	
	public direction(int idDirection, String nomDirection, String nomDG, int idDG, String visibiliteDirection){
		super();
		this.idDirection=idDirection;
		this.nomDirection=nomDirection;
		this.nomDG=nomDG;
		this.idDG=idDG;
		this.visibiliteDirection=visibiliteDirection;
	}
	
	public String getNomDG() {
		return nomDG;
	}

	public void setNomDG(String nomDG) {
		this.nomDG = nomDG;
	}

	public String getVisibiliteDirection() {
		return visibiliteDirection;
	}

	public void setVisibiliteDirection(String visibiliteDirection) {
		this.visibiliteDirection = visibiliteDirection;
	}

	public direction(){
		super();
	}

	public String getNomDirection() {
		return nomDirection;
	}

	public void setNomDirection(String nomDirection) {
		this.nomDirection = nomDirection;
	}

	public int getIdDirection() {
		return idDirection;
	}

	public void setIdDirection(int idDirection) {
		this.idDirection = idDirection;
	}

	public int getIdDG() {
		return idDG;
	}

	public void setIdDG(int idDG) {
		this.idDG = idDG;
	}
}
