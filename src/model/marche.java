package model;

public class marche {

	private int idMarche;
	private String nomMarche;
	
	public marche(int idMarche,String nomMarche){
		super();
		this.idMarche=idMarche;
		this.nomMarche=nomMarche;
	}

	public int getIdMarche() {
		return idMarche;
	}

	public void setIdMarche(int idMarche) {
		this.idMarche = idMarche;
	}

	public String getNomMarche() {
		return nomMarche;
	}

	public void setNomMarche(String nomMarche) {
		this.nomMarche = nomMarche;
	}
	
	
}
