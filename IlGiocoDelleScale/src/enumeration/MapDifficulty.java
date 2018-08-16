package enumeration;

public enum MapDifficulty {

	EASY("easy"),
	
	MEDIUM("medium"),
	
	DIFFICULT("difficult");
	
	
	private final String difficulty;
	
	private MapDifficulty(final String difficulty) {
		this.difficulty = difficulty;
	}
	
	public String  toString() {
		return this.difficulty;
	}
	
}
