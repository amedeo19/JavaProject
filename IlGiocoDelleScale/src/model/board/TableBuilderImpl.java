package model.board;

import java.util.List;
import java.util.ArrayList;

import enumeration.MapDifficulty;
import enumeration.MapDimension;

public class TableBuilderImpl implements TableBuilder{
	private final int tableHeight;
	private final int tableWidth;
	private final MapDifficulty difficulty;
	
	private final UdStrategy snake;
	private final UdStrategy stairs;
	List<UpsideDown> jump = new ArrayList<>();


	public TableBuilderImpl(MapDifficulty difficulty,MapDimension dimension) {
		this.difficulty=difficulty;
		this.tableHeight=(int) Math.sqrt(dimension.getDimension());
		this.tableWidth= (int) Math.sqrt(dimension.getDimension());
		this.snake = new Snake(tableHeight, tableWidth);
		this.stairs = new Stairs(tableHeight, tableWidth);
		this.jump.clear();
	
		if (MapDifficulty.EASY == this.difficulty) {
			for(int i=0; i<4; i++) {
				this.jump.add(this.snake.getObject());
			}
			for(int i=0; i<6; i++) {
				this.jump.add(this.stairs.getObject());
			}
		} else if (MapDifficulty.MEDIUM == this.difficulty) {
			for(int i=0; i<6; i++) {
				this.jump.add(this.snake.getObject());
			}
			for(int i=0; i<6; i++) {
				this.jump.add(this.stairs.getObject());
			}
		} else if (MapDifficulty.DIFFICULT == this.difficulty) {
			for(int i=0; i<6; i++) {
				this.jump.add(this.snake.getObject());
			}
			for(int i=0; i<4; i++) {
				this.jump.add(this.stairs.getObject());
			}
		}
	}


	@Override
	public TableBuilderImpl CreateTable() {
		// TODO Auto-generated method stub
		return CreateTable();
	}


	public List<UpsideDown> getJump() {
		// TODO Auto-generated method stub
		return this.jump;
	}
}
