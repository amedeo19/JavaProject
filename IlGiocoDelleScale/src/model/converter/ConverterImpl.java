package model.converter;

import model.board.Coordinate;

public class ConverterImpl implements Converter{

	private final int width;
	private final ConverterStrategy Even;
	private final ConverterStrategy Odd;
	
	public ConverterImpl(int width) {
		
		this.width=width;
		this.Even=new Even();
		this.Odd=new Odd(this.width);
	}
	
	@Override
	public int convert(Coordinate coordinate) {
		
		if (this.checkEven(coordinate.getY())){
			return this.Even.getNumber(coordinate);
		}else{
			return this.Odd.getNumber(coordinate);
		}
	}
	
	private boolean checkEven(int num){
		
		return (num%2)==0;
	}

}
