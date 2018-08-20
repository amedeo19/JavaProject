package view.view;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import controller.Controller;
import controller.ControllerImpl;
import enumeration.Characters;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.dice.Dice;
import model.pawns.Pawns;
import utilities.Coordinate;
import view.start.Gui;
import view.start.GuiImpl;

public class ViewGuiImpl implements View{

	
	private static final String FXML_PATH = "file://view/start/Start.fxml";
	private static final String FXML_PATH2 ="file://..src/view/start/Start.fxml";
	private Stage stage;
	private Controller controller;
	private final Wait<Boolean> wait = new Wait<>();
	private GuiImpl gui = new GuiImpl();
	
	
	@Override
	public void start() {
        final Wait<Boolean> wait = new Wait<>();
        Platform.runLater(() -> {
            try {
				this.startView(FXML_PATH2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wait.actionPerformed(true);
        });
        wait.waitForUser();
		
	}

	@Override
	public void startMenu(Stage stage) throws IOException {
		this.stage = stage;
		try {
			this.gui.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void startView(String path) throws IOException {
//		final FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
//        final Parent root = (Parent) loader.load();
        
//        stage.setTitle("Scale e serpenti");
//        if (stage.getScene() == null) {
//            stage.setScene(new Scene(root));
//        } else {
//            stage.getScene().setRoot(root);
//        }
//        if (loader.getController() instanceof ViewGuiImpl) {
//            this.gui = loader.getController();
//            
//            stage.setFullScreen(true);
//        } else {
//            this.gui = loader.getController();
//            stage.setFullScreen(false);
//            stage.centerOnScreen();
//            stage.sizeToScene();
//        }
//        stage.show();
		
	}


	@Override
	public void update(Pawns pawn, Coordinate coordinate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	
	public void restart() {
		Platform.runLater(() -> {
            try {
                this.startMenu(this.stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wait.actionPerformed(true);
        });
	}
	
	

}
