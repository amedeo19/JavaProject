package model.board;

import enumeration.*;

public class Snake extends AbstractObject{

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
			start = new Coordinate(randInt(0,super.tableWidth-1), randInt(1,super.tableHeight-1));
			stop = new Coordinate(randInt(0,super.tableWidth-1), randInt(0,start.getY()-1));
		}while ((start == stop) || (tableLiStart.contains(start)) || (tableLiStart.contains(stop)));
		
		tableLiStart.add(start);
		tableLiStop.add(stop);
		return new UpsideDownImpl(start, stop, UpsideDownType.SNAKE);
	}


}
