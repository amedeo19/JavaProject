package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import enumeration.Characters;
import javafx.fxml.Initializable;
import model.board.Coordinate;
public interface Controller extends Initializable{

	
	public void start(List<String> diceList, List<Optional<Integer>> faceList, int lastNumber, List<Characters> Character);
	
	public void finishGame(int turn) throws IOException;
	
	public void play();
	
	public int convertToInt(Coordinate coordinate);
	
	public Coordinate convertToCoordinate(int pos);


}
