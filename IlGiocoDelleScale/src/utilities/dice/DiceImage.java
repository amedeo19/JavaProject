package utilities.dice;

import javafx.scene.image.ImageView;

public interface DiceImage { // UNUSED

	/**
	 * Set the image of that number
	 * @param num is the number to set the image
	 */
	public void setImage(int num);
	
	/**
	 * @return the image for the selected number
	 */
	public ImageView getImage();
	
}
