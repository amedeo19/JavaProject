package view.start;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import controller.Controller;
import controller.ControllerImpl;

import java.util.stream.*;

import enumeration.Characters;
import enumeration.Dice;
import enumeration.MapDifficulty;
import enumeration.MapDimension;

public class Gui implements Initializable {
	//liste di oggetti utili all'inizializzazione della partita
	ObservableList<Integer> num = FXCollections.observableArrayList(1,2,3,4);
	ObservableList<MapDifficulty> mapdiff = FXCollections.observableArrayList(Arrays.asList(MapDifficulty.values()));
	ObservableList<MapDimension> mapdim = FXCollections.observableArrayList(Arrays.asList(MapDimension.values()));
	ObservableList<Integer> numdice = FXCollections.observableArrayList(1,2,3);
	ObservableList<Integer> numcell = FXCollections.observableArrayList(1,2,3,4);
	ObservableList<Characters> cha = FXCollections.observableArrayList(Arrays.asList(Characters.values()));
	ObservableList<Dice> dic = FXCollections.observableArrayList(Arrays.asList(Dice.values()));
	ObservableList<Characters> chaselect = FXCollections.observableArrayList();
	List<Dice> listOfDice = new ArrayList<>();
	List<Optional<Integer>> listFace = new ArrayList<>();
	List<Text> TextList=new ArrayList<>();
	List<ChoiceBox<Characters>> PawnList=new ArrayList<>();
	List<ChoiceBox<Dice>> DiceList=new ArrayList<>();

	@FXML
	private Text Text1;
	@FXML
	private Text TextP1;
	@FXML
	private Text TextP2;
	@FXML
	private Text TextP3;
	@FXML
	private Text TextP4;
	@FXML
	private Text PawnSelection;
	@FXML
	private Text DiceSelection;
	@FXML
	private Text TextDifficulty;
	@FXML
	private Text TextDimension;
	@FXML
	private ImageView Logo;
	@FXML
	private Button GoToPlayerSelect;
	@FXML 
	private ChoiceBox<Integer> numPlayer;
	@FXML
	private Button Exit;
	@FXML
	private Button Back;
	@FXML
	private Button GoToDiceSelect;
	@FXML
	private Button Update;
	@FXML
	private Button Update1;
	@FXML
	private Button StartGame;
	@FXML
	private ChoiceBox<Characters> PawnP1;
	@FXML
	private ChoiceBox<Characters> PawnP2;
	@FXML
	private ChoiceBox<Characters> PawnP3;
	@FXML
	private ChoiceBox<Characters> PawnP4;
	@FXML
	private ChoiceBox<Integer> DiceNumber;
	@FXML
	private ChoiceBox<MapDifficulty> Difficulty;
	@FXML
	private ChoiceBox<MapDimension> Dimension;
	@FXML
	private ChoiceBox<Dice> Dice1;
	@FXML
	private ChoiceBox<Dice> Dice2;
	@FXML
	private ChoiceBox<Dice> Dice3;
	@FXML
	private TextField FaceN1;
	@FXML
	private TextField FaceN2;
	@FXML
	private TextField FaceN3;
	
	private int numDices;
	private int numPlayers;
	private static final int cellNumber=100;
	private Controller controller = new ControllerImpl();

	
	public void SelectPawns() {
		this.numPlayers = (int) numPlayer.getValue(); //ciclo per mostrare solo un carto numero di choicebox da cui scegliere il personaggio
		for (int i=0;i<numPlayers;i++) {
			switch (i) {
				case 0: this.TextList.add(TextP1);
						this.PawnList.add(PawnP1);
						
						break;
				case 1: this.TextList.add(TextP2);
						this.PawnList.add(PawnP2);
						break;
				case 2: this.TextList.add(TextP3);
						this.PawnList.add(PawnP3);
						break;
				case 3: this.TextList.add(TextP4);
						this.PawnList.add(PawnP4);
						break;
			}
		}
		System.out.println(this.TextList.size());
		this.TextList.forEach(e->e.setVisible(true));
		this.PawnList.forEach(e->e.setVisible(true));
		numPlayer.setVisible(false);
		GoToPlayerSelect.setVisible(false);
		Logo.setVisible(false);
		Text1.setVisible(false);
	 	GoToDiceSelect.setVisible(true);
		PawnSelection.setVisible(true);
		TextDifficulty.setVisible(false);
		TextDimension.setVisible(false);
		Difficulty.setVisible(false);
		Dimension.setVisible(false);
		System.out.println(this.Difficulty.getValue());
		System.out.println(this.Dimension.getValue());
		
	}
	public void Exit() {
		System.exit(0);
	}
	public void Update() {
		this.numDices = (int) DiceNumber.getValue();
		System.out.println(numDices);
		Dice2.setVisible(false);
		Dice3.setVisible(false);
		FaceN1.setVisible(false);
		FaceN2.setVisible(false);
		FaceN3.setVisible(false);
		for (int i=0;i<numDices;i++) {
			switch (i) {
				case 0: this.DiceList.add(Dice1);
						this.Dice1.setVisible(true);
						break;
				case 1: this.DiceList.add(Dice2);
						this.Dice2.setVisible(true);
						break;
				case 2: this.DiceList.add(Dice3);
						this.Dice3.setVisible(true);
						break;
			}
		}
	}
	public void Update1() {
	Dice typeDice1 = Dice1.getValue();
	Dice typeDice2 = Dice2.getValue();
	Dice typeDice3 = Dice3.getValue();
	FaceN1.setVisible(false);
	FaceN2.setVisible(false);
	FaceN3.setVisible(false);

	if ((typeDice1.toString().equals("Multiface")) || (typeDice1.toString().equals("Total Personalized"))) {
		FaceN1.setVisible(true);
	}
	if ((typeDice2.toString().equals("Multiface")) || (typeDice2.toString().equals("Total Personalized"))) {
		FaceN2.setVisible(true);
	}
	if ((typeDice3.toString().equals("Multiface")) || (typeDice3.toString().equals("Total Personalized"))) {
		FaceN3.setVisible(true);
	}
	}
	public void Back() {
		numPlayer.setVisible(true);
		GoToPlayerSelect.setVisible(true);
		Logo.setVisible(true);
		Text1.setVisible(true);
		GoToDiceSelect.setVisible(false);
		PawnSelection.setVisible(false);
	 	this.TextList.forEach(e->e.setVisible(false));
	 	this.TextList.clear();
	 	this.PawnList.forEach(e->e.setVisible(false));
	 	this.PawnList.clear();
	 	this.DiceList.forEach(e->e.setVisible(false));
	 	this.DiceList.clear();
		DiceNumber.setVisible(false);
		Update.setVisible(false);
		Update1.setVisible(false);
		FaceN1.setVisible(false);
		FaceN2.setVisible(false);
		FaceN3.setVisible(false);
		StartGame.setVisible(false);
		DiceSelection.setVisible(false);
   	 	this.PawnP1.setValue(Characters.Baghera);
   	 	this.PawnP2.setValue(Characters.Baghera);
   	 	this.PawnP3.setValue(Characters.Baghera);
   	 	this.PawnP4.setValue(Characters.Baghera);
   	 	this.numPlayer.setValue(1);
	 	this.DiceNumber.setValue(1);
	 	this.Dice1.setValue(Dice.CLASSIC);
	 	this.Dice2.setValue(Dice.CLASSIC);
	 	this.Dice3.setValue(Dice.CLASSIC);
	 	TextDifficulty.setVisible(true);
		TextDimension.setVisible(true);
		Difficulty.setVisible(true);
		this.Difficulty.setValue(MapDifficulty.EASY);
		Dimension.setVisible(true);
		this.Dimension.setValue(MapDimension.SMALL);

	}
	public void SelectDice(){
		this.chaselect.clear();
		this.numPlayers = (int) numPlayer.getValue();
		for (int i=0;i<numPlayers;i++) {
			switch (i) {
				case 0: this.chaselect.add(PawnP1.getValue());
						break;
				case 1:	this.chaselect.add(PawnP2.getValue());
						break;
				case 2: this.chaselect.add(PawnP3.getValue());
						break;
				case 3: this.chaselect.add(PawnP4.getValue());
						break;
			}
		}
		System.out.println(chaselect);
		this.TextList.forEach(e->e.setVisible(false));
		this.PawnList.forEach(e->e.setVisible(false));
		numPlayer.setVisible(false);
		GoToPlayerSelect.setVisible(false);
		Logo.setVisible(false);
		Text1.setVisible(false);
		PawnSelection.setVisible(false);
		DiceNumber.setVisible(true);
		Update.setVisible(true);
		Update1.setVisible(true);
		GoToDiceSelect.setVisible(false);
		StartGame.setVisible(true);
		DiceSelection.setVisible(true);

		}
	public void StartGame() {
		for (int i=0;i<this.numDices;i++) {
			switch (i) {
				case 0: this.listFace.add(Optional.ofNullable(Integer.parseInt(FaceN1.getText())));
						this.listOfDice.add(Dice1.getValue());
						break;
				case 1: this.listFace.add(Optional.ofNullable(Integer.parseInt(FaceN2.getText())));
						this.listOfDice.add(Dice2.getValue());
						break;
				case 2: this.listFace.add(Optional.ofNullable(Integer.parseInt(FaceN3.getText())));
						this.listOfDice.add(Dice3.getValue());
						break;
			}
		}
		this.controller.start(dicemap, cellNumber, chaselect);
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.numPlayer.setItems(num);
        this.numPlayer.setValue(1);
        this.PawnP1.setItems(cha);
   	 	this.PawnP1.setValue(Characters.Baghera);
   	 	this.PawnP2.setItems(cha);
	 	this.PawnP2.setValue(Characters.Baghera);
	 	this.PawnP3.setItems(cha);
   	 	this.PawnP3.setValue(Characters.Baghera);
   	 	this.PawnP4.setItems(cha);
	 	this.PawnP4.setValue(Characters.Baghera);
	 	this.DiceNumber.setItems(numdice);
	 	this.DiceNumber.setValue(1);
	 	this.Dice1.setItems(dic);
	 	this.Dice1.setValue(Dice.CLASSIC);
	 	this.Dice2.setItems(dic);
	 	this.Dice2.setValue(Dice.CLASSIC);
	 	this.Dice3.setItems(dic);
	 	this.Dice3.setValue(Dice.CLASSIC);
	 	this.Difficulty.setItems(mapdiff);
	 	this.Difficulty.setValue(MapDifficulty.EASY);
	 	this.Dimension.setItems(mapdim);
	 	this.Dimension.setValue(MapDimension.SMALL);

	 	TextP1.setVisible(false);
	 	TextP2.setVisible(false);
	 	TextP3.setVisible(false);
	 	TextP4.setVisible(false);
	 	PawnP1.setVisible(false);
	 	PawnP2.setVisible(false);
	 	PawnP3.setVisible(false);
	 	PawnP4.setVisible(false);
	 	GoToDiceSelect.setVisible(false);
		PawnSelection.setVisible(false);
		DiceNumber.setVisible(false);
		Dice1.setVisible(false);
		Dice2.setVisible(false);
		Dice3.setVisible(false);
		Update.setVisible(false);
		Update1.setVisible(false);
		StartGame.setVisible(false);
		FaceN1.setVisible(false);
		FaceN2.setVisible(false);
		FaceN3.setVisible(false);
		DiceSelection.setVisible(false);
		TextDifficulty.setVisible(true);
		Difficulty.setVisible(true);
		Dimension.setVisible(true);
    }

}