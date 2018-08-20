package model.converter;

import utilities.Coordinate;

public interface Converter {

	public int toInt(Coordinate coordinate);
	
	public Coordinate toCoordinate(int num);
	
}
