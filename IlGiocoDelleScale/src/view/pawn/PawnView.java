package view.pawn;


import javafx.fxml.Initializable;
import model.board.Coordinate;

public interface PawnView extends Initializable{
	
	public void update(Coordinate coordinate);
	
}
