package view.view;

import java.io.IOException;
import controller.Controller;
import enumeration.Characters;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.board.ViewImpl;
import view.end.EndGuiBaghera;
import view.end.EndGuiBaloo;
import view.end.EndGuiMowgli;
import view.end.EndGuiReLuigi;
import view.end.EndGuiShereKhan;
import view.start.Gui;
import view.start.Menu;

public class ViewGuiImpl implements View{

	private static final String FXML_PATH_VIEW = "/view/board/BoardEasy.fxml";
	private static final String FXML_PATH_MENU = "/view/start/Start.fxml";
	
	private static final String FXML_PATH_END_BALOO = "/view/end/EndBaloo.fxml";
	private static final String FXML_PATH_END_BAGHERA = "/view/end/EndBaghera.fxml";
	private static final String FXML_PATH_END_MOWGLI = "/view/end/EndMowgli.fxml";
	private static final String FXML_PATH_END_RELUIGI = "/view/end/EndReLuigi.fxml";
	private static final String FXML_PATH_END_SHEREKHAN = "/view/end/EndShereKhan.fxml";
	
	private Stage stage = new Stage();
	private Menu gui = new Gui();
	private view.board.View guiBoard = new ViewImpl();
	private Controller controller;
	private Characters character;
	
	private view.end.EndGui end;
	
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
	public void setController(Controller controller) {
		this.controller=controller;
	}
	
	@Override
	public void restart() {
		try {
			this.startMenu(this.stage);
            stage.centerOnScreen();
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
            stage.centerOnScreen();
            stage.sizeToScene();
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
		switch(this.character.toString()) {
		case "Baloo": this.end = new EndGuiBaloo();
			try {
				this.startView(FXML_PATH_END_BALOO);
	            stage.centerOnScreen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "Baghera": this.end = new EndGuiBaghera();
			try {
				this.startView(FXML_PATH_END_BAGHERA);
	            stage.centerOnScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "King Louie": this.end = new EndGuiReLuigi();
			try {
				this.startView(FXML_PATH_END_RELUIGI);
	            stage.centerOnScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Shere Khan": this.end = new EndGuiShereKhan();
			try {
				this.startView(FXML_PATH_END_SHEREKHAN);
	            stage.centerOnScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default: this.end = new EndGuiMowgli();
			try {
				this.startView(FXML_PATH_END_MOWGLI);
	            stage.centerOnScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	
	@Override
	public void setWinner(Characters character) {
		this.character = character;
	}

}
