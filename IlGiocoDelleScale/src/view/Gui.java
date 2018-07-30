package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gui implements Initializable {
	ObservableList<Integer> num = FXCollections.observableArrayList(1,2,3,4);
	public Button Start;
	@FXML 
	public ChoiceBox numPlayer;
	public void SelectPawns() {
		
	}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.numPlayer.setItems(num);
        this.numPlayer.setValue(1);
    }

}