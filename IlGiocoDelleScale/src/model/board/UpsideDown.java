package model.board;
import enumeration.*;
public interface UpsideDown {
	
	boolean isInPosition(Coordinate position);
	
	Coordinate getTarget();
	
	Coordinate getStart();
	
	UpsideDownType getType();
}
