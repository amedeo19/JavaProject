package model.dice;

import java.util.List;
import java.util.Optional;
import utilities.Pair;

public class SpecialDice implements Dice{

	private final Dice dice;
	private int Special;
	private final Optional<List<Pair<Optional<Integer>,Optional<Integer>>>> list;
	private boolean done=false;
	private final int MIN=1;
	private final int MAX=20;
	private final int MINSECOND=-10;
	private final int MAXSECOND=10;
	
	
	public SpecialDice(List<Pair<Optional<Integer>,Optional<Integer>>> list,Dice dice) {
		super();
		this.Special=0;
		this.dice= dice;
		this.list=Optional.of(list);
	}
	
	public boolean isDone(){
		if (!this.done){
			throw new IllegalStateException("You haven't already roll");
		}
		return false;
	}
	
	public boolean checkIsSpecial(int number){
		return this.list.get()
				.stream()
				.filter(x->x.getFst().isPresent()==true) // se il primo numero è presente
				.filter(x->x.getFst().get().equals(number))// ed è uguale al number
				.filter(y->y.getSnd().isPresent()==true) // se il secondo numero è presente   //CRUCIALE
				.distinct()
				.count()>0;
	}
	
	public void setSpecial(int number){ // temo che se mi rimane un solo numero first con un empty come second non vada bene
		if (this.list.isPresent()){
			if (this.list.get().stream().anyMatch(x->x.getFst().equals(Optional.of(number)))){
				if (this.checkIsSpecial(number)){
					this.Special=this.list.get()  // La prima cosache si dice è quella che conta
							.stream()
							.filter(x->x.getFst().isPresent()==true) // se il primo numero è presente
							.filter(x->x.getFst().get().equals(number))// ed è uguale al number
							.filter(y->y.getSnd().isPresent()==true) // se il secondo numero è presente   //CRUCIALE
							.mapToInt(y->y.getSnd().get())	//allora li prendo
							.boxed()// Li faccio tutti
							.findFirst()// Scelgo di prendere il primo
							.get()	//lo prendo
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
		this.done=true;
		int number=this.dice.roll();
		this.setSpecial(number);
		this.setNumber(this.getSpecial()+number);
		return this.getNumber();
	}
	
	@Override
	public int viewNum(){					// non credo vada bene
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
	public Dice build() {
		if (this.list.isPresent()){
			if (this.list.get().stream().anyMatch(x->x.getFst().equals(Optional.empty()))){
				throw new IllegalStateException("Error, some first number isn't insert");
			}else if (this.list.get().stream().anyMatch(x->x.getSnd().equals(Optional.empty()))){
				throw new IllegalStateException("Error, some first number isn't insert");
			}
			if (this.list.get().stream().filter(x->!x.getFst().equals(Optional.empty())).anyMatch(x->x.getFst().get()<MIN) || this.list.get().stream().filter(x->!x.getFst().equals(Optional.empty())).anyMatch(x->x.getFst().get()>MAX) ){
				throw new IllegalStateException("Error,too big or too small special first number");
			}
			if (!this.list.get().stream().allMatch(x->x.getSnd().get()>=MINSECOND) || !this.list.get().stream().allMatch(x->x.getSnd().get()<=MAXSECOND)){
				throw new IllegalStateException("Error,too big or too small special second number");
			}
		}
		return dice.build();
	}

}