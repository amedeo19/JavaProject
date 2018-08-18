package view.view;

import java.io.IOException;

import controller.Controller;
import javafx.stage.Stage;
import model.board.Coordinate;
import model.pawns.Pawns;

public interface View {

	
	void start();
	
	
	void startMenu(Stage stage) throws IOException;
	
	
	void startRace();
	
	
	void update(Pawns pawn, Coordinate coordinate);
	
	
	void setController(Controller controller);
	
	
}
