package utilities.dice;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DiceImageImpl implements DiceImage{

	private ImageView image; 
	private final static int Default=1; 
	private final DiceMapImpl diceMap;

	
	public DiceImageImpl() {
		
		this.diceMap= new DiceMapImpl();
		this.setImage(Default);
	}
	
	@Override
	public void setImage(int num) {
		
		this.image=this.readImage(this.diceMap.getDiceMap().get(num));
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
