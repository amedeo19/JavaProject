package view.view;

import java.io.IOException;
import controller.Controller;
import enumeration.Characters;
import javafx.stage.Stage;

public interface View {

	
	/**
	 * Inizialize game view
	 * @throws IOException
	 */
	void start() throws IOException;
	
	
	/**
	 * Back to menu
	 * @param stage 
	 * @throws IOException
	 */
	void startMenu(Stage stage) throws IOException;
	
	
	
	/**
	 * method to set the correct controller
	 * @param controller the controller parameter to pass
	 */
	void setController(Controller controller);
	
	
	/**
	 * Restart game
	 */
	public void restart();
	
	
	/**
	 * Open the end view
	 */
	public void end();
	
	
	/**
	 * method to set the correct winner
	 * @param character the character parameter to pass
	 */
	public void setWinner(Characters character);
	
	
}
