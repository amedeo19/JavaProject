package model.board;

import enumeration.UpsideDownType;

public class UpsideDownImpl implements UpsideDown {

	private final Coordinate start;
	private final Coordinate finish;
	private final UpsideDownType type;
	
	public UpsideDownImpl(Coordinate start, Coordinate finish, UpsideDownType type) {
		this.start = start;
		this.finish = finish;
		this.type = type;
	}

	@Override
	public Coordinate getStart() {
		return start;
	}

	@Override
	public boolean isInPosition(Coordinate position) {
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
