package model;

import java.sql.Date;

public class celluleArbre {

	private int idCellule;
	private Date dateDebutCellule, dateFinCellule;
	private String nomCellule;
	public int getIdCellule() {
		return idCellule;
	}
	public void setIdCellule(int idCellule) {
		this.idCellule = idCellule;
	}
	public Date getDateDebutCellule() {
		return dateDebutCellule;
	}
	public void setDateDebutCellule(Date dateDebutCellule) {
		this.dateDebutCellule = dateDebutCellule;
	}
	public Date getDateFinCellule() {
		return dateFinCellule;
	}
	public void setDateFinCellule(Date dateFinCellule) {
		this.dateFinCellule = dateFinCellule;
	}
	public String getNomCellule() {
		return nomCellule;
	}
	public void setNomCellule(String nomCellule) {
		this.nomCellule = nomCellule;
	}
	
}
