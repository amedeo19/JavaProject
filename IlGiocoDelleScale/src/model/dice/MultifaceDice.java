package model.dice;

public class MultifaceDice implements Dice{

	private final Dice dice;
	private final int face;
	private final int MAXFACE=20;
	private final int MINFACE=4;
	private boolean done=false;
	
	public MultifaceDice(int numberOfFace,Dice dice) {
		super();
		this.dice=dice;
		this.face=numberOfFace;
	}
	
	public boolean isDone(){
		if (!this.done){
			throw new IllegalStateException("You haven't already roll");
		}
		return false;
	}
	
	@Override
	public int roll() {
		this.done=true;
		int number;
		do {
			number=this.dice.roll();
		}while (!this.checkResult(number));
		return this.getNumber();
	}
	
	public boolean checkResult(int number){
		if (number>this.face){
			return false;
		}
		this.setNumber(number);
		return true;
	}

	@Override
	public void setNumber(int number) {
		this.isDone();
		this.dice.setNumber(number);
	}

	@Override
	public int getNumber() {
		this.isDone();
		return this.dice.getNumber();
	}

	@Override
	public Dice build() {
		if (this.face<MINFACE){
			throw new IllegalStateException("Too low numbers");
		}else if (this.face>MAXFACE){
			throw new IllegalStateException("Too much numbers");
		}
		return dice.build();
	}

	@Override
	public int viewNum() {
		return this.getNumber();
	}

}

