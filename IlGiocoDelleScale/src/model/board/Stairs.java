package model.board;
import enumeration.*;

public class Stairs extends AbsrtactObject{
	
	public Stairs(int tableHeight, int tableWidth) {
		super(tableHeight, tableWidth);
	}
	
	@Override
	public UpsideDownImpl getObject() {
		Coordinate start = null;
		Coordinate stop =null;
		do {
			start = new Coordinate(randInt(0,tableWidth-1), randInt(tableHeight-4,tableHeight-1));
			stop = new Coordinate(randInt(0,tableWidth-1), randInt(start.getY()+1,start.getY()-1));
		}while (start != stop && !tableLiStart.contains(start) && !tableLiStart.contains(stop));
		
		tableLiStart.add(start);
		tableLiStop.add(stop);
		return new UpsideDownImpl(start, stop, UpsideDownType.STAIR);
	}

}
