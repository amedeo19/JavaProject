package model.data;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import model.dice.Dice;

public class DataImpl implements Data{

	Optional<List<Dice>> diceList;
	Optional<Integer> lastNumber;
	
	public DataImpl(List<Dice> diceList,int cellNumber) {
		super();
		this.diceList=Optional.of(diceList);
		this.lastNumber=Optional.of(cellNumber);
	}
	
	@Override
	public int getFinishNumber() {
		return this.lastNumber.get();
	}

	@Override
	public List<Dice> getDice() {
		return this.diceList.get();
	}
	

	public static class DataBuilderImpl implements DataBuilder{

		Optional<List<Dice>> diceList;
		Optional<Integer> lastNumber;
		boolean done;
		private final static int MINFINISH=30;
		private final static int MAXFINISH=200;
		private static final int MAXDICE=3;
		private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Build Error");
		private static final Supplier<RuntimeException> diceError = () -> new IllegalStateException("Dice Error");
		private static final Supplier<RuntimeException> cellError = () -> new IllegalStateException("Error with number of cell");
		
		public DataBuilderImpl() {
			this.reset();
		}
		
		@Override
		public DataBuilderImpl setDice(List<Dice> listDice) {
			
			this.isDone();
			if ((listDice.isEmpty()) || (listDice.size())>MAXDICE){
				throw diceError.get();
			} 
			this.diceList=Optional.of(listDice);
			return this;
		}

		@Override
		public void build() {
			
			this.isDone();
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
		public DataBuilder setFinish(int finish) {// control if >0 and if already built
			if ((finish<MINFINISH) || (finish>MAXFINISH)){
				throw cellError.get();
			}
			this.lastNumber=Optional.of(finish);
			return this;
		}

		
		@Override
		public void isDone() {// va bene col true?
			if (this.done){
				throw buildError.get();
			}
		}
		
	}

	
}
