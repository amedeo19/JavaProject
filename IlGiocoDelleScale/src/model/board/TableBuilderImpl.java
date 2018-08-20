package model.board;

import java.util.List;
import java.util.ArrayList;

import enumeration.MapDifficulty;
import enumeration.MapDimension;

public class TableBuilderImpl implements TableBuilder{
	
	private final int tableHeight;
	private final int tableWidth;
	private final MapDifficulty difficulty;
	private final static int LOW=4;
	private final static int HIGH=6;
	private final UdStrategy snake;
	private final UdStrategy stair;
	List<UpsideDown> jump = new ArrayList<>();


	public TableBuilderImpl(MapDifficulty difficulty,MapDimension dimension) {
		this.difficulty=difficulty;
		this.tableHeight=(int) Math.sqrt(dimension.getDimension());
		this.tableWidth= (int) Math.sqrt(dimension.getDimension());
		this.snake = new Snake(tableHeight, tableWidth);
		this.stair = new Stair(tableHeight, tableWidth);
		this.jump.clear();
	
//		switch (this.difficulty){
//		
//		}
		if (MapDifficulty.EASY.equals(this.difficulty)) {
			for(int i=0; i<LOW; i++) {
				this.jump.add(this.snake.getObject());
			}
			for(int i=0; i<HIGH; i++) {
				this.jump.add(this.stair.getObject());
			}
		} else if (MapDifficulty.MEDIUM.equals(this.difficulty)) {
			for(int i=0; i<HIGH; i++) {
				this.jump.add(this.snake.getObject());
			}
			for(int i=0; i<HIGH; i++) {
				this.jump.add(this.stair.getObject());
			}
		} else if (MapDifficulty.DIFFICULT.equals(this.difficulty)) {
			for(int i=0; i<HIGH; i++) {
				this.jump.add(this.snake.getObject());
			}
			for(int i=0; i<LOW; i++) {
				this.jump.add(this.stair.getObject());
			}
		}
		
		
	}


	public List<UpsideDown> getJump() {
		return this.jump;
	}
}
