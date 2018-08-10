package model.converter;

import model.board.Coordinate;

public class Even extends AbstractConverter{

	public Even(int width) {
		
		super(width);
	}
	
	@Override
	public int getNumber(Coordinate coordinate) {
	
		return ((coordinate.getY()*super.getWidth())+((coordinate.getX())+1));
	}

	@Override
	public Coordinate getCoordinate(int num) {
		
		return new Coordinate((num -(this.getHeight(num)*super.getWidth())+1), (this.getHeight(num)));
	}

	
}
