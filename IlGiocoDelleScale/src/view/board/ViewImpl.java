package view.board;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import controller.Controller;
import enumeration.MapDimension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.converter.ConverterView;
import model.converter.ConverterViewImpl;
import utilities.Coordinate;
import view.view.View;
import view.view.ViewGuiImpl;

public class ViewImpl implements view.board.View {

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
	private ImageView pawn1;
	@FXML
	private ImageView pawn2;
	@FXML
	private ImageView pawn3;
	@FXML
	private ImageView pawn4;
	
	@FXML
	private Label viewDice2;
	@FXML
	private ImageView imageDice2;
	@FXML
	private Label viewDice3;
	@FXML
	private ImageView imageDice3;

	@FXML
	private Button restart;
	@FXML
	private Button exit;
	@FXML
	private Button end;

	private List<ImageView> pawnList;
	private View view;
	private Controller controller;
	private List<Label> labels;
	private List<ImageView> images;
	private final static int START = 0;
	private ConverterView converter;
	private List<String> print;

	@Override
	public void SetText() {

		this.print = new ArrayList<>();
		this.controller.getSnakeList().forEach(e -> this.print.add(e.print()));
		this.controller.getStairList().forEach(e -> this.print.add(e.print()));
		this.text.setText(this.print.toString());
		
	}

	@Override
	public void RollDice() {

		this.controller.play();
		this.setImageDice();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.pawnList= new ArrayList<ImageView>();
		this.button.setVisible(true);
		this.viewDice1.setVisible(false);
		this.viewDice2.setVisible(false);
		this.viewDice3.setVisible(false);
		this.imageDice1.setVisible(false);
		this.imageDice2.setVisible(false);
		this.imageDice3.setVisible(false);
		this.converter = new ConverterViewImpl((int) Math.sqrt(MapDimension.SMALL.getDimension()));
		this.text.setVisible(true);
		
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
		this.controller.setView(this);
		this.SetText();
		this.setImageDiceVisible();
		this.setInitialImageDice();
		this.setImagePawn();
		
	}

	private void setImageDiceVisible() {
		this.images = new ArrayList<>();
		this.labels = new ArrayList<>();
		for (int i = START; i < this.controller.getNumDice(); i++) {
			switch (i) {
			case 0:
				this.images.add(imageDice1);
				this.labels.add(viewDice1);
				break;
			case 1:
				this.images.add(imageDice2);
				this.labels.add(viewDice2);
				break;
			case 2:
				this.images.add(imageDice3);
				this.labels.add(viewDice3);
				break;
			}
		}
		imageDice1.setVisible(true);
		this.images.forEach(e -> e.setVisible(true));
		this.labels.forEach(e -> e.setVisible(true));
	}

	
	private void setInitialImageDice() {
		for (int i = START; i < this.controller.getNumDice(); i++) {
			this.labels.get(i).setText(String.valueOf(START));
		}
	}

	@Override
	public void setImageDice() {
		for (int i = START; i < this.controller.getNumDice(); i++) {
			this.labels.get(i).setText(String.valueOf(this.controller.getViewNumDice().get(i)));
		}
	}

	@Override
	public void setView(ViewGuiImpl view) {
		this.view = view;
	}
	
	private void setImagePawn() {
		for(int i=START; i< this.controller.getCharacterList().size(); i++) {
			
			switch (i) {
			case 0:
				this.pawnList.add(pawn1);
				break;
			case 1: 
				this.pawnList.add(pawn2);
				break;
			case 2: 
				this.pawnList.add(pawn3);
				break;
			case 3: 
				this.pawnList.add(pawn4);
				break;
			}
			
			this.pawnList.get(i).setVisible(true);
			
			switch (this.controller.getCharacterList().get(i).toString()){
			case "Shere Khan":
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/shereKhan.png").getImage());
				break;
			case "Baloo":
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/Balooo.png").getImage());
				break;
			case "King Louie":
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/reLuigi.png").getImage());
				break;
			case "Baghera":
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/bagheraLaPanteraNera.png").getImage());
				break;
			}
			
		}
	}
	
	private ImageView readImage(final String path) {
	    
    	try {
        return new ImageView(new Image(path));
        } catch (Exception exception) {
        exception.printStackTrace();
    }
    return null;
    }
	

	@Override
	public void restart() {
		this.view.restart();
		
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}
	
	@Override
	public void end() {
		try {
			this.controller.finishGame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void update(int turn, Coordinate NewCoordinate) {
		this.grid.setColumnIndex(this.pawnList.get(turn), NewCoordinate.getX());
		this.grid.setRowIndex(this.pawnList.get(turn),this.converter.getHeight(NewCoordinate.getY()));
	}

	
}