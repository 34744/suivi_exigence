package model;

public class utilisateur {
	private String nomUtilisateur, prenomUtilisateur, mailUtilisateur, numUlis, actifUtilisateur,  utilisateurDG;
	private int idUtilisateur, utilisateurDirection;
	public utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String numUlis, String mailUtilisateur, String actifUtilisateur, int utilisateurDirection, String utilisateurDG) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.numUlis=numUlis;
		this.mailUtilisateur = mailUtilisateur;
		this.actifUtilisateur=actifUtilisateur;
		this.utilisateurDirection=utilisateurDirection;
		}
	


	public int getUtilisateurDirection() {
		return utilisateurDirection;
	}



	public void setUtilisateurDirection(int utilisateurDirection) {
		this.utilisateurDirection = utilisateurDirection;
	}



	public String getUtilisateurDG() {
		return utilisateurDG;
	}


	public void setUtilisateurDG(String utilisateurDG) {
		this.utilisateurDG = utilisateurDG;
	}


	public String getActifUtilisateur() {
		return actifUtilisateur;
	}

	public void setActifUtilisateur(String actifUtilisateur) {
		this.actifUtilisateur = actifUtilisateur;
	}

	public String getNumUlis() {
		return numUlis;
	}

	public void setNumUlis(String numUlis) {
		this.numUlis = numUlis;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getMailUtilisateur() {
		return mailUtilisateur;
	}

	public void setMailUtilisateur(String mailUtilisateur) {
		this.mailUtilisateur = mailUtilisateur;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public utilisateur() {
		super();
		}
	
	
	} 
