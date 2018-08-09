package view.end;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EndGuiImplShereKhan extends Application{
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("EndShereKhan.fxml"));
        //primaryStage.setTitle("Scale e Serpenti");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}
	
}