package model.board;

import java.util.List;
//import java.util.Observable;
import java.util.ArrayList;
import java.util.Collections;

import enumeration.MapDifficulty;
import enumeration.MapDimension;
import utilities.Coordinate;

public class TableBuilderImpl implements TableBuilder{
	
	private final int tableHeight;
	private final int tableWidth;
	private final MapDifficulty difficulty;
	private final static int LOW=4;
	private final static int MEDIUM=5;
	private final static int HIGH=6;
	private final UdStrategy snake;
	private final UdStrategy stair;
	private List<UpsideDown> snakes;
	private List<UpsideDown> stairs;
	private List<UpsideDown> jump;

	public TableBuilderImpl(final MapDifficulty difficulty,final MapDimension dimension) {
		this.difficulty=difficulty;
		this.tableHeight=(int) Math.sqrt(dimension.getDimension());
		this.tableWidth= (int) Math.sqrt(dimension.getDimension());
		this.snake = new Snake(tableHeight, tableWidth);
		this.stair = new Stair(tableHeight, tableWidth);
		this.snakes=new ArrayList<>();
		this.stairs=new ArrayList<>();
		this.jump=new ArrayList<>();
		switch (this.difficulty){
		case EASY : 
			for(int i=0; i<LOW; i++) {
				this.snakes.add(this.snake.getObject());
			}
			for(int i=0; i<HIGH; i++) {
				this.stairs.add(this.stair.getObject());
			}
			break;
		case MEDIUM:
			for(int i=0; i<MEDIUM; i++) {
				this.snakes.add(this.snake.getObject());
			}
			for(int i=0; i<MEDIUM; i++) {
				this.stairs.add(this.stair.getObject());
			}
			break;
		case DIFFICULT: 
			for(int i=0; i<HIGH; i++) {
				this.snakes.add(this.snake.getObject());
			}
			for(int i=0; i<LOW; i++) {
				this.stairs.add(this.stair.getObject());
			}
			break;
		}
		
		this.eraseStart();
		
		this.jump.addAll(this.snakes);
		this.jump.addAll(this.stairs);
		
	}
	
	private void eraseStart(){
		List<Integer> erasedList = new ArrayList<>();
		for (int i=0;i<this.stairs.size();i++){
			for (int j=0;j<this.snakes.size();j++){
				if ((this.stairs.get(i).getStart().getX() == this.snakes.get(j).getStart().getX()) && 
						(this.stairs.get(i).getStart().getY() == this.snakes.get(j).getStart().getY())){
					erasedList.add(j);
				}
			}
		}
		for (int k=0;k<erasedList.size();k++){
			this.snakes.remove(erasedList.get(k));
		}
	}
	
	@Override
	public boolean isCellJump(final Coordinate cell) {
		return this.jump.stream().anyMatch(x -> x.isInPosition(cell));
	}
	
	@Override
	public Coordinate getNewPosition(final Coordinate start) {
		return this.jump.stream().filter(x -> x.isInPosition(start)).map(x -> x.getTarget()).findFirst().get();
	}

	@Override
	public List<UpsideDown> getSnakes() {
		return Collections.unmodifiableList(this.snakes);
	}

	@Override
	public List<UpsideDown> getStairs() {
		return Collections.unmodifiableList(this.stairs);
	}

}
