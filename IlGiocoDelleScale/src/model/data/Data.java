package model.data;

import java.util.List;

import model.dice.Dice;

public interface Data {

	public int getFinishNumber();
	
	public List<Dice> getDice();
	
	public void setDice(List<Dice> dicelist);
	
	public void setFinish(int finish);
	
	public void reset();
	
	public void build();
	
}
