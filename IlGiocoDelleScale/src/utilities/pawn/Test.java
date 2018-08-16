package utilities.pawn;


import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test {
	
	

	public static void main(String[] args) {
		
		JFXPanel panel = new JFXPanel();
		Group root = new Group();
		PawnView ImagePawn = new PawnViewImp();
		ImageView imageView = ImagePawn.getImage();
         
        Group myGroup = GroupBuilder.create()
                .children(imageView)
                .build();
         
        root.getChildren().add(myGroup);
        Scene scene = new Scene(root, 500, 400);
        
//		ImageDice.setImage(3);
//		ImageDice.getImage();

//		final int xSize = 400;
//		final int ySize = 280;
//		final Color backgroundColor = Color.WHITE;
//		final String text = "SQL Browser";
//		final String version = "Product Version: 1.0";
//		GridPane grid = new GridPane();
//		grid.setAlignment(Pos.CENTER);
//		grid.setHgap(10);
//		grid.setVgap(10);
//		grid.setPadding(new Insets(25, 25, 25, 25));
//		
//		ImageView imgView = new ImageView(new Image("file://../res/dice/dice1.png"));
//
//		grid.add(imgView, 0, 0);
//		Scene aboutDialogScene = new Scene(grid, xSize, ySize, backgroundColor);
//		aboutDialog.setScene(aboutDialogScene);
//		aboutDialog.show();
	}
	
}
