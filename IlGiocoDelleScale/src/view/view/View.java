package view.view;

import java.io.IOException;
import controller.Controller;
import enumeration.Characters;
import javafx.stage.Stage;

public interface View {

	
	void start() throws IOException;
	
	
	void startMenu(Stage stage) throws IOException;
	
	
	
	void setController(Controller controller);
	
	
	public void restart();
	
	
	public void end();
	
	
	public void setWinner(Characters character);
	
	
}
