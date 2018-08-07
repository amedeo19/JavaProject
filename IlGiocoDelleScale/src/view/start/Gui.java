package view.start;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.*;

import enumeration.Characters;

public class Gui implements Initializable {
	ObservableList<Integer> num = FXCollections.observableArrayList(1,2,3,4);
	ObservableList<Characters> cha = FXCollections.observableArrayList(Arrays.asList(Characters.values()));
	List<Text> TextList=new ArrayList<>();
	List<ChoiceBox<Characters>> PawnList=new ArrayList<>();
	@FXML
	private Text Text1;
	@FXML
	private Text TextP1;
	@FXML
	private Text TextP2;
	@FXML
	private Text TextP3;
	@FXML
	private Text TextP4;
	@FXML
	private Text PawnSelection;
	@FXML
	private ImageView Logo;
	@FXML
	private Button GoToPlayerSelect;
	@FXML 
	private ChoiceBox<Integer> numPlayer;
	@FXML
	private Button Exit;
	@FXML
	private Button Back;
	@FXML
	private ChoiceBox<Characters> PawnP1;
	@FXML
	private ChoiceBox<Characters> PawnP2;
	@FXML
	private ChoiceBox<Characters> PawnP3;
	@FXML
	private ChoiceBox<Characters> PawnP4;
	
	public void SelectPawns() {
		int numPlayers = (int) numPlayer.getValue();
		for (int i=0;i<numPlayers;i++) {
			switch (i) {
				case 0: this.TextList.add(TextP1);
						this.PawnList.add(PawnP1);
						break;
				case 1: this.TextList.add(TextP2);
						this.PawnList.add(PawnP2);
						break;
				case 2: this.TextList.add(TextP3);
						this.PawnList.add(PawnP3);
						break;
				case 3: this.TextList.add(TextP4);
						this.PawnList.add(PawnP4);
						break;
			}
		}
		System.out.println(this.TextList.size());
		this.TextList.forEach(e->e.setVisible(true));
		this.PawnList.forEach(e->e.setVisible(true));
		numPlayer.setVisible(false);
		GoToPlayerSelect.setVisible(false);
		Logo.setVisible(false);
		Text1.setVisible(false);
		
	}
	public void Exit() {
		System.exit(0);
	}
	public void Back() {
		numPlayer.setVisible(true);
		GoToPlayerSelect.setVisible(true);
		Logo.setVisible(true);
		Text1.setVisible(true);
	 	this.TextList.forEach(e->e.setVisible(false));
	 	this.TextList.clear();
	 	this.PawnList.forEach(e->e.setVisible(false));
	 	this.PawnList.clear();
	}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.numPlayer.setItems(num);
        this.numPlayer.setValue(1);
        this.PawnP1.setItems(cha);
   	 	this.PawnP1.setValue(Characters.Baghera);
   	 	this.PawnP2.setItems(cha);
	 	this.PawnP2.setValue(Characters.Baghera);
	 	this.PawnP3.setItems(cha);
   	 	this.PawnP3.setValue(Characters.Baghera);
   	 	this.PawnP4.setItems(cha);
	 	this.PawnP4.setValue(Characters.Baghera);

	 	TextP1.setVisible(false);
	 	TextP2.setVisible(false);
	 	TextP3.setVisible(false);
	 	TextP4.setVisible(false);
	 	PawnP1.setVisible(false);
	 	PawnP2.setVisible(false);
	 	PawnP3.setVisible(false);
	 	PawnP4.setVisible(false);
    }

}