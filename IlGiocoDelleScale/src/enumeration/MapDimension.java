package enumeration;

public enum MapDimension {

	SMALL("small", 64),
	
	MEDIUM("medium", 100),
	
	LARGE("large", 196);
	
	
	private final String map;
	private final int dimension;
	
	private MapDimension(final String map, final int dimension) {
		this.map = map;
		this.dimension = dimension;
	}
	
	public String toString() {
		return this.map;
	}
	
	public int GetDimension() {
		return this.dimension;
	}
	
}
