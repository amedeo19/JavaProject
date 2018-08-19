package view.end;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.start.GuiImpl;

public class EndGuiMowgli implements Initializable {

	private static final String PATH = "file://../src/view/start/Start.fxml";
	private Stage stage;
	private Controller controller = new ControllerImpl();
	
	@FXML
	private Button Exit;
	
	@FXML
	private Button Return;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.Exit.setVisible(true);
		this.Return.setVisible(true);
	}

	
	public void Exit() {
		System.exit(0);
	}
	
	public void Return() throws Exception {
		this.close();
		Platform.runLater(() -> {
            try {
                this.controller.startController();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
				e.printStackTrace();
			} 
        });
	}
	
	private void close() {
		Stage stage = (Stage) Return.getScene().getWindow();
	    stage.hide();
	}
	




	
}
