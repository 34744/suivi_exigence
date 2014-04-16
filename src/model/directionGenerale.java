package model;

public class directionGenerale {
	private String nomDirectionGenerale, visibiliteDg;
	private int idDirectionGenerale;
	
	public directionGenerale(int idDirectionGenerale, String nomDirectionGenerale, String visibiliteDg){
		super();
		this.idDirectionGenerale=idDirectionGenerale;
		this.nomDirectionGenerale=nomDirectionGenerale;
		this.visibiliteDg=visibiliteDg;
		
	}

	public directionGenerale() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNomDirection() {
		return nomDirectionGenerale;
	}

	public void setNomDirection(String nomDirection) {
		this.nomDirectionGenerale = nomDirection;
	}

	public int getIdDirection() {
		return idDirectionGenerale;
	}

	public void setIdDirection(int idDirection) {
		this.idDirectionGenerale = idDirection;
	}

	public void setVisibiliteDG(String visibiliteDg) {
		// TODO Auto-generated method stub
		this.visibiliteDg=visibiliteDg;
	}

	public String getNomDirectionGenerale() {
		return nomDirectionGenerale;
	}

	public void setNomDirectionGenerale(String nomDirectionGenerale) {
		this.nomDirectionGenerale = nomDirectionGenerale;
	}

	public String getVisibiliteDg() {
		return visibiliteDg;
	}

	public void setVisibiliteDg(String visibiliteDg) {
		this.visibiliteDg = visibiliteDg;
	}

	public int getIdDirectionGenerale() {
		return idDirectionGenerale;
	}

	public void setIdDirectionGenerale(int idDirectionGenerale) {
		this.idDirectionGenerale = idDirectionGenerale;
	}
}
