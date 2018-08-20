package model.model;

import model.data.Data;
import model.movements.Movements;
import model.movements.MovementsImpl;
import model.pawns.Pawns;

public class ModelImpl implements Model{

	private final Movements move;
	
	public ModelImpl(final Data data) {
		this.move=new MovementsImpl(data);
	}
	
	@Override
	public synchronized int movePawn(final Pawns p) {
		
		this.move.changePosition(p);
		return p.getPosition();
	}

	@Override
	public synchronized boolean checkWin(final Pawns p) {
		
		return this.move.checkWin(p.getPosition());
	}

}

