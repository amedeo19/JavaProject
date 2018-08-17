package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import enumeration.Characters;
import enumeration.MapDifficulty;
import enumeration.MapDimension;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.board.Coordinate;
import model.converter.Converter;
import model.converter.ConverterImpl;
import model.data.Data;
import model.data.DataImpl;
import model.dice.Dice;
import model.dice.ListDice;
import model.dice.ListDiceImpl;
import model.model.*;
import model.pawns.Pawns;
import model.pawns.PawnsImpl;
import view.start.Gui;
import view.start.GuiImpl;

public class ControllerImpl implements Controller {

	private Map<Integer,Integer> mapSpecial;
	private final Model game;
	private boolean control;	//dadi
	List<enumeration.Dice> diceList;
	List<Dice> listOfDice;
	List<Optional<Integer>> faceList;
	private int numCell;
	List<Pawns> PawnsList;			//per ogni pedone occorre aggiungere un numero identificativo per gestire il turno
	List<Characters> CharacterList;
	int lastNumber;
	private Data data;
	private Optional<SettingImpl> setting;
	private Optional<Pawns> p;
	private Converter converse;
	private Coordinate Newcoordinate;
	private GuiImpl gui;
	private MapDifficulty difficulty;
	private MapDimension dimension;
	
	@FXML
	private Button button;


	public ControllerImpl() {
		this.game = new ModelImpl();
		this.gui = new GuiImpl();
		this.p=Optional.empty();
		this.setting = Optional.empty();
		this.listOfDice = new ArrayList<Dice>();
		this.CharacterList = new ArrayList<>();
		this.PawnsList = new ArrayList<>();
		this.mapSpecial=new HashMap<>();
		this.mapSpecial.put(4, 3);
		this.mapSpecial.put(8, -5);
		this.mapSpecial.put(12, 7);
		this.mapSpecial.put(16, -2);
		this.mapSpecial.put(20, 10);
	}
	
	@Override
	public void play() {
        
		if(control) {
	        this.p = Optional.of(this.PawnsList.get(this.setting.get().getTurn()));
	        int newPos = this.game.movePawn(this.p.get());			//prendo la pos finale
	        this.Newcoordinate = this.convertToCoordinate(newPos);				//mandare alla view le coordinate finali della pedina
	        
	        this.p.get().setState(false);
	        this.setting.get().moveTurn();
	        if(this.game.checkWin(this.p.get())) {
	        	try {
					this.finishGame(this.setting.get().getTurn());
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
        } else {
        	throw new IllegalStateException();
        }
    }
	
	
	@Override
	public void finishGame(int turn) throws IOException{
		if(this.control) {				//finestra che permette di uscire o tornare al menu iniziale
			
			
			this.control = false;
		} else {
			throw new IllegalStateException();
		}
		
	}
	
	
	public void start(List<enumeration.Dice> diceList, List<Optional<Integer>> faceList, int numCell, List<Characters> Character, MapDimension dimension, MapDifficulty difficulty) {	
		
		this.CharacterList=Character;
		this.difficulty = difficulty;
		this.dimension = dimension;
		this.CreatePawn();
		this.diceList = diceList;
		this.faceList = faceList;
		this.ConvertListDice();
		this.numCell=numCell;
		this.converse = new ConverterImpl((int)Math.sqrt(this.numCell));
		this.data= new DataImpl(this.listOfDice, this.numCell);
		// Pawn
		this.setting = Optional.of(new SettingImpl(this.PawnsList.size(), this.data));
		this.game.startGame(this.data);
		
	}
	

	public void startController() {
		this.control = true;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ServerConfigChooser.fxml"));
		    GuiImpl controller = new GuiImpl();
		    loader.setController(controller);
		    Parent root = (Parent) loader.load();

		    Stage stage = new Stage();
		    stage.setScene(new Scene(root));
		    stage.show();
		} catch (IOException e){
			e.printStackTrace();
		}
		//this.view.start();
	}

	@Override
	public int convertToInt(Coordinate coordinate) {
		return this.converse.toInt(coordinate);
	}

	@Override
	public Coordinate convertToCoordinate(int pos) {
		return this.converse.toCoordinate(pos);
	}
	
	public void ConvertListDice() {

		ListDice diceBuilder = new ListDiceImpl();
		
		for (int i=0;i<this.diceList.size();i++) {
			
			// switch
			if (this.diceList.get(i).equals("Multiface")) {
				this.listOfDice.add(diceBuilder.multiFaceDice(this.faceList.get(i).get()));
			}else if (this.diceList.get(i).equals("Total Personalized")) {
				this.listOfDice.add(diceBuilder.totalPersonalized(this.mapSpecial,this.faceList.get(i).get()));
			}else if (this.diceList.get(i).equals("Special Dice")) {
				this.listOfDice.add(diceBuilder.specialClassicDice(this.mapSpecial));
			}else if (this.diceList.get(i).equals("Special Twenty")) {
				this.listOfDice.add(diceBuilder.specialTwentyDice(this.mapSpecial));
			}else if(this.diceList.get(i).equals("Classic")) {
				this.listOfDice.add(diceBuilder.classicDice());
			}else {
				this.listOfDice.add(diceBuilder.twentyFaceDice());
			}
		}
	}
	
	public void CreatePawn() {
		Pawns p = new PawnsImpl();
		System.out.println(p.getPosition());
		
		this.CharacterList.forEach(e -> {
			this.PawnsList.add(new PawnsImpl());
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.button.setVisible(true);
		
	}

	public List<Characters> getCharacterList(){
		return Collections.unmodifiableList(this.CharacterList);
	}
	
	
	
}
