package model.movements;

import model.pawns.Pawns;

public interface Movements {

	/**
	 * Move the pawn
	 * @param p is the pawn
	 */
	public void changePosition(final Pawns p);
	
	/**
	 * Control if the pawn have win
	 * @param pos is the final position of the player
	 * @return if the player have win or no
	 */
	public boolean checkWin(final int pos);
	
}
