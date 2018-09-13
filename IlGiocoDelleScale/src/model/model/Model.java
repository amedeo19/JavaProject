package model.model;

import model.pawns.Pawns;

public interface Model {

	/**
	 * Control if the player have win
	 * @param p is the pawn
	 * @return a flag that check win or not
	 */
	public boolean checkWin(Pawns p);
	
	/**
	 * Move the pawn
	 * @param p is the pawn
	 * @return the new position of the pawn without a possible jump
	 */
	public int movePawn(Pawns p);
}
