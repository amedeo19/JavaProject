package model.dice;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class SpecialDice extends MultifaceDice{

	private int Special;
	private final static int MIN=1;
	private final static int MAX=20;
	private final static int MINSECOND=-10;
	private final static int MAXSECOND=10;
	private Optional<Map<Integer,Integer>>map;
	private static final Supplier<RuntimeException> keyError = () -> new IllegalStateException("Error with some first numbers");
	private static final Supplier<RuntimeException> valueError = () -> new IllegalStateException("Error with some second numbers");	

	public SpecialDice(Map<Integer,Integer> map,int numberOfFace) { // map
		
		super(numberOfFace);
		this.Special=0;
		this.map=Optional.ofNullable(map);
		if (this.map.isPresent()){
			
			if (this.map.get().entrySet().stream().anyMatch(x->x.getKey()<MIN) || this.map.get().entrySet().stream().anyMatch(x->x.getKey()>MAX)){
				throw keyError.get();
			}
			if (!this.map.get().entrySet().stream().allMatch(x->x.getValue()>=MINSECOND) || !this.map.get().entrySet().stream().allMatch(x->x.getValue()<=MAXSECOND)){
				throw valueError.get();
			}
		}
	}

	private boolean checkIsSpecial(int number){
		if (!this.map.isPresent()){
			return false;
		}else{
			return this.map.get()
							.entrySet()
							.stream()
							.filter(x -> x.getKey().equals(number))
							.distinct()
							.count() > 0;
		}
	}
	
	private void setSpecial(int number){ 
		if (this.map.isPresent()){
			if (this.map.get().entrySet().stream().anyMatch(x->x.getKey().equals(number))){
				if (this.checkIsSpecial(number)){
					this.Special=this.map.get()  // First number is the only that count
							.entrySet()
							.stream()
							.filter(x->x.getKey().equals(number))
							.mapToInt(y->y.getValue())	
							.boxed()
							.findFirst()
							.get()
							.intValue();
					return;
				}
				
			}
		}
		this.Special=0;
	}
	
	public int getSpecial(){
		
		return this.Special; 
	}
	
	@Override
	public int roll() {
		
		int number=super.roll();
		this.setSpecial(number);
		this.setNumber(this.getSpecial()+number);
		return this.getNumber();
	}
	
	@Override
	public int viewNum(){		
		
		return this.getNumber()-this.getSpecial();
	}

	@Override
	public void setNumber(int number) {
		
		super.setNumber(number);
	}

	@Override
	public int getNumber() {
		
		return super.getNumber();
	}
	
}