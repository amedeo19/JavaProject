package model.converter;

import utilities.Coordinate;

public class ConverterImpl implements Converter{

	private final int width;
	private final ConverterStrategy Even;
	private final ConverterStrategy Odd;
	
	public ConverterImpl(final int width) {
		
		this.width=width;
		this.Even=new Even(this.width);
		this.Odd=new Odd(this.width);
	}
	
	@Override
	public int toInt(final Coordinate coordinate) {
		
		if (this.checkIntEven(coordinate.getY())){
			return this.Even.getNumber(coordinate);
		}else{
			return this.Odd.getNumber(coordinate);
		}
	}
	
	@Override
	public Coordinate toCoordinate(final int num) {
		
		if (this.checkCooEven(this.getHeight(num))){
			return this.Even.getCoordinate(num);
		}else{
			return this.Odd.getCoordinate(num);
		}
		
	}
	
	private boolean checkIntEven(final int num){
		
		return (num%2)==0;
	}
	
	private int getHeight(final int num){
		
		return (num/this.width);
	}
	
	private boolean checkCooEven(final int num){
		
		return (num%2)==0;
	}
}
