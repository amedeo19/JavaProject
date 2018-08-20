package model.movements;

import model.pawns.Pawns;

public interface Movements {

	public void changePosition(final Pawns p);
	
	public boolean checkWin(final int pos);	
	
}
