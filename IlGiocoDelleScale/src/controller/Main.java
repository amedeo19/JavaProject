package controller;

public class Main {
	
	private final ControllerImpl controller;
	
	private Main() {
		this.controller = ControllerImpl.getController();
	}
	
	private void start() {
		this.controller.start();
	}

	public static void main(final String[] args) {
        final Main application = new Main();
        application.start();
    }
}
