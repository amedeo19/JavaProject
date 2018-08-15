package view.pawn;


import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import enumeration.Characters;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import model.pawns.Pawns;
import model.pawns.PawnsImpl;
import model.board.Coordinate;


public class PawnViewImp implements PawnView {

	@FXML
	private Label viewPawn;
	@FXML
	private ImageView image;

	private static final int Start=0;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.viewPawn.setLocation(Start, Start);
		this.viewPawn.setVisible(true);
		
	}


	@Override
	public void update(Coordinate coordinate) {

		this.viewPawn.setLocation(coordinate.getX(), coordinate.getY());
		
	}

}
