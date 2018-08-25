package model.board;

import java.util.List;
import utilities.Coordinate;

public interface TableBuilder {
	
	public boolean isCellJump(final Coordinate cell);
	
	public Coordinate getNewPosition(final Coordinate start);
	
	public List<UpsideDown> getSnakes();
	
	public List<UpsideDown> getStairs();
}
