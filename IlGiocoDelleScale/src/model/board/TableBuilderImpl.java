package model.board;

import java.util.List;
import java.util.ArrayList;

import enumeration.MapDifficulty;
import enumeration.MapDimension;

public class TableBuilderImpl implements TableBuilder{
	private final int tableHeight = 10;
	private final int tableWidth = 10;
	private final MapDifficulty difficulty;
	private final MapDimension dimension;
	
	UdStrategy snake = new Snake(tableHeight, tableWidth);
	UdStrategy stairs = new Stairs(tableHeight, tableWidth);
	List<UpsideDown> jump = new ArrayList<>();


	public TableBuilderImpl(MapDifficulty difficulty,MapDimension dimension) {
		this.difficulty=difficulty;
		this.dimension=dimension;
		this.jump.clear();
	
		if (MapDifficulty.EASY == this.difficulty) {
			for(int i=0; i<4; i++) {
				UpsideDown snakeReal = this.snake.getObject();
				this.jump.add(snakeReal);
			}
			for(int i=0; i<6; i++) {
				UpsideDown stairsReal = this.stairs.getObject();
				this.jump.add(stairsReal);
			}
		} else if (MapDifficulty.MEDIUM == this.difficulty) {
			for(int i=0; i<6; i++) {
				UpsideDown snakeReal = this.snake.getObject();
				this.jump.add(snakeReal);
			}
			for(int i=0; i<6; i++) {
				UpsideDown stairsReal = this.stairs.getObject();
				this.jump.add(stairsReal);
			}
		} else if (MapDifficulty.DIFFICULT == this.difficulty) {
			for(int i=0; i<6; i++) {
				UpsideDown snakeReal = this.snake.getObject();
				this.jump.add(snakeReal);
			}
			for(int i=0; i<4; i++) {
				UpsideDown stairsReal = this.stairs.getObject();
				this.jump.add(stairsReal);
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
