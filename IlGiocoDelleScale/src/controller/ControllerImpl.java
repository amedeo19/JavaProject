package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import enumeration.Characters;
import enumeration.MapDifficulty;
import enumeration.MapDimension;
import javafx.stage.Stage;
import model.board.TableBuilder;
import model.board.TableBuilderImpl;
import model.board.UpsideDown;
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
import utilities.Coordinate;
import view.start.GuiImpl;
import view.view.View;
import view.view.ViewGuiImpl;

public class ControllerImpl implements Controller {

	private Map<Integer,Integer> mapSpecial;
	private Model game;
	private boolean control;	//dadi
	private List<enumeration.Dice> diceList;
	private List<Dice> listOfDice;
	private List<Optional<Integer>> faceList;
	private List<Pawns> PawnsList;			//per ogni pedone occorre aggiungere un numero identificativo per gestire il turno
	private List<Characters> CharacterList;
	private int lastNumber;
	private Data data;
	private int numCell;
	private Optional<Setting> setting;
	private Optional<Pawns> p;
	private Converter converse;
	private Coordinate Newcoordinate;
	private GuiImpl gui;
	private MapDifficulty difficulty;
	private MapDimension dimension;
	private boolean multiplayer;
	private boolean IAturn;
	private View view;
	private TableBuilder table;
	private final static int SINGLEPLAYER=1;
	private final static int TIMEIA=3000;


	public ControllerImpl(View view) {
		this.view = view;
		this.multiplayer = false;
		this.IAturn=false;
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
	        
	        if (this.table.isCellJump(this.Newcoordinate)) {
	        	Coordinate pos=this.table.getNewPosition(this.Newcoordinate);
	        	this.Newcoordinate=pos;
	        	this.p.get().setPosition(this.convertToInt(this.Newcoordinate));
	        	System.out.println(this.Newcoordinate);
	        }
	        this.setting.get().moveTurn();
	        
	        if(this.game.checkWin(this.p.get())) {
	        	try {
					this.finishGame();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        
			if (!this.multiplayer){
				this.IAturn=!this.IAturn;
			}
			if ((!this.multiplayer) && this.IAturn){
				try {
					Thread.sleep(TIMEIA);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.play();
			}
        } else {
        	throw new IllegalStateException();
        }

    }
	
	
	private void finishGame() throws IOException{
		if(this.control) {				//finestra che permette di uscire o tornare al menu iniziale
			this.getCharacterList().get(this.setting.get().getTurn());
			
			this.control = false;
		} else {
			throw new IllegalStateException();
		}
		
	}
	

	@Override
	public void start(List<enumeration.Dice> diceList, List<Optional<Integer>> faceList, List<Characters> Character, MapDimension dimension, MapDifficulty difficulty) {	

		this.control = true;
		this.view.setController(this);
		this.CharacterList=Character;
		this.difficulty = difficulty;
		this.dimension = dimension;
		this.table = new TableBuilderImpl(difficulty, dimension);
		this.numCell = this.dimension.getDimension();
		System.out.println(this.numCell);
		this.CreatePawn();
		this.checkMultiplayer();
		this.diceList = diceList;
		this.faceList = faceList;
		this.ConvertListDice();
		this.converse = new ConverterImpl((int)Math.sqrt(this.numCell));
		this.data= new DataImpl(this.listOfDice, this.numCell);
		// Pawn
		this.setting = Optional.of(new SettingImpl(this.PawnsList.size(), this.data));
		this.game = new ModelImpl(this.data);
		
		//chiamare view di andre
		//javafx.application.Application.launch(View.class);
		
	}
	

	public void startController() throws Exception {
		this.control = true;
		//Stage stage = new Stage();
		//this.view.startMenu(stage);
		//javafx.application.Application.launch(GuiImpl.class);
	}

	private int convertToInt(Coordinate coordinate) {
		return this.converse.toInt(coordinate);
	}

	private Coordinate convertToCoordinate(int pos) {
		return this.converse.toCoordinate(pos);
	}
	
	private void ConvertListDice() {

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
		this.CharacterList.forEach(e -> {
			this.PawnsList.add(new PawnsImpl());
		});
	}

	
	private List<Characters> getCharacterList(){
		return Collections.unmodifiableList(this.CharacterList);
	}
	
	
	
	public void checkMultiplayer() {
		if(this.CharacterList.size() == SINGLEPLAYER) {		//caso single player, creo CPU (ShereKhan o Baghera)
			this.multiplayer = false;
			this.PawnsList.add(new PawnsImpl());
			if((this.CharacterList.get(0).equals(Characters.Baghera)) || (this.CharacterList.get(0).equals(Characters.Baloo))) {
				this.CharacterList.add(Characters.ShereKhan);
			} else {
				this.CharacterList.add(Characters.Baghera);
			}
		} else {
			this.multiplayer = true;
		}
	}
	
	public List<UpsideDown> getSnakeList() {
		return this.table.getSnakes();
	}
	
	public List<UpsideDown> getStairList() {
		return this.table.getStairs();
	}

	
	
	
}
