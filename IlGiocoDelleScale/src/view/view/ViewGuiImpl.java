package view.view;

import java.io.IOException;
import controller.Controller;
import controller.ControllerImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.pawns.Pawns;
import utilities.Coordinate;
import view.board.ViewImpl;
import view.end.EndGuiBaloo;
import view.start.Gui;
import view.start.Menu;

public class ViewGuiImpl implements View{

	private static final String FXML_PATH_VIEW = "/view/board/BoardEasy.fxml";
	private static final String FXML_PATH_MENU = "/view/start/Start.fxml";
	private static final String FXML_PATH_END_BALOO = "/view/end/EndBaloo.fxml";
	private Stage stage = new Stage();
	private Menu gui = new Gui();
	private view.board.View guiBoard = new ViewImpl();
	private Controller controller;
	
	private view.end.EndGui end = new EndGuiBaloo();
	
	public ViewGuiImpl() {
		this.guiBoard.setView(this);
		this.end.setView(this);
	}
	
	
	@Override
	public void start() throws IOException {
		this.startView(FXML_PATH_VIEW);
	}

	@Override
	public void startMenu(Stage stage) throws IOException {
		this.stage = stage;
		this.startView(FXML_PATH_MENU);
	}


	@Override
	public void update(Pawns pawn, Coordinate coordinate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(Controller controller) {
		this.controller=controller;
	}
	
	@Override
	public void restart() {
		try {
			this.startMenu(this.stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void startView(final String path) throws IOException  {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        final Parent root = loader.load();
        stage.setTitle("Snake N Ladder");
        if (stage.getScene() == null) {
            stage.setScene(new Scene(root));
        } else {
            stage.getScene().setRoot(root);
        }
        if (loader.getController() instanceof ViewImpl) {
            this.guiBoard = loader.getController();
    		this.guiBoard.setController(controller);
    		this.guiBoard.setView(this);
            stage.setFullScreen(false);
        } else if (loader.getController() instanceof Gui){
            this.gui = loader.getController();
            this.gui.setViewGuiImpl(this);
            stage.setFullScreen(false);
            stage.centerOnScreen();
            stage.sizeToScene();
        } else {
        	this.end = loader.getController();
        	this.end.setView(this);
        	stage.setFullScreen(false);
            stage.centerOnScreen();
            stage.sizeToScene();
        }
        stage.show();
    }
	
	
	public void end() {
		try {
			this.startView(FXML_PATH_END_BALOO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
