
package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import enumeration.Characters;
import enumeration.Dice;
import enumeration.MapDifficulty;
import enumeration.MapDimension;
import model.board.UpsideDown;
import view.board.View;

public interface Controller {

	
	/**
	 * Initialize the game
	 * @param diceList is the list of dice
	 * @param faceList is the number of face of each Dice
	 * @param Character is the list of character 
	 * @param dimension is the dimension of BoardGame
	 * @param difficulty is the difficulty of game
	 */
	public void start(final List<Dice> diceList,final List<Optional<Integer>> faceList,final List<Characters> Character,final MapDimension dimension,final MapDifficulty difficulty);
	
	/**
	 * is the method that call the roll of dice and the movements of a Pawn
	 */
	public void play();
	
	/**
	 * Set a boolean variable
	 * @throws Exception
	 */
	public void startController() throws Exception;
	
	/**
	 * @return the stair' list
	 */
	public List<UpsideDown> getStairList();
	
	/**
	 * @return the snakes' list
	 */
	public List<UpsideDown> getSnakeList();
	
	/**
	 * @return the list of dice number
	 */
	public List<Integer> getViewNumDice();
	
	/**
	 * @return the list of character
	 */
	public List<Characters> getCharacterList();
	
	/**
	 * @return the number of dice in the game
	 */
	public int getNumDice();
	
	/**
	 * @param view Is the method to set the right view
	 */
	public void setView(View view);
	
	/**
	 * Open the end view with the correct winner
	 * @throws IOException
	 */
	public void finishGame() throws IOException;

}
