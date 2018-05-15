package controller;

public class Controller {

	private static final Controller SINGLETON = new Controller();



	public static Controller getController() {
        return SINGLETON;
    }
	
	public void start() {
        
    }
	
}
