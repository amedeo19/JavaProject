package model.pawns;

public interface Pawns {

	public int getPosition();
	
	public void setPosition(int pos);

	public boolean checkPossible(int pos);
}
