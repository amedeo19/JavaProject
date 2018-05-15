package model.dice;

import java.util.List;
import java.util.Optional;
import utilities.Pair;

public interface ListDice {

	Dice classicDice();
	
	Dice twentyFaceDice();
	
	Dice multiFaceDice(int numberOfFace);
	
	Dice specialTwentyDice(List<Pair<Optional<Integer>,Optional<Integer>>> list);
	
	Dice specialClassicDice(List<Pair<Optional<Integer>,Optional<Integer>>> list);
	
	Dice totalPersonalazide(List<Pair<Optional<Integer>,Optional<Integer>>> list,int number);
	
}
