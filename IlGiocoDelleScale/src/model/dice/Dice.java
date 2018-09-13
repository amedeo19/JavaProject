package model.dice;

public interface Dice {

	/**
	 * Roll the dice
	 * @return the number of the roll dice
	 */
	public int roll();
	
	/**
	 * Set the last number appeared
	 * @param number to set
	 */
	public void setNumber(int number);
	
	/**
	 * Get the last number appeared
	 * @return the number
	 */
	public int getNumber();
	
	/**
	 * Get the number to pass to the view
	 * @return the number without special added
	 */
	public int viewNum();
}

