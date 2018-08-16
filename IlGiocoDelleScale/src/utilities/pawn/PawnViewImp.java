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
	private Pawns pawn;
	private Characters character;
	private Coordinate coordinate;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.viewPawn.setLocation(this.coordinate.getX(), this.coordinate.getY());
		this.pawn = new PawnsImpl();
		this.viewPawn.setVisible(true);
		
	}


	@Override
	public void update(Coordinate coordinate) {

		this.coordinate = coordinate;
		this.viewPawn.setLocation(this.coordinate.getX(), this.coordinate.getY());
		
	}

}
