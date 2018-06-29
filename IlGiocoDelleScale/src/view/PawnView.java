package view;

import enumeration.Characters;
import model.pawns.Pawns;

public interface PawnView {
	
	
	Characters getPawn();
	
	
	void MovePawn(Pawns p);
	
	
	int getPosition();
	
}
