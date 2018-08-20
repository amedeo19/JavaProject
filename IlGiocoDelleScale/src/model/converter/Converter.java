package model.converter;

import utilities.Coordinate;

public interface Converter {

	public int toInt(final Coordinate coordinate);
	
	public Coordinate toCoordinate(final int num);
	
}
