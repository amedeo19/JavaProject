package model.dice;

import java.util.Map;

public class ListDiceImpl implements ListDice{

	private static final int MAXCLASSIC=6; // static add
	
	@Override
	public Dice classicDice() {
		return new MultifaceDice(MAXCLASSIC, this.twentyFaceDice());
	}

	@Override
	public Dice twentyFaceDice() {
		return new TwentyFaceDice();
	}

	@Override
	public Dice multiFaceDice(int numberOfFace) {
		return new MultifaceDice(numberOfFace, this.twentyFaceDice());
	}

	@Override
	public Dice specialTwentyDice(Map<Integer,Integer> map) {
		return new SpecialDice(map, this.classicDice());
	}
	
	@Override
	public Dice specialClassicDice(Map<Integer,Integer> map ) {
		return new SpecialDice(map, this.multiFaceDice(MAXCLASSIC));
	}

	@Override
	public Dice totalPersonalazide(Map<Integer,Integer> map , int number) {
		return new SpecialDice(map, this.multiFaceDice(number));
	}



}
