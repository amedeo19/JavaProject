package model.board;

import utilities.Coordinate;

public interface TableBuilder {
	
	public boolean isCellJump(Coordinate cell);
	
	public Coordinate getNewPosition(Coordinate start);
}
