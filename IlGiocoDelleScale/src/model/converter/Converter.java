package model.converter;

import utilities.Coordinate;

public interface Converter {

	/**
	 * Convert Coordinate into int 
	 * @param coordinate position
	 * @return int position
	 */
	public int toInt(final Coordinate coordinate);
	
	/**
	 * Convert int to Coordinate
	 * @param num (int) position
	 * @return Coordinate position
	 */
	public Coordinate toCoordinate(final int num);
	
}
