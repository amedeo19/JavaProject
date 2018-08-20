package model.board;

import java.util.List;

public class TableImpl implements Table{
	
	private final List<UpsideDown> udList;
	
	public TableImpl(List<UpsideDown> udList) {
		this.udList = udList;
	}
	
	@Override
	public boolean isCellJump(Coordinate cell) {
		return udList.stream().anyMatch(x -> x.isInPosition(cell));
	}
	
	@Override
	public Coordinate getNewPosition(Coordinate start) {
		return udList.stream().filter(x -> x.isInPosition(start)).map(x -> x.getTarget()).findFirst().get();
	}

}
