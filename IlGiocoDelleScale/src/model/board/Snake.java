package model.board;

import enumeration.*;

public class Snake extends AbsrtactObject{

	private final static int START=0;
	private final static int FINAL=1;
	
	public Snake(int tableHeight, int tableWidth) {
		super(tableHeight, tableWidth);
		System.out.println(tableHeight);
		System.out.println(tableWidth);
	}

	@Override
	public UpsideDownImpl getObject() {
		Coordinate start = null;
		Coordinate stop =null;
		do { 
			start = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(FINAL,super.tableHeight-FINAL));
			stop = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(START,start.getY()));
		}while (start.equals(stop));
		
		return new UpsideDownImpl(start, stop, UpsideDownType.SNAKE);
	}


}
