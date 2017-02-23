package ca.mcgill.ecse223.tileo.application;

import ca.mcgill.ecse223.tileo.model.*;
import ca.mcgill.ecse223.tileo.view.TileOPage;


public class TileOApplication {
	private static TileO tileO;
	
	public static void main(String args[]){
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TileOPage().setVisible(true);
            }
        });
	}
	
	public static Game getCurrentGame(){
		return tileO.getCurrentGame();
	}
	
	//Thomas generated - on advice of Berk in tutorial
	public static boolean setCurrentGame(Game aNewCurrentGame){
		return tileO.setCurrentGame(aNewCurrentGame);
	}
	
	public static void save() {
		//Use to save
	}
	
	public static void load() {
		//Use to load
	}
}
