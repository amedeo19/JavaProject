package model.dice;

import java.util.Map;

public interface ListDice {

	/**
	 * @return a classic dice
	 */
	Dice classicDice();
	
	/**
	 * @return a twenty face dice
	 */
	Dice twentyFaceDice();
	
	/**
	 * @param numberOfFace is the face's number
	 * @return a dice that take in input the face's number
	 */
	Dice multiFaceDice(final int numberOfFace);
	
	/**
	 * @param map take the special number in input
	 * @return a special dice with twenty face
	 */
	Dice specialTwentyDice(final Map<Integer,Integer> map);
	
	/**
	 * @param map take the special number in input
	 * @return a special dice with six face
	 */
	Dice specialClassicDice(final Map<Integer,Integer> map);
	
	/**
	 * @param map take the special number in input
	 * @param numberOfFace is the face's number
	 * @return a special dice with face's number selected in input
	 */
	Dice totalPersonalized(final Map<Integer,Integer> map,final int number);
	
}
