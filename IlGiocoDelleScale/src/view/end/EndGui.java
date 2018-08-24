package view.end;

import javafx.fxml.Initializable;
import view.view.ViewGuiImpl;

public interface EndGui extends Initializable {

	public void setView(ViewGuiImpl view);
	
	public void restart();
	
	public void exit();
}
