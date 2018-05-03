package controller;

public class Main {
	
	private final Controller controller;
	
	private Main() {
		this.controller = Controller.getController();
	}
	
	private void start() {
		this.controller.start();
	}

	public static void main(final String[] args) {
        final Main application = new Main();
        application.start();
    }
}
