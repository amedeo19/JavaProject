package view.board2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiBoardImpl extends Application {

	
	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("BoardEasy.fxml"));
        primaryStage.setTitle("Snake N Ladders");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();  
    }
}
