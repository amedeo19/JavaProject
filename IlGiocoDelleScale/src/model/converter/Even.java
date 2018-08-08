package model.converter;

import model.board.Coordinate;

public class Even implements ConverterStrategy{

	@Override
	public int getNumber(Coordinate coordinate) {
	
		return ((coordinate.getY()*10)+(coordinate.getX()));
	}

}
