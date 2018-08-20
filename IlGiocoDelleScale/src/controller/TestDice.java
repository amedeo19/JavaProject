package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import enumeration.Characters;
import enumeration.Dice;
import enumeration.MapDifficulty;
import enumeration.MapDimension;
import javafx.stage.Stage;
import view.view.View;
import view.view.ViewGuiImpl;

public class TestDice {


	@SuppressWarnings("static-access")
	public static void main(final String[] args) {

		View view = new ViewGuiImpl();
		Controller controller = new ControllerImpl(view);
		List<Dice> diceList = new ArrayList<>();
		List<Optional<Integer>> faceList = new ArrayList<>();
		List<Characters> Character = new ArrayList<>();
		Characters per = null;
		MapDifficulty difficulty = MapDifficulty.EASY;
		MapDimension dimension = null;
		Stage stage = new Stage();
		
		
		diceList.add(Dice.CLASSIC);
		diceList.add(Dice.MULTIFACE);
		diceList.add(Dice.SPECIALTWENTY);
		
		faceList.add(Optional.empty());
		faceList.add(Optional.of(5));
		faceList.add(Optional.empty());
		
		Character.add(per.KingLouie);
		Character.add(per.Baloo);
		
		
		System.out.println("sad\n" + diceList.size() );
		System.out.println(faceList.size());
		System.out.println(Character.toString());
		System.out.println(difficulty.toString());
		
		
		
		controller.start(diceList, faceList, Character, dimension.LARGE, difficulty);
		
		controller.play();
		
		try {
			
			view.startMenu(stage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
