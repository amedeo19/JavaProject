package view.board;

import controller.Controller;
import javafx.fxml.Initializable;
import utilities.Coordinate;
import view.view.ViewGuiImpl;

public interface View extends Initializable{

	/**
	 * Print the coordinate of Stairs and Snakes
	 */
	public void SetText();
	
	/**
	 * Roll the dice
	 */
	public void RollDice();
	
	/**
	 * @param view Is the method to set the right view
	 */
	public void setView(ViewGuiImpl view);
	
	/**
	 * @param controller Is the method to set the right controller
	 */
	public void setController(Controller controller);

	/**
	 * Restart the menù view
	 */
	public void restart();
	
	/**
	 * Close application
	 */
	public void exit();
	
	/**
	 * Call the end view
	 */
	public void end();
	
	/**
	 * is the method that show the dice in the game
	 */
	public void setImageDice();

	/**
	 * move the Pawn view
	 * @param turn change the turn of the player
	 * @param NewCoordinate set the New coordinate of a player
	 */
	public void update(int turn, Coordinate NewCoordinate);
	
}
