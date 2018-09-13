package model.board;

import enumeration.*;
import utilities.Coordinate;

public interface UpsideDown {
	
	/**
	 * Control if the position is the same of the start of that snake
	 * @param position to control
	 * @return true if is the start of jump or no
	 */
	boolean isInPosition(final Coordinate position);
	
	/**
	 * @return end's coordinate 
	 */
	Coordinate getTarget();
	
	/**
	 * @return start's coordinate
	 */
	Coordinate getStart();
	
	/**
	 * @return type's of the jump (snake or stair)
	 */
	UpsideDownType getType();
	
	/**
	 * @return a string that describe jump
	 */
	String print();
}
