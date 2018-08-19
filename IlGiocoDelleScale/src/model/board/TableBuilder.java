
package model.board;

import java.util.Random;


import enumeration.MapDifficulty;
import enumeration.MapDimension;

public class TableBuilder implements Table {
	
	private final int tableHeight = 10;
	private final int tableWidth = 10;
	private final MapDifficulty difficulty;
	private final MapDimension dimension;
	
	UdStrategy snake = new Snake();
	UdStrategy stairs = new Stairs();


	public TableBuilder(MapDifficulty difficulty,MapDimension dimension) {
		this.difficulty=difficulty;
		this.dimension=dimension;
	
		if (MapDifficulty.EASY == this.difficulty) {
			for(int i=0; i<4; i++) {
				UpsideDown snakeReal = this.snake.getObjectSnake(tableHeight, tableWidth);
			}
			for(int i=0; i<6; i++) {
				UpsideDown stairsReal = this.stairs.getObjectStairs(tableHeight, tableWidth);
			}
		}
	}
	
}
	

		


	
	
	



