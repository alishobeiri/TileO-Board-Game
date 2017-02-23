package ca.mcgill.ecse223.tileo.application;

import ca.mcgill.ecse223.tileo.persistence.PersistenceObjectStream;
import ca.mcgill.ecse223.tileo.model.*;
import ca.mcgill.ecse223.tileo.view.BoardPanel;
import ca.mcgill.ecse223.tileo.view.DeckPanel;
import ca.mcgill.ecse223.tileo.view.GamePage;
import ca.mcgill.ecse223.tileo.view.TileOPage;


public class TileOApplication {
	private static TileO tileO;
	
	public static void main(String args[]){
		// Thomas - not actually sure this is the right way to do this
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TileOPage().setVisible(true);
                //TODO remove following line after testing
                new GamePage().setVisible(true);
                
                Game game = tileO.getCurrentGame();
                game.rollDie();

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

		// Thomas - not sure this is right, copied from btms, also copied persistence java file
		PersistenceObjectStream.serialize(tileO);
	}
	
	// TODO basically copy the code from BTMS
	public static void load() {
		//Use to load
	}
}
