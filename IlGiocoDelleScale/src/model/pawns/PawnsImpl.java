package model.pawns;

public class PawnsImpl implements Pawns{

	
	public int START=0; 
	public int positions;
	
	public PawnsImpl() {
		this.positions=this.START;
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

	
}
