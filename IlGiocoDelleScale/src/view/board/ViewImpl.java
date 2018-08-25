package view.board;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import controller.Controller;
import enumeration.Characters;
import enumeration.MapDimension;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.converter.ConverterView;
import model.converter.ConverterViewImpl;
import model.pawns.Pawns;
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
	private boolean state;
	private Controller controller;
	private List<Label> labels;
	private List<ImageView> images;
	private final static int START = 0;
	private ConverterView converter;
	private List<String> print;
	private final static int TIMEIA=2000;
	private Sleep agent;

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

		this.state = true;
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
		
		this.pawn1.setVisible(true);
		this.pawn2.setVisible(true);
		if(this.controller.getCharacterList().size() == 2) {
			this.pawn3.setVisible(true);
		} else if (this.controller.getCharacterList().size() == 3) {
			this.pawn3.setVisible(true);
			this.pawn4.setVisible(true);
		} else {
			this.pawn3.setVisible(false);
			this.pawn4.setVisible(false);
		}
		
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

	@Override
	public void changeState() {

		this.state = (!this.state);
		if (this.state){
			this.sleep();
		}
	}
	
	private void sleep(){
		this.agent = new Sleep(this);
		this.agent.start();
	}
	
	public class Sleep extends Thread{
		
		private final view.board.View view;
		
		public Sleep(final view.board.View view) {
			this.view=view;		}
		
		@Override
		public void run() {
			
			super.run();

			this.view.setImageDice();
			this.view.disable(true);
			try {
				Thread.sleep(TIMEIA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.view.setImageDice();
			this.view.disable(false);
		}
	}

	@Override
	public void disable(boolean value) {
		this.button.setDisable(value);
	}
	
	private void setImagePawn() {
		for(int i=START; i< this.controller.getCharacterList().size(); i++) {
			if (i == 0) {
				this.pawnList.add(pawn1);
			} else if (i == 1) {
				this.pawnList.add(pawn2);
			} else if (i == 2) {
				this.pawnList.add(pawn3);
			} else if (i == 3) {
				this.pawnList.add(pawn4);
			}
			if (this.controller.getCharacterList().get(i).equals(Characters.ShereKhan)) {
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/shereKhan.png").getImage());
			}
			if (this.controller.getCharacterList().get(i).equals(Characters.Baloo)) {
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/Balooo.png").getImage());
			}
			if (this.controller.getCharacterList().get(i).equals(Characters.KingLouie)) {
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/reLuigi.png").getImage());
			} else if (this.controller.getCharacterList().get(i).equals(Characters.Baghera)) {
				this.pawnList.get(i).setImage(this.readImage("file://../res/Pawns/bagheraLaPanteraNera.png").getImage());
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
//		this.view.setWinner(Characters.Baloo);
//		this.view.end();
		try {
			this.controller.finishGame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void update(int turn, Coordinate NewCoordinate) {
//		if(turn == 0) {
//			this.grid.setColumnIndex(pawn1, NewCoordinate.getX());
//			this.grid.setRowIndex(pawn1,this.converter.getHeight(NewCoordinate.getY()));
//			this.grid.setColumnIndex(this.pawnList.get(turn), NewCoordinate.getX());
//			this.grid.setRowIndex(this.pawnList.get(turn),this.converter.getHeight(NewCoordinate.getY()));
//			this.pawn1.setX(NewCoordinate.getX());
//			this.pawn1.setY(this.converter.getHeight(NewCoordinate.getY()));
//			this.pawn1.setLayoutX(NewCoordinate.getX());
//			this.pawn1.setLayoutY(this.converter.getHeight(NewCoordinate.getY()));
//			this.pawn1.setTranslateX(NewCoordinate.getX());
//			this.pawn1.setTranslateY(this.converter.getHeight(NewCoordinate.getY()));
//			
//		} else if(turn == 1) {
//			this.pawn2.setX(NewCoordinate.getX());
//			this.pawn2.setY(this.converter.getHeight(NewCoordinate.getY()));
//		}
		this.grid.setColumnIndex(this.pawnList.get(turn), NewCoordinate.getX());
		this.grid.setRowIndex(this.pawnList.get(turn),this.converter.getHeight(NewCoordinate.getY()));
		System.out.println("coordinate: " + NewCoordinate.getX() + " " + this.converter.getHeight( NewCoordinate.getY()));
	}

	
}