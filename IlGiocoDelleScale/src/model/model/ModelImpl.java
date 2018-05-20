package model.model;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import model.dice.Dice;
import model.movements.Movements;
import model.pawns.Pawns;

public class ModelImpl implements Model{

	Movements move;
	Optional<List<Dice>> diceList;
	Optional<Integer> lastNumber;
	boolean done;
	private static final int MAXDICE=3;
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Build Error");
	private static final Supplier<RuntimeException> diceError = () -> new IllegalStateException("Dice Error");
	
	
	public ModelImpl() {
		this.reset(); 
	}
	

	private static class LazyHolder { // Singleton bene??
		private static final ModelImpl SINGLETON = new ModelImpl();
	}
	
	public static ModelImpl getLog() {
		return LazyHolder.SINGLETON;
	}
	

	@Override
	public void setDice(List<Dice> dicelist) {

		this.isDone(false);
		this.diceList=Optional.ofNullable(dicelist);
	}

	@Override
	public List<Dice> getDice() {
		
		this.isDone(true);
		return this.diceList.get();
	}

	@Override
	public void build() {
		
		this.isDone(false);
		if (!this.diceList.isPresent() || this.diceList.get().size()>MAXDICE){
			throw diceError.get();
		}
		if (!this.lastNumber.isPresent()){
			throw new IllegalStateException("Error with number of cell");
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
		if (finish<=0){
			throw new IllegalStateException("Unreal finish");
		}
		this.lastNumber=Optional.of(finish);
	}

	@Override
	public int getFinishNumber() { 
		this.isDone(true);
		return this.lastNumber.get();
	}

	
	@Override
	public void isDone(boolean value) {// va bene col true?
		if (this.done!=value){
			throw buildError.get();
		}
	}


	@Override
	public int movePawn(Pawns p) {
		this.isDone(true);
		this.move.changePosition(p, this.diceList.get(),this.lastNumber.get());
		p.setState(!p.getState());
		return p.getPosition();
	}
	


}
