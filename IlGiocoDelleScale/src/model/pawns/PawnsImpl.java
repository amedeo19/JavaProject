package model.pawns;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Supplier;

public class PawnsImpl extends Observable implements Pawns{

	
	private static final int START=0; 
	private int positions;
	private boolean state;
	private boolean build;
	private static final Supplier<RuntimeException> pawnError = () -> new IllegalStateException("Pawn not built");
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Pawn already built");

	
	public PawnsImpl() {
		
		this.positions=START;
		this.state=false;
		this.build();
	}
	
	private void isDone() {
		
		if (!this.build){
			throw pawnError.get();
		}
	}
	
	private void checkNotDone() {
		
		if (this.build){
			throw buildError.get();
		}
	}
	
	@Override
    public void setState(boolean state) {
      
		this.isDone();
		this.state = state;
        setChanged();
        notifyObservers();
    }
 
    @Override
    public boolean getState() {
       
    	this.isDone();
    	return this.state;
    }
	
	@Override
	public int getPosition() {
		
		this.isDone();
		return this.positions;
	}

	@Override
	public void setPosition(int pos) {   // observer
 		
		this.isDone();
		this.positions=pos;
	}

	@Override
	public void addObserverList(List<Observer> obsList) {
		
		this.isDone();
		if (!obsList.isEmpty()){
			obsList.forEach(o->this.addObserver(o));
		}
	}

	@Override
	public void build() {

		this.checkNotDone();
		this.build=true;
	}

	@Override
	public void reset() {

		this.isDone();
		this.setPosition(START);
		this.deleteObservers();
		this.build=false;
	}

	
}
