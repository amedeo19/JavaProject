package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import enumeration.Characters;
import enumeration.Dice;
import enumeration.MapDifficulty;
import enumeration.MapDimension;

public interface Controller {

	
	public void start(List<Dice> diceList, List<Optional<Integer>> faceList, List<Characters> Character, MapDimension dimension, MapDifficulty difficulty);
	
	public void play();
	
	public void startController() throws Exception;
	


}
