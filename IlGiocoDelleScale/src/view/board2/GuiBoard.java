package view.board2;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import controller.ControllerImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.board.UpsideDown;
import model.dice.Dice;
import model.dice.MultifaceDice;
import view.view.View;
import view.view.ViewGuiImpl;


public class GuiBoard implements Initializable{
	@FXML
	private Button button;
	@FXML
	private Label viewDice;
	@FXML
	private ImageView image;
	@FXML
	private GridPane grid;
	@FXML
	private Label text;
	@FXML
	private ImageView Pawn1;
	private Dice dice;
	private View view;
	private Controller controller = new ControllerImpl(view);
	private List<UpsideDown> snakes = new ArrayList<>();
	private List<UpsideDown> stairs = new ArrayList<>();
	
	public void SetText() {
		this.snakes = this.controller.getSnakeList();
		this.stairs = this.controller.getStairList();
		
		this.text.setText(this.snakes.toString() + this.stairs.toString());
		this.text.setText("Ciaone");
	}
	
	public void RollDice() {
		
		this.dice.roll();
		this.viewDice.setText(String.valueOf(this.dice.viewNum()));
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewDice.setText(String.valueOf(0));
		dice=new MultifaceDice(6);
		button.setVisible(true);
		viewDice.setVisible(true);
		

		text.setVisible(true);
	}
	
	public void setView(ViewGuiImpl view) {
		this.view = view;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
