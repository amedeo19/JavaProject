package model.pawns;

public class PawnsImpl implements Pawns{

	private static final int START=0; 
	private int positions;

	public PawnsImpl() {
		
		this.positions=START;
	}
	
	
	@Override
	public int getPosition() {
		
		return this.positions;
	}

	@Override
	public void setPosition(final int pos) {
 		
		this.positions=pos;
	}



	
}
