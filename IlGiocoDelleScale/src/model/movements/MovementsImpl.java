package model.movements;

import model.data.Data;
import model.pawns.Pawns;

public class MovementsImpl implements Movements {
	
	private int finalPosition;
	private final Data Data;
	private final static int Start=0;
	private final int Finish;
	
	public MovementsImpl(final Data data) {
		
		this.Data=data;
		this.Finish=(this.Data.getFinishNumber()-1);
	}
	
	@Override
	public void changePosition(final Pawns p) {
		
	p.setPosition(this.dicePosition(p.getPosition(),
				  this.Data.getDice().stream().mapToInt(d->d.roll()).sum())); 
	}
	
	private int dicePosition(final int initialPosition,final int diceNumber) {

		this.finalPosition=initialPosition+diceNumber;

		if (diceNumber>(this.Finish+(this.Finish-initialPosition))) {  // You can't do 2 maps round
			return Start;
		}else if (this.finalPosition > this.Finish){
			return (this.Finish-(this.finalPosition-this.Finish));
		}else{
			return this.finalPosition;
		}
		
	}


	@Override
	public boolean checkWin(final int pos) {
		
		if (pos==this.Finish){
			return true;
		}
		return false;
	}


}
