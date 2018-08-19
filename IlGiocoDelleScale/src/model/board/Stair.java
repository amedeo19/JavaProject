package model.board;

import enumeration.*;

public class Stair extends AbstractObject{
	
	private final static int START=0;
	private final static int FINAL=1;
	private final static int LAST=2;
	
	public Stair(int tableHeight, int tableWidth) {
		super(tableHeight, tableWidth);
	}
	
	@Override
	public UpsideDownImpl getObject() {
		Coordinate start = null;
		Coordinate stop =null;
		do {
			start = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(START,super.tableHeight-LAST));
			stop = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(start.getY(),super.tableHeight-FINAL));
		}while (start.equals(stop));
		
		return new UpsideDownImpl(start, stop, UpsideDownType.STAIR);
	}

}
