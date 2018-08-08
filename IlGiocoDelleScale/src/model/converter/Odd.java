package model.converter;

import model.board.Coordinate;

public class Odd implements ConverterStrategy{

	private final int width; 
	
	public Odd(int width) {
		
		this.width=width;
	}
	
	@Override
	public int getNumber(Coordinate coordinate) {
		return ((coordinate.getY()*10)+(this.width-(coordinate.getX()+1)));
	}

}
