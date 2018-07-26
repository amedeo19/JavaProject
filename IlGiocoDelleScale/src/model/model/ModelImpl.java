package model.model;

import java.util.function.Supplier;
import model.data.Data;
import model.movements.Movements;
import model.movements.MovementsImpl;
import model.pawns.Pawns;

public class ModelImpl implements Model{

	private Movements move;
	private boolean build;
	private static final Supplier<RuntimeException> modelError = () -> new IllegalStateException("Model not built");
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("Model already built");
	
	public ModelImpl() { 
		this.move=MovementsImpl.getMovements();
	}
	

	private static final Model SINGLETON = new ModelImpl();
	
	public static Model getModel() {
        return SINGLETON;
	}
	
	private void isDone() {
		
		if (!this.build){
			throw modelError.get();
		}
	}
	
	private void checkNotDone() {
		
		if (this.build){
			throw buildError.get();
		}
	}
	
	@Override
	public synchronized int movePawn(Pawns p) {
		
		this.isDone();
		this.move.changePosition(p);
		p.setState(!p.getState());
		return p.getPosition();
	}

	@Override
	public void startGame(Data data) {
		
		this.checkNotDone();
		this.move.setData(data);
		this.move.build();
		this.build();
	}

	@Override
	public void endGame() {
		
		this.isDone();
		this.move.reset();
		this.reset();
	}

	@Override
	public synchronized boolean checkWin(Pawns p) {
		
		this.isDone();
		return this.move.checkWin(p.getPosition());
	}

	@Override
	public void build() {
		
		this.checkNotDone();
		this.build=true;
	}

	@Override
	public void reset() {

		this.isDone();
		this.build=false;
	}
	
	


}
