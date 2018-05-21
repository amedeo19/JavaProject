package model.data;

import java.util.List;
import model.dice.Dice;

public interface DataBuilder {

	public void isDone();
	
	public DataBuilder setDice(List<Dice> dicelist);
	
	public DataBuilder setFinish(int finish);
	
	public void reset();
	
	public void build();
	
}
