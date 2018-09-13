package view.end;

import javafx.fxml.Initializable;
import view.view.ViewGuiImpl;

public interface EndGui extends Initializable {

	/**
	 * method to set the correct view
	 * @param view the view parameter to pass
	 */
	public void setView(ViewGuiImpl view);
	
	/**
	 * Back to menu
	 */
	public void restart();
	
	/**
	 * Close application
	 */
	public void exit();
}
