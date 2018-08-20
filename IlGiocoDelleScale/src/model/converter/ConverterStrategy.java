package model.converter;

import utilities.Coordinate;

public interface ConverterStrategy {

	public int getNumber(final Coordinate coordinate);

	public Coordinate getCoordinate(final int num);
	
}
