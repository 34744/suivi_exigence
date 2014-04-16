package model;

public class applicationArbre {

		private int IdApplication;
		private String NomApplication;
		private String visibiliteApplication;
		
		public applicationArbre(){
			super();
		}
		
		public applicationArbre (int idApplication, String nomApplication, String visibiliteApplication){
			super();
			this.IdApplication=idApplication;
			this.NomApplication=nomApplication;
			this.visibiliteApplication=visibiliteApplication;
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

		public int getIdApplication() {
			return IdApplication;
		}

		public void setIdApplication(int idApplication) {
			IdApplication = idApplication;
		}

		public String getNomApplication() {
			return NomApplication;
		}

		public void setNomApplication(String nomApplication) {
			NomApplication = nomApplication;
		}
		
		
}
