package view.pawn;

import java.util.Map;

public class PawnMapImpl {

	private static Map<Integer, String> PawnMap;
	private static final String Pawn = "file://../res/Pawns/";
	private static final String PNG = ".png";
	
	public PawnMapImpl() {
		
		PawnMap.put(1, Pawn + "bagheraLaPanteraNera" + PNG);
		PawnMap.put(2, Pawn + "balooo" + PNG);
		PawnMap.put(3, Pawn + "mowgli" + PNG);
		PawnMap.put(4, Pawn + "reLuigi" + PNG);
		PawnMap.put(5, Pawn + "shereKhan" + PNG);
		
	}
	
	public static Map<Integer, String> getPawnMap(){
		return PawnMap;
	}
	
}
