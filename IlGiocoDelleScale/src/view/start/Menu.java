package view.start;

import javafx.fxml.Initializable;
import view.view.ViewGuiImpl;

/**
 * Interface for the view of the game.
 */
public interface Menu extends Initializable {
	/**
	 * set initial parameters and call pawn choices menu
	 */
	public void SelectPawns();
	/**
	 * close application
	 */
	public void Exit();
	/**
	 * method to set the right number of dices
	 */
	public void Update();
	/**
	 * method to confirm dice selection and enable multiface inputbox
	 */
	public void Update1();
	/**
	 * return to the initial menu
	 */
	public void Back();
	/**
	 * confirm character selection and pass to the dice selection menu
	 */
	public void SelectDice();
	/**
	 * initialize game
	 */
	public void StartGame();
	/**
	 * method to set the correct controller to the view
	 * @param view the view parameter to pass
	 */
	public void setViewGuiImpl(ViewGuiImpl view);
}
