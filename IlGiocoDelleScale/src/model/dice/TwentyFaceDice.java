package model.dice;

import java.util.Optional;
import java.util.Random;

public class TwentyFaceDice implements Dice{

	private Optional<Integer> number;
	final private int MAXNUMBER=20;
    private boolean done = false;
    
    private void checkDone(){
        if (this.done){
            throw new IllegalStateException("You have already built");
        }
    }
    
    private void checkNotDone(){
    	if (!this.done){
            throw new IllegalStateException("You haven't already built");
        }
    }
	
	@Override
	public int roll() {
		this.checkNotDone();final Random randomNumber = new Random();
		this.number = Optional.of(randomNumber.nextInt(this.MAXNUMBER) + 1);
		return this.getNumber();
	}

	@Override
	public void setNumber(int number) {
		this.checkNotDone();
		this.number=Optional.of(number);
	}

	@Override
	public int getNumber() {
		this.checkNotDone();
		return this.number.get();
	}

	@Override
	public Dice build() {
		this.checkDone();
        this.done = true;
        return new ClassicDice();
	}

	@Override
	public int viewNum() {
		return this.getNumber();
	}

}

