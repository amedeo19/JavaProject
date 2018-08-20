package model.board;

public interface Table {

	public boolean isCellJump(Coordinate cell);
	
	public Coordinate getNewPosition(Coordinate start);
	
}
