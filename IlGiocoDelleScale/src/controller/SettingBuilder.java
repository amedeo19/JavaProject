package controller;

import java.util.List;

import model.dice.Dice;

public class SettingBuilder {

	private int NumPlayers;
	private List<Dice> DiceList;
	
	
	
	
	public SettingBuilder NumPlayers(final int NumPlayers) {
		this.NumPlayers = NumPlayers;
		return this;
	}
	
	
	public SettingBuilder Dice(final List<Dice> DiceList) {
		this.DiceList = DiceList;
		return this;
	}
	
	
	
	public Settings build() {
		return new Settings(NumPlayers, DiceList);
	}
	
	
}
