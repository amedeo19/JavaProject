package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import enumeration.Characters;
import enumeration.Dice;
import enumeration.MapDifficulty;
import enumeration.MapDimension;

public class TestDice {


	@SuppressWarnings("static-access")
	public static void main(final String[] args) {

		Controller controller = new ControllerImpl();
		List<Dice> diceList = new ArrayList<>();
		List<Optional<Integer>> faceList = new ArrayList<>();
		List<Characters> Character = new ArrayList<>();
		Characters per = null;
		MapDifficulty difficulty = MapDifficulty.EASY;
		MapDimension dimension = MapDimension.LARGE;
		
		
		diceList.add(Dice.CLASSIC);
		diceList.add(Dice.MULTIFACE);
		diceList.add(Dice.SPECIALTWENTY);
		
		faceList.add(Optional.empty());
		faceList.add(Optional.of(5));
		faceList.add(Optional.empty());
		
		Character.add(per.ShereKhan);
		Character.add(per.Baghera);
		
		
		System.out.println("sad\n" + diceList.size() +"\n"  );
		System.out.println(faceList.size());
		System.out.println(Character.toString());
		
		controller.start(diceList, faceList, Character, dimension, difficulty);
		
		try {
			controller.startController();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
