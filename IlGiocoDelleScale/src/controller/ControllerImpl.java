package controller;


import java.util.List;
import java.util.Map;

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
	int lastNumber;
	private final Data data;
	private final ListData list;
	private final Pawns p;
	
	
	
	public ControllerImpl(List<Dice> list, int lastNumber) {
		this.game = new ModelImpl();
		this.turn = 0;
		this.diceList = list;
		this.lastNumber = lastNumber;
		
		this.list = new ListDataImpl();
		this.list.personalizedMode(lastNumber, diceList);
		this.data = new DataImpl(this.diceList, this.lastNumber);
		
		this.p = new PawnsImpl();
	}


	public ControllerImpl() {
		this.game = new ModelImpl();
		this.turn = 0;
		this.list = new ListDataImpl();
		this.diceList.add(new ListDiceImpl().classicDice());
		this.data = new DataImpl(this.diceList, 100);
		this.p = new PawnsImpl();
	}


	public static ControllerImpl getController() {
        return SINGLETON;
    }
	
	
	
	public void play() {
        if(control) {
			this.game.getLog();
	        this.game.startGame(data);
	        int a = this.game.movePawn(p);
	        this.p.setPosition(a);
	        this.p.setState(false);
	        if(this.game.checkWin(p)) {
	        	this.game.endGame();
	        }
        } else {
        	throw new IllegalStateException();
        }
    }
	
	public void start() {
		this.control = true;
	}
	
	
	
	
	
	
}
