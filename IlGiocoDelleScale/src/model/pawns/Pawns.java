package model.pawns;

import enumeration.Characters;

public interface Pawns {

	public int getPosition();
	
	public void setPosition(int pos);

	public boolean checkPossible(int pos);
	
	public void setPawn(Characters car);
	
	public Characters getPawn();
}
