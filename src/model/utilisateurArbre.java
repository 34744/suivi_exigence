package model;

public class utilisateurArbre {

	private int idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String numUlis;
	private String mailUtilisateur;
	private String utilisateurActif;
	private String utilisateurDirection;
	private String utilisateurDG;
	public utilisateurArbre(){
		super();
	}
	
	public utilisateurArbre (int idUtilisateur, String nomUtilisateur, String prenomUtilisateur,
			String numUlis, String mailUtilisateur, String utilisateurActif, String utilisateurDirection, String utilisateurDG){
		super();
		this.idUtilisateur=idUtilisateur;
		this.nomUtilisateur=nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.numUlis = numUlis;
		this.mailUtilisateur = mailUtilisateur;
		this.utilisateurActif=utilisateurActif;
		this.utilisateurDirection=utilisateurDirection;
		this.utilisateurDG=utilisateurDG;
	}

	

	

	public String getUtilisateurDirection() {
		return utilisateurDirection;
	}

	public void setUtilisateurDirection(String utilisateurDirection) {
		this.utilisateurDirection = utilisateurDirection;
	}

	public String getUtilisateurDG() {
		return utilisateurDG;
	}

	public void setUtilisateurDG(String utilisateurDG) {
		this.utilisateurDG = utilisateurDG;
	}

	public String getUtilisateurActif() {
		return utilisateurActif;
	}

	public void setUtilisateurActif(String utilisateurActif) {
		this.utilisateurActif = utilisateurActif;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public String getNumUlis() {
		return numUlis;
	}

	public void setNumUlis(String numUlis) {
		this.numUlis = numUlis;
	}

	public String getMailUtilisateur() {
		return mailUtilisateur;
	}

	public void setMailUtilisateur(String mailUtilisateur) {
		this.mailUtilisateur = mailUtilisateur;
	}

}
