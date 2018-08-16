package utilities.dice;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceMapImpl{

	private static Map<Integer,String> diceMap;
	private static final int Start=1;
	private static final int End=20;
	private static final String Dice = "file://../res/dice/dice";
	private static final String PNG = ".png";	
	
	public DiceMapImpl() {
		
		diceMap = IntStream.range(Start, End + 1)
                	.boxed()
                	.collect(Collectors.toMap(i -> i, i -> Dice + i + PNG));
	}
	
	public static Map<Integer, String> getDiceMap() {
		
		return diceMap;
	}

	
}
