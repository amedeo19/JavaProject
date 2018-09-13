package model.board;

import java.util.List;
import utilities.Coordinate;

public interface TableBuilder {
	
	/**
	 * Control if the cell is a start of a jump 
	 * @param cell is the cell that i have to control
	 * @return a boolean, true is jump and false no
	 */
	public boolean isCellJump(final Coordinate cell);
	
	/**
	 * Return the position after jump
	 * @param start is the initial position
	 * @return a coordinate that indicate the position after jump
	 */
	public Coordinate getNewPosition(final Coordinate start);
	
	/**
	 * @return the snakes' list
	 */
	public List<UpsideDown> getSnakes();
	
	/**
	 * @return the stairs' list
	 */
	public List<UpsideDown> getStairs();
}
