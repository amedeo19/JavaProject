package controller;

import java.io.IOException;
import java.util.List;

import model.dice.Dice;
import model.pawns.Pawns;

public interface Controller {

	
	public void start(List<Dice> list, int lastNumber, List<Pawns> Pawns);
	
	public void FinishGame(int turn) throws IOException;
	
	public void Play();

}
