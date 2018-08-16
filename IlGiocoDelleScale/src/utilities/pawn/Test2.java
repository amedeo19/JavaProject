package view.pawn;


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
			PawnView ImagePawn = new PawnViewImp();
			PawnView ImagePawn2 = new PawnViewImp();
			ImagePawn.setImage(1);
			ImagePawn2.setImage(2);
//			ImageView imageView = new ImageView();
//			ImageView imageView2 = new ImageView();
			ImageView imageView = ImagePawn.getImage();
			ImageView imageView2 = ImagePawn2.getImage();
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
