package model.dice;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class SpecialDice implements Dice{

	private final Dice dice;
	private int Special;
	private boolean build=false;
	private final static int MIN=1;
	private final static int MAX=20;
	private final static int MINSECOND=-10;
	private final static int MAXSECOND=10;
	private Optional<Map<Integer,Integer>>map;
	private static final Supplier<RuntimeException> keyError = () -> new IllegalStateException("Error with some first numbers");
	private static final Supplier<RuntimeException> valueError = () -> new IllegalStateException("Error with some second numbers");
	private static final Supplier<RuntimeException> buildError = () -> new IllegalStateException("You haven't already built");
	
	public SpecialDice(Map<Integer,Integer> map,Dice dice) { // map
		
		super();
		this.Special=0;
		this.dice= dice;
		this.map=Optional.ofNullable(map);
	}
	
	public void isDone(){
		
		if (!this.build){
			throw buildError.get();
		}
	}
	
	public boolean checkIsSpecial(int number){
		return this.map.get()
				.entrySet()
				.stream()
				.filter(x->x.getKey().equals(number))
				.distinct()
				.count()>0;
	}
	
	public void setSpecial(int number){ 
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
		
		this.isDone();
		return this.Special; 
	}
	
	@Override
	public int roll() {
		
		int number=this.dice.roll();
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
		
		this.isDone();
		this.dice.setNumber(number);
	}

	@Override
	public int getNumber() {
		
		this.isDone();
		return this.dice.getNumber();
	}

	@Override
	public void build() {
		
		if (this.map.isPresent()){
			
			if (this.map.get().entrySet().stream().anyMatch(x->x.getKey()<MIN) || this.map.get().entrySet().stream().anyMatch(x->x.getKey()>MAX)){
				throw keyError.get();
			}
			if (!this.map.get().entrySet().stream().allMatch(x->x.getValue()>=MINSECOND) || !this.map.get().entrySet().stream().allMatch(x->x.getValue()<=MAXSECOND)){
				throw valueError.get();
			}
		}
		
		this.dice.build();
		this.build=true;
	}

}