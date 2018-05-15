package model.dice;

import java.util.List;
import java.util.Optional;
import utilities.Pair;

public class ListDiceImpl implements ListDice{

	private final int MAXCLASSIC=6;
	
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
	public Dice specialTwentyDice(List<Pair<Optional<Integer>, Optional<Integer>>> list) {
		return new SpecialDice(list, this.classicDice());
	}
	
	@Override
	public Dice specialClassicDice(List<Pair<Optional<Integer>, Optional<Integer>>> list) {
		return new SpecialDice(list, this.multiFaceDice(MAXCLASSIC));
	}

	@Override
	public Dice totalPersonalazide(List<Pair<Optional<Integer>,Optional<Integer>>> list, int number) {
		return new SpecialDice(list, this.multiFaceDice(number));
	}



}
