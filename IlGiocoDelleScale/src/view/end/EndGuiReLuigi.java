package view.end;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import view.view.View;
import view.view.ViewGuiImpl;

public class EndGuiReLuigi implements EndGui{

	@FXML
	private Button exit;
	
	@FXML
	private Button restart;
	
	
	private View view;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.exit.setVisible(true);
		this.restart.setVisible(true);
	}

	
	public void exit() {
		System.exit(0);
	}
	
	public void restart() {
		this.view.restart();
	}


	@Override
	public void setView(ViewGuiImpl view) {
		this.view = view;
	}


	
}
