package model.board;

import enumeration.*;
import utilities.Coordinate;

public interface UpsideDown {
	
	boolean isInPosition(final Coordinate position);
	
	Coordinate getTarget();
	
	Coordinate getStart();
	
	UpsideDownType getType();
}
