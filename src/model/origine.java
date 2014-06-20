package model;

public class origine {
int idOrigine;
String nomOrigine;

public origine(int idOrigine, String nomOrigine) {
	super();
	this.idOrigine = idOrigine;
	this.nomOrigine = nomOrigine;
}

public origine() {
	super();
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

}
