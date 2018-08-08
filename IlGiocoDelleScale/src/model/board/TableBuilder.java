package model.board;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TableBuilder {
	
	private final int tableHeight = 10;
	private final int tableWidth = 10;
	
	public final List<Coordinate> tableLiStart  = new LinkedList<>();
	public final List<Coordinate> tableLiStop = new LinkedList<>();
	Random random = new Random();

	
	private int randInt(int min, int max) {
	    int randomNum = random.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	public UpsideDownImpl s1() {
		Coordinate start = null;
		Coordinate stop =null;
		do {
			start = new Coordinate(randInt(0,tableWidth-1), randInt(5,tableHeight-1));
			stop = new Coordinate(randInt(0,tableWidth-1), randInt(0,start.getY()-1));
		//studiare pattern e strategy per vedere la creazione delle scale perche opposta
			//manca da fare l'interfaccia della table e l'interfaccia del builder
		}while (start != stop && !tableLiStart.contains(start) && !tableLiStart.contains(stop));
		
		tableLiStart.add(start);
		tableLiStop.add(stop);
		return new UpsideDownImpl(start, stop, UpsideDownType.SNAKE);
	}
	

}
