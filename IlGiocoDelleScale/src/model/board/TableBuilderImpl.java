package model.board;

import java.util.List;
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
	
//		switch (this.difficulty){
//		
//		}
		if (MapDifficulty.EASY.equals(this.difficulty)) {
			for(int i=0; i<LOW; i++) {
				this.snakes.add(this.snake.getObject());
			}
			for(int i=0; i<HIGH; i++) {
				this.stairs.add(this.stair.getObject());
			}
		} else if (MapDifficulty.MEDIUM.equals(this.difficulty)) {
			for(int i=0; i<HIGH; i++) {
				this.snakes.add(this.snake.getObject());
			}
			for(int i=0; i<HIGH; i++) {
				this.stairs.add(this.stair.getObject());
			}
		} else if (MapDifficulty.DIFFICULT.equals(this.difficulty)) {
			for(int i=0; i<HIGH; i++) {
				this.snakes.add(this.snake.getObject());
			}
			for(int i=0; i<LOW; i++) {
				this.stairs.add(this.stair.getObject());
			}
		}
		this.jump.addAll(this.snakes);
		this.jump.addAll(this.stairs);
		
		
		
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
