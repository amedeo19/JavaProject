package view.pawn;

import enumeration.Characters;
import model.pawns.Pawns;

public interface PawnView {
	
	
	void SetInitPos();
	
	Characters getPawn();
	
	
	void MovePawn(Pawns p, int pos);
	
	
	int getPosition();
	
}
