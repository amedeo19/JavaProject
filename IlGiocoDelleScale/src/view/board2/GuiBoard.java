package view.board2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.dice.Dice;
import model.dice.MultifaceDice;


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
	
	public void SetText() {
		
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
	}

}
