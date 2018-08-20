package model.dice;

import java.util.Map;

public interface ListDice {

	Dice classicDice();
	
	Dice twentyFaceDice();
	
	Dice multiFaceDice(final int numberOfFace);
	
	Dice specialTwentyDice(final Map<Integer,Integer> map);
	
	Dice specialClassicDice(final Map<Integer,Integer> map);
	
	Dice totalPersonalized(final Map<Integer,Integer> map,final int number); // Personalized
	
}
