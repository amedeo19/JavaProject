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
import view.board2.GuiBoard;
import view.board2.GuiBoardImpl;
import view.start.Gui;
import view.start.GuiImpl;

public class ViewGuiImpl implements View{

	private static final String FXML_PATH_VIEW = "/view/board2/BoardEasy.fxml";
	private static final String FXML_PATH_MENU = "/view/start/Start.fxml";
	private Stage stage = new Stage();
	private Controller controller;
	private Gui gui = new Gui();
	private GuiBoardImpl guiBoardImpl = new GuiBoardImpl();
	private GuiBoard guiBoard = new GuiBoard();
	
	public ViewGuiImpl() {
		this.controller = new ControllerImpl(this);
//		this.controller.getSnakeList();
//		this.controller.getStairList();
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
		this.controller = controller;
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
        if (loader.getController() instanceof GuiBoard) {
            this.guiBoard = loader.getController();
            stage.setFullScreen(false);
        } else {
            this.gui = loader.getController();
    		this.guiBoard.setController(this.controller);
            this.gui.setViewGuiImpl(this);
            stage.setFullScreen(false);
            stage.centerOnScreen();
            stage.sizeToScene();
        }
        stage.show();
    }

}
