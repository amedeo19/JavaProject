package view.board2;

import controller.Controller;
import javafx.fxml.Initializable;
import view.view.ViewGuiImpl;

public interface Gui extends Initializable{

	public void SetText();
	
	public void RollDice();
	
	public void setView(ViewGuiImpl view);
	
	public void setController(Controller controller);
	
}
