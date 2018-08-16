package utilities.dice;


import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.stage.Stage;

public class Test2 extends Application {


	 
	    public static void main(String[] args) {
	        launch(args);
	    }
	     
	    @Override
	    public void start(Stage primaryStage) {
	        
//	    	JFXPanel panel = new JFXPanel();
			Group root = new Group();
			DiceImage ImageDice = new DiceImageImpl();
			DiceImage ImageDice2 = new DiceImageImpl();
			ImageDice.setImage(5);
			ImageDice2.setImage(19);
//			ImageView imageView = new ImageView();
//			ImageView imageView2 = new ImageView();
			ImageView imageView = ImageDice.getImage();
			ImageView imageView2 = ImageDice2.getImage();
			imageView2.setLayoutX(200);
	        Group myGroup = GroupBuilder.create()
	                .children(imageView)
	                .build();
	        
	        Group group2 = GroupBuilder.create()
	                .children(imageView2)
	                .build();
	         
	        root.getChildren().add(myGroup);
	        root.getChildren().add(group2);
	        
	        primaryStage.setScene(new Scene(root, 500, 400));
	        primaryStage.show();
	    }


}
