package model.dice;

public interface Dice {

	public int roll();
	
	public void setNumber(int number);
	
	public int getNumber();
	
	public Dice build();
	
	public int viewNum();
}

