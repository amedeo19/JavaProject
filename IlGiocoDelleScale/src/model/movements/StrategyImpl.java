package model.movements;


public class StrategyImpl implements Strategy{

	private int finalPosition;
	private final static int Start=0;
	
	public StrategyImpl() {
	}
	
	private static class LazyHolder { // Singleton bene?? Aggiungere la classe LazyHolder alle utilities?
		private static final StrategyImpl SINGLETON = new StrategyImpl();
	}
	
	public static StrategyImpl getLog() {
		return LazyHolder.SINGLETON;
	}
	
	@Override
	public int dicePosition(int initialPosition, int diceNumber, int cellNumber) {

		this.finalPosition=initialPosition+diceNumber;

		if (diceNumber>(cellNumber+(cellNumber-initialPosition))) {  // You can't do 2 maps round
			this.finalPosition=Start;
		}
		
		if (this.finalPosition > cellNumber){
			this.finalPosition=(cellNumber-(this.finalPosition-cellNumber));
		}
		
		return this.finalPosition-initialPosition;
		
	}

}
