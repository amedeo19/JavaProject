package model.pawns;

import java.util.Optional;

import enumeration.Characters;
import utilities.Pair;

public class PawnsImpl implements Pawns{

	
	public Pair<Integer, Integer> START=new Pair<Integer, Integer>(0, 0); 
	public Pair<Integer,Integer> positions;
	public Optional<Characters> character;
	
	public PawnsImpl() {
		this.positions=this.START;
		this.character=Optional.empty();
	}
	
	@Override
	public Pair<Integer,Integer> getPosition() {
		return this.positions;
	}

	@Override
	public void setPosition(Pair<Integer,Integer> pos) {
		if (!checkPossible(pos)){
			throw new IllegalStateException("You can't go in that position");
		}
		this.positions=pos;
	}

	@Override
	public boolean checkPossible(Pair<Integer, Integer> pos) {
		if (pos.getFst()<this.START.getFst() || pos.getSnd()<this.START.getSnd()){
			return false;
		}
		return true;
	}

	@Override
	public void setPawn(Characters car) {
		this.character=Optional.ofNullable(car);
	}

	@Override
	public Characters getPawn() {
		return this.character.get();
	}

	
}
