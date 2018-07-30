package controller;

import java.util.List;

import enumeration.Characters;
import model.dice.Dice;

public class Settings {

	private final int NumPlayers;
	private List<Dice> DiceList;
	
	
	
	public Settings(final int NumPlayers, List<Dice> DiceList) {
		this.NumPlayers = NumPlayers;
		this.DiceList = DiceList;
	}
	
	
	public int getNumPlayers() {
		return this.NumPlayers;
	}
	
	
	public List<Dice> GetDiceList(){
		return this.DiceList;
	}
	
	
}
