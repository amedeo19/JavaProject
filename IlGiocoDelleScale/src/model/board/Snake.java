package model.board;

import enumeration.*;
import utilities.Coordinate;

public class Snake extends AbstractObject{

	public Snake(int tableHeight, int tableWidth) {
		super(tableHeight, tableWidth);
	}

	@Override
	public UpsideDown getObject() {
		Coordinate start = null;
		Coordinate stop = null;
		do { 
			start = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(FINAL,super.tableHeight-FINAL));
			stop = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(START,start.getY()));
		}while (start.equals(stop));
		
		return new UpsideDownImpl(start, stop, UpsideDownType.SNAKE);
	}


}
