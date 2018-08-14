package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.board.Coordinate;
import model.dice.Dice;
import model.pawns.Pawns;

public interface Controller {

	
	public void start(Map<Optional<Integer>, Dice> DiceMap, int lastNumber, List<Character> Character);
	
	public void FinishGame(int turn) throws IOException;
	
	public void Play();
	
	public int ConverteToInt(Coordinate coordinate);
	
	public Coordinate ConverteToCoordinate(int pos);


}
