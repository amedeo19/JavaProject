package controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.data.Data;
import model.data.DataImpl;
import model.data.ListData;
import model.data.ListDataImpl;
import model.dice.Dice;
import model.dice.ListDiceImpl;
import model.model.*;
import model.pawns.Pawns;
import model.pawns.PawnsImpl;

public class ControllerImpl implements Controller {

	private static final ControllerImpl SINGLETON = new ControllerImpl();
	private final Model game;
	private int turn;
	private boolean control;	//dadi
	List<Dice> diceList;
	List<Pawns> PawnsList;			//per ogni pedone occorre aggiungere un numero identificativo per gestire il turno
	int lastNumber;
	private final Data data;
	private final ListData list;
	private final Pawns p;
	private Optional<Settings> setting;
	
	
	
	public ControllerImpl(List<Dice> list, int lastNumber, List<Pawns> Pawns) {
		this.game = new ModelImpl();
		this.turn = 0;
		this.diceList = list;
		this.PawnsList = Pawns;
		this.lastNumber = lastNumber;
		this.setting = Optional.empty();
		this.list = new ListDataImpl();
		this.list.personalizedMode(lastNumber, diceList);
		this.data = new DataImpl(this.diceList, this.lastNumber);
		this.p = new PawnsImpl();
	}


	public ControllerImpl() {
		this.game = new ModelImpl();
		this.turn = 0;
		this.setting = Optional.empty();
		this.list = new ListDataImpl();
		this.diceList.add(new ListDiceImpl().classicDice());
		this.data = new DataImpl(this.diceList, 100);
		this.p = new PawnsImpl();
	}


	public static ControllerImpl getController() {
        return SINGLETON;
    }
	
	
	public void rollDice() {
        if(control) {
			this.game.getLog();
	        this.game.startGame(data);
	        Pawns k = this.PawnsList.get(turn);
	        int a = this.game.movePawn(k);
	        int b = this.data.getFinishNumber();		//cosi prendo il risultato dell'ultimo lancio di quel dado
	        k.setPosition(a);
	        k.setState(false);
	        if (this.turn < this.setting.get().getNumPlayers() - 1) {
	        	this.turn++;
	        } else {
	        	this.turn=0;
	        }
	        if(this.game.checkWin(k)) {
	        	try {
					this.FinishGame();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
        } else {
        	throw new IllegalStateException();
        }
    }
	
	
	@Override
	public void FinishGame() throws IOException{
		if(this.control) {
			this.game.endGame();
		} else {
			throw new IllegalStateException();
		}
		
	}
	
	
	public void start() {
		this.control = true;
	}


	@Override
	public void Play (int NumPlayers, List<Dice> DiceList) {
		if(this.control) {
			this.setting = Optional.of(new SettingBuilder()
					.NumPlayers(NumPlayers)
					.Dice(DiceList)
					.build());
			
			this.turn = 0;
			
		} else {
			throw new IllegalStateException();
		}
	}
	
	
	
}
