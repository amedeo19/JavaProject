package model.model;

import java.util.List;
import model.dice.Dice;
import model.pawns.Pawns;

public interface Model {
	
	public void isDone(boolean value);
	
	public void setDice(List<Dice> dicelist);
	
	public void setFinish(int finish);
		
	public int getFinishNumber();
	
	public List<Dice> getDice();
	
	public void reset();
	
	public void build();
	
	public int movePawn(Pawns p);
	
}
