package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import view.view.View;
import view.view.ViewGuiImpl;

public class Main extends Application {
	
	private class Main2 extends Thread{
		
		private final View view;
		
		Main2(final View view) {
			//this.controller = new ControllerImpl();
			this.view = view;
		}
		
		public void run() {
	        new ControllerImpl();
	    }
		
	}
	
	//private final ControllerImpl controller;
	
	public void start(final Stage stage) throws IOException {// Non puoi 
		try {
			//this.controller.startController();
			final View view = new ViewGuiImpl();
			view.startMenu(stage);
			new Main2(view).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
//        final Main application = new Main();
//        application.start();
        //startare il menu' del Mon
        //this.controller(parametri passati dal Mon)
		launch(new String[0]);
    }
	
}
