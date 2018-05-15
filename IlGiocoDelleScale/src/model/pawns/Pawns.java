package model.pawns;

import enumeration.Characters;
import utilities.Pair;

public interface Pawns {

	public Pair<Integer,Integer> getPosition();
	
	public void setPosition(Pair<Integer,Integer> pos);

	public boolean checkPossible(Pair<Integer, Integer> pos);
	
	public void setPawn(Characters car);
	
	public Characters getPawn();
}
