package model.pawns;

import java.util.Optional;

import enumeration.Characters;

public class PawnsImpl implements Pawns{

	
	public int START=0; 
	public int positions;
	public Optional<Characters> character;
	
	public PawnsImpl() {
		this.positions=this.START;
		this.character=Optional.empty();
	}
	
	@Override
	public int getPosition() {
		return this.positions;
	}

	@Override
	public void setPosition(int pos) {
		if (!checkPossible(pos)){
			throw new IllegalStateException("You can't go in that position");
		}
		this.positions=pos;
	}

	@Override
	public boolean checkPossible(int pos) {
		if (pos<this.START){
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
