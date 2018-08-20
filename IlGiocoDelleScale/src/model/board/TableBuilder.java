package model.board;

import java.util.List;

import utilities.Coordinate;

public interface TableBuilder {
	
	public boolean isCellJump(Coordinate cell);
	
	public Coordinate getNewPosition(Coordinate start);
	
	public List<UpsideDown> getSnakes();
	
	public List<UpsideDown> getStairs();
}
