package model.movements;

import java.util.Optional;
import java.util.function.Supplier;

import model.data.Data;
import model.pawns.Pawns;

public class MovementsImpl implements Movements {
	
	private Strategy strategy;
	private Optional<Data> Data;
	private boolean done;
	private static final Supplier<RuntimeException> dataError = () -> new IllegalStateException("Error data");
	
	public MovementsImpl() {
		this.strategy=StrategyImpl.getLog();
	}
	
	private static class LazyHolder { // Singleton bene?? Aggiungere la classe LazyHolder alle utilities?
		private static final MovementsImpl SINGLETON = new MovementsImpl();
	}
	
	public static MovementsImpl getLog() {
		return LazyHolder.SINGLETON;
	}
	
	@Override
	public void changePosition(Pawns p) {
		this.done(true);
		p.setPosition(p.getPosition()+this.strategy.dicePosition(p.getPosition(),
				this.getData().getDice().stream().mapToInt(d->d.roll()).sum(),
				this.getData().getFinishNumber())); // Strategy
	}

	@Override
	public void setData(Data data) {
		this.Data=Optional.ofNullable(data);
		this.done(false);
		this.done=true;
	}

	@Override
	public void done(boolean value) {
		if (this.done!=value){
			throw dataError.get();
		}
	}

	@Override
	public Data getData() {
		this.done(true);
		return this.Data.get();
	}

	@Override
	public void reset() {

		this.done=false;
		this.Data=Optional.empty();
	}

	@Override
	public boolean checkWin(int pos) {
		if (pos==this.Data.get().getFinishNumber()){
			return true;
		}
		return false;
	}
	
	

}
