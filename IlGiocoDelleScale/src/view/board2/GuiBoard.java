package view.board2;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import controller.Controller;
import controller.ControllerImpl;
import enumeration.Characters;
import enumeration.MapDimension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.board.UpsideDown;
import model.converter.ConverterView;
import model.converter.ConverterViewImpl;
import view.view.View;
import view.view.ViewGuiImpl;


public class GuiBoard implements GUI{
	@FXML
	private Button button;
	@FXML
	private Label viewDice1;
	@FXML
	private ImageView imageDice1;
	@FXML
	private GridPane grid;
	@FXML
	private Label text;
	@FXML
	private ImageView Pawn1;
	@FXML
	private Label viewDice2;
	@FXML
	private ImageView imageDice2;
	@FXML
	private Label viewDice3;
	@FXML
	private ImageView imageDice3;
	
	
	private View view;
	private Controller controller = new ControllerImpl(view);
	private List<UpsideDown> snakes = new ArrayList<>();
	private List<UpsideDown> stairs = new ArrayList<>();
	private List<Optional<Integer>> viewListDice = new ArrayList<>();
	private List<Label> labels = new ArrayList<>();
	private List<ImageView> images = new ArrayList<>();
	private List<Characters> listCharacter = new ArrayList<Characters>();
	private final static int START = 0;
	private ConverterView converter;
	
	@Override
	public void SetText() {
		this.snakes = this.controller.getSnakeList();
		this.stairs = this.controller.getStairList();
		
		this.text.setText(this.snakes.toString() + this.stairs.toString());
		this.text.setText("Ciaone");
	}
	
	@Override
	public void RollDice() {
		
		
		this.controller.play();
		this.viewListDice = this.controller.getViewNumDice();
		this.setImageDice();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button.setVisible(true);
		viewDice1.setVisible(false);
		viewDice2.setVisible(false);
		viewDice3.setVisible(false);
		imageDice1.setVisible(false);
		imageDice2.setVisible(false);
		imageDice3.setVisible(false);
		this.converter= new ConverterViewImpl((int) Math.sqrt(MapDimension.SMALL.getDimension()));

		text.setVisible(true);
	}
	
	@Override
	public void setView(ViewGuiImpl view) {
		this.view = view;
	}
	
	@Override
	public void setController(Controller controller) {
		this.controller = controller;
		this.viewListDice = this.controller.getViewNumDice();
		this.setImageDiceVisible();
		this.listCharacter = this.controller.getCharacterList();
	}
	
	private void setImageDiceVisible() {
		for(int i=0; i<this.viewListDice.size(); i++) {
			switch(i) {
			case 0: this.images.add(imageDice1);
					this.labels.add(viewDice1);
					break;
			case 1: this.images.add(imageDice2);
					this.labels.add(viewDice2);
					break;
			case 2: this.images.add(imageDice3);
					this.labels.add(viewDice3);
					break;
			}
		}
		this.images.forEach(e->e.setVisible(true));
		this.labels.forEach(e->e.setVisible(true));
	}
	
	private void setImageDice() {
		for(int i=START; i<this.viewListDice.size(); i++) {
			 this.labels.get(i).setText(String.valueOf(this.viewListDice.get(i).get()));
		}
	}

}
