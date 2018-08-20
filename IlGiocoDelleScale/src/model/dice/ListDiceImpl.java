package model.dice;

import java.util.Map;

public class ListDiceImpl implements ListDice{     // da modificare, ristrutturerò con un absract class diceImpl e poi metodo protected per il roll che prende in input il numero di facce del dado

	private static final int MAXCLASSIC=6; // static add
	private static final int TWENTY=20; // static add
	
	@Override
	public Dice classicDice() {
		return new MultifaceDice(MAXCLASSIC);
	}

	@Override
	public Dice twentyFaceDice() {
		return new MultifaceDice(TWENTY);
	}

	@Override
	public Dice multiFaceDice(final int numberOfFace) {
		return new MultifaceDice(numberOfFace);
	}
	
	@Override
	public Dice specialClassicDice(final Map<Integer,Integer> map) {
		return new SpecialDice(map, this.multiFaceDice(MAXCLASSIC));
	}
	
	@Override
	public Dice specialTwentyDice(final Map<Integer,Integer> map) {
		return new SpecialDice(map, this.multiFaceDice(TWENTY));
	}

	@Override
	public Dice totalPersonalized(final Map<Integer,Integer> map , int number) {  // Personalized
		return new SpecialDice(map, this.multiFaceDice(number));
	}



}
