package model.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.data.Data;
import model.data.DataImpl;
import model.dice.Dice;
import model.dice.ListDice;
import model.dice.ListDiceImpl;
import model.model.Model;
import model.model.ModelImpl;
import model.pawns.Pawns;
import model.pawns.PawnsImpl;
import view.dice.ViewImpl;

public class Test{

	

public static void main(String[] args) {
		
		final ListDice builder = new ListDiceImpl();
		final Dice d  = builder.twentyFaceDice();
		final Dice d2 = builder.twentyFaceDice();
		final Dice d3 = builder.twentyFaceDice();
		Map<Integer,Integer> map = new HashMap<>();
		final Dice d4 = builder.totalPersonalized(map,4);
		List<Dice> diceList = new ArrayList<>();
		diceList.add(d);
		diceList.add(d2);
		diceList.add(d4);
		map.put(2, -10);
//		final ViewImpl view = new ViewImpl(d);
//		System.out.println(d.roll());
//		System.out.println(d.viewNum());
//		view.update();
		
//		d2.build();
//		d3.build();
//		d4.build();
//		for (int i=0;i<10;i++){
//			System.out.println(d4.roll());
//		}
//		d.build();
//		System.out.println(d4.roll());
//		System.out.println(d4.roll());
//		System.out.println(d4.roll());
//		System.out.println(d4.roll());
//		System.out.println(d4.roll());
//		System.out.println(d4.roll());
//		System.out.println(d4.roll());
//		Dice d2= builder.classicDice();
//		

		final Data data = new DataImpl(diceList,30);
		final Pawns p = new PawnsImpl(); 
		final Model m =  new ModelImpl(data);
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		m.movePawn(p);
		data.getDice().forEach(e->System.out.print(e.getNumber()+" "));
		System.out.println();
		System.out.println(p.getPosition());
		
		
	}


}
