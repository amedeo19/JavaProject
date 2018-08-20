package model.board;

import enumeration.UpsideDownType;
import utilities.Coordinate;

public class UpsideDownImpl implements UpsideDown {

	private final Coordinate start;
	private final Coordinate finish;
	private final UpsideDownType type;
	
	public UpsideDownImpl(final Coordinate start,final Coordinate finish,final UpsideDownType type) {
		this.start = start;
		this.finish = finish;
		this.type = type;
	}

	@Override
	public Coordinate getStart() {
		return start;
	}

	@Override
	public boolean isInPosition(final Coordinate position) {
		return position.equals(this.start);
	}

	@Override
	public Coordinate getTarget() {
		return finish;
	}

	@Override
	public UpsideDownType getType() {		
		return type;
	}
	
	
	
	
}
