package view;

import java.awt.Toolkit;

public final class Size {
	
	private static final Double Pawn_height_const = 0.66;
	
	
	
	public static final double Height_screen = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static final double Width_screen = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	
	public static final double Height_map = Height_screen * 0.9;
	
	
	
	private static double Pawn_height = Height_map / 8 * Pawn_height_const;
	
	
	private Size() { }
	
	public static void setHeight(final int a) {
		Pawn_height = Height_map / a * Pawn_height_const;
	}
	
	public static double getPawnHeight() {
		return Pawn_height;
	}
	

}
