package model.dice;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class MultifaceDice implements Dice{

	private Optional<Integer> number;
	private boolean build=false;
	private final int face;
	private final Random randomNumber = new Random();
	private final static int MAXFACE=20;
	private final static int MINFACE=4;
	private static final Supplier<RuntimeException> minError = () -> new IllegalStateException("Too low numbers");
	private static final Supplier<RuntimeException> maxError = () -> new IllegalStateException("Too much numbers");
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Build Error");
	private static final Supplier<RuntimeException> rollError = () -> new IllegalStateException("Roll Error");

	
	public MultifaceDice(int numberOfFace) {
		
		super();
		this.face=numberOfFace;
	}
	
	private void isBuilt(){
		if (!this.build){
			throw rollError.get();
		}
	}

    private void checkNotBuilt(){
    	
    	if (this.build){
            throw buildError.get();
        }
    }
	
	@Override
	public int roll() {
		
		this.isBuilt();
		this.setNumber(this.randomNumber.nextInt(this.face) + 1);
		return this.getNumber();
	}
	
	@Override
	public void setNumber(int number) {
	
		this.isBuilt();;
		this.number=Optional.of(number);
	}

	@Override
	public int getNumber() {
		
		this.isBuilt();
		return this.number.get();
	}

	@Override
	public void build() {
		
		if (this.face<MINFACE){
			throw minError.get();
		}else if (this.face>MAXFACE){
			throw maxError.get();
		}

		this.checkNotBuilt();
		this.build=true;
	}
	
	@Override
	public int viewNum() {
		return this.getNumber();
	}

}

