package model.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import enumeration.MapDifficulty;
import enumeration.MapDimension;
import model.board.TableBuilder;
import model.board.TableBuilderImpl;
import model.converter.Converter;
import model.converter.ConverterImpl;
import model.converter.ConverterView;
import model.converter.ConverterViewImpl;
import model.data.Data;
import model.data.DataImpl;
import model.dice.Dice;
import model.dice.ListDice;
import model.dice.ListDiceImpl;
import model.model.Model;
import model.model.ModelImpl;
import model.pawns.Pawns;
import model.pawns.PawnsImpl;
import utilities.Coordinate;

public class TestModel {

	@org.junit.Test
//	@Ignore
	public void testDice(){
		
		final ListDice builder = new ListDiceImpl();
		Map<Integer,Integer> map = new HashMap<>();
		final Dice d  = builder.totalPersonalized(map, 15);
		final Dice d2 = builder.specialTwentyDice(map);
		final Dice d3 = builder.specialClassicDice(map);
		List<Dice> diceList = new ArrayList<>();
		diceList.add(d);
		diceList.add(d2);
		diceList.add(d3);
		map.put(2, -10);
		map.put(4, -10);
		int cellNumber=64;
		Data data = new DataImpl(diceList, cellNumber);
		d3.setNumber(5);
		assertEquals(d3.getNumber(), 5);
		assertEquals(data.getDice(), diceList);
		assertEquals(data.getFinishNumber(),cellNumber);
		
	}
	
	@org.junit.Test
//	@Ignore
	public void testBoard(){
		
		TableBuilder table = new TableBuilderImpl(MapDifficulty.EASY, MapDimension.LARGE);
		assertEquals(table.getSnakes().size(),4);
		assertEquals(table.getStairs().size(),6);
		
		
	}
	
	@org.junit.Test
//	@Ignore
	public void testConverter(){
		
		Converter converter = new ConverterImpl(MapDimension.LARGE.getDimension());
		Coordinate coordinate = new Coordinate(0, 2);
		int num = converter.toInt(coordinate);
		assertEquals(coordinate, converter.toCoordinate(num));
		assertEquals(num, converter.toInt(coordinate));
		
		ConverterView cview = new ConverterViewImpl((int) Math.sqrt(MapDimension.SMALL.getDimension()));
		assertEquals(cview.getHeight(0), 7);
		
	}
	
	@org.junit.Test
//	@Ignore
	public void testMovement(){
		
		
		final ListDice builder = new ListDiceImpl();
		Map<Integer,Integer> map = new HashMap<>();
		final Dice d  = builder.totalPersonalized(map, 15);
		final Dice d2 = builder.specialTwentyDice(map);
		final Dice d3 = builder.specialClassicDice(map);
		List<Dice> diceList = new ArrayList<>();
		diceList.add(d);
		diceList.add(d2);
		diceList.add(d3);
		Data data = new DataImpl(diceList, MapDimension.MEDIUM.getDimension());
		Model model = new ModelImpl(data);
		Pawns p = new PawnsImpl();
		
		p.setPosition(MapDimension.MEDIUM.getDimension()-1);
		assertEquals(model.checkWin(p),true);
		assertEquals(p.getPosition(),MapDimension.MEDIUM.getDimension()-1);
	}
		
}
