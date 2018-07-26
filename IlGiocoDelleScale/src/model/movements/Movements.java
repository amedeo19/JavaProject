package model.movements;

import model.data.Data;
import model.pawns.Pawns;

public interface Movements {

	public void changePosition(Pawns p);
	
	public int dicePosition(int initialPosition, int diceNumber);
	
	public void setData(Data data);
	
	public Data getData();
	
	public void reset();
	
	public boolean checkWin(int pos);
	
	public void build();
	
	
}
