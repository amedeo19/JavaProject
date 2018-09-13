package model.data;

import java.util.List;

import model.dice.Dice;

public interface Data {

	/**
	 * @return the cell's number
	 */
	public int getFinishNumber();
	
	/**
	 * @return the dice's list 
	 */
	public List<Dice> getDice();
	
}
