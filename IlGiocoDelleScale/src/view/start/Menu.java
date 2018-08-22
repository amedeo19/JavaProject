package view.start;

import javafx.fxml.Initializable;
import view.view.ViewGuiImpl;

public interface Menu extends Initializable {
	public void SelectPawns();
	public void Exit();
	public void Update();
	public void Update1();
	public void Back();
	public void SelectDice();
	public void StartGame();
	public void setViewGuiImpl(ViewGuiImpl view);
}
