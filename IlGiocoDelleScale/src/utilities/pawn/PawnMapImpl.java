package utilities.pawn;

import java.util.HashMap;
import java.util.Map;

public class PawnMapImpl {

	private Map<Integer, String> pawnMap= new HashMap<Integer, String>();
	private static final String Pawn = "file://../res/Pawns/";
	private static final String PNG = ".png";
	
	
	
	public PawnMapImpl() {
		
//		PawnMap = IntStream.range(Start, End + 1)
//				.boxed()
//				.collect(Collectors.toMap(i -> i, i -> Pawn + this.character.toString() + PNG));

		pawnMap.put(1, Pawn + "bagheraLaPanteraNera" + PNG);
		pawnMap.put(2, Pawn + "balooo" + PNG);
		pawnMap.put(3, Pawn + "mowgli" + PNG);
		pawnMap.put(4, Pawn + "reLuigi" + PNG);
		pawnMap.put(5, Pawn + "shereKhan" + PNG);
		
	}
	
	public Map<Integer, String> getPawnMap(){
		return pawnMap;
	}
	
}
