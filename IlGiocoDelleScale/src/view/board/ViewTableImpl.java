package view.board;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;

import enumeration.MapDimension;

public class ViewTableImpl extends Application {
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(600, 600);
		double x = 600/8;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * x);
				tile.setTranslateY(i * x);
				
				root.getChildren().add(tile);
			}
		}
		return root;
	}

	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
	}
	
	private class Tile extends StackPane{
		private MapDimension dimension;

		public Tile() {
			this.dimension = dimension;
			//if(this.dimension == MapDimension.SMALL) {
				double x = 600 / 8;
				Rectangle border = new Rectangle(x, x);
				border.setFill(null);
				border.setStroke(javafx.scene.paint.Color.BLACK);
			//}
				setAlignment(Pos.CENTER);
				getChildren().addAll(border);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
