package controller;

import java.util.List;
import java.util.Optional;
import enumeration.Characters;
import enumeration.Dice;
import enumeration.MapDifficulty;
import enumeration.MapDimension;

public interface Controller {

	
	public void start(final List<Dice> diceList,final List<Optional<Integer>> faceList,final List<Characters> Character,final MapDimension dimension,final MapDifficulty difficulty);
	
	public void play();
	

}
