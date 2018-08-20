package model.movements;

import model.pawns.Pawns;

public interface Movements {

	public void changePosition(Pawns p);
	
	public boolean checkWin(int pos);	
	
}
