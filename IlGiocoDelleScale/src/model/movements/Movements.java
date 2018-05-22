package model.movements;

import model.data.Data;
import model.pawns.Pawns;

public interface Movements {

	public void changePosition(Pawns p);
	
	public void setData(Data data);
	
	public Data getData();
	
	public void done(boolean value);
	
	public void reset();
	
	public boolean checkWin(int pos);
	
}
