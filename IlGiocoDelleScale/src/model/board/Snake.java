package model.board;

public class Snake extends AbsrtactObject{

	public UpsideDownImpl getSnake() {
		Coordinate start = null;
		Coordinate stop =null;
		do {
			start = new Coordinate(randInt(0,tableWidth-1), randInt(5,tableHeight-1));
			stop = new Coordinate(randInt(0,tableWidth-1), randInt(0,start.getY()-1));
		}while (start != stop && !tableLiStart.contains(start) && !tableLiStart.contains(stop));
		
		tableLiStart.add(start);
		tableLiStop.add(stop);
		return new UpsideDownImpl(start, stop, UpsideDownType.SNAKE);
	}

	@Override
	public UpsideDownImpl getObjectSnake() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpsideDownImpl getObjectStairs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpsideDownImpl snake() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpsideDownImpl stairs() {
		// TODO Auto-generated method stub
		return null;
	}
}
