package controller;

import java.io.IOException;
import java.util.List;

import model.dice.Dice;

public interface Controller {

	
	public void rollDice();
	
	public void start();
	
	public void FinishGame() throws IOException;
	
	public void Play(int NumPlayers, List<Dice> DiceList);

}
