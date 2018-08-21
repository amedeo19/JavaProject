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

	
	private Stage stage;
	private Controller controller;
	private final Wait<Boolean> wait = new Wait<>();
	private GuiImpl gui = new GuiImpl();
	private GuiBoardImpl guiBoardImpl = new GuiBoardImpl();
	private GuiBoard guiBoard = new GuiBoard();
	
	public ViewGuiImpl() {
		this.controller = new ControllerImpl(this);
//		this.controller.getSnakeList();
//		this.controller.getStairList();
		this.guiBoard.setView(this);
		this.guiBoard.setController(controller);
	}
	
	
	@Override
	public void start() throws IOException {
        final Wait<Boolean> wait = new Wait<>();
        Platform.runLater(() -> {
            try {
				this.guiBoardImpl.start(stage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
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
