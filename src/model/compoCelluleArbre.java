package model;

import java.sql.Date;

public class compoCelluleArbre {

	private int idCellule, idUtilisateur;
	private Date dateDebutCellule, dateFinCellule;
	private String nomCellule, numUlis;
	
	public compoCelluleArbre (){
		super();

	}
	
	public String getNumUlis() {
		return numUlis;
	}

	public void setNumUlis(String numUlis) {
		this.numUlis = numUlis;
	}

	public compoCelluleArbre (String numUlis){
		super();
		this.numUlis=numUlis;
	}
	
	
	public compoCelluleArbre (int idCellule, int idUtilisateur, Date dateDebutCellule, Date dateFinCellule){
		super();
		
		this.idCellule=idCellule;
		this.idUtilisateur=idUtilisateur;
		this.dateDebutCellule=dateDebutCellule;
		this.dateFinCellule=dateFinCellule;
				
	}
	
	public compoCelluleArbre (String nomCellule, int idUtilisateur, Date dateDebutCellule, Date dateFinCellule){
		super();
		
		this.nomCellule=nomCellule;
		this.idUtilisateur=idUtilisateur;
		this.dateDebutCellule=dateDebutCellule;
		this.dateFinCellule=dateFinCellule;
				
	}

	public int getIdCellule() {
		return idCellule;
	}

	public void setIdCellule(int idCellule) {
		this.idCellule = idCellule;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomCellule() {
		return nomCellule;
	}

	public void setNomCellule(String nomCellule) {
		this.nomCellule = nomCellule;
	}

	public int getFkCellule() {
		return idCellule;
	}

	public void setFkCellule(int fkCellule) {
		this.idCellule = fkCellule;
	}

	public int getFkUtilisateur() {
		return idUtilisateur;
	}

	public void setFkUtilisateur(int fkUtilisateur) {
		this.idUtilisateur = fkUtilisateur;
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

	public compoCelluleArbre elementAt(int row) {
		// TODO Auto-generated method stub
		return null;
	}
}
