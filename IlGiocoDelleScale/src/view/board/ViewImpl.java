package view.board;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import controller.Controller;
import enumeration.MapDimension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.converter.ConverterView;
import model.converter.ConverterViewImpl;
import view.view.View;
import view.view.ViewGuiImpl;


public class ViewImpl implements view.board.View{
	
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
	private boolean state;
	private Controller controller;
	private List<Label> labels;
	private List<ImageView> images;
	private final static int START = 0;
	private ConverterView converter;
	private List<String> print;
	
	@Override
	public void SetText() {

		this.print=new ArrayList<>();
		this.controller.getSnakeList().forEach(e->this.print.add(e.print()));
		this.controller.getStairList().forEach(e->this.print.add(e.print()));
		this.text.setText(this.print.toString());
	}
	
	@Override
	public void RollDice() {
		
		this.controller.play();
		this.setImageDice();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.state=true;
		this.button.setVisible(true);
		this.viewDice1.setVisible(false);
		this.viewDice2.setVisible(false);
		this.viewDice3.setVisible(false);
		this.imageDice1.setVisible(false);
		this.imageDice2.setVisible(false);
		this.imageDice3.setVisible(false);
		this.converter= new ConverterViewImpl((int) Math.sqrt(MapDimension.SMALL.getDimension()));
		this.text.setVisible(true);
	}
	
	@Override
	public void setController(Controller controller) {
		this.controller = controller;
		this.controller.setView(this);
		this.SetText();
		this.setImageDiceVisible();
		this.setInitialImageDice();
	}
	
	private void setImageDiceVisible() {
		this.images=new ArrayList<>();
		this.labels=new ArrayList<>();
		for(int i=START; i<this.controller.getNumDice(); i++) {
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
		imageDice1.setVisible(true);
		this.images.forEach(e->e.setVisible(true));
		this.labels.forEach(e->e.setVisible(true));
	}
	
	private void setInitialImageDice() {
		for(int i=START; i<this.controller.getNumDice(); i++) {
			 this.labels.get(i).setText(String.valueOf(START));
		}
	}
	
	private void setImageDice() {
		for(int i=START; i<this.controller.getNumDice(); i++) {
			this.labels.get(i).setText(String.valueOf(this.controller.getViewNumDice().get(i)));
		}
	}

	@Override
	public void setView(ViewGuiImpl view) {
		this.view = view;
	}

	@Override
	public void changeState() {

		this.state=(!this.state);
		if (!this.state){
			this.setImageDice();
		}
		this.button.setVisible(this.state);
	}
}