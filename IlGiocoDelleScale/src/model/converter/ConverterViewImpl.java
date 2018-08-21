package model.converter;

public class ConverterViewImpl implements ConverterView{

	private final int height; 
	
	public ConverterViewImpl(final int height) {
		this.height=height;
	}
	
	@Override
	public int getHeight(int height) {
		return (this.height-height);
	}

}
