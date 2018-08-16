package utilities.pawn;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PawnViewImp implements PawnView {

	private ImageView image;
	private final static int Default = 1;
	private PawnMapImpl pawnMap;
		
	public PawnViewImp() {

		this.pawnMap = new PawnMapImpl();
		this.setImage(Default);
	}
	
	
	@Override
	public void setImage(int num) {
		
		this.image=this.readImage(pawnMap.getPawnMap().get(num));
	}

	@Override
	public ImageView getImage() {
		return this.image;
	}
	
	private ImageView readImage(final String path) {
		
		try {
			return new ImageView(new Image(path));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return null;
	}

	

}
