package model.converter;

import utilities.Coordinate;

public abstract class AbstractConverter implements ConverterStrategy{

	private final int width;
	
	public AbstractConverter(final int width) {
		this.width=width;
	}
	
	public abstract int getNumber(Coordinate coordinate);

	public abstract Coordinate getCoordinate(int num);
	
	protected int getHeight(final int num){
		
		return (num/this.getWidth());
	}

	protected int getWidth() {
		return width;
	}

	
	
}
