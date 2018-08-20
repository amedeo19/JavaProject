package model.dice;

import java.util.Map;
import java.util.Optional;

public abstract class SpecialAbstract implements Dice{

	protected final Dice dice;
	protected final Optional<Map<Integer,Integer>>map;
	protected int Special;
	
	public SpecialAbstract(final Map<Integer,Integer> map,final Dice dice) {
	
		this.dice = dice;
		this.Special = 0;
		this.map = Optional.ofNullable(map);
	}
	
	protected boolean checkIsSpecial(int number){
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
	
	protected void setSpecial(int number){ 
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
	
	protected int getSpecial(){
		
		return this.Special; 
	}
	
	@Override
	public int roll() {
		return this.dice.roll();
	}

	@Override
	public void setNumber(int number) {
		this.dice.setNumber(number);
	}

	@Override
	public int getNumber() {
		return this.dice.getNumber();
	}

	@Override
	public int viewNum() {
		return this.dice.viewNum();
	}

}
