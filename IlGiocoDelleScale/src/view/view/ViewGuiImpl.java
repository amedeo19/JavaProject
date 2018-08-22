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
import view.start.Gui;

public class ViewGuiImpl implements View{

	private static final String FXML_PATH_VIEW = "/view/board/BoardEasy.fxml";
	private static final String FXML_PATH_MENU = "/view/start/Start.fxml";
	private Stage stage = new Stage();
	private Controller controller;
	private Gui gui = new Gui();
	private view.board.View guiBoard = new ViewImpl();
	
	public ViewGuiImpl() {
		this.guiBoard.setView(this);
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
		this.guiBoard.setController(controller);
	}
	
	
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
            stage.setFullScreen(false);
        } else {
            this.gui = loader.getController();
            this.gui.setViewGuiImpl(this);
            stage.setFullScreen(false);
            stage.centerOnScreen();
            stage.sizeToScene();
        }
        stage.show();
    }

}
