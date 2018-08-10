package controller;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.board.Coordinate;
import model.converter.Converter;
import model.converter.ConverterImpl;
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
	private Converter converse;
	private Coordinate coordinate;


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
					this.FinishGame(this.setting.get().getTurn());
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
        } else {
        	throw new IllegalStateException();
        }
    }
	
	
	@Override
	public void FinishGame(int turn) throws IOException{
		if(this.control) {				//finestra che permette di uscire o tornare al menu iniziale
			
			
			
		} else {
			throw new IllegalStateException();
		}
		
	}
	
	
	public void start(List<Dice> list, int numCell, List<Pawns> Pawns) {	
		
		this.PawnsList=Pawns;
		this.diceList=list;
		this.numCell=numCell;
		this.converse = new ConverterImpl((int)Math.sqrt(this.numCell));
		this.data= new DataImpl(this.diceList, this.numCell);
		this.setting = Optional.of(new SettingImpl(this.PawnsList.size(), this.data));
		this.game.startGame(this.data);
	}

	public void startController() {
		this.control = true;
		//this.view.start();
	}

	@Override
	public int ConverteToInt(Coordinate coordinate) {
		return this.converse.toInt(coordinate);
	}

	@Override
	public Coordinate ConverteToCoordinate(int pos) {

		return this.converse.toCoordinate(pos);
	}

	
	
	
}
