package view.view;

import java.io.IOException;

import controller.Controller;
import javafx.stage.Stage;
import model.pawns.Pawns;
import utilities.Coordinate;

public interface View {

	
	void start();
	
	
	void startMenu(Stage stage) throws IOException;
	
	
	void startRace();
	
	
	void update(Pawns pawn, Coordinate coordinate);
	
	
	void setController(Controller controller);
	
	
}
