package model.converter;

import utilities.Coordinate;

public interface ConverterStrategy {

	public int getNumber(Coordinate coordinate);

	public Coordinate getCoordinate(int num);
	
}
