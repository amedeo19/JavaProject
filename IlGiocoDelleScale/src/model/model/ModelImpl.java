package model.model;

import java.util.function.Supplier;
import model.data.Data;
import model.movements.Movements;
import model.movements.MovementsImpl;
import model.pawns.Pawns;

public class ModelImpl implements Model{

	Movements move;
	boolean done;
	private static final Supplier<RuntimeException> initError = () -> new IllegalStateException("Init Error");
	
	
	public ModelImpl() { 
		this.move=MovementsImpl.getLog();
	}
	

	private static class LazyHolder { // Singleton bene??
		private static final ModelImpl SINGLETON = new ModelImpl();
	}
	
	public ModelImpl getLog() {
		return LazyHolder.SINGLETON;
	}

	@Override
	public synchronized int movePawn(Pawns p) {
		
		this.check();
		this.move.changePosition(p);
		p.setState(!p.getState());
		System.out.println(p.getPosition());
		return p.getPosition();
	}

	@Override
	public void startGame(Data data) {
		
		this.move.setData(data);
		this.changeDone();
	}

	@Override
	public void endGame() {
		
		this.changeDone();
		this.move.reset();
	}

	@Override
	public void check() {
		if (!this.done){
			throw initError.get();
		}
	}

	@Override
	public void changeDone() {
		this.done=!this.done;
	}

	@Override
	public synchronized boolean checkWin(Pawns p) {
		
		this.check();
		return this.move.checkWin(p.getPosition());
	}
	
	


}
