package model;

public class directionGeneraleArbre {
	private String nomDirectionGenerale, visibiliteDg;
	private int idDirectionGenerale;
	
	public directionGeneraleArbre(int idDirectionGenerale, String nomDirectionDirection, String visibiliteDg){
		super();
		this.idDirectionGenerale=idDirectionGenerale;
		this.nomDirectionGenerale=nomDirectionDirection;
		this.visibiliteDg=visibiliteDg;
	}
	
	public directionGeneraleArbre(){
		super();
	}

	public String getVisibiliteDg() {
		return visibiliteDg;
	}

	public void setVisibiliteDg(String visibiliteDg) {
		this.visibiliteDg = visibiliteDg;
	}

	public String getNomDirectionGenerale() {
		return nomDirectionGenerale;
	}

	public void setNomDirectionGenerale(String nomDirectionGenerale) {
		this.nomDirectionGenerale = nomDirectionGenerale;
	}

	public int getIdDirectionGenerale() {
		return idDirectionGenerale;
	}

	public void setIdDirectionGenerale(int idDirectionGenerale) {
		this.idDirectionGenerale = idDirectionGenerale;
	}
}
