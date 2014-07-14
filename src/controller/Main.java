package controller;

import java.io.IOException;

import model.GestionLog;
import model.completude;
import view.accueil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("coucou");
		// TODO Auto-generated method stub

		//view.Connection connect = new view.Connection();
		/*Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(new String []{"C:\\MovAmp\\movamp.exe"});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	/*	model.getData.getMarche();
		model.getData.getApplication();
		model.getData.getCellule();
		model.getData.getCompoCellule();*/
		System.setProperty( "file.encoding", "UTF-8" ); 
		GestionLog.lancementApplication();
	//	completude.test();
		view.Connection connection = new view.Connection();
	//	view.mainJFrame main = new view.mainJFrame();
		
	}

}
