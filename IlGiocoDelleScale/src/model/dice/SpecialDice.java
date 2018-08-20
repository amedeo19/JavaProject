package model.dice;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class SpecialDice extends SpecialAbstract{

	private final static int MIN=1;
	private final static int MAX=20;
	private final static int MINSECOND=-10;
	private final static int MAXSECOND=10;
	private static final Supplier<RuntimeException> keyError = () -> new IllegalStateException("Error with some first numbers");
	private static final Supplier<RuntimeException> valueError = () -> new IllegalStateException("Error with some second numbers");	

	public SpecialDice(Map<Integer,Integer> map,Dice dice) { // map
		
		super(map,dice);
		this.Special=0;
		if (this.map.isPresent()){
			
			if (this.map.get().entrySet().stream().anyMatch(x->x.getKey()<MIN) || this.map.get().entrySet().stream().anyMatch(x->x.getKey()>MAX)){
				throw keyError.get();
			}
			if (!this.map.get().entrySet().stream().allMatch(x->x.getValue()>=MINSECOND) || !this.map.get().entrySet().stream().allMatch(x->x.getValue()<=MAXSECOND)){
				throw valueError.get();
			}
		}
	}
	
	@Override
	public int roll() {
		
		int number=super.roll();
		super.setSpecial(number);
		super.setNumber(super.getSpecial()+number);
		return super.getNumber();
	}
	
	@Override
	public int viewNum(){		
		
		return super.getNumber()-super.getSpecial();
	}
	
}