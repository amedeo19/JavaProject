package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewManagerImpl implements ViewManager {

	private static final ViewManagerImpl SINGLETON = new ViewManagerImpl();
	
	private ViewManagerImpl() {
	}
	
	public ImageView getImage(final String path) {
		return new ImageView(this.ReadFile(path));
	}
	
	@Override
	public Object ReadFile(String path) {
		try {
			return new Image(ViewManagerImpl.class.getResourceAsStream("/" + path));
		} catch (Exception exception){
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public void WriteFile(String path) {
		// TODO Auto-generated method stub
	}

}
