package model.data;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import model.dice.Dice;

public class DataImpl implements Data{

	Optional<List<Dice>> diceList;
	Optional<Integer> lastNumber;
	boolean done;
	private final static int MINFINISH=30;
	private final static int MAXFINISH=200;
	private static final int MAXDICE=3;
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Build Error");
	private static final Supplier<RuntimeException> diceError = () -> new IllegalStateException("Dice Error");
	private static final Supplier<RuntimeException> cellError = () -> new IllegalStateException("Error with number of cell");
	private static final Supplier<RuntimeException> dataError = () -> new IllegalStateException("Not already built");
	
	private static final Data SINGLETON = new DataImpl();
	
	public static Data getData() {
        return SINGLETON;
	}
	
	private void isDone() {								
		
		if (!this.done){
			throw buildError.get();
		}
	}
	
	private void checkNotDone() {								
		
		if (this.done){
			throw dataError.get();
		}
	}
	
	@Override
	public void setDice(List<Dice> listDice) {
		
		this.checkNotDone();
		if ((listDice.isEmpty()) || (listDice.size())>MAXDICE){
			throw diceError.get();
		} 
		this.diceList=Optional.of(listDice);
	}

	@Override
	public void build() {
		
		this.checkNotDone();
		if (!this.diceList.isPresent()){
			throw diceError.get();
		}
		if (!this.lastNumber.isPresent()){
			throw cellError.get();
		}
		this.done=true;
	}

	@Override
	public void reset() {
		
		this.diceList=Optional.empty();
		this.lastNumber=Optional.empty();
		this.done=false;
	}

	@Override
	public void setFinish(int finish) {// control if >0 and if already built
		
		this.checkNotDone();
		if ((finish<MINFINISH) || (finish>MAXFINISH)){
			throw cellError.get();
		}
		this.lastNumber=Optional.of(finish);
	}	
	
	@Override
	public int getFinishNumber() {
		
		this.isDone();
		return this.lastNumber.get();
	}

	@Override
	public List<Dice> getDice() {
		
		this.isDone();
		return this.diceList.get();
	}
	
	
}
