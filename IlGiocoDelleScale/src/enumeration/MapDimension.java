package enumeration;

public enum MapDimension {

	SMALL("small"),
	
	MEDIUM("medium"),
	
	LARGE("large");
	
	
	private final String dimension;
	
	private MapDimension(final String dimension) {
		this.dimension = dimension;
	}
	
	public String toString() {
		return this.dimension;
	}
	
}
