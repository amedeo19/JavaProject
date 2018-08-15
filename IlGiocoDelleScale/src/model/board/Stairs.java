package model.board;

public class Stairs extends AbsrtactObject{
	
	public UpsideDownImpl getStairs() {
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


	@Override
	public UpsideDownImpl getObjectStairs() {
		return null;
	}


	@Override
	public UpsideDownImpl stairs() {
		return null;
	}


	@Override
	public UpsideDownImpl getObjectSnake() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UpsideDownImpl snake() {
		// TODO Auto-generated method stub
		return null;
	}

}
