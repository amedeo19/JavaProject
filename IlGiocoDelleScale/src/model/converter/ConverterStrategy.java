package model.converter;

import utilities.Coordinate;

public interface ConverterStrategy {

	/**
	 * Convert Coordinate into int 
	 * @param coordinate position
	 * @return int position
	 */
	public int getNumber(final Coordinate coordinate);

	/**
	 * Convert int to Coordinate
	 * @param num (int) position
	 * @return Coordinate position
	 */
	public Coordinate getCoordinate(final int num);
	
}
