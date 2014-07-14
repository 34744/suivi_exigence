package model;

public class application {

	private int idApplication;
	private String nomApplication;
	private String visibiliteApplication;
	
	public application (int idApplication, String nomApplication, String visibiliteApplication){
		super();
		GestionLog.arriveeMethode(this.getClass().getName()+" "+ getClass().getMethods());
		this.idApplication=idApplication;
		this.nomApplication=nomApplication;
		this.visibiliteApplication=visibiliteApplication;
		GestionLog.sortieMethode(this.getClass().getName()+" "+ getClass().getMethods());
		}

	public String isVisibiliteApplication() {
		return visibiliteApplication;
	}

	public void setVisibiliteApplication(String visibiliteApplication) {
		this.visibiliteApplication = visibiliteApplication;
	}

	public String getVisibiliteApplication() {
		return visibiliteApplication;
	}

	public application() {
		// TODO Auto-generated constructor stub
	super();
	}

	public int getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(int idApplication) {
		this.idApplication = idApplication;
	}

	public String getNomApplication() {
		return nomApplication;
	}

	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}
	
	
}
