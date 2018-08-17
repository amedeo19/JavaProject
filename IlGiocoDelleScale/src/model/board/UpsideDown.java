package model.board;

import enumeration.UpsideDownType;

public interface UpsideDown {
	
	boolean isInPosition(Coordinate position);
	
	Coordinate getTarget();
	
	UpsideDownType getType();
}
