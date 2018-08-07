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
import model.dice.ListDice;
import model.dice.ListDiceImpl;
import model.model.*;
import model.pawns.Pawns;
import model.pawns.PawnsImpl;

public class ControllerImpl implements Controller {

	
	private final Model game;
	private boolean control;	//dadi
	List<Dice> diceList;
	private int numCell;
	List<Pawns> PawnsList;			//per ogni pedone occorre aggiungere un numero identificativo per gestire il turno
	int lastNumber;
	private Data data;
	private Optional<SettingImpl> setting;
	private Optional<Pawns> p;


	public ControllerImpl() {
		this.game = new ModelImpl();
		this.p=Optional.empty();
		this.setting = Optional.empty();
		//this.diceList.add(new ListDiceImpl().classicDice());
	}
	
	@Override
	public void Play() {
        
		if(control) {
	        this.p = Optional.of(this.PawnsList.get(this.setting.get().getTurn()));
	        int newPos = this.game.movePawn(this.p.get());			//prendo la pos finale
	        this.p.get().setState(false);
	        this.setting.get().moveTurn();
	        if(this.game.checkWin(this.p.get())) {
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
		if(this.control) {									//finestra che permette di uscire o tornare al menu iniziale
			
		} else {
			throw new IllegalStateException();
		}
		
	}
	
	
	public void start(List<Dice> list, int numCell, List<Pawns> Pawns) {	
		
		this.PawnsList=Pawns;
		this.diceList=list;
		this.numCell=numCell;
		this.data= new DataImpl(this.diceList, this.numCell);
		this.setting = Optional.of(new SettingImpl(this.PawnsList.size(), this.data));
		this.game.startGame(this.data);
	}

	public void startController() {
		this.control = true;
		//this.view.start();
	}

	
	
	
}
