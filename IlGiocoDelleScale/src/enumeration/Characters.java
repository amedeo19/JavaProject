package enumeration;

public enum Characters {
	

	Baghera("character.baghera"),
	
	Baloo("character.baloo"),
	
	ShereKhan("character.sharekhan"),
	
	KingLouie("character.kinglouie");
	
	
	private final String character;
	
	
	Characters(final String character){
		this.character = character;
	}
	
	
	public String toString() {
		return this.character;
	}
}

