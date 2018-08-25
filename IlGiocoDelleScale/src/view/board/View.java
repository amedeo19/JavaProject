package view.board;

import controller.Controller;
import javafx.fxml.Initializable;
import utilities.Coordinate;
import view.view.ViewGuiImpl;

public interface View extends Initializable{

	public void SetText();
	
	public void RollDice();
	
	public void setView(ViewGuiImpl view);
	
	public void setController(Controller controller);

	public void restart();
	
	public void exit();
	
	public void end();
	
	public void setImageDice();

	public void update(int turn, Coordinate NewCoordinate);
	
}
