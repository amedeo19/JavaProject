package model.data;

import java.util.ArrayList;
import java.util.List;

import model.dice.Dice;
import model.dice.ListDiceImpl;

public class ListDataImpl implements ListData{

	private static final int MAXCLASSIC=100;
	private List<Dice> diceList = new ArrayList<>();
	
	@Override
	public Data classicMode() {
		
		this.checkList();
		this.diceList.add(new ListDiceImpl().classicDice());
		this.diceList.forEach(d->d.build());
		return new DataImpl(this.diceList, MAXCLASSIC);
	}

	@Override
	public Data personalizedMode(int cellNumber, List<Dice> diceList) {
	
		diceList.forEach(d->d.build());
		return new DataImpl(diceList,cellNumber);
	}

	@Override
	public void checkList() {
		if (!this.diceList.isEmpty()){
			this.diceList.clear();
		}
	}

}
