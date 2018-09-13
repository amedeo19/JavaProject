package model.board;

import enumeration.*;
import utilities.Coordinate;

public class Snake extends AbstractObject{

	public Snake(final int tableHeight,final int tableWidth) {
		super(tableHeight, tableWidth);
	}

	@Override
	public UpsideDown getObject() {
		Coordinate start = null;
		Coordinate stop = null;
		do { 
			start = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(FINAL,super.tableHeight-FINAL));
			this.changeStart(start);
			stop = new Coordinate(this.randNum(START,super.tableWidth-FINAL), this.randNum(START,start.getY()));
		}while (start.equals(stop));
		
		return new UpsideDownImpl(start, stop, UpsideDownType.SNAKE);
	}

	private void changeStart(Coordinate start){
		if ((start.getX()==START)&&(start.getY()==(super.tableHeight-FINAL))){
			start = new Coordinate(FINAL,(super.tableHeight-(FINAL)));
		}
	}
	
}
