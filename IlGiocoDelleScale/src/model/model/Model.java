package model.model;

import java.util.List;
import model.dice.Dice;
import utilities.Pair;

public interface Model {

	public void setSnakes(List<Pair<Integer,Integer>> snakeslist);
	
	public void setLadders(List<Pair<Integer,Integer>> ladderslist);
	
	public void setBase(int base);
	
	public void setHeight(int height);
	
	public void setDice(List<Dice> dicelist);

	public List<Pair<Integer,Integer>> getSnakes();
	
	public List<Pair<Integer,Integer>> getLadder();
	
	public int getBase();
	
	public int getHeight();
	
	public List<Dice> getDice();
	
	public void build();
}
