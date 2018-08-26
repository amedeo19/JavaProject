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
import javafx.scene.control.TextArea;
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
	private TextArea text;
	
	@FXML
	private ImageView pawn1;
	@FXML
	private ImageView pawn2;
	@FXML
	private ImageView pawn3;
	@FXML
	private ImageView pawn4;
	
	@FXML
	private ImageView Ladder1;
	@FXML
	private ImageView Ladder2;
	@FXML
	private ImageView Ladder3;
	@FXML
	private ImageView Ladder4;
	@FXML
	private ImageView Ladder5;
	@FXML
	private ImageView Ladder6;
	@FXML
	private ImageView Ladder7;
	@FXML
	private ImageView Ladder8;
	@FXML
	private ImageView Ladder9;
	@FXML
	private ImageView Ladder10;
	@FXML
	private ImageView Ladder11;
	@FXML
	private ImageView Ladder12;
	
	
	@FXML
	private ImageView Snake1;
	@FXML
	private ImageView Snake2;
	@FXML
	private ImageView Snake3;
	@FXML
	private ImageView Snake4;
	@FXML
	private ImageView Snake5;
	@FXML
	private ImageView Snake6;
	@FXML
	private ImageView Snake7;
	@FXML
	private ImageView Snake8;
	@FXML
	private ImageView Snake9;
	@FXML
	private ImageView Snake10;
	@FXML
	private ImageView Snake11;
	@FXML
	private ImageView Snake12;
	
	
	
	
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

	private List<ImageView> snakes;
	private List<ImageView> ladders;
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
		this.text.setEditable(false);
		
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
		this.setJumpFalse();
	}
	
	private void setJumpFalse(){
		this.Snake1.setVisible(false);
		this.Snake2.setVisible(false);
		this.Snake3.setVisible(false);
		this.Snake4.setVisible(false);
		this.Snake5.setVisible(false);
		this.Snake6.setVisible(false);
		this.Snake7.setVisible(false);
		this.Snake8.setVisible(false);
		this.Snake9.setVisible(false);
		this.Snake10.setVisible(false);
		this.Snake11.setVisible(false);
		this.Snake12.setVisible(false);
		this.Ladder1.setVisible(false);
		this.Ladder2.setVisible(false);
		this.Ladder3.setVisible(false);
		this.Ladder4.setVisible(false);
		this.Ladder5.setVisible(false);
		this.Ladder6.setVisible(false);
		this.Ladder7.setVisible(false);
		this.Ladder8.setVisible(false);
		this.Ladder9.setVisible(false);
		this.Ladder10.setVisible(false);
		this.Ladder11.setVisible(false);
		this.Ladder12.setVisible(false);
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
		this.controller.setView(this);
		this.SetText();
		this.setImageDiceVisible();
		this.setInitialImageDice();
		this.setImagePawn();
		this.setViewUpsideDown();
	}

	private void setViewUpsideDown(){
		this.snakes = new ArrayList<>();
		for (int i = START; i < this.controller.getSnakeList().size(); i++) {
			switch (i) {
			case 0:
				this.snakes.add(Snake1);
				this.grid.setColumnIndex(Snake1, this.controller.getSnakeList().get(i).getStart().getX());
				this.grid.setRowIndex(Snake1, this.converter.getHeight(this.controller.getSnakeList().get(i).getStart().getY()));
				this.snakes.add(Snake2);
				this.grid.setColumnIndex(Snake2, this.controller.getSnakeList().get(i).getTarget().getX());
				this.grid.setRowIndex(Snake2, this.converter.getHeight(this.controller.getSnakeList().get(i).getTarget().getY()));
				break;
			case 1:
				this.snakes.add(Snake3);
				this.grid.setColumnIndex(Snake3, this.controller.getSnakeList().get(i).getStart().getX());
				this.grid.setRowIndex(Snake3, this.converter.getHeight(this.controller.getSnakeList().get(i).getStart().getY()));
				this.snakes.add(Snake4);
				this.grid.setColumnIndex(Snake4, this.controller.getSnakeList().get(i).getTarget().getX());
				this.grid.setRowIndex(Snake4, this.converter.getHeight(this.controller.getSnakeList().get(i).getTarget().getY()));
				break;
			case 2:
				this.snakes.add(Snake5);
				this.grid.setColumnIndex(Snake5, this.controller.getSnakeList().get(i).getStart().getX());
				this.grid.setRowIndex(Snake5, this.converter.getHeight(this.controller.getSnakeList().get(i).getStart().getY()));
				this.snakes.add(Snake6);
				this.grid.setColumnIndex(Snake6, this.controller.getSnakeList().get(i).getTarget().getX());
				this.grid.setRowIndex(Snake6, this.converter.getHeight(this.controller.getSnakeList().get(i).getTarget().getY()));
				break;
			case 3:
				this.snakes.add(Snake7);
				this.grid.setColumnIndex(Snake7, this.controller.getSnakeList().get(i).getStart().getX());
				this.grid.setRowIndex(Snake7, this.converter.getHeight(this.controller.getSnakeList().get(i).getStart().getY()));
				this.snakes.add(Snake8);
				this.grid.setColumnIndex(Snake8, this.controller.getSnakeList().get(i).getTarget().getX());
				this.grid.setRowIndex(Snake8, this.converter.getHeight(this.controller.getSnakeList().get(i).getTarget().getY()));
				break;
			case 4:
				this.snakes.add(Snake9);
				this.grid.setColumnIndex(Snake9, this.controller.getSnakeList().get(i).getStart().getX());
				this.grid.setRowIndex(Snake9, this.converter.getHeight(this.controller.getSnakeList().get(i).getStart().getY()));
				this.snakes.add(Snake10);
				this.grid.setColumnIndex(Snake10, this.controller.getSnakeList().get(i).getTarget().getX());
				this.grid.setRowIndex(Snake10, this.converter.getHeight(this.controller.getSnakeList().get(i).getTarget().getY()));
				break;
			case 5:
				this.snakes.add(Snake11);
				this.grid.setColumnIndex(Snake11, this.controller.getSnakeList().get(i).getStart().getX());
				this.grid.setRowIndex(Snake11, this.converter.getHeight(this.controller.getSnakeList().get(i).getStart().getY()));
				this.snakes.add(Snake12);
				this.grid.setColumnIndex(Snake12, this.controller.getSnakeList().get(i).getTarget().getX());
				this.grid.setRowIndex(Snake12, this.converter.getHeight(this.controller.getSnakeList().get(i).getTarget().getY()));
				break;
			}
		}
		this.snakes.forEach(e -> e.setVisible(true));
		this.snakes.forEach(e->e.setImage(this.readImage("file://../res/SnakeNLadder/snake.png").getImage()));
		this.ladders = new ArrayList<>();
		for (int i = START; i < this.controller.getStairList().size(); i++) {
			switch (i) {
			case 0:
				this.ladders.add(Ladder1);
				this.grid.setColumnIndex(Ladder1, this.controller.getStairList().get(i).getStart().getX());
				this.grid.setRowIndex(Ladder1, this.converter.getHeight(this.controller.getStairList().get(i).getStart().getY()));
				this.ladders.add(Ladder2);
				this.grid.setColumnIndex(Ladder2, this.controller.getStairList().get(i).getTarget().getX());
				this.grid.setRowIndex(Ladder2, this.converter.getHeight(this.controller.getStairList().get(i).getTarget().getY()));
				break;
			case 1:
				this.ladders.add(Ladder3);
				this.grid.setColumnIndex(Ladder3, this.controller.getStairList().get(i).getStart().getX());
				this.grid.setRowIndex(Ladder3, this.converter.getHeight(this.controller.getStairList().get(i).getStart().getY()));
				this.ladders.add(Ladder4);
				this.grid.setColumnIndex(Ladder4, this.controller.getStairList().get(i).getTarget().getX());
				this.grid.setRowIndex(Ladder4, this.converter.getHeight(this.controller.getStairList().get(i).getTarget().getY()));
				break;
			case 2:
				this.ladders.add(Ladder5);
				this.grid.setColumnIndex(Ladder5, this.controller.getStairList().get(i).getStart().getX());
				this.grid.setRowIndex(Ladder5, this.converter.getHeight(this.controller.getStairList().get(i).getStart().getY()));
				this.ladders.add(Ladder6);
				this.grid.setColumnIndex(Ladder6, this.controller.getStairList().get(i).getTarget().getX());
				this.grid.setRowIndex(Ladder6, this.converter.getHeight(this.controller.getStairList().get(i).getTarget().getY()));
				break;
			case 3:
				this.ladders.add(Ladder7);
				this.grid.setColumnIndex(Ladder7, this.controller.getStairList().get(i).getStart().getX());
				this.grid.setRowIndex(Ladder7, this.converter.getHeight(this.controller.getStairList().get(i).getStart().getY()));
				this.ladders.add(Ladder8);
				this.grid.setColumnIndex(Ladder8, this.controller.getStairList().get(i).getTarget().getX());
				this.grid.setRowIndex(Ladder8, this.converter.getHeight(this.controller.getStairList().get(i).getTarget().getY()));
				break;
			case 4:
				this.ladders.add(Ladder9);
				this.grid.setColumnIndex(Ladder9, this.controller.getStairList().get(i).getStart().getX());
				this.grid.setRowIndex(Ladder9, this.converter.getHeight(this.controller.getStairList().get(i).getStart().getY()));
				this.ladders.add(Ladder10);
				this.grid.setColumnIndex(Ladder10, this.controller.getStairList().get(i).getTarget().getX());
				this.grid.setRowIndex(Ladder10, this.converter.getHeight(this.controller.getStairList().get(i).getTarget().getY()));
				break;
			case 5:
				this.ladders.add(Ladder11);
				this.grid.setColumnIndex(Ladder11, this.controller.getStairList().get(i).getStart().getX());
				this.grid.setRowIndex(Ladder11, this.converter.getHeight(this.controller.getStairList().get(i).getStart().getY()));
				this.ladders.add(Ladder12);
				this.grid.setColumnIndex(Ladder12, this.controller.getStairList().get(i).getTarget().getX());
				this.grid.setRowIndex(Ladder12, this.converter.getHeight(this.controller.getStairList().get(i).getTarget().getY()));
				break;
			}
		}
		this.ladders.forEach(e -> e.setVisible(true));
		this.ladders.forEach(e->e.setImage(this.readImage("file://../res/SnakeNLadder/ladder.png").getImage()));
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