package model.movements;

import java.util.Optional;
import java.util.function.Supplier;
import model.data.Data;
import model.pawns.Pawns;

public class MovementsImpl implements Movements {
	
	private int finalPosition;
	private Optional<Data> Data;
	private boolean build;
	private final static int Start=0;
	private static final Supplier<RuntimeException> dataError = () -> new IllegalStateException("Data not built");
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Data already built");
	
	private static final Movements SINGLETON = new MovementsImpl();
	
	public static Movements getMovements() {
        return SINGLETON;
	}
	
	private void isDone() {
		
		if (!this.build){
			throw dataError.get();
		}
	}
	
	private void checkNotDone() {
		
		if (this.build){
			throw buildError.get();
		}
	}
	
	@Override
	public void changePosition(Pawns p) {
		
		this.isDone();
		p.setPosition(this.dicePosition(p.getPosition(),
					  this.getData().getDice().stream().mapToInt(d->d.roll()).sum())); 
	}
	
	@Override
	public int dicePosition(int initialPosition, int diceNumber) {

		this.finalPosition=initialPosition+diceNumber;

		if (diceNumber>(this.getData().getFinishNumber()+(this.getData().getFinishNumber()-initialPosition))) {  // You can't do 2 maps round
			return Start;
		}else if (this.finalPosition > this.getData().getFinishNumber()){
			return (this.getData().getFinishNumber()-(this.finalPosition-this.getData().getFinishNumber()));
		}else{
			return this.finalPosition;
		}
		
	}

	@Override
	public void setData(Data data) {
		
		this.checkNotDone();
		this.Data=Optional.ofNullable(data);
	}

	@Override
	public Data getData() {
		
		this.isDone();
		return this.Data.get();
	}

	@Override
	public void reset() {

		this.isDone();
		this.build=false;
		this.Data=Optional.empty();
	}

	@Override
	public boolean checkWin(int pos) {
		
		
		if (pos==this.getData().getFinishNumber()){
			return true;
		}
		return false;
	}

	@Override
	public void build() {
		
		this.checkNotDone();
		this.build=true;
	}
	
	

}
