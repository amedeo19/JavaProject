package model.model;

import model.data.Data;
import model.pawns.Pawns;

public interface Model {
	
	public Model getLog();
	
	public void check();
	
	public boolean checkWin(Pawns p);
	
	public void startGame(Data data);
	
	public int movePawn(Pawns p);
	
	public void endGame();
	
	public void changeDone();
	
}
